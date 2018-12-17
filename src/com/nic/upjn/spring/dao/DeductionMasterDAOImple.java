package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("DeductionMasterDAO")
public class DeductionMasterDAOImple implements DeductionMasterDAO{

	@Autowired
	SessionFactory sessionfactory;
	
	@Override
	public List getList(String condition, String namedQuery) {
		Query query = null;
		List list = null;
		
		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			if(condition == null){
				query = session.getNamedQuery(namedQuery);
				list = query.list();
			}
			else{
				query = session.getNamedQuery(namedQuery);
				query.setString(0, condition);
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
}
