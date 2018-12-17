

/******************************** ServiceStatus Service**************************/

/*==========================================================================
 * Description : ServiceStatus is a simple interface standard that contains an abstract method  for Posting status operations.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


 /** Interface for PostingStatus **/
package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.JoinEmployeeDTO;
import com.nic.upjn.spring.dto.RelieveELDTO;
import com.nic.upjn.spring.dto.RelieveEmployeeDTO;
import com.nic.upjn.spring.dto.SearchEmployeeDTO;
import com.nic.upjn.spring.entity.PpNoduesdetail;
import com.nic.upjn.spring.entity.RmOffice;

@SuppressWarnings("rawtypes")
public interface PostingStatusService {

	public List getList(int where_condtion, String namedQuery);

	public List getList(String where_condtion, String namedQuery);

	public List getTransferList(String sql);

	public String[] executeProcedurePP_VALIDATEEMPGETINFO(String employeecode,
			String rmofficeid, String root, String type);

	public boolean insertD(PpNoduesdetail pp);

	public boolean update(PpNoduesdetail pp, String id);

	public boolean delete(String id);

	public int proc_execute(JoinEmployeeDTO joinEmployeeDTO);

	public int proc_executePROC_PP_ADDELDETAIL(RelieveELDTO relieveELDTO);

	public boolean deleteRelieveEL(String id);

	public int PROC_PP_JOINELDETAIL(RelieveELDTO relieveELDTO);

	public int executeProc(Object ob);

	public String[] executePROC_PP_NODUESEMPGETINFO(String ppEmployeemasterid);

	public int insert(RelieveEmployeeDTO relieveEmployeeDTO);

	public int PROC_PP_EDITTRANSFER(RelieveEmployeeDTO relieveEmployeeDTO);

	public int executeProcedurePP_DELTRANSFERDETAILS(String ppTransferdetailid,
			String ppEmployeemasterid, String ppNoduesdetailid);

	public List<RmOffice> getOfficeCombo(int[] where_condtion, String string);
	
	public String createSearchSQL(String _predicate,Object obj, Integer rmofficeid);
	
	List duplicateEmployee(String employeecode);
			

}
