package com.tere.modelling.exeptions;

import com.tere.modelling.exeptions.ModellingException;

public class OperationNotFoundException extends ModellingException
{

	public OperationNotFoundException(String operationName)
	{
		super(operationName);
	}

}
