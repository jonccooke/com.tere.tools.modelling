package com.tere.modelling.exeptions;

public class ConstraintVoliationException extends ModellingException
{
	protected ConstraintVoliationException(String message)
	{
		super(message);
	}
	
	public ConstraintVoliationException(String name, Object expected, Object actual)
	{
		super(String.format("Name:%s, expected %s, actual %s", name, expected, actual));
	}

	public ConstraintVoliationException(String name, Object expected, Object actual, Throwable throwable)
	{
		super(String.format("Name:%s, expected %s, actual %s", name, expected, actual), throwable);
	}

}
