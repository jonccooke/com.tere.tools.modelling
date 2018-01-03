package com.tere.modelling.model.impl;

import java.math.BigDecimal;
import java.util.Date;

import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TUserPackage;
import com.tere.modelling.model.factory.TFactory;

public class TJavaPackage extends TUserPackage
{
	public TJavaPackage(TFactory tFactory, String name)
	{
		super(tFactory, name);
		putInternalDataType(new TDataType(TSTRING, String.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TINT, Integer.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TLONG, Long.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TFLOAT, Float.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TDOUBLE, Double.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TBIGDECIMAL, BigDecimal.class.getCanonicalName(), true, this));
		putInternalDataType(new TDataType(TDATE, Date.class.getCanonicalName(), true, this));
		putInternalDataType(new TDataType(TCHAR, Character.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TBYTE, Byte.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TBOOLEAN, Boolean.class.getSimpleName(), true, this));
		putInternalDataType(new TDataType(TSHORT, Short.class.getSimpleName(), true, this));
	}

	@Override
	public String getNamespaceToken()
	{
		return ".";
	}

//	@Override
//	public String getNamespace()
//	{
//		return "com.java.lang";
//	}
//
//	@Override
//	public void setNamespace(String namespace)
//	{
//		throw new UnsupportedOperationException("setNamespace");
//		
//	}
//
}
