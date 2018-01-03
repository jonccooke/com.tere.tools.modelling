package com.tere.modelling.exeptions;


public class InvalidPropertyException extends ModellingException
{

	public InvalidPropertyException(String propertyName)
	{
		super(propertyName);
	}


	public InvalidPropertyException(String propertyName, Throwable throwable)
	{
		super(propertyName, throwable);
	}


}
