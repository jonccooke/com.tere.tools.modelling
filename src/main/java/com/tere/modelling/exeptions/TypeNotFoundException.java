package com.tere.modelling.exeptions;

import com.tere.TereException;

public class TypeNotFoundException extends ModellingException
{
	public TypeNotFoundException(String typeName)
	{
		super(typeName);
	}

}
