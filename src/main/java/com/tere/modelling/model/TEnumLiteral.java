package com.tere.modelling.model;


public class TEnumLiteral extends TBase
{
	private int literalValue;
	
	public TEnumLiteral(String name, int literalValue)
	{
		super(name);
		this.literalValue = literalValue;
	}

	public int getLiteralValue()
	{
		return literalValue;
	}

	@Override
	public String toString()
	{
		return "TEnumLiteral [literalValue=" + literalValue + ", name()="
				+ getName() + "]";
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + literalValue;
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
//		TEnumLiteral other = (TEnumLiteral) obj;
//		if (literalValue != other.literalValue)
//			return false;
//		return true;
//	}

}
