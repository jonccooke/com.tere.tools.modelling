package com.tere.modelling.util;

import java.io.File;
import java.net.URI;

//import org.eclipse.emf.common.util.URI;
//import org.eclipse.emf.ecore.EClassifier;

public class NamespaceUtil
{
	public static final String NAMESPACE_SEPARATOR = ".";
	
//    public static String createNameSpace(EClassifier classifier)
//    {
//        return createNameSpace(classifier.getEPackage().getNsURI());
//    }
//
//    public static String createQName(EClassifier classifier)
//    {
//        return createNameSpace(classifier) + NAMESPACE_SEPARATOR + classifier.getName();
//    }
//
    public static String createNameSpace(String uriString)
    {
        String nameSpace = "";
        URI uri = URI.create(uriString);

        if (null != uri)
        {
            StringBuffer nsBuf = new StringBuffer();
            String authority = uri.getAuthority();
            if (null != authority)
            {
                String[] authoritySegments = authority.split("[" + NAMESPACE_SEPARATOR +"]");
                for (int nNsLoop = authoritySegments.length - 1; nNsLoop >= 0; nNsLoop--)
                {
                    if (!"www".equals(authoritySegments[nNsLoop]))
                    {
                        nsBuf.append(authoritySegments[nNsLoop]);
                        nsBuf.append(".");
                    }
                }
            }
//            String[] namespaceSegments = uri.getSegments();
//            if (null != namespaceSegments)
//            {
//                for (int nNsLoop = 0; nNsLoop < namespaceSegments.length; nNsLoop++)
//                {
//                    nsBuf.append(namespaceSegments[nNsLoop]);
//                    if (nNsLoop < namespaceSegments.length - 1)
//                    {
//                        nsBuf.append(".");
//                    }
//                }
//            }
//            nameSpace = nsBuf.toString();
        }
        return nameSpace;
    }

    public static String createPathFromNameSpace(String namespace)
    {
        return namespace.replaceAll("[" + NAMESPACE_SEPARATOR +"]", File.pathSeparator);
    }

}
