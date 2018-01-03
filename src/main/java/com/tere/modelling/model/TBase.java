package com.tere.modelling.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class TBase
{
	private String name;
	private String displayName;
	private Map<String, TAnnotation> annotations = new LinkedHashMap<String, TAnnotation>();

	public TBase(String name)
	{
		super();
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String toString()
	{
		return "TBase [name=" + name + "]";
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void addAnnotation(TAnnotation annotation)
	{
		annotations.put(annotation.getName(), annotation);
	}

	public void addAnnotation(TPackage tPackage, String annotationName,
			String annotationEntryName, String annotationEntryValue)
	{
		TAnnotation tAnnotation = annotations.get(annotationName);
		if (null == tAnnotation)
		{
			tAnnotation = tPackage.getFactory()
					.createAnnotation(annotationName);
			addAnnotation(tAnnotation);
		}
//		tAnnotationEntry = new TAnnotationEntry(annotationEntryName,
//				annotationEntryValue);
		tAnnotation.addEntry(annotationEntryName, annotationEntryValue);
	}

	public Collection<TAnnotation> getAnnotations()
	{
		return annotations.values();
	}

	public String getAnnotation(String annotationName,
			String annotationEntryName)
	{
		TAnnotation tAnnotation = annotations.get(annotationName);

		if (null != tAnnotation)
		{
			return tAnnotation.getEntry(annotationEntryName);
		}
		return null;
	}

	public TAnnotation getAnnotation(String annotationName)
	{
		TAnnotation tAnnotation = annotations.get(annotationName);

		return tAnnotation;
	}

	public boolean containsAnnotation(String annotationName,
			String annotationEntryName)
	{
		TAnnotation tAnnotation = annotations.get(annotationName);

		if (null != tAnnotation)
		{
			boolean b = tAnnotation.containsEntry(annotationEntryName);
			return b;
		}
		return false;
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((annotations == null) ? 0 : annotations.hashCode());
//		result = prime * result
//				+ ((displayName == null) ? 0 : displayName.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj)
//	{
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TBase other = (TBase) obj;
//		if (annotations == null)
//		{
//			if (other.annotations != null)
//				return false;
//		}
//		else if (!annotations.equals(other.annotations))
//			return false;
//		if (displayName == null)
//		{
//			if (other.displayName != null)
//				return false;
//		}
//		else if (!displayName.equals(other.displayName))
//			return false;
//		if (name == null)
//		{
//			if (other.name != null)
//				return false;
//		}
//		else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

}
