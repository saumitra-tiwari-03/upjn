package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.ManagePayBillDAO;
import com.nic.upjn.spring.entity.PpRegistermaster;
import com.nic.upjn.spring.entity.PpSectionmaster;
import com.nic.upjn.spring.entity.ViewListForAssignRegister;
import com.nic.upjn.spring.entity.ViewSearchResult;

@Service("ManagePayBillService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ManagePayBillServiceImple implements ManagePayBillService{
	
	@Autowired
	ManagePayBillDAO managePayBillDAO;
	
	@Override
	public List<ViewListForAssignRegister> getEmpList(int rmOfficeID,
			String ppSectionMasterID) {
		List<ViewListForAssignRegister> list = managePayBillDAO.getEmpList(rmOfficeID, ppSectionMasterID);
		return list;
	}
	
	@Override
	public List<PpRegistermaster> getRegisterList() {
		List<PpRegistermaster> list = managePayBillDAO.getRegisterList();
		return list;
	}

	@Override
	public List<ViewSearchResult> getEmpListForAddSection(String rmOfficeID,
			String predicate) {
		List<ViewSearchResult> list = managePayBillDAO.getEmpListForAddSection(rmOfficeID,predicate);
		return list;
	}

	@Override
	public List<PpSectionmaster> getList(Integer rmOfficeid, String sectionname, String string) {
		List<PpSectionmaster> list = managePayBillDAO.getList(rmOfficeid,sectionname,string);
		return list;
	}

	@Override
	public boolean setSectionID(String ppEmployeeMasterID, String sectionID) {
		boolean isComplete = false;
		isComplete = managePayBillDAO.setSectionID(ppEmployeeMasterID,sectionID);
		return isComplete;
	}

}
