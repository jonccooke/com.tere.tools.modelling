package com.tere.modelling.config;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import com.tere.TereException;
import com.tere.modelling.model.TPackage;

public interface Importer
{
    public Collection<TPackage> importModel(InputStream inputStream, Properties properties) throws TereException;

}
