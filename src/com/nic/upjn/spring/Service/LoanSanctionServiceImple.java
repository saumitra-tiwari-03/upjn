package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.nic.upjn.spring.dao.LoanSanctionDAOInter;
import com.nic.upjn.spring.entity.PpLoanmaster;

@Service("loanSanctionService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoanSanctionServiceImple implements LoanSanctionService {

	@Autowired
	LoanSanctionDAOInter loanSanctionDAOInter;

	public List<PpLoanmaster> populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID) {

		List <PpLoanmaster>list = null;
		
		try {

			list = loanSanctionDAOInter.populateLoanMasterCombo(empMasterID, pp_LoanDetailID);

		} catch (Exception e) {
		}

		return list;

	}


	public List<?> getComboList(String where_condition, String namedQuery) {
		return loanSanctionDAOInter.getComboList(where_condition, namedQuery);
	}


}
