package com.tere.modelling.model;


public class TDataType extends TBaseType
{
	private boolean primative = false;

	public TDataType(String name, TPackage tPackage)
	{
		super(name, tPackage);
	}
	
	public TDataType(String name, TPackage tPackage, String instanceClassName)
	{
		super(name, instanceClassName, tPackage);
	}

	public TDataType(String name,
			String instanceClassName,
			boolean serialisable,
			TPackage tPackage)
	{
		super(name, instanceClassName, serialisable, tPackage);
	}


	public boolean isPrimative()
	{
		return primative;
	}

	public void setPrimative(boolean primative)
	{
		this.primative = primative;
	}

	public boolean isCollection()
	{
		return false;
	}

	@Override
	public String toString()
	{
		return "TDataType [name=" + getName() + ", primative=" + primative + ", instanceClass="+ getInstanceClassName() + "]";
	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + (primative ? 1231 : 1237);
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
//		TDataType other = (TDataType) obj;
//		if (primative != other.primative)
//			return false;
//		return true;
//	}
//

}
