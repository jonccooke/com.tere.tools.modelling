package com.tere.modelling.iterator;

import com.tere.modelling.model.TAttribute;
import com.tere.modelling.model.TBaseType;
import com.tere.modelling.model.TClass;
import com.tere.modelling.model.TCollection;
import com.tere.modelling.model.TDataType;
import com.tere.modelling.model.TEnum;
import com.tere.modelling.model.TEnumLiteral;
import com.tere.modelling.model.TMap;
import com.tere.modelling.model.TOperation;
import com.tere.modelling.model.TPackage;

public abstract class TIterator
{
	
	public void iterate(Object tBase)
	{
		if (tBase instanceof TAttribute)
		{
			found((TAttribute)tBase);
		}
		else if (tBase instanceof TBaseType)
		{
			found((TBaseType)tBase);
			
		}
		else if (tBase instanceof TClass)
		{
			found((TClass)tBase);
			
		}
		else if (tBase instanceof TCollection)
		{
			found((TDataType)tBase);
			
		}
		else if (tBase instanceof TEnum)
		{
			found((TEnum)tBase);
			
		}
		else if (tBase instanceof TEnumLiteral)
		{
			found((TEnumLiteral)tBase);
			
		}
		else if (tBase instanceof TMap)
		{
			found((TMap)tBase);
			
		}
		else if (tBase instanceof TOperation)
		{
			found((TOperation)tBase);
			
		}
		else if (tBase instanceof TPackage)
		{
			found((TPackage)tBase);
			
		}
	}

	public abstract void found(TPackage tBase);

	public abstract void found(TOperation tBase);

	public abstract void found(TEnumLiteral tBase);

	public abstract void found(TEnum tBase);

	public abstract void found(TDataType tBase);

	public abstract void found(TClass tBase);

	public abstract void found(TBaseType tBase);

	public abstract void found(TAttribute tBase);
}
