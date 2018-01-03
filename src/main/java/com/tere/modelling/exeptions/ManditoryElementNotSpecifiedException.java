package com.tere.modelling.exeptions;

public class ManditoryElementNotSpecifiedException extends ConstraintVoliationException
{

	public ManditoryElementNotSpecifiedException(String elementName)
	{
		super(elementName);

	}
}
