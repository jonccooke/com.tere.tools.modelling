package com.tere.modelling.model;

public class TAttribute extends TElement
{
	private TDataType type;
	private boolean identity = false;
	private Integer length;
	private Integer scale;
	private Integer precision;
	private String format;
	private TClass owner;

	public TAttribute(String name, TDataType type, TClass owner)
	{
		super(name);
		this.type = type;
		this.setOwner(owner);
	}

	public TAttribute(String name, TDataType type)
	{
		super(name);
		this.type = type;
	}

	public TDataType getType()
	{
		return type;
	}

	public void setType(TDataType type)
	{
		this.type = type;
	}

	@Override
	public String toString()
	{
		return "TAttribute [name =" + getName() + ", changeable=" + readOnly + ", identity=" + identity
				+ ", type=" + type + "]";
	}

	public boolean isIdentity()
	{
		return identity;
	}

	public void setIdentity(boolean identity)
	{
		this.identity = identity;
	}

	public Integer getLength()
	{
		return length;
	}

	public void setLength(Integer length)
	{
		this.length = length;
	}

	public Integer getScale()
	{
		return scale;
	}

	public void setScale(Integer scale)
	{
		this.scale = scale;
	}

	public Integer getPrecision()
	{
		return precision;
	}

	public void setPrecision(Integer precision)
	{
		this.precision = precision;
	}

	public String getFormat()
	{
		return format;
	}

	public void setFormat(String format)
	{
		this.format = format;
	}

	public TClass getOwner()
	{
		return owner;
	}

	public void setOwner(TClass owner)
	{
		this.owner = owner;
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + ((format == null) ? 0 : format.hashCode());
//		result = prime * result + (identity ? 1231 : 1237);
//		result = prime * result + ((length == null) ? 0 : length.hashCode());
//		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
//		result = prime * result
//				+ ((precision == null) ? 0 : precision.hashCode());
//		result = prime * result + ((scale == null) ? 0 : scale.hashCode());
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
//		TAttribute other = (TAttribute) obj;
//		if (format == null)
//		{
//			if (other.format != null)
//				return false;
//		}
//		else if (!format.equals(other.format))
//			return false;
//		if (identity != other.identity)
//			return false;
//		if (length == null)
//		{
//			if (other.length != null)
//				return false;
//		}
//		else if (!length.equals(other.length))
//			return false;
//		if (owner == null)
//		{
//			if (other.owner != null)
//				return false;
//		}
//		else if (!owner.equals(other.owner))
//			return false;
//		if (precision == null)
//		{
//			if (other.precision != null)
//				return false;
//		}
//		else if (!precision.equals(other.precision))
//			return false;
//		if (scale == null)
//		{
//			if (other.scale != null)
//				return false;
//		}
//		else if (!scale.equals(other.scale))
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
