package com.tere.modelling.model.factory;

public class TFactoryManager
{

	private static TFactoryManager instance = new TFactoryManager();
	
	private TFactory tFactory = new TFactory();
	
	public static TFactoryManager getInstance()
	{
		return instance;
	}

	/**
	 * @param tFactory the tFactory to set
	 */
	public void setFactory(TFactory tFactory)
	{
		this.tFactory = tFactory;
	}

	/**
	 * @return the tFactory
	 */
	public TFactory getFactory()
	{
		return tFactory;
	}

}
