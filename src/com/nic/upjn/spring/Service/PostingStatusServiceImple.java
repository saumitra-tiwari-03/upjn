/******************************** PostingStatusServiceImple Class **************************/

/*==========================================================================
 * Description : PostingStatusServiceImple class contains  operation for the Posting Status. 
 * Date:  
 * Author: VIKAS SINGH
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.Service;

/** Description of required classes that are used **/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nic.upjn.spring.dao.PostingStatusDAO;
import com.nic.upjn.spring.dto.JoinEmployeeDTO;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.dto.SearchEmployeeDTO;
import com.nic.upjn.spring.entity.PpNoduesdetail;
import com.nic.upjn.spring.entity.RmOffice;




@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("PostingStatusService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PostingStatusServiceImple implements PostingStatusService {

	@Autowired
	private PostingStatusDAO postingStatusDAO;
	
	
	
	/** method for populating the combo on basis of  Integer Value **/
	
    @Override
	public List getList(int where_condtion, String namedQuery) {
		List list;

		list = postingStatusDAO.getComboList(where_condtion, namedQuery);

		return list;
	}

	/** method for populating the combo on basis of  String Value **/
    
	@Override
	public List getList(String where_condtion, String namedQuery) {
		List list;
		list = postingStatusDAO.getComboList(where_condtion, namedQuery);
		return list;
	}

	/** Get Transfer List  **/
	@Override
	public List getTransferList(String sql) {
		List results = postingStatusDAO.getTransferList(sql);
		return results;
	}

	/** Executing procedure for ProcPpValidateEmpGetInfo for getting EmployeeInfo **/
    @Override
	public String[] executeProcedurePP_VALIDATEEMPGETINFO(String employeecode,
			String rmofficeid, String root, String type) {
		String[] b = postingStatusDAO.executeProcedurePP_VALIDATEEMPGETINFO(
				employeecode, rmofficeid, root, type);
		return b;
	}

	/** inserted  PpNoduesdetail information **/
	@Override
	public boolean insertD(PpNoduesdetail pp) {
		boolean result = postingStatusDAO.insertD(pp);
		return result;
	}

	/** Update  PpNoduesdetail information **/
    @Override
	public boolean update(PpNoduesdetail pp, String id) {
		boolean result = postingStatusDAO.update(pp, id);
		return result;
	}

	/** Delete  PpNoduesdetail information **/
    @Override
	public boolean delete(String id) {
		boolean result = postingStatusDAO.delete(id);
		return result;
	}

	/** calling procedure for   Employee Joining information **/
    @Override
	public int proc_execute(JoinEmployeeDTO joinEmployeeDTO) {
		int result = postingStatusDAO.proc_execute(joinEmployeeDTO);
		return result;
	}

	/** execute procedure PROC_PP_ADDELDETAIL **/
    @Override
	public int proc_executePROC_PP_ADDELDETAIL(RelieveELDTO relieveELDTO) {
		int result = postingStatusDAO
				.proc_executePROC_PP_ADDELDETAIL(relieveELDTO);
		return result;
	}

	/** Delete  deleteRelieveEL on the basis of ID **/
	@Override
	public boolean deleteRelieveEL(String id) {
		boolean result = postingStatusDAO.deleteRelieveEL(id);
		return result;
	}

	/** Executing procedure  PROC_PP_JOINELDETAIL for joining Employee at Relieve EL-Page **/
	@Override
	public int PROC_PP_JOINELDETAIL(RelieveELDTO relieveELDTO) {
		int result = postingStatusDAO.PROC_PP_JOINELDETAIL(relieveELDTO);
		return result;
	}
	
	/** Executing procedure  PROC_PP_JOINELDETAIL for joining Employee at Relieve EL-Page **/
    @Override
	public int executeProc(Object ob) {
		int result = postingStatusDAO.executeProc(ob);
		return result;
	}

	/** Executing procedure  PROC_PP_NODUESEMPGETINFO for NO Dues EmployeeInfo **/
	@Override
	public String[] executePROC_PP_NODUESEMPGETINFO(String ppEmployeemasterid) {
		String[] b = postingStatusDAO
				.executePROC_PP_NODUESEMPGETINFO(ppEmployeemasterid);
		return b;
	}

	/** Inserted data for RelieveEmployee **/
    @Override
	public int insert(RelieveEmployeeDTO relieveEmployeeDTO) {
		int result = postingStatusDAO.insert(relieveEmployeeDTO);
		return result;
	}

	/** Executing procedure  PROC_PP_EDITTRANSFER for Edit Transfer Details **/
    @Override
	public int PROC_PP_EDITTRANSFER(RelieveEmployeeDTO relieveEmployeeDTO) {
		int result = postingStatusDAO.PROC_PP_EDITTRANSFER(relieveEmployeeDTO);
		return result;
	}

	/** Executing procedure  PP_DELTRANSFERDETAILS for Delete Transfer Details **/
    @Override
	public int executeProcedurePP_DELTRANSFERDETAILS(String ppTransferdetailid,
			String ppEmployeemasterid, String ppNoduesdetailid) {
		int result = postingStatusDAO.executeProcedurePP_DELTRANSFERDETAILS(
				ppTransferdetailid, ppEmployeemasterid, ppNoduesdetailid);
		return result;
	}

    /** method for populating the combo where the condition is Integer Array **/
    @Override
	public List<RmOffice> getOfficeCombo(int[] where_condtion, String string) {
		List list;

		list = postingStatusDAO.getComboList(where_condtion, string);
		return list;
	}

    /** This method is called internally by 'SEARCH EMPLOYEE BY ID' method of this Controller **/
	public String createSearchSQL(String _predicate,Object obj,Integer rmofficeid) {

		System.out.println("the value of predicate in method createSearchSQl :"
				+ _predicate);
		String preSQL = "SELECT * FROM VIEW_EMPLOYEE_SEARCH ";
		String predicate = "";
		String sQL = "";
		String employeecode = null;
		String firstname = null;
		String lastname = null;
		String pp_designationmasterID = null;
		String mas_employmentsubtypeID = null;
		
		if(obj instanceof SearchEmployeeDTO){ 
			SearchEmployeeDTO searchEmployeeDTO = (SearchEmployeeDTO)obj;
			
			 employeecode = searchEmployeeDTO.getEmployeecode();
			 firstname = searchEmployeeDTO.getFirstname();
			 lastname = searchEmployeeDTO.getLastname();
			 pp_designationmasterID = searchEmployeeDTO.getPpDesignationmasterid();
			 mas_employmentsubtypeID = searchEmployeeDTO.getMasEmploymentsubtypeid();
		}
		
		if(obj instanceof RelieveEmployeeDTO){ 
			RelieveEmployeeDTO relieveEmployeeDTO = (RelieveEmployeeDTO)obj;
			
			 employeecode = relieveEmployeeDTO.getEmployeecode();
			 firstname = relieveEmployeeDTO.getFirstname();
			 lastname = relieveEmployeeDTO.getLastname();
			 pp_designationmasterID = relieveEmployeeDTO.getPpDesignationmasterid();
			 mas_employmentsubtypeID = relieveEmployeeDTO.getMasEmploymentsubtypeid();
		}
		
		if(obj instanceof RelieveELDTO){ 
			RelieveELDTO relieveELDTO = (RelieveELDTO)obj;
			
			 employeecode = relieveELDTO.getEmployeecode();
			 firstname = relieveELDTO.getFirstname();
			 lastname = relieveELDTO.getLastname();
			 pp_designationmasterID = relieveELDTO.getPpDesignationmasterid();
			 mas_employmentsubtypeID = relieveELDTO.getMasEmploymentsubtypeid();
		}

		if (employeecode != null
				&& !(employeecode.trim().equals(""))) {

			predicate = predicate
					+ " lower(EMPLOYEECODE) LIKE '"
					+ (employeecode).toLowerCase()
							.trim() + "%' AND ";
		}
		if (firstname != null
				&& !(firstname.trim().equals(""))) {

			predicate = predicate + " lower(FIRSTNAME) LIKE '"
					+ (firstname).toLowerCase().trim()
					+ "%' AND ";
		}
		if (lastname != null
				&& !(lastname.trim().equals(""))) {

			predicate = predicate + " lower(LASTNAME) LIKE '"
					+ (lastname).toLowerCase().trim()
					+ "%' AND ";
		}
		if (pp_designationmasterID != null
				&& !pp_designationmasterID.trim()
						.equals("-1")) {

			predicate = predicate + " PP_DESIGNATIONMASTERID ='"
					+ pp_designationmasterID + "' AND ";
		}
		if (mas_employmentsubtypeID != null
				&& !mas_employmentsubtypeID.trim()
						.equals("-1")) {

			predicate = predicate + " mas_EmploymentSubTypeID = '"
					+ mas_employmentsubtypeID + "' AND ";
		}
		if (rmofficeid != null) {
			if (!rmofficeid.toString().trim().equals("")) {

				/** The rm_office id should be changed from static(314) to dynamic ***/
			
				predicate = predicate + " rm_OfficeID = '" + rmofficeid + "' AND ";
			}
		}

		if (predicate.endsWith(" AND ")) {

			int len = predicate.length();
			predicate = predicate.substring(0, len - 4);
		}

		if (predicate == "") {

			sQL = preSQL;

			if (!(_predicate.equals(""))) {

				sQL = sQL + " WHERE " + _predicate;
			}

		} else {

			sQL = preSQL + " WHERE " + predicate;

			if (!(_predicate.equals(""))) {

				sQL = sQL + " AND " + _predicate;
			}
		}

		return sQL;
	}

	
	@Override
	public List duplicateEmployee(String employeecode) {
		List duplicateEmployee = postingStatusDAO.duplicateEmployee(employeecode);
        return duplicateEmployee;
	}
}
