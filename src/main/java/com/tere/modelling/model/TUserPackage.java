package com.tere.modelling.model;

import com.tere.modelling.model.factory.TFactory;

public class TUserPackage extends TPackage
{

	public TUserPackage(TFactory tFactory, String name)
	{
		super(tFactory, name);
	}

	@Override
	public String getNamespaceToken()
	{
		return ".";
	}

	public TBaseType removeDataType(String name)
	{
		return removeInternalDataType(name);
	}

	public void clearDataTypes()
	{
		clearInternalDataTypes();
	}

	public void putDataType(TDataType tDataType)
	{
		putInternalDataType(tDataType);
	}

	public void putClass(TClass tClass)
	{
		putInternalClass(tClass);
	}

	public void putEnum(TEnum tEnum)
	{
		putInternalEnum(tEnum);
	}

}
