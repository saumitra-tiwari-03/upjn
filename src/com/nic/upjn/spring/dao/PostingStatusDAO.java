/******************************** PostingStatusDAO Dao**************************/

/*==========================================================================
 * Description : ServiceStatusDao is a simple interface standard that contains an abstract method for Service Status.   
 * Date:  
 * Author: VIKAS SINGH
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for PostingStatusDAO **/


package com.nic.upjn.spring.dao;

/** Description of required classes that are used **/
import java.util.List;

import com.nic.upjn.spring.dto.JoinEmployeeDTO;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.entity.PpNoduesdetail;

@SuppressWarnings("rawtypes")
public interface PostingStatusDAO {

	List getComboList(int where_condtion, String namedQuery);

	List getComboList(String where_condtion, String namedQuery);

	List getTransferList(String sql);

	int executeProcedurePP_DELTRANSFERDETAILS(String ppTransferdetailid,
			String ppEmployeemasterid, String ppNoduesdetailid);

	int PROC_PP_EDITTRANSFER(RelieveEmployeeDTO relieveEmployeeDTO);

	int insert(RelieveEmployeeDTO relieveEmployeeDTO);

	int executeProc(Object ob);

	String[] executePROC_PP_NODUESEMPGETINFO(String ppEmployeemasterid);

	int PROC_PP_JOINELDETAIL(RelieveELDTO relieveELDTO);

	boolean deleteRelieveEL(String id);

	int proc_executePROC_PP_ADDELDETAIL(RelieveELDTO relieveELDTO);

	int proc_execute(JoinEmployeeDTO joinEmployeeDTO);

	boolean delete(String id);

	boolean update(PpNoduesdetail pp, String id);

	boolean insertD(PpNoduesdetail pp);

	String[] executeProcedurePP_VALIDATEEMPGETINFO(String employeecode,
			String rmofficeid, String root, String type);

	List getComboList(int[] where_condtion, String string);
	
	List duplicateEmployee(String employeecode);

}
