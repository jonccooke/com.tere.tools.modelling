package com.tere.modelling.model.impl;

import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TPackage;
import com.tere.modelling.model.factory.TFactory;

public class TCSharpPackage extends TPackage
{
	public TCSharpPackage(TFactory tFactory)
	{
		super(tFactory, "csharp_3_5");
		putInternalDataType(new TDataType(TSTRING, "string", true, this));
		putInternalDataType(new TDataType(TINT, "Int32", true, this));
		putInternalDataType(new TDataType(TLONG, "Long", true, this));
		putInternalDataType(new TDataType(TFLOAT, "Float", true, this));
		putInternalDataType(new TDataType(TDOUBLE, "Double", true, this));
		putInternalDataType(new TDataType(TBIGDECIMAL, "Decimal", true, this));
		putInternalDataType(new TDataType(TDATE, "DateTime", true, this));
		putInternalDataType(new TDataType(TCHAR, "Char", true, this));
		putInternalDataType(new TDataType(TBYTE, "Byte", true, this));
		putInternalDataType(new TDataType(TBOOLEAN, "Boolean", true, this));
		putInternalDataType(new TDataType(TSHORT, "Short", true, this));
	}


	@Override
	public void setName(String name)
	{
		throw new UnsupportedOperationException("setName");
	}


	@Override
	public String getNamespaceToken()
	{
		return ".";
	}

	@Override
	public String getNamespace()
	{
		return "com.micosoft.lang";
	}

	@Override
	public void setNamespace(String namespace)
	{
		throw new UnsupportedOperationException("setNamespace");
		
	}

}
