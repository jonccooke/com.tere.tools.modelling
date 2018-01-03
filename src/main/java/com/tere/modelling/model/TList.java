package com.tere.modelling.model;

public class TList extends TCollection
{
	public TList(String name,
			TBaseType baseType,
			TPackage genPackage)
	{
		super(name, baseType, true, genPackage);
	}

	public TList(String name, TBaseType baseType, boolean ordered, TPackage tPackage)
	{
		super(name, baseType, ordered, false, tPackage);
	}

	@Override
	public boolean isOrdered()
	{
		return true;
	}

}
