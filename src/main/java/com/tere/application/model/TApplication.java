package com.tere.application.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.tere.modelling.model.TBase;
import com.tere.modelling.model.TPackage;
import com.tere.modelling.model.TParameter;
import com.tere.modelling.model.factory.TPackageManager;

public class TApplication extends TBase
{

	protected Map<String, TPackage> packages;
	protected Map<String, TParameter> variables;
	protected String baseNamespace;
	protected String platform;
	protected String platformVersion;
	protected String version;
	protected String modelNamespace;
	protected String daoNamespace;
	protected String dataNamespace;
	protected String ioNamespace;
	protected String servicesNamespace;
	protected String uiNamespace;
	protected String resourcesPath;


	public TApplication(String name)
	{
		super(name);
		packages = new HashMap<String, TPackage>();
		variables = new HashMap<String, TParameter>();
	}

	public String getDataNamespace()
	{
		return dataNamespace;
	}

	public void setDataNamespace(String dataNamespace)
	{
		this.dataNamespace = dataNamespace;
	}

	public String getModelNamespace()
	{
		return modelNamespace;
	}

	public void setModelNamespace(String modelNamespace)
	{
		this.modelNamespace = modelNamespace;
	}

	public String getDaoNamespace()
	{
		return daoNamespace;
	}

	public void setDaoNamespace(String daoNamespace)
	{
		this.daoNamespace = daoNamespace;
	}

	public String getIoNamespace()
	{
		return ioNamespace;
	}

	public void setIoNamespace(String ioNamespace)
	{
		this.ioNamespace = ioNamespace;
	}

	public String getServicesNamespace()
	{
		return servicesNamespace;
	}

	public void setServicesNamespace(String servicesNamespace)
	{
		this.servicesNamespace = servicesNamespace;
	}

	public String getUiNamespace()
	{
		return uiNamespace;
	}

	public void setUiNamespace(String uiNamespace)
	{
		this.uiNamespace = uiNamespace;
	}

	public String getResourcesPath()
	{
		return resourcesPath;
	}

	public void setResourcesPath(String resourcesPath)
	{
		this.resourcesPath = resourcesPath;
	}

	public String getBaseNamespace()
	{
		return baseNamespace;
	}

	public void setBaseNamespace(String namespace)
	{
		this.baseNamespace = namespace;
	}

	public String getPlatform()
	{
		return platform;
	}

	public void setPlatform(String platform)
	{
		this.platform = platform;
	}

	public String getPlatformVersion()
	{
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion)
	{
		this.platformVersion = platformVersion;
	}

	public String getVersion()
	{
		return version;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public void putPackage(TPackage tPackage)
	{
		packages.put(tPackage.getQName(), tPackage);
		TPackageManager.getInstance().putPackage(tPackage);
	}

	public void putVariable(TParameter variable)
	{
		variables.put(variable.getName(), variable);
	}

	public Collection<TPackage> getPackages()
	{
		return packages.values();
	}

	public Collection<TParameter> getVariables()
	{
		return variables.values();

	}

	public void setPackages(Map<String, TPackage> packages)
	{
		this.packages = packages;
	}

	public void setVariables(Map<String, TParameter> variables)
	{
		this.variables = variables;
	}

	public void addPackages(Collection<TPackage> packages)
	{
		for (TPackage tPackage : packages)
		{
			putPackage(tPackage);
		}
	}

	
}
