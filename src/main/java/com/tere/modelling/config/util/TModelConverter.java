package com.tere.modelling.config.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.tere.TereException;

public interface TModelConverter
{

	void convert(InputStream inputStream, OutputStream outputStream,
			Properties properties) throws TereException;

}
