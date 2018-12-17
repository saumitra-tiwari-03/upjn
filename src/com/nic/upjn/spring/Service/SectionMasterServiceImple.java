package com.nic.upjn.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.SectionMasterDAO;
import com.nic.upjn.spring.entity.PpSectionmaster;

@Service("SectionMasterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SectionMasterServiceImple implements SectionMasterService{

	@Autowired
	SectionMasterDAO sectionMasterDAO ;
	
	@Override
	public boolean saveSectionMaster(PpSectionmaster ppSectionMaster) {
		
		boolean flag = false;
		
		flag = sectionMasterDAO.saveSectionMaster(ppSectionMaster);

		return flag;
	}

	@Override
	public List<PpSectionmaster> getSectionList(String rmOfficeID) {
		
		return sectionMasterDAO.getSectionList(rmOfficeID);
	}

	@Override
	public String populateSectionMaster(String ppSectionMasterID) {
		
		return sectionMasterDAO.populateSectionMaster(ppSectionMasterID);
	}

	@Override
	public boolean updateSectionMaster(String sectionMasterID,
			PpSectionmaster ppSectionmaster) {
		
		return sectionMasterDAO.updateSectionMaster(sectionMasterID, ppSectionmaster);
	}

	@Override
	public boolean deleteSectionMaster(String sectionMasterID) {
		
		return sectionMasterDAO.deleteSectionMaster(sectionMasterID);
	}

	@Override
	public Boolean updateEmpRegister(ArrayList<String> ppEmployeemasterid, String[] selectedRegister) {
		
		return sectionMasterDAO.updateEmpRegister(ppEmployeemasterid,selectedRegister);
	}

	@Override
	public boolean dropEmpForThisBillType(ArrayList<String> ppEmployeemasterid, String sectionID) {
		boolean isComplete = false;
		try{
			isComplete = sectionMasterDAO.dropEmpForThisBillType(ppEmployeemasterid, sectionID);
		}catch (Exception e){
				System.out.println("Exception raised is "+e);
		}
		return isComplete;
	}

}
