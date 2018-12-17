/******************************** LOGIN DAO**************************/




/*==========================================================================
 * Description : LoginDao is a simple interface standard that contains an abstract method named checkLogin() used for login purpose.   
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 *


/** Interface for UserLogin **/
package com.nic.upjn.spring.dao;

import java.util.HashMap;
import java.util.List;

import com.nic.upjn.spring.entity.ViewRmGetlinkstoassign;

public interface LoginDao
{
	
	HashMap<String,String> checkLogin(String adminname, String password);

	String getAdminpassword(String name, String NamedQuery);

	List<ViewRmGetlinkstoassign> getRoleLinksToAssign(int pp_EmployeeMasterID);

	List getComboList(String where_condtion, String namedQuery);
		
}




	 
 


