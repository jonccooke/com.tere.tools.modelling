package com.tere.modelling.config.tmodel.xml;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

import com.tere.TereException;
import com.tere.logging.LogManager;
import com.tere.logging.Logger;
import com.tere.modelling.exeptions.ManditoryElementNotSpecifiedException;
import com.tere.modelling.exeptions.TypeNotFoundException;
import com.tere.modelling.model.TAnnotation;
import com.tere.modelling.model.TAttribute;
import com.tere.modelling.model.TBase;
import com.tere.modelling.model.TBaseType;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TOperation;
import com.tere.modelling.model.TPackage;
import com.tere.modelling.model.TParameter;
import com.tere.modelling.model.TReference;
import com.tere.modelling.model.TUserPackage;
import com.tere.modelling.model.factory.TPackageManager;
import com.tere.utils.io.xml.XmlReader;
import com.tere.utils.io.xml.XmlReader.ListFunction;

public class TModelXMLReader
{
	private static Logger log = LogManager.getLogger(TModelXMLReader.class);
	private Collection<TPackage> tPackages = new Vector<TPackage>();
	private XmlReader reader = null;
	private TUserPackage currentPackage = null;
	private TClass currentClass = null;
	// private TBase currentBase = null;
	// private TAnnotation currentAnnotation = null;
	private TClassListener tClassListener;
	private TClassOperationListener tClassOperationListener;
	private String rootPath = "//";

	public TModelXMLReader()
	{
	}

	public interface TClassListener
	{
		public void onCreate(TClass tClass);
	}

	public interface TClassOperationListener
	{
		public void onCreate(TClass tClass, TOperation tOperation);
	}

	public void addTClassListener(TClassListener tClassListener)
	{
		this.tClassListener = tClassListener;
	}

	public void addTOperationListener(
			TClassOperationListener tClassOperationListener)
	{
		this.tClassOperationListener = tClassOperationListener;
	}

	private int getInteger(Map<String, String> attributes, String key,
			int defaultvalue)
	{
		if (attributes.containsKey(key))
		{
			return Integer.parseInt(attributes.get(key));
		}
		return defaultvalue;
	}

	private int getInteger(Map<String, String> attributes, String key)
			throws ManditoryElementNotSpecifiedException
	{
		if (attributes.containsKey(key))
		{
			return Integer.parseInt(attributes.get(key));
		}
		throw new ManditoryElementNotSpecifiedException(key);
	}

	private boolean getBoolean(Map<String, String> attributes, String key,
			boolean defaultvalue)
	{

		if (attributes.containsKey(key))
		{
			return Boolean.parseBoolean(attributes.get(key));
		}
		return defaultvalue;
	}

	private boolean getBoolean(Map<String, String> attributes, String key)
			throws ManditoryElementNotSpecifiedException
	{
		if (attributes.containsKey(key))
		{
			return Boolean.parseBoolean(attributes.get(key));
		}
		throw new ManditoryElementNotSpecifiedException(key);
	}

	private String getString(Map<String, String> attributes, String key,
			String defaultvalue)
	{

		if (attributes.containsKey(key))
		{
			return attributes.get(key);
		}
		return defaultvalue;
	}

	private String getString(Map<String, String> attributes, String key)
			throws ManditoryElementNotSpecifiedException
	{

		if (attributes.containsKey(key))
		{
			return attributes.get(key);
		}
		throw new ManditoryElementNotSpecifiedException(key);
	}

	protected void listAnnotationEntries(XmlReader xmlReader, Node node,
			TAnnotation tAnnotation, Map<String, String> attributes)
			throws TereException
	{
//		TAnnotationEntry annotationEntry = currentPackage.getFactory()
//				.createAnnotationEntry(getString(attributes, "name"),
//						getString(attributes, "value"));
		tAnnotation.addEntry(getString(attributes, "name"), getString(attributes, "value"));
	}

	protected void listAnnotations(XmlReader xmlReader, Node node,
			TBase baseValue, Map<String, String> attributes)
			throws TereException
	{
		TAnnotation annotation = currentPackage.getFactory()
				.createAnnotation(getString(attributes, "name"));
		baseValue.addAnnotation(annotation);
		// currentAnnotation = annotation;

		try
		{
			xmlReader.list(node, "entry", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					listAnnotationEntries(xmlReader, node, annotation,
							attributes);
				}
			});
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}
	}

	protected void listAnnotations(XmlReader xmlReader, Node node,
			TBase parentValue, TBase baseValue, Map<String, String> attributes)
			throws TereException
	{
		TAnnotation annotation = TPackageManager.getInstance().getFactory()
				.createAnnotation(getString(attributes, "name"));
		// currentAnnotation = annotation;

		try
		{
			String path = "//package[@name='" + currentPackage.getName()
					+ "']/tClass[@name='" + parentValue.getName() + "']";
			xmlReader.list(node, "entry", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					listAnnotationEntries(xmlReader, node, annotation,
							attributes);

				}
			});
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}
	}

	protected void createReference(XmlReader xmlReader, Node node, String value,
			Map<String, String> attributes) throws TereException
	{

	}

	protected void createType(XmlReader xmlReader, Node node, String name,
			Map<String, String> attributes) throws TereException
	{
		String nameStr = getString(attributes, "name");
		TDataType tDataType = currentPackage.getFactory()
				.createDataType(nameStr, currentPackage, null);
		try
		{
			xmlReader.list(node, "annotation", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					listAnnotations(xmlReader, node, tDataType, attributes);

				}
			});
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}

	}

	protected TBaseType getOrCreateType(XmlReader xmlReader, String typeName)
			throws TereException
	{
		try
		{
			if (currentPackage.containsType(typeName))
			{
				return currentPackage.getDataType(typeName);
			}
			else
			{
				String path = "//package[@name='" + currentPackage.getName()
						+ "']/tDataType[@name='" + typeName + "']";

				if (xmlReader.existsOne(path))
				{
					xmlReader.one(path, this::createType);
				}
				else
				{
					return getOrCreateClass(xmlReader, typeName);
				}
			}
			throw new TypeNotFoundException(typeName);
		}
		catch (XPathExpressionException |

				DOMException e)
		{
			throw new TereException(e);
		}

	}

	protected TBaseType getType(XmlReader xmlReader, String typeName)
			throws TereException
	{
		if (currentPackage.containsType(typeName))
		{
			return currentPackage.getDataType(typeName);
		}
		else
		{
			return currentPackage.getClass(typeName);
		}

	}


	protected TClass getOrCreateClass(XmlReader xmlReader, String typeName)
			throws TereException
	{
		try
		{
			String path = "//package[@name='" + currentPackage.getName()
					+ "']/tClass[@name='" + typeName + "']";

			if (xmlReader.existsOne(path))
			{
				if (!currentPackage.containsClass(typeName))
				{
					xmlReader.one(path, this::createClass);
				}
				return currentPackage.getClass(typeName);

			}
			throw new TypeNotFoundException(typeName);
		}
		catch (XPathExpressionException |

				DOMException e)
		{
			throw new TereException(e);
		}

	}

	protected void createClass(XmlReader xmlReader, Node node, String value,
			Map<String, String> attributes) throws TereException
	{
		try
		{
			String nameStr = getString(attributes, "name");
			if (currentPackage.containsClass(nameStr))
			{
				return;
			}

			TClass tClass = currentPackage.getFactory().createClass(nameStr,
					currentPackage, getString(attributes, "baseClass", null));
			tClass.setAbstract(getBoolean(attributes, "abstract", false));
			tClass.setInterface(getBoolean(attributes, "interface", false));
			tClass.setInstanceClassName(
					getString(attributes, "instanceClass", null));
			tClass.setSerialisable(
					getBoolean(attributes, "serialisable", false));
			// currentPackage.putClass((TClass) tClass);

			String parentName = getString(attributes, "parent", null);
			if (null != parentName)
			{
				TClass parent = getOrCreateClass(xmlReader, parentName);

				tClass.setParent(parent);
				xmlReader.list(node, "annotation", new ListFunction()
				{

					@Override
					public void list(XmlReader xmlReader, Node node,
							String value, Map<String, String> attributes)
							throws TereException
					{
						listAnnotations(xmlReader, node, tClass, attributes);
					}
				});
			}
			currentClass = tClass;
			// currentBase = tClass;
			xmlReader.list(node, "annotation", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					listAnnotations(xmlReader, node, tClass, attributes);
				}
			});

			xmlReader.list(node, "attribute", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					String attrbuteName = getString(attributes, "name");
					String typeName = getString(attributes, "type");
					boolean identity = getBoolean(attributes, "identity",
							false);
					int lowerBound = getInteger(attributes, "lowerBound", 0);
					TDataType dataType = currentPackage.getDataType(typeName);
					TAttribute tAttribute = currentPackage.getFactory()
							.createAttribute(attrbuteName, dataType, tClass);
					tAttribute.setIdentity(identity);
					tAttribute.setLowerBound(
							getInteger(attributes, "lowerBound", 0));
					tAttribute.setUpperBound(
							getInteger(attributes, "upperBound", 1));
					tAttribute.setManditory(
							getBoolean(attributes, "manditory", false));
					tAttribute.setOrdered(
							getBoolean(attributes, "ordered", false));
					tAttribute.setReadOnly(
							getBoolean(attributes, "readOnly", false));
					tAttribute
							.setUnique(getBoolean(attributes, "unique", false));

					try
					{
						xmlReader.list(node, "annotation", new ListFunction()
						{

							@Override
							public void list(XmlReader xmlReader, Node node,
									String value,
									Map<String, String> attributes)
									throws TereException
							{
								listAnnotations(xmlReader, node, tAttribute,
										attributes);

							}
						});
					}
					catch (XPathExpressionException | DOMException e)
					{
						throw new TereException(e);
					}
				}
			});
			if (null != tClassListener)
			{
				tClassListener.onCreate(tClass);
			}
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}
	}

	protected void createPackage(XmlReader xmlReader, Node node, String value,
			Map<String, String> attributes) throws TereException
	{
		String packageTypeName = getString(attributes, "packageTypeName");
		String packageName = getString(attributes, "name");
		String namespace = getString(attributes, "namespace");
		String version = getString(attributes, "version");
		TUserPackage tPackage = TPackageManager.getInstance().getFactory()
				.createPackage(packageName);
		tPackage.setNamespace(namespace);
		tPackage.setVersion(version);
		tPackages.add(tPackage);
		currentPackage = tPackage;
		// currentBase = tPackage;
		try
		{
			reader.list(node, "tClass", this::createClass);
			xmlReader.list(node, "annotation", new ListFunction()
			{

				@Override
				public void list(XmlReader xmlReader, Node node, String value,
						Map<String, String> attributes) throws TereException
				{
					listAnnotations(xmlReader, node, tPackage, attributes);

				}
			});
			reader.list(node, "tClass", new ListFunction()
			{
				
				@Override
				public void list(XmlReader xmlReader, Node classNode, String value,
						Map<String, String> attributes) throws TereException
				{
					final String className = attributes.get("name");
					final TClass parentClass = currentPackage.getClass(className);;
					try
					{
						reader.list(classNode, "reference", new ListFunction()
						{
							
							@Override
							public void list(XmlReader xmlReader, Node node, String value,
									Map<String, String> attributes) throws TereException
							{
								String nameStr = getString(attributes, "name");
								String referenceClassTypeStr = getString(attributes, "type");
								TClass tReferenceClass = null;
								if (!currentPackage.containsClass(referenceClassTypeStr))
								{
									throw new TypeNotFoundException(referenceClassTypeStr);
								}
								tReferenceClass = currentPackage.getClass(referenceClassTypeStr);
								
								if (null == tReferenceClass)
								{
									throw new TypeNotFoundException(referenceClassTypeStr);
								}
								TReference tReference = currentPackage.getFactory()
										.createReference(nameStr, tReferenceClass, parentClass);
								parentClass.putReference(tReference);
								// currentBase = tReference;
								tReference.setAggregation(getBoolean(attributes, "aggregation", false));
								tReference.setLowerBound(getInteger(attributes, "lowerBound", 0));
								tReference.setUpperBound(getInteger(attributes, "upperBound", 1));
								tReference.setManditory(getBoolean(attributes, "manditory", false));
								tReference.setOrdered(getBoolean(attributes, "ordered", false));
								tReference.setReadOnly(getBoolean(attributes, "readOnly", false));
								tReference.setUnique(getBoolean(attributes, "unique", false));

								try
								{
									xmlReader.list(node, "annotation", new ListFunction()
									{

										@Override
										public void list(XmlReader xmlReader, Node node, String value,
												Map<String, String> attributes) throws TereException
										{
											listAnnotations(xmlReader, node, tReference, attributes);

										}
									});
								}
								catch (XPathExpressionException | DOMException e)
								{
									throw new TereException(e);
								}

								
							}
						});
						xmlReader.list(classNode, "operation", new ListFunction()
						{

							@Override
							public void list(XmlReader xmlReader, Node node, String value,
									Map<String, String> attributes) throws TereException
							{
								try
								{
									String operationName = getString(attributes, "name");
									String returnTypeName = getString(attributes,
											"returnType", null);
									TBaseType tReturnType = getType(xmlReader,
											returnTypeName);
									TOperation tOperation = currentPackage.getFactory()
											.createOperation(operationName, parentClass);

									tOperation.setReturnType(tReturnType);
									xmlReader.list(node, "parameter", new ListFunction()
									{

										@Override
										public void list(XmlReader xmlReader, Node node,
												String value,
												Map<String, String> attributes)
												throws TereException
										{
											String paramName = getString(attributes,
													"name");
											String paramType = getString(attributes,
													"type");
											TParameter parameter = null;

											if (currentPackage.containsType(paramType))
											{
												parameter = currentPackage.getFactory()
														.createParameter(paramName,
																currentPackage.getDataType(
																		paramType),
																tOperation);
											}
											else
											{
												parameter = currentPackage.getFactory()
														.createParameter(paramName,
																currentPackage.getClass(
																		paramType),
																tOperation);

											}
										}
									});
									xmlReader.list(node, "annotation", new ListFunction()
									{

										@Override
										public void list(XmlReader xmlReader, Node node,
												String value,
												Map<String, String> attributes)
												throws TereException
										{
											listAnnotations(xmlReader, node, tOperation,
													attributes);

										}
									});
									if (null != tClassOperationListener)
									{
										tClassOperationListener.onCreate(parentClass,
												tOperation);
									}
								}
								catch (XPathExpressionException | DOMException e)
								{
									throw new TereException(e);
								}
							}
						});

					}
					catch (XPathExpressionException | DOMException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			});
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}

	}

	public Collection<TPackage> read(InputStream inputStream,
			Properties properties) throws TereException
	{

		try
		{
			reader = new XmlReader(inputStream);

			reader.list(rootPath + "package", this::createPackage);
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}

		return tPackages;
	}

	public Collection<TPackage> read(XmlReader xmlReader) throws TereException
	{

		try
		{
			this.reader = xmlReader;

			reader.list(rootPath + "package", this::createPackage);
		}
		catch (XPathExpressionException | DOMException e)
		{
			throw new TereException(e);
		}

		return tPackages;
	}

	public Collection<TPackage> read(String rootPath, XmlReader xmlReader)
			throws TereException
	{

		this.rootPath = rootPath;

		return read(xmlReader);
	}

}
