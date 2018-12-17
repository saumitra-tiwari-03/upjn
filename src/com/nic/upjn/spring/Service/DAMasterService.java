package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.DAActionDTO;
import com.nic.upjn.spring.dto.DesignationMasterDTO;
import com.nic.upjn.spring.dto.LoanMasterDTO;

public interface DAMasterService {

	public List getDAList();

	public boolean insertDA(DAActionDTO daActionDTO);


	public List getList(String where_condtion, String namedQuery);

	public boolean insertLoanMaster(LoanMasterDTO loanMasterDTO);

	public boolean updateLoanMaster(LoanMasterDTO loanMasterDTO);

	public boolean deleteLoanMaster(String ppLoanmasterid);

	public boolean addDesignation(DesignationMasterDTO designationMasterDTO);

	public boolean editDesignation(DesignationMasterDTO designationMasterDTO);

	public boolean deleteDesignation(String ppDesignationmasterid);

}
