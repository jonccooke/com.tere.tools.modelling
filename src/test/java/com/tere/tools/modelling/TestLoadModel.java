package com.tere.tools.modelling;

import java.io.IOException;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.tere.TereException;
import com.tere.logging.LogManager;
import com.tere.logging.Logger;
import com.tere.modelling.config.tmodel.xml.TModelXMLReader;
import com.tere.modelling.config.tmodel.xml.TModelXMLReader.TClassListener;
import com.tere.modelling.config.tmodel.xml.TModelXMLReader.TClassOperationListener;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TOperation;
import com.tere.modelling.model.TPackage;
import com.tere.utils.directory.FileUtils;

public class TestLoadModel
{

	private static Logger log = LogManager.getLogger(TestLoadModel.class);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
	}

	@Test
	public void testLoadModel() throws TereException, IOException
	{
		TModelXMLReader modelXMLReader = new TModelXMLReader();

		Collection<TPackage> packages = modelXMLReader
				.read(FileUtils.getInputStream("src/test/resources/valuationmodelOpenGamma.xml"), null);

	}

	@Test
	public void testLoadModelClassListeners() throws TereException, IOException
	{
		TModelXMLReader modelXMLReader = new TModelXMLReader();

		modelXMLReader.addTClassListener(new TClassListener()
		{

			@Override
			public void onCreate(TClass tClass)
			{

				log.info(tClass.getName());
			}
		});
		Collection<TPackage> packages = modelXMLReader
				.read(FileUtils.getInputStream("classpath:Risk.tmodel"), null);

	}

	@Test
	public void testLoadModelOperationListeners()
			throws TereException, IOException
	{
		TModelXMLReader modelXMLReader = new TModelXMLReader();

		modelXMLReader.addTOperationListener(new TClassOperationListener()
		{

			@Override
			public void onCreate(TClass tClass, TOperation tOperation)
			{
				log.info(tClass.getName() + ":" +tOperation.getName());

			}

		});
		Collection<TPackage> packages = modelXMLReader
				.read(FileUtils.getInputStream("classpath:Risk.tmodel"), null);

	}

}
