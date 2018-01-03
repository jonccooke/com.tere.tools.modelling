package com.tere.modelling.config.datasource;

import java.io.OutputStream;
import java.util.Collection;
import java.util.Properties;

import com.tere.modelling.config.Exporter;
import com.tere.modelling.model.TPackage;

public class DBExporter implements Exporter {

	@Override
	public void exportModel(Properties properties, Collection<TPackage> list,
			OutputStream outputStream) {
//		JDBCAccess dsAccess = null;
//		try {
//			dsAccess = (JDBCAccess)DataSourceManager.getDSAccess(properties);
//
//			dsAccess.connect(properties);
//
//			DSMeta meta = dsAccess.getDSMeta();
//			Map<String, DSCatalog> catalogs = meta.getCatalogs();
//
//			// for (
//			// DSCatalog catalog = catalogs.get("OWNER_SIT_REL");
//			for (DSCatalog catalog : catalogs.values()) {
//				System.out.println(String.format("Catalog:%s", catalog
//						.getCatalogName()));
//				Map<String, DSSchema> schemas = meta.getSchemas(true, catalog);// ,
//																				// catalogs);
//				// for (DSSchema schema : schemas.values())
//				DSSchema schema = schemas.get("ETFM_OWNER_SIT_REL");
//
//				if (null != schema) {
//					System.out.println(String.format("\tSchema:%s", schema
//							.getSchemaName()));
//					Map<String, DSTable> tables = schema.getTables();
//					DSTable table = tables.get("TBL$WORKFLOW_TRANSACTION");
//					// for (DSTable table : tables.values())
//					if (null != table) {
//						System.out.println(String.format(
//								"\t\tTable:%s, type:%s", table.getTableName(),
//								table.getTableTypeName()));
//						Map<String, DSColumn> columns = table.getColumns();
//						table.getCrossReferences();
//
//						for (DSColumn column : columns.values()) {
//							String fColName = "";
//
//							DSColumn fColumn = column.getCrossReference();
//
//							if (null != fColumn) {
//								fColName = String.format(", table:%s, col:%s",
//										fColumn.getTable().getTableName(),
//										fColumn.getColumnName());
//							}
//							try {
//								System.out
//										.println(String
//												.format(
//														"\t\t\tColumn:%s, db type:%s, JDBC Type:%s%s",
//														column.getColumnName(),
//														// column.getColumnSize(),
//														// column.getDecimalDigits(),
//														column
//																.getPlatformTypeName(),
//														TypeUtils
//																.getTypeName(column
//																		.getPlatformType()),
//														fColName));
//							} catch (TypeNotFoundException e) {
//								String
//										.format(
//												"\t\t\tColumn:%s, db type:%s, JDBC Type:Unknown(%d)%s",
//												column.getColumnName(),
//												// column.getColumnSize(),
//												// column.getDecimalDigits(),
//												column.getPlatformTypeName(),
//												column.getPlatformType(), fColName);
//							}
//
//						}
//						// System.out.println(String.format("\t\tTable:%s, type:%s",
//						// , table.getTableType()));
//
//					}
//
//				}
//			}
//			dsAccess.disconnect();
//
//		}/* catch (SQLException e) {
//			throw new Exception(e);
//		} catch (NotConnectedException e) {
//			throw new Exception(e);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IllegalAccessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InstantiationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}*/ catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (null != dsAccess) {
//				try {
//					dsAccess.disconnect();
//				} catch (TereException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}

}
