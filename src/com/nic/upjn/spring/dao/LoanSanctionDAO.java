package com.nic.upjn.spring.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.nic.upjn.spring.entity.PpLoanmaster;

@Repository("loanSanctionDAOInter")
public class LoanSanctionDAO implements LoanSanctionDAOInter {

	@Autowired
	SessionFactory sessionFactory;

	public List populateLoanMasterCombo(String empMasterID, String pp_LoanDetailID) throws  Exception {
		List <PpLoanmaster>list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String sql = "";
		try {
			
			sql = (new StringBuilder())
					.append("select pp_LoanMasterID,loanName,loanShortName,max_InstallmentNo from pp_LoanMast"
							+ "er where  pp_LoanMasterID not in (select pp_LoanMasterID from pp_LoanDetail wher"
							+ "e pp_EmployeeMasterID='")
					.append(empMasterID)
					.append("' and pa_isfullyrecovered='0') or loanShortName='GPF' or pp_LoanMasterID=(select"
							+ " pp_LoanMasterID from PP_LOANDETAIL where pp_LoanDetailID='")
					.append(pp_LoanDetailID).append("') order by loanName").toString();
			Query query = session.createSQLQuery(sql).addEntity(PpLoanmaster.class);
			
			
		} catch (Exception msqle) {
			throw msqle;
		} 
		return list;
	}

	@Override
	public List<?> getComboList(String where_condition, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condition);
				list = (List<Object>) query.list();
				tx.commit();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
				tx.commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}
	
	
	

}
