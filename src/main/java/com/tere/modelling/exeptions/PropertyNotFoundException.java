package com.tere.modelling.exeptions;

import com.tere.TereException;

public class PropertyNotFoundException extends ModellingException
{

	public PropertyNotFoundException(String propertyName)
	{
		super(propertyName);
	}

}
