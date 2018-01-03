package com.tere.modelling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Vector;

import com.tere.modelling.exeptions.ModellingException;
import com.tere.modelling.exeptions.OperationNotFoundException;
import com.tere.modelling.exeptions.TClassHeirarchyNotFoundException;
import com.tere.utils.list.ListUtils;

public class TClass extends TBaseType
{
	private LinkedHashMap<String, TOperation> operations = new LinkedHashMap<String, TOperation>();
	private LinkedHashMap<String, TAttribute> attributes = new LinkedHashMap<String, TAttribute>();
	private LinkedHashMap<String, TReference> references = new LinkedHashMap<String, TReference>();
	private List<TReference> opposites = new Vector<TReference>();
	private TClass parent = null;
	//private HashSet<TClass> children = new LinkedHashSet<TClass>();
	private boolean abs;
	private TClass baseClass = null;
	private boolean intrface = false;

	// public TClass(String name)
	// {
	// super(name);
	// setInstanceClassName(name);
	// }

	public TClass(String name, TPackage tPackage, String instanceClassName)
	{
		super(name, tPackage);
		setInstanceClassName(instanceClassName);
	}

	public TClass(String name, TPackage tPackage)
	{
		super(name, tPackage);
	}

	public TClass(String name, String instanceClassName, TPackage tPackage)
	{
		super(name, tPackage);
		setInstanceClassName(instanceClassName);
	}

	public String getNamespace()
	{
		if (null != getTPackage())
		{
			return getTPackage().getNamespace();
		}
		return "";
	}

	public boolean isInterface()
	{
		return intrface;
	}

	public void setInterface(boolean intrface)
	{
		this.intrface = intrface;
	}

	public List<TOperation> getOperations()
	{
		return new ArrayList<TOperation>(operations.values());
	}


	public List<TOperation> getAllOperations()
	{
		List<TOperation> operations = new ArrayList<TOperation>();
		
		operations.addAll(getOperations());
		for (TClass parent : getAllParents())
		{
			operations.addAll(parent.getAllOperations());
		}

		return operations;
	}

	public boolean isAbstract()
	{
		return abs;
	}

	public void setAbstract(boolean abs)
	{
		this.abs = abs;
	}

	public void putAttribute(TAttribute attribute)
	{
		attributes.put(attribute.getName(), attribute);
		try
		{
			getTPackage().getClassHeirarchy(getBaseClass()).addAttribute(attribute);
		}
		catch (TClassHeirarchyNotFoundException e)
		{
		}
	}

	public TAttribute getAttribute(String name)
	{
		return attributes.get(name);
	}

	public List<TAttribute> getAttributes()
	{
		return new ArrayList<TAttribute>(attributes.values());
	}

	public List<TAttribute> getAllAttributes()
	{
		List<TAttribute> attributes = new ArrayList<TAttribute>();
		
		attributes.addAll(getAttributes());
		for (TClass parent : getAllParents())
		{
			attributes.addAll(parent.getAttributes());
		}

		return attributes;
//		Vector<TAttribute> attrs = new Vector<TAttribute>();
//		if (null != parent)
//		{
//			attrs.addAll(parent.getAttributes());
//		}
//
//		attrs.addAll(attributes.values());
//
//		for (TClass child : children)
//		{
//			attrs.addAll(child.getAttributes());
//		}

//		return attrs;
	}

	public List<TAttribute> getObjectAndParentAttributes()
	{
		Vector<TAttribute> attrs = new Vector<TAttribute>(getAllParentAttributes());

		attrs.addAll(attributes.values());

		return attrs;
	}

	public List<TAttribute> getPrimaryAttributes()
	{
		Vector<TAttribute> retAttributes = new Vector<TAttribute>();
		for (TAttribute attribute : getAttributes())
		{
			if (attribute.isIdentity())
			{
				retAttributes.add(attribute);
			}
		}
		if (null != parent)
		{
			retAttributes.addAll(parent.getPrimaryAttributes());
		}

		return retAttributes;
	}

	public List<TAttribute> getNonPrimaryAttributes()
	{
		Vector<TAttribute> retAttributes = new Vector<TAttribute>();
		for (TAttribute attribute : getAttributes())
		{
			if (!attribute.isIdentity())
			{
				retAttributes.add(attribute);
			}
		}

		return retAttributes;
	}

//	public List<TAttribute> getAllChildAttributes()
//	{
//		Vector<TAttribute> attrs = new Vector<TAttribute>();
//
//		for (TClass child : children)
//		{
//			attrs.addAll(child.getAttributes());
//		}
//
//		return attrs;
//	}

	public List<TAttribute> getAllPrimaryAttributes()
	{
		Vector<TAttribute> retAttributes = new Vector<TAttribute>();
		for (TAttribute attribute : getAllAttributes())
		{
			if (attribute.isIdentity())
			{
				retAttributes.add(attribute);
			}
		}

		return retAttributes;
	}

	public List<TAttribute> getAllNonPrimaryAttributes()
	{
		Vector<TAttribute> retAttributes = new Vector<TAttribute>();
		for (TAttribute attribute : getAllAttributes())
		{
			if (!attribute.isIdentity())
			{
				retAttributes.add(attribute);
			}
		}

		return retAttributes;
	}

	public List<TAttribute> getAllParentAttributes()
	{
		Vector<TAttribute> attrs = new Vector<TAttribute>();
		if (null != parent)
		{
			TClass curParent = parent;
			while (null != curParent)
			{
				attrs.addAll(curParent.getAttributes());
				curParent = curParent.getParent();
			}
		}

		return attrs;
	}

	public void putOperation(TOperation operation)
	{
		operations.put(operation.getName(), operation);
		try
		{
			getTPackage().getClassHeirarchy(getBaseClass()).addOperation(operation);
		}
		catch (TClassHeirarchyNotFoundException e)
		{
		}
	}

	public TOperation getOperation(String operationName) throws ModellingException
	{
		if (operations.containsKey(operationName))
		{
			return operations.get(operationName);
		}
		else throw new OperationNotFoundException(operationName);
	}

	public void putOperations(Collection<TOperation> operations)
	{
		for (TOperation operation : operations)
		{
			putOperation(operation);
		}
	}

//	public void addParent(TClass parent)
//	{
//		this.parent = parent;
//		
//		if (getName().equals("FXAccount"))
//		{
//			int n=0;
//			n++;
//		}
//
//		parent.addChild(this);
//	}

	public void setParent(TClass parent)
	{
		this.parent = parent;
//		TClass curParent = parent;
//		
//		while (null != curParent)
//		{
//		if (null != parent.getBaseClass())
//		{
//			this.baseClass = parent.getBaseClass();
//		}
//		else
//		{
//			this.baseClass = parent;
//		}
		
	}

//	private void addChild(TClass child)
//	{
//		if (!children.contains(child))
//		{
//			children.add(child);
//			for (TClass parent : getAllParents())
//			{
//				parent.addChild(child);
//			}
//			for (TClass curChild : child.getChildren())
//			{
//				children.add(child);
//			}
//		}
//	}


	public List<TClass> getAllParents()
	{
		List<TClass> parents = new Vector<TClass>();

		TClass curParent = getParent();

		while (null != curParent)
		{
			parents.add(curParent);

			curParent = curParent.getParent();
		}

		return parents;
	}
//
//	public List<TClass> getChildren()
//	{
//		return new Vector<TClass>(children);
//	}

	public void putReference(TReference reference)
	{
		references.put(reference.getName(), reference);
		reference.setBase(this);
		try
		{
			getTPackage().getClassHeirarchy(getBaseClass()).addReference(reference);
		}
		catch (TClassHeirarchyNotFoundException e)
		{
		}

	}

	public TElement getReference(String name)
	{
		return references.get(name);
	}

	public List<TReference> getReferences()
	{
		return new Vector<TReference>(references.values());
	}

	public List<TReference> getObjectAndParentReferences()
	{
		Vector<TReference> refs = new Vector<TReference>(
				getAllParentReferences());
		refs.addAll(getReferences());
		return refs;
	}

	public List<TReference> getAllReferences()
	{
		List<TReference> references = new ArrayList<TReference>();
		
		references.addAll(getReferences());
		for (TClass parent : getAllParents())
		{
			references.addAll(parent.getReferences());
		}

		return references;
//		Vector<TReference> refs = new Vector<TReference>(
//				getObjectAndParentReferences());
//
//		refs.addAll(getAllChildReferences());
//		if (null == baseClass)
//		{
//			return getTPackage().getTClassHeirarchy(this).getAllReferences();
//		}
//		try
//		{
//			return getTPackage().getClassHeirarchy(getBaseClass()).getAllReferences();
//		}
//		catch (TClassHeirarchyNotFoundException e)
//		{
//			return null;
//		}

//		return refs;
	}

//	public List<TReference> getAllChildReferences()
//	{
//		Vector<TReference> refs = new Vector<TReference>();
//
//		for (TClass child : children)
//		{
//			refs.addAll(child.getReferences());
//		}
//
//		return refs;
//	}

	public List<TReference> getAllParentReferences()
	{
		Vector<TReference> refs = new Vector<TReference>();
		if (null != parent)
		{
			TClass curParent = parent;
			while (null != curParent)
			{
				refs.addAll(curParent.getReferences());
				curParent = curParent.getParent();
			}
		}
		return refs;
	}

	public void addOpposite(TReference tReference)
	{
		opposites.add(tReference);
	}

	public List<TReference> getOpposites()
	{
		return opposites;
	}

	public List<TReference> getAllOpposites()
	{
		List<TReference> opposites = new ArrayList<TReference>();
		
		opposites.addAll(getOpposites());
		for (TClass parent : getAllParents())
		{
			opposites.addAll(parent.getOpposites());
		}

		return opposites;
//		try
//		{
//			return getTPackage().getClassHeirarchy(getBaseClass()).getAllOpposites();
//		}
//		catch (TClassHeirarchyNotFoundException e)
//		{
//			return null;
//		}
	}

	public List<TReference> getObjectAndParentOpposites()
	{
		Vector<TReference> refs = new Vector<TReference>(
				getAllParentOpposites());

		refs.addAll(opposites);
		return refs;
	}

//	public List<TReference> getAllChildOpposites()
//	{
//		Vector<TReference> refs = new Vector<TReference>();
//
//		for (TClass child : children)
//		{
//			refs.addAll(child.getOpposites());
//		}
//		return refs;
//	}

	public List<TReference> getAllParentOpposites()
	{
		Vector<TReference> refs = new Vector<TReference>();
		if (null != parent)
		{
			TClass curParent = parent;
			while (null != curParent)
			{
				refs.addAll(curParent.getOpposites());
				curParent = curParent.getParent();
			}
		}
		return refs;
	}

	public List<TClass> getAllClasses()
	{
		List<TClass> classes = new ArrayList<TClass>();
		
		classes.add(this);
		for (TClass parent : getAllParents())
		{
			classes.add(parent);
		}

		return classes;
//		try
//		{
//			return getTPackage().getClassHeirarchy(getBaseClass()).getClasses();
//		}
//		catch (TClassHeirarchyNotFoundException e)
//		{
//			return null;
//		}
	}

	@Override
	public String toString()
	{
		return "TClass [name=" + getName() + "]";
	}

	public TClass getParent()
	{
		return parent;
	}

	public TClass getBaseClass()
	{
		TClass curParent = parent;
		if (null != parent)
		{
			while (null != curParent)
			{
				if (null == curParent.getParent())
				{
					break;
				}
				curParent = curParent.getParent();
			}
		}
		else
		{
			return this;
		}
		
		return curParent;
	}
//
//	public void setBaseClass(TClass baseClass)
//	{
//		this.baseClass = baseClass;
//	}

	@Override
	public String getInstanceClassName()
	{
		return super.getInstanceClassName();
	}

	public boolean isHasChildren()
	{
		try
		{
			return getTPackage().getClassHeirarchy(getBaseClass()).getClasses().size() != 1;
		}
		catch (TClassHeirarchyNotFoundException e)
		{
			return false;
		}
	}

	public boolean isHasParent()
	{
		return null != parent;
	}

	public Collection<TClass> getUniqueReferenceTypes()
	{
		List<TClass> uTypes = new Vector<TClass>();

		for (TReference type : getReferences())
		{
			ListUtils.addUnique(type.getType(), uTypes);
		}
		for (TReference type : getOpposites())
		{
			ListUtils.addUnique(type.getType(), uTypes);
		}
		return uTypes;
	}

	public Collection<TEnum> getUniqueENumTypes()
	{
		List<TEnum> uTypes = new Vector<TEnum>();

		for (TAttribute type : getAttributes())
		{
			if (type.getType() instanceof TEnum)
			{
				ListUtils.addUnique(type.getType(), uTypes);
			}
		}
		return uTypes;
	}

	public Collection<TClass> getAllUniqueReferenceTypes()
	{
		List<TClass> uTypes = new Vector<TClass>();

		for (TReference type : getAllReferences())
		{
			ListUtils.addUnique(type.getType(), uTypes);
		}
		for (TReference type : getAllOpposites())
		{
			ListUtils.addUnique(type.getType(), uTypes);
		}
		return uTypes;
	}

	public Collection<TEnum> getAllUniqueEnumTypes()
	{
		List<TEnum> uTypes = new Vector<TEnum>();

		for (TAttribute type : getAllAttributes())
		{
			if (type.getType() instanceof TEnum)
			{
				ListUtils.addUnique(type.getType(), uTypes);
			}
		}
		return uTypes;
	}

	public Collection<TBaseType> getAllUniqueTypes()
	{
		List<TBaseType> uTypes = new Vector<TBaseType>();
		uTypes.addAll(getAllUniqueReferenceTypes());
		uTypes.addAll(getAllUniqueEnumTypes());
		if (!uTypes.contains(this))
		{
			uTypes.add(this);
		}
		return uTypes;
	}


}