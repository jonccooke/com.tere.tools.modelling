package com.tere.modelling.model;


public class TParameter extends TElement
{
	private TBaseType tDataType;
	private int length;
	private int scale;
	private int precision;
    protected String format;
	private boolean isReference;

	public int getLength()
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public int getScale()
	{
		return scale;
	}

	public void setScale(int scale)
	{
		this.scale = scale;
	}

	public int getPrecision()
	{
		return precision;
	}

	public void setPrecision(int precision)
	{
		this.precision = precision;
	}

	public TParameter(String name, TBaseType type)
	{
		super(name);
		this.tDataType = type;
		if (type instanceof TClass)
		{
			isReference =  true;
		}
	}

	public TBaseType getType()
	{
		return tDataType;
	}

	@Override
	public String toString()
	{
		return "TParameter name:"+getName() +", [tDataType=" + tDataType + "]";
	}
//
//	public void setType(TBaseType tDataType)
//	{
//		this.tDataType = tDataType;
//	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public boolean isReference()
	{
		return isReference;
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((format == null) ? 0 : format.hashCode());
//		result = prime * result + length;
//		result = prime * result + precision;
//		result = prime * result + scale;
//		result = prime * result
//				+ ((tDataType == null) ? 0 : tDataType.hashCode());
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
//		TParameter other = (TParameter) obj;
//		if (format == null)
//		{
//			if (other.format != null)
//				return false;
//		}
//		else if (!format.equals(other.format))
//			return false;
//		if (length != other.length)
//			return false;
//		if (precision != other.precision)
//			return false;
//		if (scale != other.scale)
//			return false;
//		if (tDataType == null)
//		{
//			if (other.tDataType != null)
//				return false;
//		}
//		else if (!tDataType.equals(other.tDataType))
//			return false;
//		return true;
//	}

}
