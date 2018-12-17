package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.DAMasterDao;
import com.nic.upjn.spring.dto.DAActionDTO;
import com.nic.upjn.spring.dto.DesignationMasterDTO;
import com.nic.upjn.spring.dto.LoanMasterDTO;
import com.nic.upjn.spring.entity.DADEntity;

@Service("daMasterService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DAMasterServiceImple implements DAMasterService {

	@Autowired
	DAMasterDao daMasterDao;

	@Override
	public List getDAList() {
		List<DADEntity> list;

		list = daMasterDao.getDAList();
		return list;
	}

	@Override
	public boolean insertDA(DAActionDTO daActionDTO) {

		boolean isComplete = true;
		String inParam[] = new String[8];
		inParam[0] = daActionDTO.getPayCategory();
		inParam[1] = daActionDTO.getRuleOrderNo();
		inParam[2] = daActionDTO.getRuleOrderDate();
		inParam[3] = daActionDTO.getDueDate();
		inParam[4] = daActionDTO.getGpfDate();
		inParam[5] = daActionDTO.getCashDate();
		inParam[6] = daActionDTO.getRuleEffectiveDate();
		inParam[7] = daActionDTO.getDaPercent();
		System.out.println((new StringBuilder()).append("EMPLOOOYEEEECODEEEE")
				.append(inParam[0]).toString());
		isComplete = daMasterDao.insertDA(inParam);
		System.out.println((new StringBuilder())
				.append("i m in manager value of complete").append(isComplete)
				.toString());
		return isComplete;

	}

	public List getList(String where_condtion, String namedQuery) {

		List list;

		list = daMasterDao.getComboList(where_condtion, namedQuery);

		return list;

	}

	@Override
	public boolean insertLoanMaster(LoanMasterDTO loanMasterDTO) {
		boolean isComplete = false;
		try {
			isComplete = daMasterDao.insertLoanMaster(loanMasterDTO);

		} catch (Exception ex) {
		}
		return isComplete;
	}

	@Override
	public boolean updateLoanMaster(LoanMasterDTO loanMasterDTO) {
		boolean isComplete = false;
		try {

			isComplete = daMasterDao.updateLoanMaster(loanMasterDTO);

		} catch (Exception e) {
			System.out.println("Exception raised is " + e);
		}

		return isComplete;
	}

	@Override
	public boolean deleteLoanMaster(String ppLoanmasterid) {

		boolean isComplete = false;
		try {

			isComplete = daMasterDao.deleteLoanMaster(ppLoanmasterid);

		} catch (Exception e) {
			System.out.println("Exception raised is " + e);
		}

		return isComplete;
	}

	@Override
	public boolean addDesignation(DesignationMasterDTO designationMasterDTO) {
		// Calling method of DAO to add user information
		boolean isComplete = false;
		isComplete = daMasterDao.insertDesignationIntoDB(designationMasterDTO);

		return isComplete;
	}

	@Override
	public boolean editDesignation(DesignationMasterDTO designationMasterDTO) {
		boolean isComplete = false;
		isComplete = daMasterDao.editDesignation(designationMasterDTO);

		return isComplete;	
		}

	@Override
	public boolean deleteDesignation(String ppDesignationmasterid) {
		boolean isComplete = false;
		isComplete = daMasterDao.deleteDesignation(ppDesignationmasterid);

		return isComplete;	
		}
	}


