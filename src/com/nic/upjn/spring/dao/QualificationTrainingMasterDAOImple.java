package com.nic.upjn.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;

@Repository("QualificationTrainingMasterDAO")
public class QualificationTrainingMasterDAOImple implements QualificationTrainingMasterDAO {

	@Autowired
	SessionFactory sessionfactory;

	@Override
	public int AddQualification(PpQualificationmaster ppQualificationmaster) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.save(ppQualificationmaster);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int AddTraining(PpTrainingtypemaster ppTrainingtypemaster) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.save(ppTrainingtypemaster);
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public List getList(String condition, String namedQuery) {
		Query query = null;
		List list = null;

		Session session = sessionfactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (condition == null) {
				query = session.getNamedQuery(namedQuery);
				list = query.list();
			} else {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, condition);
				list = query.list();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public int editQualification(PpQualificationmaster ppQualificationmaster) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.createCriteria(ppQualificationmaster.getPpQualificationmasterid() + "");

			session.update(ppQualificationmaster);
			session.flush();
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public int editTraining(PpTrainingtypemaster ppTrainingtypemaster) {
		Session session = null;
		int result = 0;
		try {

			session = sessionfactory.openSession();
			Transaction t = session.beginTransaction();

			session.createCriteria(ppTrainingtypemaster.getPpTrainingtypemasterid() + "");

			session.update(ppTrainingtypemaster);
			session.flush();
			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean deleteQualification(String ppQualificationmasterid) {
		boolean result = false;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"DELETE FROM PP_QUALIFICATIONMASTER WHERE PP_QUALIFICATIONMASTERID=:PP_QUALIFICATIONMASTERID");
			query.setParameter("PP_QUALIFICATIONMASTERID", ppQualificationmasterid);

			query.executeUpdate();
			tx.commit();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean deleteTraining(String ppTrainingtypemasterid) {
		boolean result = false;
		Session session = null;

		try {
			session = sessionfactory.openSession();
			Transaction tx = session.beginTransaction();

			Query query = session.createSQLQuery(
					"DELETE FROM PP_TRAININGTYPEMASTER WHERE PP_TRAININGTYPEMASTERID=:PP_TRAININGTYPEMASTERID");
			query.setParameter("PP_TRAININGTYPEMASTERID", ppTrainingtypemasterid);

			query.executeUpdate();
			tx.commit();

			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return result;
	}

}
