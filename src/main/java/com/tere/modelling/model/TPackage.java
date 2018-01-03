package com.tere.modelling.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import com.tere.modelling.exeptions.TClassHeirarchyNotFoundException;
import com.tere.modelling.model.factory.TFactory;
import com.tere.modelling.model.factory.TPackageManager;

public abstract class TPackage extends TBase
{
	public static final String TOBJECT = "Object";
	public static final String TSTRING = "String";
	public static final String TINT = "integer";
	public static final String TFLOAT = "float";
	public static final String TDOUBLE = "double";
	public static final String TLONG = "long";
	public static final String TDATE = "date";
	public static final String TCHAR = "char";
	public static final String TBYTE = "byte";
	public static final String TBOOLEAN = "boolean";
	public static final String TSHORT = "short";
	public static final String TBIGDECIMAL = "BigDecimal";

	private Map<String, TDataType> dataTypes = new LinkedHashMap<String, TDataType>();
	private Map<String, TClass> classes = new LinkedHashMap<String, TClass>();
	private Map<String, TEnum> enums = new LinkedHashMap<String, TEnum>();
	private Map<String, TClassHierarchy> tClassHierarchies = new LinkedHashMap<String, TClassHierarchy>();
	private TFactory tFactory = null;
	private String namespace = "";
	private String version = "0.0.1";

	public TPackage(String name)
	{
		this(TPackageManager.getInstance().getFactory(), name);
	}

	public TPackage(TFactory tFactory, String name)
	{
		super(name);
		this.setFactory(tFactory);
	}

	public abstract String getNamespaceToken();

	public Collection<TDataType> getDataTypes()
	{
		return dataTypes.values();
	}

	public Collection<TClass> getClasses()
	{
		return classes.values();
	}

	public Collection<TEnum> getEnums()
	{
		return enums.values();

	}

	protected void putInternalDataType(TDataType dataType)
	{
		dataTypes.put(dataType.getName(), dataType);
		dataType.setTPackage(this);
	}

	protected TBaseType removeInternalDataType(String name)
	{
		return dataTypes.remove(name);
	}

	protected void clearInternalDataTypes()
	{
		dataTypes.clear();
	}

	public TDataType getDataType(String dataTypeName)
	{
		return dataTypes.get(dataTypeName);
	}

	protected void putInternalClass(TClass tClass)
	{
		classes.put(tClass.getName(), tClass);
		getOrCreateTClassHeirarchy(tClass.getBaseClass()).addClass(tClass);
	}

	protected TClass getInternalClass(String name)
	{
		return classes.get(getName());

	}

	protected TClass removeInternalClass(String name)
	{
		return classes.remove(getName());

	}

	protected void clearInternalClasses()
	{
		classes.clear();

	}

	protected void putInternalEnum(TEnum tEnum)
	{
		enums.put(tEnum.getName(), tEnum);

	}

	protected TEnum removeInternalEnum(String name)
	{
		return enums.remove(getName());

	}

	protected void clearInternalEnums()
	{
		classes.clear();

	}

	public TClass getClass(String name)
	{
		return classes.get(name);
	}

	public TEnum getEnum(String name)
	{
		return enums.get(name);
	}

	@Override
	public String toString()
	{
		return "TPackage [classes=" + classes + ", dataTypes=" + dataTypes
				+ ", enums=" + enums + ", qname=" + getQName() + "]";
	}

	public String getNamespace()
	{
		return namespace;
	}

	public void setNamespace(String namespace)
	{
		this.namespace = namespace;
	}

	public String getQName()
	{
		StringBuffer buf = new StringBuffer();
		String namespace = getNamespace();
		if (null != namespace)
		{
			buf.append(namespace);
			buf.append(getNamespaceToken());
		}
		buf.append(getName());
		return buf.toString();
	}

	/**
	 * @param tFactory
	 *            the tFactory to set
	 */
	protected void setFactory(TFactory tFactory)
	{
		this.tFactory = tFactory;
	}

	/**
	 * @return the tFactory
	 */
	public TFactory getFactory()
	{
		return tFactory;
	}

	protected TClassHierarchy getOrCreateTClassHeirarchy(TClass baseClass)
	{
		TClassHierarchy tClassHierarchy = null;
		if (!tClassHierarchies.containsKey(baseClass.getName()))
		{
			tClassHierarchy = new TClassHierarchy(baseClass);
			tClassHierarchies.put(baseClass.getName(), tClassHierarchy);
		}
		else
		{
			tClassHierarchy = tClassHierarchies.get(baseClass.getName());
			
		}
		return tClassHierarchy;
	}

	public TClassHierarchy getClassHeirarchy(TClass baseClass) throws TClassHeirarchyNotFoundException
	{
		TClassHierarchy tClassHierarchy = null;
		if (!tClassHierarchies.containsKey(baseClass.getName()))
		{
			throw new TClassHeirarchyNotFoundException(baseClass.getName());
		}
		else
		{
			tClassHierarchy = tClassHierarchies.get(baseClass.getName());
			
		}
		return tClassHierarchy;
	}

	public Collection<TClassHierarchy> getTClassHeirarchies()
	{
		return tClassHierarchies.values();
	}

	public void rebuildHeirarchies()
	{
		for (TClass tClass : classes.values())
		{
//			if (null != tClass.getParent())
//			{
				TClass baseClass = tClass.getBaseClass();
				getOrCreateTClassHeirarchy(baseClass).addClass(tClass);
//			}
		}
	}
	//
	// @Override
	// public int hashCode()
	// {
	// final int prime = 31;
	// int result = super.hashCode();
	// result = prime * result + ((classes == null) ? 0 : classes.hashCode());
	// result = prime * result
	// + ((dataTypes == null) ? 0 : dataTypes.hashCode());
	// result = prime * result + ((enums == null) ? 0 : enums.hashCode());
	// result = prime * result
	// + ((namespace == null) ? 0 : namespace.hashCode());
	// result = prime * result
	// + ((tFactory == null) ? 0 : tFactory.hashCode());
	// return result;
	// }
	//
	//
	// @Override
	// public boolean equals(Object obj)
	// {
	// if (this == obj)
	// return true;
	// if (!super.equals(obj))
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// TPackage other = (TPackage) obj;
	// if (classes == null)
	// {
	// if (other.classes != null)
	// return false;
	// }
	// else if (!classes.equals(other.classes))
	// return false;
	// if (dataTypes == null)
	// {
	// if (other.dataTypes != null)
	// return false;
	// }
	// else if (!dataTypes.equals(other.dataTypes))
	// return false;
	// if (enums == null)
	// {
	// if (other.enums != null)
	// return false;
	// }
	// else if (!enums.equals(other.enums))
	// return false;
	// if (namespace == null)
	// {
	// if (other.namespace != null)
	// return false;
	// }
	// else if (!namespace.equals(other.namespace))
	// return false;
	// if (tFactory == null)
	// {
	// if (other.tFactory != null)
	// return false;
	// }
	// else if (!tFactory.equals(other.tFactory))
	// return false;
	// return true;
	// }
	//

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public boolean containsClass(String className)
	{
		return classes.containsKey(className);
	}

	public boolean containsType(String typeName)
	{
		return dataTypes.containsKey(typeName);
	}

}
