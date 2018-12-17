/******************************** LOGIN SERVICE **************************/
/*==========================================================================
 * Description : LoginService Interface for standard of LoginServiceImplentation
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */

package com.nic.upjn.spring.Service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* This method is used for Authorization and deciding the RollType of user */

public interface LoginService {
	
	public boolean userAuthentication(String adminname,String password,HttpServletRequest request,HttpServletResponse response)  throws Exception;

	public String getLinksForTree(String ppEmployeemasterid);
	
	public List getList(String object, String string); 
 
}
