/******************************** RoleManagementDAOImple Class **************************/

/*==========================================================================
 * Description	 : RoleManagementDAOImple class contains the database operation for the Role Management.  
 * Date			 : 01/03/2016 
 * Author		 : VIKAS SINGH
 * Review By 	 : 
 * Review Date	 :  
 *==========================================================================
 */

/** Package Name **/
package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.security.EncryptionService;
import com.nic.upjn.spring.dto.ChangePasswordDTO;
import com.nic.upjn.spring.dto.CreateUserDTO;
import com.nic.upjn.spring.entity.Admin;
import com.nic.upjn.spring.entity.PpEmployeemaster;
import com.nic.upjn.spring.entity.RmLoginrole;
import com.nic.upjn.spring.entity.RmMenuitem;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.RmRole;
import com.nic.upjn.spring.entity.RmRolemenuitem;
import com.nic.upjn.spring.entity.RmofficeView;
import com.nic.upjn.spring.entity.ViewRmEmployeerolelist;
import com.nic.upjn.spring.entity.ViewRmGetlinkstoassign;
import com.nic.upjn.spring.entity.ViewRmRolesforemployee;

@Repository("RoleManagementDAO")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class RoleManagementDAOImple implements RoleManagementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/** method for Retrieving List of Employees **/

	@Override
	public List<?> selectquery(Integer key, String NamedQuery) {

		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			if (key != 0) {
				query = session.getNamedQuery(NamedQuery);
				query.setInteger(0, key);
				list = (List<Object>) query.list();
			}

			else {
				query = session.getNamedQuery(NamedQuery);
				list = (List<Object>) query.list();
			}

			transaction.commit();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	/** Method for Creating New User **/
	public boolean createUser(CreateUserDTO createUserDTO) {
		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {

			String[] inParam = new String[2];

			inParam[0] = createUserDTO.getPpEmployeemasterid();
			inParam[1] = createUserDTO.getPassword();

			this.setPassword(inParam);

			if (result = true) {

				String[] roles = createUserDTO.getRoles();

				if (roles.length > 0) {

					SessionImplementor sessionImplementor = (SessionImplementor) session;
					java.sql.Connection connection = sessionImplementor.connection();

					for (int i = 0; i < roles.length; i++) {

						createUserDTO.setRmRoleid(roles[i]);

						// Setting Input Parameters for the procedure
						inParam = new String[2];
						inParam[0] = createUserDTO.getPpEmployeemasterid();
						inParam[1] = createUserDTO.getRmRoleid();

						CallableStatement stmt = connection.prepareCall("{call PROC_RM_ADDEMPLOYEEROLE(?,?,?)}");
						stmt.setString(1, inParam[0]);
						stmt.setString(2, inParam[1]);
						stmt.registerOutParameter(3, Types.VARCHAR);

						stmt.execute();

						String output = stmt.getString(3);
						if (output.equals("1")) {
							result = true;
						}
						System.out.println(output + "------ output------");

					}
					t.commit();
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** Method for Changing Password of User **/
	public boolean setPassword(String[] inParam) {

		boolean result = false;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			System.out.println(inParam[0] + "-----" + inParam[1]);

			CallableStatement stmt = connection.prepareCall("{call PROC_RM_RESETPASSWORD(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);

			stmt.execute();

			t.commit();

			String output = stmt.getString(3);
			if (output.equals("1")) {
				result = true;
			}
			System.out.println(output + "------ output------");

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return result;
	}

	/** Method for Deleting Password of User **/
	@Override
	public boolean deleteUser(String ppEmployeemasterid) {

		boolean result = false;

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();

		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_DELEMPLOYEEROLE(?,?)}");
			stmt.setString(1, ppEmployeemasterid);
			stmt.registerOutParameter(2, Types.VARCHAR);

			stmt.execute();

			t.commit();

			String output = stmt.getString(2);
			if (output.equals("1")) {
				result = true;
			}
			System.out.println(output + "------ output------");
		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** Method to Lock the Password of User **/
	@Override
	public boolean lockUser(PpEmployeemaster ppEmployeemasterlock) {

		Session session = sessionFactory.openSession();

		ppEmployeemasterlock.setIsloginlocked('1');
		boolean result = false;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createCriteria(ppEmployeemasterlock.getPpEmployeemasterid() + "");
			session.update(ppEmployeemasterlock);
			session.flush();

			tx.commit();
			result = true;
		} catch (HibernateException e) {

			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
		return result;

	}

	/** Method to Unlock the Password of User **/
	@Override
	public boolean unlockUser(String ppEmployeemasterid) {

		boolean result = false;
		Session session = null;
		System.out.println(ppEmployeemasterid);
		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session
					.createSQLQuery("update pp_EmployeeMaster set isLoginLocked = '0' where pp_EmployeeMasterID = "
							+ ppEmployeemasterid);

			query.executeUpdate();

			t.commit();

			result = true;
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}

		return result;
	}

	/** Method for Changing the Password of User **/
	@Override
	public boolean changePassword(String[] inParam) {

		boolean result = false;

		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();

		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_RESETPASSWORD(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);

			stmt.execute();

			t.commit();

			String output = stmt.getString(3);
			if (output.equals("1")) {
				result = true;
			}
			System.out.println(output + "------ output------");
		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** To retrieve the Old Password of User **/
	@Override
	public List getOldPassword(String ppEmployeemasterid) {

		ChangePasswordDTO changepassworddto = new ChangePasswordDTO();
		List list = null;
		Session session = sessionFactory.openSession();
		Query query = null;
		String result = "";

		try {
			if (ppEmployeemasterid.equals("0")) {
				list = new ArrayList();
				String NamedQuery = "Admin.findByAdminname";
				String name = "admin";
				changepassworddto.setPpEmployeemasterid(ppEmployeemasterid);

				Transaction t = session.beginTransaction();

				if (name != null) {
					query = session.getNamedQuery(NamedQuery);
					query.setString(0, name);
					list = (List<Object>) query.list();

					t.commit();
				}
				for (Object object : list) {
					Admin admin = (Admin) object;
					result = admin.getPassword();
				}

				changepassworddto.setPassword(result);
				list.add(changepassworddto);

			}

			else {

				list = new ArrayList();
				String NamedQuery = "PpEmployeemaster.findByPpEmployeemasterid";

				Transaction t = session.beginTransaction();

				if (ppEmployeemasterid != null) {
					query = session.getNamedQuery(NamedQuery);
					query.setString(0, ppEmployeemasterid);
					list = (List<Object>) query.list();

					t.commit();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	/** method for populating the combo on basis of Integer Value **/
	@Override
	public List getComboList(int where_condition, String namedQuery) {
		Query query = null;
		List<Object> list = null;
		Session session = null;
		try {

			session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			if (where_condition != 0) {
				query = session.getNamedQuery(namedQuery);
				query.setInteger(0, where_condition);
				list = (List<Object>) query.list();
			}

			else {
				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	/** method for populating the combo on basis of String Value **/
	@Override
	public List getComboList(String where_condition, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		try {

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condition);
				query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				list = (List<Object>) query.list();
			}

			else {
				query = session.getNamedQuery(namedQuery);
				query.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				list = (List<Object>) query.list();

			}
			transaction.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<?> serachOffices(String sQL) {
		List<?> SearchOfficeInfoList = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(sQL);
			query.addEntity(RmofficeView.class);
			SearchOfficeInfoList = query.list();
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return SearchOfficeInfoList;

	}

	@Override
	public void saveNewOfficeRecord(RmOffice rmOffice) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(rmOffice);
			session.flush();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void saveBasicRecordNewOffice(PpEmployeemaster ppEmployeemaster) {
		ppEmployeemaster.setIsretired('0');
		ppEmployeemaster.setIsloginlocked('0');
		ppEmployeemaster.setPpDesignationmasterid(473);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(ppEmployeemaster);
			session.flush();
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateNewOfficeRecord(RmOffice rmOffice) {

		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.createCriteria(rmOffice.getRmOfficeid() + "");
			session.update(rmOffice);
			session.flush();

			tx.commit();
		} catch (HibernateException e) {

			e.printStackTrace();

		}

		catch (Exception e) {
			System.out.println(e);
		} finally {
			session.close();
		}
	}

	@Override
	public int executeProcedureForAssignOfficeAdmin(CreateUserDTO createUserDTO) {
		boolean isComplete = false;
		int result = 0;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();

		EncryptionService encryptionService = EncryptionService.getInstance();
		try {
			String encPassword = encryptionService.encrypt(md5(createUserDTO.getPassword()));
			createUserDTO.setPassword(encPassword);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_ASSIGNOFFICEADMIN(?,?,?,?)}");
			stmt.setString(1, createUserDTO.getOfficeNameID() + "");
			stmt.setString(2, createUserDTO.getPpEmployeemasterid());
			stmt.setString(3, createUserDTO.getPassword());
			stmt.registerOutParameter(4, Types.VARCHAR);

			stmt.executeUpdate();

			String output = stmt.getString(4);
			tx.commit();

			if (output != null && output.equals("1")) {// If all SP has been
														// completed
														// successfully

				isComplete = true; // Set isComplete = true
			}
			boolean isDefaultComplete = this.insertDefaultRights(createUserDTO.getRmOfficeid(), session, tx);

			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	private boolean insertDefaultRights(Integer rmOfficeid, Session session, Transaction tx) {
		boolean isComplete = false;
		String rm_RoleID = null;
		String rm_MenuItemID = null;

		tx = session.beginTransaction();

		List<RmRole> rmRoleInfo = (List<RmRole>) selectquery(rmOfficeid, "RmRole.findByRmOfficeid");
		for (RmRole rmRole : rmRoleInfo) {
			rm_RoleID = rmRole.getRmRoleid() + "";
		}
		List<RmMenuitem> rmMenuInfo = (List<RmMenuitem>) selectquery(1, "RmMenuitem.findByIsDefaultOaRole");
		try {
			for (RmMenuitem rmMenuitem : rmMenuInfo) {

				rm_MenuItemID = rmMenuitem.getRmMenuitemid() + "";
				RmRolemenuitem rmRolemenuitem = new RmRolemenuitem();
				rmRolemenuitem.setRmMenuitemid(rm_MenuItemID);
				rmRolemenuitem.setRmRoleid(rm_RoleID);
				session.save(rmRolemenuitem);
				session.flush();
				tx.commit();

				isComplete = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isComplete;
	}

	@Override
	public int executeProcedureForUpdateAssignOfficeAdmin(CreateUserDTO createUserDTO) {

		int result = 0;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();

		EncryptionService encryptionService = EncryptionService.getInstance();
		try {
			String encPassword = encryptionService.encrypt(md5(createUserDTO.getPassword()));
			createUserDTO.setPassword(encPassword);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {
			CallableStatement stmt = connection.prepareCall("{call Proc_RM_ReAssignOfficeAdmin(?,?,?,?)}");
			stmt.setString(1, createUserDTO.getRmRoleid() + "");
			stmt.setString(2, createUserDTO.getPpEmployeemasterid());
			stmt.setString(3, createUserDTO.getPassword());
			stmt.registerOutParameter(4, Types.VARCHAR);

			stmt.executeUpdate();

			String output = stmt.getString(4);
			tx.commit();

			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public int addRole(CreateUserDTO createUserDTO) {

		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_ADDROLE(?,?,?)}");
			stmt.setString(1, createUserDTO.getRolename());
			stmt.setString(2, createUserDTO.getRmOfficeid() + "");
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();

			String output = stmt.getString(3);
			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return result;

	}

	@Override
	public int editRole(CreateUserDTO createUserDTO) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_EDITROLE(?,?,?)}");
			stmt.setString(1, createUserDTO.getRmRoleid());
			stmt.setString(2, createUserDTO.getRolename());
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();

			String output = stmt.getString(3);
			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return result;

	}

	@Override
	public int deleteRole(String rmRoleid) {

		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_DELROLE(?,?)}");
			stmt.setString(1, rmRoleid);

			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.executeUpdate();

			String output = stmt.getString(2);
			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return result;
	}

	@Override
	public List<?> getRoleLinksToAssign(Integer pp_EmployeeMasterID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		String ppEmployeeMasterID = pp_EmployeeMasterID + "";

		String sql = "";
		List result = null;
		try {

			/*
			 * String sql="SELECT * FROM VIEW_RM_GETLINKSFORTREE1"+
			 * " WHERE PP_EMPLOYEEMASTERID='"+pp_EmployeeMasterID+
			 * "' OR PP_EMPLOYEEMASTERID IS NULL"+ " ORDER BY RM_MENUITEMID";
			 */

			if (pp_EmployeeMasterID == 0) {
				sql = "select * FROM VIEW_RM_GETLINKSTOASSIGN";

			} else if (pp_EmployeeMasterID == 1) {
				sql = "select * from (" + "select distinct * from "
						+ "(select distinct RM_MENUITEMID,MENUNAME,LINKS,LINKLevel,QUERYSTRING,parentId,sortID "
						+ "FROM  VIEW_RM_GETLINKSFORTREE  WHERE "
						+ "  pp_EmployeeMasterID is null ) START WITH RM_MENUITEMID IN "
						+ "(SELECT distinct Rm_MenuItemID FROM VIEW_RM_GETLINKSFORTREE WHERE LINKS IS NOT NULL AND rolename='SERVICE BOOK' "
						+ ") CONNECT BY RM_MENUITEMID = PRIOR PARENTID" + ")  START WITH PARENTID='0'"
						+ "CONNECT BY PARENTID= PRIOR RM_MENUITEMID  order SIBLINGS by sortID";

			} else {
				sql = "select * from (" + "select distinct * from "
						+ "(select distinct RM_MENUITEMID,MENUNAME,LINKS,LINKLevel,QUERYSTRING,parentId,sortID "
						+ "FROM  VIEW_RM_GETLINKSFORTREE  WHERE " + " pp_employeeMasterID='" + pp_EmployeeMasterID
						+ "' or pp_employeeMasterID IS NULL) START WITH RM_MENUITEMID IN "
						+ "(SELECT distinct Rm_MenuItemID FROM VIEW_RM_GETLINKSFORTREE WHERE LINKS IS NOT NULL AND pp_employeeMasterID='"
						+ pp_EmployeeMasterID + "' " + ") CONNECT BY RM_MENUITEMID = PRIOR PARENTID"
						+ ")  START WITH PARENTID='0'"
						+ "CONNECT BY PARENTID= PRIOR RM_MENUITEMID  order SIBLINGS by sortID";
			}

			Query query = session.createSQLQuery(sql).addEntity(ViewRmGetlinkstoassign.class);

			result = query.list();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	@Override
	public int setRoleRights(String rm_RoleID, String strIds) {

		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try {
			CallableStatement stmt = connection.prepareCall("{call PROC_RM_ASSIGNRIGHTS(?,?,?)}");
			stmt.setString(1, rm_RoleID);
			stmt.setString(2, strIds);

			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();
       
			String output = stmt.getString(3);
			  System.out.println("value of output is................#############"+output);
			if (output.equals("1")) {
				result = Integer.parseInt(output);
				tx.commit();
			}
			else{
				tx.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			session.close();
		}
		return result;
	}

	public static String md5(String input) {
		String md5 = null;
		if (null == input) {
			return null;
		}
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(input.getBytes(), 0, input.length());
			md5 = (new BigInteger(1, digest.digest())).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return md5;
	}

	public boolean checkExistanceLocCode(Long value) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		boolean userFound = false;
		try {
			String SQL_QUERY = " from RmOffice as o where o.locCode=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, value);

			List list = query.list();
			transaction.commit();

			if ((list != null) && (list.size() > 0)) {
				userFound = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return userFound;
	}

	public boolean checkExistanceForOffice(String value) {
		System.out.println("In Check login");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		boolean userFound = false;
		try {
			String SQL_QUERY = " from RmOffice as o where o.officename=?";
			Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0, value);

			List list = query.list();

			transaction.commit();

			if ((list != null) && (list.size() > 0)) {
				userFound = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return userFound;
	}

	/** Populating Combo when Condition datatype is Integar Array **/
	public List getComboList(int[] where_condtion, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condtion != null) {
				query = session.getNamedQuery(namedQuery);

				for (int i = 0; i < where_condtion.length; i++) {
					query.setInteger(i, where_condtion[i]);

				}

				list = (List<Object>) query.list();

			}
			tx.commit();
		} catch (Exception e) {

		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public List<ViewRmRolesforemployee> loadObject(String ppEmployeemasterid) {

		List<ViewRmRolesforemployee> list = null;
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		ViewRmRolesforemployee viewRmRolesforemployee = null;
		try {

			Criteria cr = session.createCriteria(ViewRmRolesforemployee.class);
			cr.add(Restrictions.eq("ppEmployeemasterid", Long.parseLong(ppEmployeemasterid)));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			list = cr.list();
			transaction.commit();

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public void deleteFromDB(CreateUserDTO createUserDTO) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {

			Query query = session.createQuery("delete RmLoginrole where ppEmployeemasterid = :ID");
			query.setParameter("ID", Long.parseLong(createUserDTO.getPpEmployeemasterid()));
			int result = query.executeUpdate();
			transaction.commit();

			String[] roles = createUserDTO.getRoles();

			for (int i = 0; i < roles.length; i++) {

				createUserDTO.setRmRoleid(roles[i]);

				String[] inParam = new String[2];
				inParam[0] = createUserDTO.getPpEmployeemasterid();
				inParam[1] = createUserDTO.getRmRoleid();

				executeProcedureForAddEmployeeRole(session, inParam);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private int executeProcedureForAddEmployeeRole(Session session, String[] inParam) {
		int result = 0;

		Transaction transaction = session.beginTransaction();
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		java.sql.Connection connection = sessionImplementor.connection();
		try {
			CallableStatement stmt = connection.prepareCall("{call Proc_RM_AddEmployeeRole(?,?,?)}");
			stmt.setString(1, inParam[0]);
			stmt.setString(2, inParam[1]);
			stmt.registerOutParameter(3, Types.VARCHAR);
			stmt.executeUpdate();

			String output = stmt.getString(3);
			if (output.equals("1")) {
				result = Integer.parseInt(output);
			}
			transaction.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();

		}

		return result;

	}
}
