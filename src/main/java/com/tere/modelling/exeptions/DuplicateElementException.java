package com.tere.modelling.exeptions;

import com.tere.modelling.model.TBase;

public class DuplicateElementException extends ModellingException
{
	public DuplicateElementException(TBase element)
	{
		super(element.getName());
	}

}
