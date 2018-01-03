package com.tere.modelling.model;

public class TBaseType extends TBase
{
	private String instanceClassName;
	private boolean serialisable;
	private TPackage tPackage;

	public TBaseType(String name, TPackage tPackage)
	{
		super(name);
		this.tPackage = tPackage;
		String namespace = tPackage.getNamespace();
		if ((null != namespace) && (0 != namespace.length()))
		{
			setInstanceClassName(namespace + tPackage.getNamespaceToken() + name);
		}
		else
		{
			setInstanceClassName(name);

		}
	}

	public TBaseType(String name,
			String instanceClassName,
			TPackage tPackage)
	{
		this(name, tPackage);
		this.instanceClassName = instanceClassName;
	}

	public TBaseType(String name,
			String instanceClassName,
			boolean serialisable,
			TPackage tPackage)
	{
		this(name, instanceClassName, tPackage);
		this.serialisable = serialisable;
	}


	public TPackage getTPackage()
	{
		return tPackage;
	}
	
	public void setTPackage(TPackage genPackage)
	{
		this.tPackage = genPackage;
	}

	/**
	 * @param instanceClassName the instanceClassName to set
	 */
	public void setInstanceClassName(String instanceClassName)
	{
		this.instanceClassName = instanceClassName;
	}

	/**
	 * @return the instanceClassName
	 */
	public String getInstanceClassName()
	{
		return instanceClassName;
	}

	/**
	 * @param serialisable the serialisable to set
	 */
	public void setSerialisable(boolean serialisable)
	{
		this.serialisable = serialisable;
	}

	/**
	 * @return the serialisable
	 */
	public boolean isSerialisable()
	{
		return serialisable;
	}
	
	public String getQName()
	{
		if ((null != getTPackage()) && (null != getTPackage().getNamespace()))
		{
			return getTPackage().getNamespace() + getTPackage().getNamespaceToken()+ getName();
		}
		return getName();
	}

	@Override
	public String toString()
	{
		return "TBaseType [instanceClassName=" + instanceClassName
				+ ", serialisable=" + serialisable + ", tPackage=" + tPackage
				+ "]";
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime
//				* result
//				+ ((instanceClassName == null) ? 0 : instanceClassName
//						.hashCode());
//		result = prime * result + (serialisable ? 1231 : 1237);
//		result = prime * result
//				+ ((tPackage == null) ? 0 : tPackage.getQName().hashCode());
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
//		TBaseType other = (TBaseType) obj;
//		if (instanceClassName == null)
//		{
//			if (other.instanceClassName != null)
//				return false;
//		}
//		else if (!instanceClassName.equals(other.instanceClassName))
//			return false;
//		if (serialisable != other.serialisable)
//			return false;
//		if (tPackage == null)
//		{
//			if (other.tPackage != null)
//				return false;
//		}
//		else if (!tPackage.equals(other.tPackage))
//			return false;
//		return true;
//	}

}
