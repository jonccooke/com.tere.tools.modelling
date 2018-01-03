package com.tere.modelling.config.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.tere.TereException;
import com.tere.logging.LogManager;
import com.tere.logging.Logger;
import com.tere.utils.directory.FileUtils;

public class TModelPathConverter<T extends TModelConverter>
{
	public Logger log = LogManager.getLogger(TModelPathConverter.class);
	private T converter;

	public TModelPathConverter(T converter)
	{
		this.converter = converter;
	}

	public void convert(String src, String dest, Properties properties)
			throws TereException
	{
		InputStream sourceStream = null;
		OutputStream destStream = null;
		try
		{
			sourceStream = FileUtils.getInputStream(src);
			destStream = new FileOutputStream(FileUtils.toAbsoluteFilePath(dest));
			converter.convert(sourceStream, destStream, properties);
		}
		catch (IOException e)
		{
			throw new TereException(e);
		}
		finally
		{
			if (null != sourceStream)
			{
				try
				{
					sourceStream.close();
				}
				catch (IOException e)
				{
					log.error(e.getMessage());
				}
			}
			if (null != destStream)
			{
				try
				{
					destStream.close();
				}
				catch (IOException e)
				{
					log.error(e.getMessage());
				}
			}
		}
		
	}


//	/**
//	 * @param args
//	 */
//	public static void main(String[] args)
//	{
//		TModelPathConverter<EcoreToTModelConverter> converter = new TModelPathConverter<EcoreToTModelConverter>(new EcoreToTModelConverter());
//		if (args.length < 2)
//		{
//			converter.log.info("usage: TModelPathConverter <ecore file> <tmodel file>");
//			return;
//			
//		}
//		try
//		{
//			converter.convert(args[0], args[1], new Properties());
//		}
//		catch (TereException e)
//		{
//			converter.log.error(e.getMessage());
//		}
//	}


}
