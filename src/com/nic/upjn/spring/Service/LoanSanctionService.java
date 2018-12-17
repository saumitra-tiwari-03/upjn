package com.nic.upjn.spring.Service;

import java.util.List;


public interface LoanSanctionService {

	
	public List populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID);

	public List getComboList(String empMasterID, String string);

}
