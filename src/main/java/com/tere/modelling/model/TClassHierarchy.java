package com.tere.modelling.model;

import java.util.List;
import java.util.Vector;

public class TClassHierarchy extends TBase
{
	private List<TClass> classList = new Vector<TClass>();
	private List<TAttribute> allAttributes = new Vector<TAttribute>();
	private List<TReference> allOpposites = new Vector<TReference>();
	private List<TReference> allReferences = new Vector<TReference>();
	private List<TOperation> allOperations = new Vector<TOperation>();

	public List<TAttribute> getAllAttributes()
	{
		return allAttributes;
	}

	public List<TReference> getAllOpposites()
	{
		return allOpposites;
	}

	public List<TReference> getAllReferences()
	{
		return allReferences;
	}

	public List<TOperation> getAllOperations()
	{
		return allOperations;
	}

	public TClassHierarchy(TClass clazz)
	{
		super(clazz.getName());
	}

	protected void addAttributes(List<TAttribute> attributes)
	{
		for (TAttribute tAttribute : attributes)
		{
			if (!allAttributes.contains(tAttribute))
			{
				allAttributes.add(tAttribute);
			}
		}
	}

	protected void addReferences(List<TReference> references)
	{
		for (TReference tReference : references)
		{
			if (!allReferences.contains(tReference))
			{
				allReferences.add(tReference);
			}
		}
	}

	protected void addOpposites(List<TReference> opposites)
	{
		for (TReference tReference : opposites)
		{
			if (!allOpposites.contains(tReference))
			{
				allOpposites.add(tReference);
			}
		}
	}

	void addOperations(List<TOperation> operations)
	{
		for (TOperation tOperation : operations)
		{
			if (!allOperations.contains(tOperation))
			{
				allOperations.add(tOperation);
			}
		}
	}

	void addAttribute(TAttribute tAttribute)
	{
		if (!allAttributes.contains(tAttribute))
		{
			allAttributes.add(tAttribute);
		}
	}

	void addReference(TReference tReference)
	{
		if (!allReferences.contains(tReference))
		{
			allReferences.add(tReference);
		}
	}

	void addOpposite(TReference opposite)
	{
		if (!allOpposites.contains(opposite))
		{
			allOpposites.add(opposite);
		}
	}

	void addOperation(TOperation operation)
	{
		if (!allOperations.contains(operation))
		{
			allOperations.add(operation);
		}
	}

	public void addClass(TClass tClass)
	{
		if (!classList.contains(tClass))
		{
			classList.add(classList.indexOf(tClass.getParent()) + 1, tClass);
			// addAttributes(tClass.getAttributes());
			// addReferences(tClass.getReferences());
			// addOpposites(tClass.getOpposites());
			// addOperations(tClass.getOperations());
		}
	}

	public List<TClass> getClasses()
	{
		return classList;
	}
}
