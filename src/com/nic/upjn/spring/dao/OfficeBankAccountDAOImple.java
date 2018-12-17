package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.FwaBankaccount;
import com.nic.upjn.spring.entity.OfficeBankAccountEntity;

@Repository("OfficeBankAccountDAO")
public class OfficeBankAccountDAOImple implements OfficeBankAccountDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public  List retrieveBankAccountList(Integer rmOfficeid) {
		List BankAccountList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "";

		sql = "select fba.fwa_bankAccountID, fba.Ac_HolderName,fba.ac_number,fba.mas_BankID,ro.officeName,fba.rm_officeID,mb.bankName,fba.ifsc_code,fba.rm_officeid1,ac.officename as acc_officename from fwa_BankAccount fba inner join rm_Office ro on ro.rm_officeID=fba.rm_officeID inner join mas_Bank mb on mb.mas_BankID=fba.mas_BankID left join rm_office ac on fba.rm_officeid1=ac.rm_officeid where fba.rm_officeID ='"
				+ rmOfficeid + "'";

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(OfficeBankAccountEntity.class);
			BankAccountList = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return BankAccountList;
	}

	@Override
	public boolean saveaccountinfo(FwaBankaccount fwabankaccount) {
		
		boolean result = false;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			session.save(fwabankaccount);
			tx.commit();
			
			result = true;
		}
		catch(Exception e){
              e.printStackTrace();			
		}
		finally {
			
		}
		return result;
	}

	@Override
	public List populateofficeaccount(String wherecondition, String namedQuery) {
		Query query = null;
		List list = null;
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			if(wherecondition == null){
				query = session.getNamedQuery(namedQuery);
				list = query.list();
			}
			else{
				query = session.getNamedQuery(namedQuery);
				query.setString(0, wherecondition);
				list = query.list();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		 finally {
				session.close();
			}
		
		return list;
	}

	@Override
	public int editaccountinfo(FwaBankaccount fwabankaccount) {
		Session session = null;
		int result = 0;
		try {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();
		
			session.createCriteria(fwabankaccount.getFwaBankaccountid()+"");		
			session.update(fwabankaccount);
			session.flush();
			t.commit();
			result = 1;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public boolean deleteaccountinfo(String id) {
		boolean result = false;
		Session session = null;
		
		try{
		    session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    
			Query query = session.createSQLQuery(
					"DELETE FROM FWA_BANKACCOUNT WHERE FWA_BANKACCOUNTID=:FWA_BANKACCOUNTID");
			query.setParameter("FWA_BANKACCOUNTID", id);
		    
		    query.executeUpdate();
		    tx.commit();
		    
		    result = true;
		} 
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}		
		return result;
	}

	

}
