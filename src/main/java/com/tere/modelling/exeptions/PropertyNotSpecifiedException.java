package com.tere.modelling.exeptions;

import com.tere.TereException;

public class PropertyNotSpecifiedException extends ModellingException
{

	public PropertyNotSpecifiedException(String propertyName)
	{
		super(propertyName);
	}

}
