package com.tere.modelling.config.json;

import java.io.InputStream;
import java.util.Collection;
import java.util.Properties;

import com.tere.TereException;
import com.tere.modelling.config.Importer;
import com.tere.modelling.model.TPackage;

public class JSONImporter implements Importer
{

	@Override
	public Collection<TPackage> importModel(InputStream inputStream,
			Properties properties) throws TereException
	{
//		ResourceSet resourceSet = new ResourceSetImpl();
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsResourceFactoryImpl());
//		
//		Resource resource = resourceSet.createResource(URI.createURI("model.json"));
//		Map<String, Object> options = new HashMap<String, Object>();
//		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
//		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);
//
//		LibraryShelf aShelf = LibraryFactory.eINSTANCE.createLibraryShelf();
//		aShelf.setName("My Shelf");
//
//		Book aBook = LibraryFactory.eINSTANCE.createBook();
//		aBook.setTitle("EMF: Eclipse Modeling Framework (2nd Edition)");
//		aBook.setNumPages(739);
//		aShelf.getItems().add(aBook);
//
//		resource.getContents().add(aShelf);
//		resource.save(options);
		return null;
		}

}
