package com.tere.modelling.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TOperation extends TBase
{

	private Map<String, TParameter> params = new LinkedHashMap<String, TParameter>();
	private boolean abstractMethod;
	private TBaseType returnType = null;
	private boolean unique = false;
	private boolean ordered = false;
	private int lowerBound = 0;
	private int upperBound = 1;
	private boolean manditory = false;
	protected boolean readOnly = false;

	public Map<String, TParameter> getParams()
	{
		return params;
	}


	public void setParams(Map<String, TParameter> params)
	{
		this.params = params;
	}


	public boolean isAbstractMethod()
	{
		return abstractMethod;
	}


	public void setAbstractMethod(boolean abstractMethod)
	{
		this.abstractMethod = abstractMethod;
	}


	public boolean isUnique()
	{
		return unique;
	}


	public void setUnique(boolean unique)
	{
		this.unique = unique;
	}


	public boolean isOrdered()
	{
		return ordered;
	}


	public void setOrdered(boolean ordered)
	{
		this.ordered = ordered;
	}


	public int getLowerBound()
	{
		return lowerBound;
	}


	public void setLowerBound(int lowerBound)
	{
		this.lowerBound = lowerBound;
	}


	public int getUpperBound()
	{
		return upperBound;
	}


	public void setUpperBound(int upperBound)
	{
		this.upperBound = upperBound;
	}


	public boolean isManditory()
	{
		return manditory;
	}


	public void setManditory(boolean manditory)
	{
		this.manditory = manditory;
	}


	public boolean isReadOnly()
	{
		return readOnly;
	}


	public void setReadOnly(boolean readOnly)
	{
		this.readOnly = readOnly;
	}


	public TOperation(String name)
	{
		super(name);
	}


	public boolean isAbstract()
	{
		return abstractMethod;
	}

	public void setAbstract(boolean isAbstract)
	{
		this.abstractMethod = isAbstract;
	}

	public TBaseType getReturnType()
	{
		return returnType;
	}

	public void setReturnType(TBaseType returnType)
	{
		this.returnType = returnType;
	}

	public boolean hasReturnValue()
	{
		return !(returnType == null);
	}

	public void putParameter(TParameter parameter)
			throws IllegalArgumentException
	{
		if (params.containsKey(parameter.getName()))
		{
			throw new IllegalArgumentException(parameter.getName()
					+ " already exists");
		}

		params.put(parameter.getName(), parameter);

	}

	public void putParameters(Collection<TParameter> parameters)
			throws IllegalArgumentException
	{
		for (TParameter parameter : parameters)
		{
			putParameter(parameter);
		}
	}

	public Collection<TParameter> getParameters()
	{
		return params.values();
	}

	@Override
	public String toString()
	{
		return getName();
	}

}
