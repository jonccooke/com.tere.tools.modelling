package com.tere.modelling.config;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Properties;

import com.tere.modelling.exeptions.ModellingException;
import com.tere.modelling.model.TPackage;

public interface Exporter
{
	public void exportModel(Properties properties, Collection<TPackage>packages, OutputStream outputStream) throws ModellingException;
}
