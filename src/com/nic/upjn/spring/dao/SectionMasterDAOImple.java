package com.nic.upjn.spring.dao;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.entity.PpSectionmaster;

@Repository("SectionMasterDAO")
public class SectionMasterDAOImple implements SectionMasterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveSectionMaster(PpSectionmaster ppSectionMaster) {

		boolean flag = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.save(ppSectionMaster);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		} finally{
			session.close();
		}
	
		return flag;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PpSectionmaster> getSectionList(String rmOfficeID) {
		
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria c = session.createCriteria(PpSectionmaster.class);
			c.add(Restrictions.eq("rmOfficeid", rmOfficeID));
			List<PpSectionmaster> sectionList = new ArrayList<PpSectionmaster>();
			sectionList = c.list();
			tx.commit();
			session.close();
			return sectionList;
		} catch (Exception ex) {

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String populateSectionMaster(String ppSectionMasterID) {

		String sectionName = null;
		Session session = null;
		try {
			 session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Criteria c = session.createCriteria(PpSectionmaster.class);
			c.add(Restrictions.eq("ppSectionmasterid", Integer.parseInt(ppSectionMasterID)));
			List<PpSectionmaster> list = new ArrayList<PpSectionmaster>();
			list = c.list();
			Iterator<PpSectionmaster> itr = list.iterator();
			while (itr.hasNext()) {
				PpSectionmaster pp = (PpSectionmaster) itr.next();
				sectionName = pp.getSectionname();
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

		return sectionName;
	}
	
	@Override
	public boolean updateSectionMaster(String sectionMasterID, PpSectionmaster ppSectionmaster){
		boolean flag = false;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			PpSectionmaster pp = (PpSectionmaster) session.get(PpSectionmaster.class,Integer.parseInt(sectionMasterID));
			pp.setSectionname(ppSectionmaster.getSectionname());
			pp.setRmOfficeid(ppSectionmaster.getRmOfficeid());
			session.update(pp);
			tx.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}

	@Override
	public boolean deleteSectionMaster(String sectionMasterID) {
		boolean flag = false;
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			PpSectionmaster sectionMaster = (PpSectionmaster) session.load(PpSectionmaster.class, Integer.parseInt(sectionMasterID));
			session.delete(sectionMaster);
			tx.commit();
			if(tx.wasCommitted() == true){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return flag;
	}

	@Override
	public Boolean updateEmpRegister(ArrayList<String> ppEmployeemasterid, String[] selectedRegister) {
		boolean flag = false;
		String x = null;
		Session session = sessionFactory.openSession();
		String[] inParam = new String[2];
		String empMasterID = "";
		String registerID = "";
		Object[] arr = ppEmployeemasterid.toArray();
		try{
			
			System.out.println(arr.length + ","+selectedRegister.length);
			for(int i = 0 ; i < arr.length ; i++){
				empMasterID += (String) arr[i] + "|";
				registerID += selectedRegister[i] + "|";
			}
			
			inParam[0] = empMasterID.substring(0,empMasterID.lastIndexOf("|"));
			inParam[1] = registerID.substring(0,registerID.lastIndexOf("|"));
			
			System.out.println(inParam[0]+"------"+inParam[1]);
			
SessionImplementor sessionImplementor = (SessionImplementor) session;
			
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_UPDATE_EMP_REGISTER(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);
			flag = stmt.execute();
			x = stmt.getString(3);
			System.out.println(x);
			flag = true;
			System.out.println(flag);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return flag;
	}

	@Override
	public boolean dropEmpForThisBillType(ArrayList<String> ppEmployeemasterid, String sectionId) {
		boolean result = false;
		
		String x = null;
		Session session = sessionFactory.openSession();
		String[] inParam = new String[2];
		String empMasterID = "";
		String sectionID = "";
		Object[] arr = ppEmployeemasterid.toArray();
		
		try{
			System.out.println(arr.length + ","+sectionID);
			for(int i = 0 ; i < arr.length ; i++){
				empMasterID += (String) arr[i] + "|";
			}
			
			inParam[0] = empMasterID.substring(0,empMasterID.lastIndexOf("|"));
			
			System.out.println(inParam[0]+"------"+sectionId);
			
            SessionImplementor sessionImplementor = (SessionImplementor) session;
			
			java.sql.Connection connection = sessionImplementor.connection();
			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_CHANGE_EMP_SECTION(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, sectionID);
			stmt.registerOutParameter(3, Types.VARCHAR);
			result = stmt.execute();
			x = stmt.getString(3);
			System.out.println(x);
			result = true;
			System.out.println(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return result;
	}
	
	

	/*@Override
	public boolean dropEmpForThisBillType(String ppEmployeemasterid, String sectionId) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_CHANGE_EMP_SECTION(?,?,?)}");

			stmt.setString(1, ppEmployeemasterid);
			stmt.setString(2, null);
			stmt.registerOutParameter(3, Types.VARCHAR);

			result = stmt.execute();

			String output = stmt.getString(3);
			System.out.println(output + " -----------");

			t.commit();
			result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return result;
	}*/

}
