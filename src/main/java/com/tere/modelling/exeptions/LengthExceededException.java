package com.tere.modelling.exeptions;

public class LengthExceededException extends ConstraintVoliationException
{

	public LengthExceededException(String name, Object expected, Object actual)
	{
		super(String.format("Length exceeded in %s, expected length %s, actual %s", name, expected, actual));
	}
}
