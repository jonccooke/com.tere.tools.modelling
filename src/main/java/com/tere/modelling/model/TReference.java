package com.tere.modelling.model;


public class TReference extends TElement
{
	private TClass type;
	private TClass base;
	private boolean aggregation = false;
	
	public TReference(String name, TClass type)
	{
		super(name);
		this.type = type;
	}

	/**
	 * @return the tClass
	 */
	public TClass getType()
	{
		return type;
	}

	public boolean isManditory()
	{
		return getLowerBound() > 0;
	}

	@Override
	public String toString()
	{
		return getName() + " -> " + getType().getName();
	}

	public void setBase(TClass base)
	{
		this.base = base;
	}

	public TClass getBase()
	{
		return base;
	}

	public void setAggregation(boolean aggregation)
	{
		this.aggregation = aggregation;
	}

	public boolean isAggregation()
	{
		return aggregation;
	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + (aggregation ? 1231 : 1237);
//		result = prime * result + ((base == null) ? 0 : base.hashCode());
//		result = prime * result + ((type == null) ? 0 : type.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TReference other = (TReference) obj;
//		if (aggregation != other.aggregation)
//			return false;
//		if (base == null)
//		{
//			if (other.base != null)
//				return false;
//		}
//		else if (!base.equals(other.base))
//			return false;
//		if (type == null)
//		{
//			if (other.type != null)
//				return false;
//		}
//		else if (!type.equals(other.type))
//			return false;
//		return true;
//	}
}
