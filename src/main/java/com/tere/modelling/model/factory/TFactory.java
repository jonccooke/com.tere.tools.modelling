package com.tere.modelling.model.factory;

import com.tere.application.model.TApplication;
import com.tere.logging.LogManager;
import com.tere.logging.Logger;
import com.tere.modelling.model.TAnnotation;
import com.tere.modelling.model.TAttribute;
import com.tere.modelling.model.TBaseType;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TEnum;
import com.tere.modelling.model.TEnumLiteral;
import com.tere.modelling.model.TOperation;
import com.tere.modelling.model.TParameter;
import com.tere.modelling.model.TReference;
import com.tere.modelling.model.TUserPackage;
import com.tere.modelling.model.impl.TJavaPackage;

public class TFactory
{
//	private static TFactory tFactory = new TFactory();
//	private TPackage tDefaultPackage = new TJavaPackage(this);

	private Logger log = LogManager.getLogger(TFactory.class);

//	protected TFactory()
//	{
//		tDefaultPackage = new TJavaPackage(this);
//	}
	
//	public static TFactory getInstance()
//	{
//		return tFactory;
//	}
//	
//	public TPackage getDefaultPackage()
//	{
//		return tDefaultPackage; 
//	}
//
//	public void setDefaultPackage(TPackage tPackage)
//	{
//		this.tDefaultPackage = tPackage; 
//	}

	public TUserPackage createPackage(String name)
	{
		log.debug("Creating TPackage %s ", name);
		return new TJavaPackage(this, name);
	}

	public TDataType createDataType(String name, TUserPackage tPackage, String instanceClassName)
	{
		log.debug("Creating TDataType %s as %s", name, instanceClassName);
		
		TDataType dataType = new TDataType(name, tPackage, instanceClassName);
		
		tPackage.putDataType(dataType);
		
		return dataType;
	}

	public TClass createClass(String name, TUserPackage tPackage)
	{
		log.debug("Creating TClass %s", name);
		TClass tClass = new TClass(name, tPackage);
		tPackage.putClass(tClass);

		return tClass;
	}

	public TClass createClass(String name, TUserPackage tPackage, String instanceClassName)
	{
		log.debug("Creating TClass %s as %s", name, instanceClassName);
		TClass tClass = createClass(name, tPackage);
		tClass .setInstanceClassName(instanceClassName);
		return tClass;
	}
	
	public TEnum createEnum(String name, TUserPackage tPackage, String instanceEnumName)
	{
		log.debug("Creating TEnum %s as %s", name, instanceEnumName);
	
		TEnum tEnum = new TEnum(name, tPackage, instanceEnumName);

		tPackage.putEnum(tEnum);
		return tEnum;
	}

	public TEnumLiteral createEnumLiteral(String name, int value, TEnum tEnum)
	{
		log.debug("Creating TEnumLiteral name:%s, value:%s", name, value);
	
		TEnumLiteral tEnumLiteral = new TEnumLiteral(name, value);

		tEnum.addLiteral(tEnumLiteral);
		
		return tEnumLiteral;
	}

	public TAttribute createAttribute(String name, TDataType type, TClass tClass)
	{
		if (null == type)
		{
			log.debug("Creating TAttribue %s will null type", name);
		}
		else
		{
			log.debug("Creating TAttribue %s as %s", name, type.getName());
		}
		TAttribute tAttribute = new TAttribute(name, type);
		tClass.putAttribute(tAttribute);
		return tAttribute;
	}

	public TReference createReference(String name, TClass toClass, TClass fromClass)
	{
		log.debug("Creating TReference %s (%s->%s)", name, fromClass.getName(), toClass.getName());
		TReference tReference = new TReference(name, toClass);
		tReference .setBase(fromClass);
		return tReference;
	}

	public TOperation createOperation(String name, TClass tClass)
	{
		log.debug("Creating TOperation %s", name);
		TOperation tOperation = new TOperation(name);
		tClass.putOperation(tOperation);
		return tOperation;
	}

	public TParameter createParameter(String name, TBaseType type, TOperation tOperation)
	{
		log.debug("Creating TParameter %s as %s", name, type.getName());
		TParameter tParameter = new TParameter(name, type);
		tOperation.putParameter(tParameter);
		return tParameter;
	}

	public TAnnotation createAnnotation(String name)
	{
		log.debug("Creating TAnnotation %s", name);
		TAnnotation tAnnotation = new TAnnotation(name);
		return tAnnotation;
	}
//
//	public TAnnotationEntry createAnnotationEntry(String name, String value)
//	{
//		log.debug("Creating TAnnotation %s", name);
//		TAnnotationEntry tAnnotationEntry = new TAnnotationEntry(name, value);
//		return tAnnotationEntry;
//	}

	public TApplication createApplication(String name)
	{
		TApplication tApplication = new TApplication(name);
		
		return tApplication;
	}
}
