package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.dto.DesignationMasterDTO;
import com.nic.upjn.spring.dto.LoanMasterDTO;

public interface DAMasterDao {

	List getDAList();

	boolean insertDA(String[] inParam);
	public List getComboList(String where_condition, String namedQuery);

	boolean insertLoanMaster(LoanMasterDTO loanMasterDTO);

	boolean updateLoanMaster(LoanMasterDTO loanMasterDTO);

	boolean deleteLoanMaster(String ppLoanmasterid);

	boolean insertDesignationIntoDB(DesignationMasterDTO designationMasterDTO);

	boolean editDesignation(DesignationMasterDTO designationMasterDTO);

	boolean deleteDesignation(String ppDesignationmasterid);

	

}
