package com.tere.modelling.model.factory;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.tere.modelling.model.TBaseType;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TEnum;
import com.tere.modelling.model.TPackage;

public class TPackageManager
{

	private static TPackageManager instance = new TPackageManager();
	
	private TFactory tFactory = new TFactory();
	
	private static Map<String, TPackage> packages;
	
	private Map<String, TBaseType> types;
	
	private TPackageManager()
	{
		packages = new ConcurrentHashMap<String, TPackage>();
		types = new ConcurrentHashMap<String, TBaseType>();
	}
	
	public static TPackageManager getInstance()
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

	public void putPackage(TPackage tPackage)
	{
		packages.put(tPackage.getQName(), tPackage);
		
		for (TDataType type : tPackage.getDataTypes())
		{
			types.put(type.getQName(), type);
		}
		for (TEnum type : tPackage.getEnums())
		{
			types.put(type.getQName(), type);
		}
		for (TClass type : tPackage.getClasses())
		{
			types.put(type.getQName(), type);
		}
	}

	public TPackage getPackage(String qName)
	{
		return packages.get(qName);
	}

	public TBaseType getTBaseType(String qName)
	{
		return types.get(qName);
	}
}
