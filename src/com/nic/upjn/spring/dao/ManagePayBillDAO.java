package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpSectionmaster;
import com.nic.upjn.spring.entity.ViewListForAssignRegister;
import com.nic.upjn.spring.entity.ViewSearchResult;

public interface ManagePayBillDAO {
	
	public List<ViewListForAssignRegister> getEmpList(int rmOfficeID,String ppSectionMasterID);
	public List<PpRegistermaster> getRegisterList();
	public List<ViewSearchResult> getEmpListForAddSection(String rmOfficeID,String predicate);
	public List<PpSectionmaster> getList(Integer rmOfficeid, String sectionname, String string);
	public boolean setSectionID(String ppEmployeeMasterID, String sectionID);

}
