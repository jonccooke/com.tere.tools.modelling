package com.tere.modelling.config;

import com.tere.modelling.model.TDataType;

public interface TModelAdaptor<T>
{
	public void putDefaultType(T dataType, TDataType tDataType);
	
	public TDataType getDefaultType(T dataType);

	public T getDefaultType(TDataType dataType);


}
