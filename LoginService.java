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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* This method is used for Authorization and deciding the RollType of user */

public interface LoginService {
	
	public boolean userAuthentication(String adminname,String password,HttpServletRequest request,HttpServletResponse response)  throws Exception;
 
}
