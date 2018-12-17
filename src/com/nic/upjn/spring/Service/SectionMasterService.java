package com.nic.upjn.spring.Service;

import java.util.ArrayList;
import java.util.List;

import com.nic.upjn.spring.entity.PpSectionmaster;

public interface SectionMasterService {
	
	public boolean saveSectionMaster(PpSectionmaster ppSectionMaster);
	
	public List<PpSectionmaster> getSectionList(String rmOfficeID);
	
	public String populateSectionMaster(String ppSectionMasterID);
	
	public boolean updateSectionMaster(String sectionMasterID,PpSectionmaster ppSectionmaster);
	
	public boolean deleteSectionMaster(String sectionMasterID);

	public Boolean updateEmpRegister(ArrayList<String> ppEmployeemasterid, String[] selectedRegister);

	public boolean dropEmpForThisBillType(ArrayList<String> ppEmployeemasterid, String sectionID);
}
