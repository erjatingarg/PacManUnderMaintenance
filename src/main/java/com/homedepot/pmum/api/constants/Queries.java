package com.homedepot.pmum.api.constants;

import java.util.ResourceBundle;

public  enum Queries {	
	MNT_SCH_LIST("Mntsch.list"),
	;
	
	private Queries(String property){
		this.property = property;
	}
	
	private String property;
	
	public String query(){
		return querieResource.getString(property);
	}
	
	private static  ResourceBundle querieResource =null;
	
	static{
		try {
			querieResource= ResourceBundle.getBundle("Queries");
		} catch (Exception e) {
			throw e;
		}
	}
}
