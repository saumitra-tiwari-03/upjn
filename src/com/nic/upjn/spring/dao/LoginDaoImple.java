/******************************** LoginDaoImple Class **************************/

/*==========================================================================
 * Description : LoginDaoImple class contains the database operation for the login. 
 * This class contains only one method checkLogin() for user validation. 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/

import org.hibernate.Session; /** Session class : Used for managing sessions for DATABASE operations.**/
import org.hibernate.SessionFactory; /** Session Factory : It is responsible for creating objects of session class , and managing connection objects. **/
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired; /** AUTOWIRED Annotation : Used for creating the object of class without using new keyword **/
import org.springframework.stereotype.Repository; /** Indicates that an annotated class is a "Repository", "A mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects".**/
import org.springframework.transaction.annotation.Transactional;/**Annotation.Transactional : Used for managing the objects of session and session Factory.**/

import com.nic.upjn.spring.entity.Admin;
import com.nic.upjn.spring.entity.ViewRmGetlinkstoassign;

import org.hibernate.Query; /** Query class : It is responsible for generating HQL (HIBERNATE QUERY LANGUAGE)  **/
import org.hibernate.SQLQuery;
import org.hibernate.engine.spi.SessionImplementor;

import java.sql.CallableStatement;
import java.sql.Types;
import java.util.HashMap;
import java.util.List; /** List : IT is collection or data structure of JAVA, it also contains collection of objects **/

/** Implementation of database operations for LOGIN purpose. * */
@Repository("loginDao")
public class LoginDaoImple implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Method used to match user name and password from database using HIBERNATE
	 **/

	@Transactional
	public HashMap<String, String> checkLogin(String adminname, String password) {
		System.out.println("In Check login");
		
		HashMap <String,String>hm = new HashMap<String,String>();
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try
		{
		CallableStatement stmt = connection.prepareCall("{call PROC_RM_VALIDATELOGIN(?,?,?,?,?)}");
		stmt.setString(1, adminname);
		stmt.setString(2, password);
	    stmt.registerOutParameter(3, Types.VARCHAR);
	    stmt.registerOutParameter(4, Types.VARCHAR);
	    stmt.registerOutParameter(5, Types.VARCHAR);
        int x = stmt.executeUpdate();

		

		String output = stmt.getString(3);
		hm.put("isCompleted",output);
		hm.put("ppEmployeemasterid", stmt.getString(4));
		hm.put("rm_OfficeID", stmt.getString(5));
		
		tx.commit();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			
			session.close();
		}
		return hm;
		

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAdminpassword(String name, String NamedQuery) {

		String result = null;
		Session session = null;

		Query query = null;
		List<Object> list;

		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			if (name != null) {
				query = session.getNamedQuery(NamedQuery);
				query.setString(0, name);
				list = (List<Object>) query.list();

				for (Object object : list) {
					Admin admin = (Admin) object;
					result = admin.getPassword();
				}

				t.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		finally{
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ViewRmGetlinkstoassign> getRoleLinksToAssign(
			int pp_EmployeeMasterID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		String ppEmployeeMasterID = pp_EmployeeMasterID+"";
		String sql="";	
		List result = null;
		try{

			/*String sql="SELECT * FROM VIEW_RM_GETLINKSFORTREE1"+
			" WHERE PP_EMPLOYEEMASTERID='"+pp_EmployeeMasterID+"' OR PP_EMPLOYEEMASTERID IS NULL"+
			" ORDER BY RM_MENUITEMID";*/

			if (pp_EmployeeMasterID==0){
				 sql="select * FROM VIEW_RM_GETLINKSTOASSIGN";
					  
			}
			else if (pp_EmployeeMasterID==1){
				 sql="select * from ("+
                                          "select distinct * from "+
				"(select distinct RM_MENUITEMID,MENUNAME,LINKS,LINKLevel,QUERYSTRING,parentId,sortID "+
				"FROM  VIEW_RM_GETLINKSFORTREE  WHERE "+
				"  pp_EmployeeMasterID is null ) START WITH RM_MENUITEMID IN "+
				"(SELECT distinct Rm_MenuItemID FROM VIEW_RM_GETLINKSFORTREE WHERE LINKS IS NOT NULL AND rolename='SERVICE BOOK' "+
				") CONNECT BY RM_MENUITEMID = PRIOR PARENTID"+
				")  START WITH PARENTID='0'"+
			    "CONNECT BY PARENTID= PRIOR RM_MENUITEMID  order SIBLINGS by sortID";
					  
			}
                        else {
				sql="select * from ("+	 
				"select distinct * from "+
				"(select distinct RM_MENUITEMID,MENUNAME,LINKS,LINKLevel,QUERYSTRING,parentId,sortID "+
				"FROM  VIEW_RM_GETLINKSFORTREE  WHERE "+
				" pp_employeeMasterID='"+pp_EmployeeMasterID+"' or pp_employeeMasterID IS NULL) START WITH RM_MENUITEMID IN "+
				"(SELECT distinct Rm_MenuItemID FROM VIEW_RM_GETLINKSFORTREE WHERE LINKS IS NOT NULL AND pp_employeeMasterID='"+pp_EmployeeMasterID+"' "+
				") CONNECT BY RM_MENUITEMID = PRIOR PARENTID"+
				")  START WITH PARENTID='0'"+
			    "CONNECT BY PARENTID= PRIOR RM_MENUITEMID  order SIBLINGS by sortID";
			}
		
		
		 Query query = session.createSQLQuery(sql).addEntity(ViewRmGetlinkstoassign.class);
				
				
          result = query.list();
          tx.commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
	
	return result;	
}

	@Override
	public List getComboList(String where_condtion, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();

			if (where_condtion != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condtion);
				list = (List<Object>) query.list();
			}

			else {

				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

		return list;
	}
}
