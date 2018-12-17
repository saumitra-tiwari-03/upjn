/**
 * 
 */
package com.nic.upjn.spring.dto;

import java.util.ArrayList;

public class SectionMasterDTO {
	
	private String sectionID;	
	private String sectionname;
	private ArrayList<String> ppEmployeemasterid;
	private String[] selectedRegister;
	private String idStr;
	private String idStr1;
	

	public String getSectionID() {
		return sectionID;
	}

	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}

	public String getSectionname() {
		return sectionname;
	}

	public void setSectionname(String sectionname) {
		this.sectionname = sectionname;
	}

	public ArrayList<String> getPpEmployeemasterid() {
		return ppEmployeemasterid;
	}

	public void setPpEmployeemasterid(ArrayList<String> ppEmployeemasterid) {
		this.ppEmployeemasterid = ppEmployeemasterid;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getIdStr1() {
		return idStr1;
	}

	public void setIdStr1(String idStr1) {
		this.idStr1 = idStr1;
	}

	public String[] getSelectedRegister() {
		return selectedRegister;
	}

	public void setSelectedRegister(String[] selectedRegister) {
		this.selectedRegister = selectedRegister;
	}

	
	
}
