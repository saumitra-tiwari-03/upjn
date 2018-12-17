package com.nic.upjn.spring.dao;

import java.util.List;

public interface LoanSanctionDAOInter  {
	
	
	public List populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID) throws  Exception;

	public List<?> getComboList(String where_condition, String namedQuery);

	
	 
	
	
	

}
