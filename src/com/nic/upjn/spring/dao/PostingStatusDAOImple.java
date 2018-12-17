
/******************************** PostingStatusDAOImple Class **************************/

/*==========================================================================
 * Description : PostingStatusDAOImple class contains the database operation for the Posting Status. 
 * Date:  
 * Author: VIKAS SINGH
 * Review By : 
 * Review Date:  
 *==========================================================================
 */
package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.upjn.spring.dto.JoinEmployeeDTO;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.dto.TransferEmployeeDTO;
import com.nic.upjn.spring.entity.PpNoduesdetail;
import com.nic.upjn.spring.entity.ViewEmployeeSearch;

@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
@Repository("PostingStatusDAO")
public class PostingStatusDAOImple implements PostingStatusDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/** method for populating the combo on basis of Integer Value **/
	@Override
	public List getComboList(int where_condition, String namedQuery) {
		Query query = null;
		List<Object> list = null;

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			if (where_condition != 0) {
				query = session.getNamedQuery(namedQuery);
				query.setInteger(0, where_condition);
				list = (List<Object>) query.list();
			}

			else {
				query = session.getNamedQuery(namedQuery);
				list = (List<Object>) query.list();
			}

			tx.commit();
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

		try {
			Transaction tx = session.beginTransaction();

			if (where_condition != null) {
				query = session.getNamedQuery(namedQuery);
				query.setString(0, where_condition);
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

	/** Get Transfer List **/
	@Override
	public List getTransferList(String sql) {
		List results = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(ViewEmployeeSearch.class);
			results = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}

	/**
	 * Executing procedure PP_DELTRANSFERDETAILS for Delete Transfer Details
	 **/
	@Override
	public int executeProcedurePP_DELTRANSFERDETAILS(String ppTransferdetailid, String ppEmployeemasterid,
			String ppNoduesdetailid) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_DELTRANSFERDETAIL(?,?,?,?)}");

			stmt.setString(1, ppTransferdetailid);
			stmt.setString(2, ppEmployeemasterid);
			stmt.setString(3, ppNoduesdetailid);
			stmt.registerOutParameter(4, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(4);
			System.out.println(output + " --------relieve employee(delete)------");

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return result;
	}

	/** Executing procedure PROC_PP_EDITTRANSFER for Edit Transfer Details **/
	@Override
	public int PROC_PP_EDITTRANSFER(RelieveEmployeeDTO relieveEmployeeDTO) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			System.out.println(relieveEmployeeDTO.getRelieveorderdate());
			String date = getFormatedDate(relieveEmployeeDTO.getRelieveorderdate());
			System.out.println(date);

			System.out.println(relieveEmployeeDTO.getPpEmployeemasterid() + "--"
					+ relieveEmployeeDTO.getTransferorderno() + "--" + relieveEmployeeDTO.getTransferorderdate() + "--"
					+ relieveEmployeeDTO.getOfficefromid() + "--" + relieveEmployeeDTO.getOfficetoid() + "--"
					+ relieveEmployeeDTO.getRelieveorderno() + "--" + date + "--" + relieveEmployeeDTO.getRelievedate()
					+ "--" + relieveEmployeeDTO.getRelieveanfn() + "--" + relieveEmployeeDTO.getPpTransferdetailid());

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_EDITTRANSFER(?,?,?,?,?,?,?,?,?,?,?)}");

			stmt.setString(1, relieveEmployeeDTO.getPpEmployeemasterid());
			stmt.setString(2, relieveEmployeeDTO.getTransferorderno());
			stmt.setString(3, relieveEmployeeDTO.getTransferorderdate());
			stmt.setString(4, relieveEmployeeDTO.getOfficefromid());
			stmt.setString(5, relieveEmployeeDTO.getOfficetoid());
			stmt.setString(6, relieveEmployeeDTO.getRelieveorderno());
			stmt.setString(7, date);
			stmt.setString(8, relieveEmployeeDTO.getRelievedate());
			stmt.setString(9, relieveEmployeeDTO.getRelieveanfn());
			stmt.setString(10, relieveEmployeeDTO.getPpTransferdetailid());
			stmt.registerOutParameter(11, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(11);
			System.out.println(output + "--------employee EL transfer ------");

			t.commit();
			result = 1;

		} catch (Exception e) {
			result = 0;
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** inserted PpNoduesdetail information **/
	@Override
	public int insert(RelieveEmployeeDTO relieveEmployeeDTO) {
		Session session = sessionFactory.openSession();

		int result = 0;
		Query exQuery = null;
		Transaction t = session.beginTransaction();
		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection
					.prepareCall("{call PROC_PP_ADDTRANSFERDETAIL(?,?,?,?,?,?,?,?,?,?,?,?)}");
			stmt.setString(1, relieveEmployeeDTO.getPpEmployeemasterid() + "");
			stmt.setString(2, relieveEmployeeDTO.getTransferorderno());
			stmt.setString(3, relieveEmployeeDTO.getTransferorderdate() + "");
			stmt.setString(4, relieveEmployeeDTO.getOfficefromid());
			stmt.setString(5, relieveEmployeeDTO.getOfficetoid());
			stmt.setString(6, relieveEmployeeDTO.getRelieveorderno());
			stmt.setString(7, relieveEmployeeDTO.getRelieveorderdate() + "");
			stmt.setString(8, relieveEmployeeDTO.getRelievedate() + "");
			stmt.setString(9, relieveEmployeeDTO.getRelieveanfn());
			stmt.setString(10, relieveEmployeeDTO.getPpNoduesdetailid());
			stmt.setString(11, relieveEmployeeDTO.getIsJoined());
			stmt.registerOutParameter(12, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(12);
			System.out.println(output + "     ---------tyeiu gfiugufdih------------------");

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	/** Executing procedure PROC_PP_EL_TRANSFER Employee Transfer **/

	@Override
	public int executeProc(Object ob) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			RelieveELDTO relieveELDTO = new RelieveELDTO();
			BeanUtils.copyProperties(ob, relieveELDTO);

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_EL_TRANSFER(?,?,?,?,?,?,?)}");

			stmt.setString(1, relieveELDTO.getPpEmployeemasterid());
			stmt.setString(2, relieveELDTO.getPpEmployeeEldetailid());
			stmt.setString(3, relieveELDTO.getTransferordno());
			stmt.setString(4, relieveELDTO.getTransferorderdate());
			stmt.setString(5, relieveELDTO.getOfficeto());
			stmt.setString(6, relieveELDTO.getRmOfficeid());
			stmt.registerOutParameter(7, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(7);
			System.out.println(output + "--------employee EL transfer ------");

			t.commit();
			result = 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	/**
	 * Executing procedure for PROC_PP_NODUESEMPGETINFO for getting EmployeeInfo
	 **/
	@Override
	public String[] executePROC_PP_NODUESEMPGETINFO(String ppEmployeemasterid) {
		String[] data = new String[2];
		int result = 0;
		Query exQuery = null;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		
		SessionImplementor sessionImplementor = (SessionImplementor) session;

		TransferEmployeeDTO transferEmployeeDTO = new TransferEmployeeDTO();

		java.sql.Connection connection = sessionImplementor.connection();
		CallableStatement stmt;
		try {
			stmt = connection.prepareCall("{call PROC_PP_NODUESEMPGETINFO(?,?,?)}");
			stmt.setString(1, ppEmployeemasterid);
			stmt.registerOutParameter(2, Types.VARCHAR);
			stmt.registerOutParameter(3, Types.VARCHAR);

			result = stmt.executeUpdate();
			String noduesordno = stmt.getString(2);
			String noduesorddate = stmt.getString(3);

			data[0] = noduesordno;
			data[1] = noduesorddate;

			System.out.println(noduesordno + "---" + noduesorddate);

			t.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			session.close();
		}
		return data;
	}

	/**
	 * Executing procedure PROC_PP_JOINELDETAIL for joining Employee at Relieve
	 * EL-Page
	 **/
	@Override
	public int PROC_PP_JOINELDETAIL(RelieveELDTO relieveELDTO) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Query exQuery = null;
		Transaction t = session.beginTransaction();
		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_JOINELDETAIL(?,?,?,?,?,?,?)}");

			stmt.setString(1, relieveELDTO.getPpEmployeemasterid());
			stmt.setString(2, relieveELDTO.getPpEmployeeEldetailid());
			stmt.setString(3, relieveELDTO.getJoiningorderdate());
			stmt.setString(4, relieveELDTO.getJoiningorder());
			stmt.setString(5, relieveELDTO.getJoiningdate());
			stmt.setString(6, relieveELDTO.getJoininganfn());
			stmt.registerOutParameter(7, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(7);
			System.out.println(output + "--------employee EL join ------");

			t.commit();
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	/** delete pp_Employee_ELDetail for Delete EmployeeELDetail **/
	@Override
	public boolean deleteRelieveEL(String id) {
		boolean result = false;

		System.out.println("--ID-------" + id);

		Session session = null;
		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session.createSQLQuery(
					"DELETE FROM pp_Employee_ELDetail WHERE pp_Employee_ELDetailID=:pp_Employee_ELDetailID");
			query.setParameter("pp_Employee_ELDetailID", id);

			query.executeUpdate();

			t.commit();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** Executing Procedure PROC_PP_ADDELDETAIL for ADDELDETAIL **/
	@Override
	public int proc_executePROC_PP_ADDELDETAIL(RelieveELDTO relieveELDTO) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Query exQuery = null;
		String output = null;
		Transaction t = session.beginTransaction();
		try {
			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDELDETAIL(?,?,?,?,?,?)}");

			stmt.setString(1, relieveELDTO.getPpEmployeemasterid());
			stmt.setString(2, relieveELDTO.getRelorderno());
			stmt.setString(3, relieveELDTO.getRelorderdate());
			stmt.setString(4, relieveELDTO.getIsJoined());
			stmt.setString(5, relieveELDTO.getRmOfficeid());
			stmt.registerOutParameter(6, Types.VARCHAR);

			result = stmt.executeUpdate();

			output = stmt.getString(6);
			System.out.println(output + "--------employee EL relieve ------");

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return Integer.parseInt(output);
	}

	/** Executing Procedure PROC_PP_ADDELDETAIL for ADDELDETAIL **/
	@Override
	public int proc_execute(JoinEmployeeDTO joinEmployeeDTO) {
		int result = 0;
		Session session = sessionFactory.openSession();
		Query exQuery = null;
		Transaction t = session.beginTransaction();
		try {

			SessionImplementor sessionImplementor = (SessionImplementor) session;
			java.sql.Connection connection = sessionImplementor.connection();

			CallableStatement stmt = connection.prepareCall("{call PROC_PP_ADDTR_JOININGDETAIL(?,?,?,?,?,?,?)}");

			stmt.setString(1, joinEmployeeDTO.getPpEmployeemasterid());
			stmt.setString(2, joinEmployeeDTO.getPpTransferdetailid());
			stmt.setString(3, joinEmployeeDTO.getJoiningdate());
			stmt.setString(4, joinEmployeeDTO.getRelieveanfn());
			stmt.setString(5, joinEmployeeDTO.getJoiningorderno());
			stmt.setString(6, joinEmployeeDTO.getJoiningorderdate());
			stmt.registerOutParameter(7, Types.VARCHAR);

			result = stmt.executeUpdate();

			String output = stmt.getString(7);
			System.out.println(output + "     --------employee joining------");

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return result;
	}

	/** Delete No dues detail information **/
	@Override
	public boolean delete(String id) {
		boolean result = false;

		System.out.println("--ID-------" + id);

		Session session = null;
		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			Query query = session
					.createSQLQuery("DELETE FROM PP_NoDuesDetail WHERE pp_NoDuesDetailID=:pp_NoDuesDetailID");
			query.setParameter("pp_NoDuesDetailID", id);

			query.executeUpdate();

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return result;
	}

	/** update No dues detail information **/
	@Override
	public boolean update(PpNoduesdetail detail, String id) {
		Session session = null;
		System.out.println(detail);
		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			detail.setPpNoduesdetailid(Long.parseLong(id));

			Query query = session.createSQLQuery(
					"update Pp_Noduesdetail set noduesordno = :noduesordno, noduesorddate = :noduesorddate"
							+ " where pp_Noduesdetailid =:pp_Noduesdetailid");
			query.setParameter("noduesordno", detail.getNoduesordno());
			query.setParameter("noduesorddate", detail.getNoduesorddate());
			query.setParameter("pp_Noduesdetailid", detail.getPpNoduesdetailid());

			query.executeUpdate();

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	/** insert No dues detail information **/
	@Override
	public boolean insertD(PpNoduesdetail detail) {
		Session session = null;
		System.out.println(detail);
		try {

			session = sessionFactory.openSession();
			Transaction t = session.beginTransaction();

			session.save(detail);

			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return false;
	}

	/**
	 * Executing procedure for ProcPpValidateEmpGetInfo for getting EmployeeInfo
	 **/
	@Override
	public String[] executeProcedurePP_VALIDATEEMPGETINFO(String employeecode, String rmofficeid, String root,
			String type) {
		String[] data = new String[3];
		Session session = sessionFactory.openSession();
		int result = 0;
		Query exQuery = null;
		SessionImplementor sessionImplementor = (SessionImplementor) session;
		Transaction t = session.beginTransaction();
		try {

			if (root == "noDues") {

				System.out.println("NO dues ---------..!!!");
				System.out.println(root + "-----" + employeecode + "-----" + rmofficeid + "----" + type);

				java.sql.Connection connection = sessionImplementor.connection();
				CallableStatement stmt = connection.prepareCall("{call PROC_PP_VALIDATEEMPGETINFO(?,?,?,?,?,?,?,?)}");

				stmt.setString(1, employeecode);
				stmt.setString(2, rmofficeid);
				stmt.setString(3, root);
				stmt.setString(4, type);
				stmt.registerOutParameter(5, Types.VARCHAR);
				stmt.registerOutParameter(6, Types.VARCHAR);
				stmt.registerOutParameter(7, Types.VARCHAR);
				stmt.registerOutParameter(8, Types.VARCHAR);

				result = stmt.executeUpdate();
				String ppEmployeemasterid = stmt.getString(6);
				String employeename = stmt.getString(7);
				String designation = stmt.getString(8);

				System.out.println(employeename + "-----" + designation + "-----" + ppEmployeemasterid);

				data[0] = employeename;
				data[1] = designation;
				data[2] = ppEmployeemasterid;

			}

			if (root == "relOnEl") {

				System.out.println("relOnEl--------ex..");
				System.out.println(root + "-----" + employeecode + "-----" + rmofficeid + "----" + type);

				java.sql.Connection connection = sessionImplementor.connection();
				CallableStatement stmt = connection.prepareCall("{call PROC_PP_VALIDATEEMPGETINFO(?,?,?,?,?,?,?,?)}");

				stmt.setString(1, employeecode);
				stmt.setString(2, rmofficeid);
				stmt.setString(3, root);
				stmt.setString(4, type);
				stmt.registerOutParameter(5, Types.VARCHAR);
				stmt.registerOutParameter(6, Types.VARCHAR);
				stmt.registerOutParameter(7, Types.VARCHAR);
				stmt.registerOutParameter(8, Types.VARCHAR);

				result = stmt.executeUpdate();
				String ppEmployeemasterid = stmt.getString(6);
				String employeename = stmt.getString(7);
				String designation = stmt.getString(8);

				System.out.println(employeename + "-----" + designation + "-----" + ppEmployeemasterid);

				data[0] = employeename;
				data[1] = designation;
				data[2] = ppEmployeemasterid;
			}

			if (root == "relForTra") {

				System.out.println("relForTra--------ex..");
				System.out.println(root + "-----" + employeecode + "-----" + rmofficeid + "----" + type);

				java.sql.Connection connection = sessionImplementor.connection();
				CallableStatement stmt = connection.prepareCall("{call PROC_PP_VALIDATEEMPGETINFO(?,?,?,?,?,?,?,?)}");

				stmt.setString(1, employeecode);
				stmt.setString(2, rmofficeid);
				stmt.setString(3, root);
				stmt.setString(4, type);
				stmt.registerOutParameter(5, Types.VARCHAR);
				stmt.registerOutParameter(6, Types.VARCHAR);
				stmt.registerOutParameter(7, Types.VARCHAR);
				stmt.registerOutParameter(8, Types.VARCHAR);

				result = stmt.executeUpdate();
				String ppEmployeemasterid = stmt.getString(6);
				String employeename = stmt.getString(7);
				String designation = stmt.getString(8);

				System.out.println(employeename + "-----" + designation + "-----" + ppEmployeemasterid);

				data[0] = employeename;
				data[1] = designation;
				data[2] = ppEmployeemasterid;
				for (int i = 0; i < data.length; i++) {
					System.out.println(data[i]);
				}

			}

			else {

			}
			
			t.commit();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			session.close();
		}
		
		System.out.println(data);
		return data;
	}

	/** method for populating the combo on basis of Integer Array **/
	@Override
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
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				session.close();
			}

		return list;
	}

	String getFormatedDate(String currentDate) {
		SimpleDateFormat outputDateFormat = null;
		Date tempDate = null;
		try {

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			tempDate = simpleDateFormat.parse(currentDate);
			outputDateFormat = new SimpleDateFormat("dd/MM/YYYY");
			System.out.println("Output date is = " + outputDateFormat.format(tempDate));
		} catch (Exception ex) {
			System.out.println("Parse Exception");
		}
		return outputDateFormat.format(tempDate);
	}

	@Override
	public List duplicateEmployee(String employeecode) {
		List duplicateEmployee = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String sql = "";
		sql = (new StringBuilder())
				.append("SELECT   EMP.PP_EMPLOYEEMASTERID, NDD.PP_NODUESDETAILID,  "
						+ " NDD.NODUESORDNO,   NDD.NODUESORDDATE,   NDD.ISON FROM PP_NODUESDETAIL NDD   INN"
						+ "ER JOIN PP_EMPLOYEEMASTER EMP     ON EMP.PP_EMPLOYEEMASTERID=NDD.PP_EMPLOYEEMAST"
						+ "ERID WHERE   NDD.ISON='1' and emp.EMPLOYEECODE='")
				.append(employeecode).append("'").toString();

		try {
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(PpNoduesdetail.class);
			duplicateEmployee = query.list();

			tx.commit();
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return duplicateEmployee;
	}
}
