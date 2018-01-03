package com.tere.modelling.model;




public class TCollection extends TDataType
{
	private TBaseType baseType;
	protected boolean ordered;
	protected boolean unique;
	protected boolean sorted;
	
	public boolean isSorted()
	{
		return sorted;
	}

	public void setSorted(boolean sorted)
	{
		this.sorted = sorted;
	}

	public TCollection(String name, TBaseType baseType, boolean ordered, boolean unique, TPackage tPackage)
	{
		super(name, tPackage);
		this.baseType = baseType;
		this.ordered = ordered;
		this.unique = unique;
	}

	public TCollection(String name, TBaseType baseType, boolean ordered, TPackage genPackage)
	{
		super(name, genPackage);
		this.baseType = baseType;
		this.ordered = ordered;
	}

	/**
	 * @param baseType the baseType to set
	 */
	public void setBaseType(TBaseType baseType)
	{
		this.baseType = baseType;
	}

	/**
	 * @return the baseType
	 */
	public TBaseType getBaseType()
	{
		return baseType;
	}

	public boolean isOrdered()
	{
		return ordered;
	}

	@Override
	public boolean isCollection()
	{
		return true;
	}

	public boolean isUnique()
	{
		return unique;
	}

	@Override
	public String toString()
	{
		return "TCollection [baseType=" + baseType + ", ordered=" + ordered
				+ ", unique=" + unique + "]";
	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result
//				+ ((baseType == null) ? 0 : baseType.hashCode());
//		result = prime * result + (ordered ? 1231 : 1237);
//		result = prime * result + (sorted ? 1231 : 1237);
//		result = prime * result + (unique ? 1231 : 1237);
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
//		TCollection other = (TCollection) obj;
//		if (baseType == null)
//		{
//			if (other.baseType != null)
//				return false;
//		}
//		else if (!baseType.equals(other.baseType))
//			return false;
//		if (ordered != other.ordered)
//			return false;
//		if (sorted != other.sorted)
//			return false;
//		if (unique != other.unique)
//			return false;
//		return true;
//	}

}
