package com.tere.modelling.model;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Vector;

public class TAnnotation
{
	private String annotationName;
	private Map<String, String> annotationEntries = new LinkedHashMap<String, String>();
	
	public TAnnotation(String annotationName)
	{
		this.annotationName = annotationName;
	}
	
	public String getName()
	{
		return annotationName;
	}

	public void setName(String annotationName)
	{
		this.annotationName = annotationName;
	}
	
//	public void addEntry(TAnnotationEntry annotationEntry)
//	{
//		annotationEntries.put(annotationEntry.getAnnotationName(), annotationEntry);
//	}
//
	public void addEntry(String name, String value)
	{
		annotationEntries.put(name, value);
	}

//	public Collection<TAnnotationEntry> getEntries()
//	{
//		return new Vector<TAnnotationEntry>(annotationEntries.values());
//	}
	
	public String getEntry(String annotationEntryName)
	{
//		TAnnotationEntry tAnnotationEntry = annotationEntries.get(annotationEntryName);
//		
//		if (null != tAnnotationEntry)
//		{
//			return tAnnotationEntry.getAnnotationEntryValue();
//		}
		return annotationEntries.get(annotationEntryName);
	}

	public boolean containsEntry(String annotationEntryName)
	{
		return annotationEntries.containsKey(annotationEntryName);
	}

	@Override
	public String toString()
	{
		StringBuffer buffer = new StringBuffer(annotationName);
		buffer.append(":{");
		for (Map.Entry<String, String> annotationEntry : annotationEntries.entrySet())
		{
			buffer.append("{");
			buffer.append(annotationEntry.getKey());
			buffer.append(" : ");
			buffer.append(annotationEntry.getValue());
			buffer.append("}");
		}
		buffer.append("}");
		return buffer.toString();
	}

//	@Override
//	public int hashCode()
//	{
//		final int prime = 31;
//		int result = 1;
//		result = prime
//				* result
//				+ ((annotationEntries == null) ? 0 : annotationEntries
//						.hashCode());
//		result = prime * result
//				+ ((annotationName == null) ? 0 : annotationName.hashCode());
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
//		TAnnotation other = (TAnnotation) obj;
//		if (annotationEntries == null)
//		{
//			if (other.annotationEntries != null)
//				return false;
//		}
//		else if (!annotationEntries.equals(other.annotationEntries))
//			return false;
//		if (annotationName == null)
//		{
//			if (other.annotationName != null)
//				return false;
//		}
//		else if (!annotationName.equals(other.annotationName))
//			return false;
//		return true;
//	}

}
