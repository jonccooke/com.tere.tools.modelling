package com.tere.modelling.model;

public class TMap extends TCollection
{
	private TBaseType keyBaseType;

	public TMap(String name,
			TBaseType keyBaseType,
			TBaseType baseType,
			TPackage tPackage)
	{
		super(name, baseType, false, tPackage);
	}

	public TMap(String name,
			TBaseType keyBaseType,
			TBaseType baseType,
			boolean ordered,
			boolean unique,
			TPackage tPackage)
	{
		super(name, baseType, ordered, unique, tPackage);
	}

	public TBaseType getBaseKeyType()
	{
		return keyBaseType;
	}

	@Override
	public String toString()
	{
		return "TMap [keyBaseType=" + keyBaseType + ", ordered=" + ordered
				+ ", unique=" + unique + "]";
	}
//
//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result
//				+ ((keyBaseType == null) ? 0 : keyBaseType.hashCode());
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
//		TMap other = (TMap) obj;
//		if (keyBaseType == null)
//		{
//			if (other.keyBaseType != null)
//				return false;
//		}
//		else if (!keyBaseType.equals(other.keyBaseType))
//			return false;
//		return true;
//	}

}
