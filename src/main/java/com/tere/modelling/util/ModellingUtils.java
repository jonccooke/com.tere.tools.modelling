package com.tere.modelling.util;

import java.util.List;
import java.util.Vector;

import com.tere.logging.LogManager;
import com.tere.logging.Logger;
import com.tere.modelling.model.TAttribute;
import com.tere.modelling.model.TBase;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TElement;
import com.tere.modelling.model.TPackage;
import com.tere.modelling.model.TParameter;
import com.tere.modelling.model.TReference;
import com.tere.utils.reflection.ClassReflect;

public class ModellingUtils
{

	public static final String GENERATE_ANNOTATION_STRING = "http://www.tere.com/tmodel/generate";
	public static final String DISPLAY_ANNOTATION_STRING = "http://www.tere.com/tmodel/display";
	public static final String CONSTRAINT_ANNOTATION_STRING = "http://www.tere.com/tmodel/constraint";
	public static final String DIMENSION_ANNOTATION_STRING = "http://www.tere.com/tmodel/dimension";
	public static final String DISPLAY_VISIBLE_STRING = "visable";
	public static final String DISPLAY_NAME_STRING = "displayName";
	public static final String DISPLAY_READ_ONLY_STRING = "displayReadOnly";
	public static final String DISPLAY_ELEMENT_STRING = "displayElement";
	public static final String FORMAT_STRING = "format";
	public static final String OPPOSITE_DISPLAY_NAME_STRING = "oppositeDisplayName";
	public static final String DIMENSION_TYPE_STRING = "dimensionType";
	public static final String DIMENSION_MODEL_STRING = "dimensionModel";

	private static Logger log = LogManager.getLogger(ModellingUtils.class);

	public static boolean visable(TBase tBase)
	{
		String entryString = tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				DISPLAY_VISIBLE_STRING);

		if (null != entryString)
		{
			return Boolean.parseBoolean(entryString);
		}
		return true;
	}

	public static boolean hasDisplayName(TBase tBase)
	{
		return null != tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				DISPLAY_NAME_STRING);
	}

	public static boolean displayReadOnly(TBase tBase)
	{
		return null != tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				"displayReadOnly");
	}

	public static String constraintFormat(TBase tBase)
	{
		return tBase.getAnnotation(CONSTRAINT_ANNOTATION_STRING, FORMAT_STRING);
	}

	public static String displayFormat(TBase tBase)
	{
		return tBase.getAnnotation(DISPLAY_ANNOTATION_STRING, FORMAT_STRING);
	}

	public static String generate(TBase tBase)
	{
		return tBase.getAnnotation(GENERATE_ANNOTATION_STRING, FORMAT_STRING);
	}

	// public static boolean generate(TBase tBase, String modelElementString)
	// {
	// String tAnnotationString = tBase.getAnnotation(GENERATE_ANNOTATION_STRING
	// ,
	// modelElementString);
	//
	// if (null != tAnnotationString)
	// {
	// return Boolean.parseBoolean(tAnnotationString);
	// }
	// return true;
	// }
	//
	// public static boolean generateModel(TBase tBase)
	// {
	// return generate(tBase, "Model");
	// }
	//
	// public static boolean generateDAO(TBase tBase)
	// {
	// return generate(tBase, "dao");
	// }
	//
	//
	// public static boolean generateAll(GenTClass genTClass)
	// {
	// return generate(genTClass, "all");
	// }

	public static String displayElement(TBase tBase)
	{

		String ret = (null == tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				DISPLAY_ELEMENT_STRING))
						? Character.toLowerCase(tBase.getName().charAt(0))
								+ tBase.getName().substring(1) + "Id"
						: tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
								DISPLAY_ELEMENT_STRING);
		return ret;
	}

	public static boolean hasDisplayElement(TBase tBase)
	{
		return (null != tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				DISPLAY_ELEMENT_STRING));
	}

	public static String oppositeName(TReference tRef)
	{
		String ret = ClassReflect.getFieldName(tRef.getName())
				+ ClassReflect.getFieldName(tRef.getType().getName());
		return ret;
	}

	public static String oppositeDisplayName(TReference tRef)
	{
		String oppName;
		String ret = (null == (oppName = tRef.getAnnotation(
				DISPLAY_ANNOTATION_STRING, OPPOSITE_DISPLAY_NAME_STRING))
						? oppositeName(tRef) : oppName);
		return ret;
	}

	public static String displayName(TBase tBase)
	{
		String ret = tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				DISPLAY_NAME_STRING);

		if (null == ret)
		{
			ret = ClassReflect.getLabelName(tBase.getName());
		}
		return ret;
	}

	public static String displayLength(TBase tBase)
	{
		String length = tBase.getAnnotation(DISPLAY_ANNOTATION_STRING,
				"length");

		if (null == length)
		{
			length = tBase.getAnnotation(CONSTRAINT_ANNOTATION_STRING,
					"length");
		}
		if (null == length)
		{
			length = "10";
		}
		return length;
	}

	public static boolean sorted(TBase tBase)
	{
		return null != tBase.getAnnotation(DISPLAY_ANNOTATION_STRING, "sorted");
	}

	public static String sortElement(TBase tBase)
	{
		return tBase.getAnnotation(DISPLAY_ANNOTATION_STRING, "sortElement");
	}

	public static String length(TBase tBase)
	{
		return tBase.getAnnotation(CONSTRAINT_ANNOTATION_STRING, "length");
	}

	public static String scale(TBase tBase)
	{
		return tBase.getAnnotation(CONSTRAINT_ANNOTATION_STRING, "scale");
	}

	public static String precision(TBase tBase)
	{
		return tBase.getAnnotation(CONSTRAINT_ANNOTATION_STRING, "precision");
	}

	/*
	 * fact or dimension
	 */
	public static boolean dimensionModel(TBase tBase)
	{
		return null != tBase.getAnnotation(DIMENSION_ANNOTATION_STRING,
				DIMENSION_MODEL_STRING);
	}

	/*
	 * dimension, bigDemension etc...
	 */
	public static String dimensionType(TBase tBase)
	{
		String str = tBase.getAnnotation(DIMENSION_ANNOTATION_STRING,
				DIMENSION_TYPE_STRING);

		return str;
	}

	public static void elementToParameter(TParameter tParameter,
			TElement tElement)
	{
		tParameter.setDisplayName(tElement.getDisplayName());
		tParameter.setLowerBound(tElement.getLowerBound());
		tParameter.setUpperBound(tElement.getUpperBound());
		tParameter.setManditory(tElement.isManditory());
	}

	public static TParameter attributeToParameter(TAttribute tAttribute)
	{
		TParameter tParameter = new TParameter(tAttribute.getName(),
				tAttribute.getType());
		elementToParameter(tParameter, tAttribute);
		tParameter.setOrdered(tAttribute.isOrdered());
		tParameter.setUnique(tAttribute.isUnique());
		if (null != tAttribute.getLength())
		{
			tParameter.setLength(tAttribute.getLength());
		}
		if (null != tAttribute.getPrecision())
		{
			tParameter.setPrecision(tAttribute.getPrecision());
		}
		if (null != tAttribute.getScale())
		{
			tParameter.setScale(tAttribute.getScale());
		}
		return tParameter;
	}

	public static TParameter referenceToParameter(TReference tReference)
	{
		TParameter tParameter = new TParameter(tReference.getName(),
				tReference.getType());
		elementToParameter(tParameter, tReference);
		tParameter.setOrdered(tReference.isOrdered());
		tParameter.setUnique(tReference.isUnique());
		return tParameter;
	}

	public static List<TReference> getReferers(TClass clazz, TPackage tPackage)
	{
		List<TReference> references = new Vector<TReference>();

		for (TClass tPackageClass : tPackage.getClasses())
		{
			if (tPackageClass != clazz)
			{
				for (TReference tReference : tPackageClass.getReferences())
				{
					TClass tReferenceClass = tReference.getType();
					log.debug("Lookup reference:%s.%s -> %s",
							tReference.getName(),
							tReference.getBase().getName(), clazz.getName());

					if (clazz == tReferenceClass)
					{
						log.debug("Adding reference:%s.%s -> %s",
								tReference.getName(),
								tReference.getBase().getName(),
								clazz.getName());
						references.add(tReference);
					}
				}
			}
		}
		return references;
	}

}
