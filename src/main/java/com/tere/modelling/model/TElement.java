package com.tere.modelling.model;

public class TElement extends TBase
{
	private boolean unique = false;
	private boolean ordered = false;
	private int lowerBound = 0;
	private int upperBound = 1;
	private boolean manditory = false;
	protected boolean readOnly = false;
	public TElement(String name)
	{
		super(name);
	}

	public void setManditory(boolean manditory)
	{
		this.manditory = manditory;
	}


	public boolean isManditory()
	{
		return manditory;
	}

	public boolean isUnique()
	{
		return unique;
	}

	public void setUnique(boolean unique)
	{
		this.unique = unique;
	}

	public boolean isMany()
	{
		if ((1 == lowerBound ) && (1 == upperBound))
		{
			return false;
		}
		if ((upperBound < 0) || (upperBound > 1))
		{
			return true;
		}
		return false;
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

	@Override
	public String toString()
	{
		return "TElement [lowerBound=" + lowerBound + ", manditory="
				+ isManditory() + ", many=" + isMany() + ", unique=" + unique
				+ ", upperBound=" + upperBound + "]";
	}

	/**
	 * @param ordered the ordered to set
	 */
	public void setOrdered(boolean ordered)
	{
		this.ordered = ordered;
	}

	/**
	 * @return the ordered
	 */
	public boolean isOrdered()
	{
		return ordered;
	}

	public boolean isReadOnly()
	{
		return readOnly;
	}

	public void setReadOnly(boolean changeable)
	{
		this.readOnly = changeable;
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + lowerBound;
//		result = prime * result + (manditory ? 1231 : 1237);
//		result = prime * result + (ordered ? 1231 : 1237);
//		result = prime * result + (readOnly ? 1231 : 1237);
//		result = prime * result + (unique ? 1231 : 1237);
//		result = prime * result + upperBound;
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
//		TElement other = (TElement) obj;
//		if (lowerBound != other.lowerBound)
//			return false;
//		if (manditory != other.manditory)
//			return false;
//		if (ordered != other.ordered)
//			return false;
//		if (readOnly != other.readOnly)
//			return false;
//		if (unique != other.unique)
//			return false;
//		if (upperBound != other.upperBound)
//			return false;
//		return true;
//	}
//
}
