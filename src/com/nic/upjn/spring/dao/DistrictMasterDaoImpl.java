package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.DistrictMasterDTO;
import com.nic.upjn.spring.entity.MasDistrict;
@Repository("districtMasterDao")
public class DistrictMasterDaoImpl implements DistrictMasterDao {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public List<?> getList(Integer where_condition, String namedQuery) {

		Query query = null;
		List<?> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setInteger(0, where_condition);
				list = (List<?>) query.list();
			}

			else {
				query = session.getNamedQuery(namedQuery);
				list = (List<?>) query.list();
			}

			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;

	}

	public Integer AddDistrict(DistrictMasterDTO districtMasterDTO) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String masDistrictId = null;

		try {

			MasDistrict masDistrict = new MasDistrict();

			masDistrict.setDistrictname(districtMasterDTO.getDistrictName());
			masDistrict.setMAS_STATEID(districtMasterDTO.getMas_StateID());					

			masDistrict.setZoneCode(null);
			masDistrict.setCensusdistrictcode(districtMasterDTO
					.getCensusDistrictCode());
			masDistrict.setZoneDesc(null);
			session.save(masDistrict);
			transaction.commit();
			
			masDistrictId = masDistrict.getMasDistrictid() + "";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return Integer.parseInt(masDistrictId);
	}

	public boolean checkDistrictAndCode(DistrictMasterDTO districtMasterDTO) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		boolean userFound = false;
		try {

			String SQL_QUERY = "select * from MAS_DISTRICT where DISTRICTNAME = "+"'"+districtMasterDTO.getDistrictName()+"'"+"and CENSUSDISTRICTCODE = "+"'"+districtMasterDTO.getCensusDistrictCode()+"'";
			SQLQuery query = session.createSQLQuery(SQL_QUERY);
			query.addEntity(MasDistrict.class);
			List<MasDistrict> list = query.list();			
			transaction.commit();

			if ((list != null) && (list.size() > 0)) {
				userFound = true;
			} else {
				userFound = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}

		return userFound;
	}

	@Override
	public Integer EditDistrict(MasDistrict masDistrict) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
        Integer result = 0 ;
		try {

			session.createCriteria(masDistrict.getMasDistrictid()+"");
			session.update(masDistrict);
			session.flush();
			transaction.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return result;
	}

	@Override
	public Boolean deleteHeadQuarter(String id) {
		boolean result = false;
		Session session = null;
		 
		try{
		    session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    
			Query query = session.createSQLQuery(
					"DELETE FROM Mas_District WHERE Mas_DistrictID=:Mas_DistrictID");
			query.setParameter("Mas_DistrictID", id);
		    
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
