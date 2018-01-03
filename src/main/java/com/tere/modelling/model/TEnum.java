package com.tere.modelling.model;

import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class TEnum extends TDataType
{
	private List<TEnumLiteral> literals = new Vector<TEnumLiteral>();

	private TEnumLiteral defaultLiteral;
	private boolean sorted= true;
	
	public TEnum(String name, TPackage tPackage)
	{
		super(name, tPackage);
	}

	public TEnum(String name, TPackage tPackage, String instanceClassName)
	{
		super(name, tPackage, instanceClassName);
	}


	public TEnumLiteral getDefaultLiteral()
	{
		return defaultLiteral;
	}

	public void addLiteral(TEnumLiteral literal, boolean isDefault)
	{
		literals.add(literal);
		
		defaultLiteral = literal;
	}

	public void addLiteral(TEnumLiteral literal)
	{
		literals.add(literal);
	}

	public Collection<TEnumLiteral> getLiterals()
	{
		return literals;
	}

	@Override
	public String toString()
	{
		return "TEnum [defaultLiteral=" + defaultLiteral + ", literals="
				+ literals + "]";
	}

	@Override
	public boolean isPrimative()
	{
		return false;
	}

	public boolean isEnum()
	{
		return true;
	}

	public boolean isSorted()
	{
		return sorted;
	}

	public void setSorted(boolean sorted)
	{
		this.sorted = sorted;
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result
//				+ ((defaultLiteral == null) ? 0 : defaultLiteral.hashCode());
//		result = prime * result
//				+ ((literals == null) ? 0 : literals.hashCode());
//		result = prime * result + (sorted ? 1231 : 1237);
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
//		TEnum other = (TEnum) obj;
//		if (defaultLiteral == null)
//		{
//			if (other.defaultLiteral != null)
//				return false;
//		}
//		else if (!defaultLiteral.equals(other.defaultLiteral))
//			return false;
//		if (literals == null)
//		{
//			if (other.literals != null)
//				return false;
//		}
//		else if (!literals.equals(other.literals))
//			return false;
//		if (sorted != other.sorted)
//			return false;
//		return true;
//	}
}
