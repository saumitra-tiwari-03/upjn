<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<link rel="icon" href="resources/images/up-jal-nigam-logo.jpg" />
	<%
	String s = request.getParameter("s");
%>
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
		<title>U.P JAL NIGAM</title>
		<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="resources/js/validation.js"></script>
		<SCRIPT language="Javascript" SRC="resources/js/md5.js"></SCRIPT>

	</head>
	<body style="margin:0px 0px 0px 0px;">
		
	<form action="/UPJN/login.html" method="post" class="frontForm">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
		
		  <tr>
			<td valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			  <tr>
				<td width="83" valign="top"><img name="home_r1_c1" src="resources/images/home_r1_c1.jpg" width="83" height="82" border="0" alt=""></td>
				<td width="284" valign="top"><img name="home_r1_c2" src="resources/images/home_r1_c2.jpg" width="284" height="82" border="0" alt=""></td>
				<td width="50" valign="top"><img name="home_r1_c4" src="resources/images/home_r1_c4.jpg" width="50" height="82" border="0" alt=""></td>
				<td valign="top" background="resources/images/home_r1_c5.jpg" class="fix_bg"><table border="0" cellpadding="0" cellspacing="0" width="257">
					<tr>
					  <td width="257" height="27" align="center" valign="middle">&nbsp;</td>
					</tr>
					<tr>
					  <td valign="top"><img name="home_r2_c5" src="resources/images/home_r2_c5.jpg" width="257" height="55" border="0" alt=""></td>
					</tr>
				</table></td>
			  </tr>
			</table></td>
		  </tr>
		  <tr>
		   <td valign="top">&nbsp;</td>
		  </tr>
		   <tr>
				<td valign="top" class="error" colspan="4">					
			<%
						if (s != null) {
							out.print(s);
						}
					%>
					
			
				</td>
			</tr>
		  <tr>
		   <td valign="top"><table align="left" border="0" cellpadding="0" cellspacing="0" width="100%">
			 <tr>
			   <td height="160" background="resources/images/login_main_r4_c6.jpg">&nbsp;</td>
			   <td width="352" valign="top">
				 <table width="352" border="0" align="left" cellpadding="0" cellspacing="0" id="LoginTable">
				   <tr>
					 <td><img name="login_main_r4_c3" src="resources/images/login_main_r4_c3.jpg" width="352" height="14" border="0" alt=""></td>
				   </tr>
				   <tr>
					 <td height="137" background="resources/images/login_main_r5_c3.jpg"><table width="100%"  border="0" align="center" cellpadding="1" cellspacing="1">
						 <tr>
						   <td class="td-light-green"><table width="90%"  border="0" align="center" cellpadding="1" cellspacing="1">
							   <tr>
								 <td colspan="3">
                  </td>
							   </tr>
							   <tr>
							   <td width="57%">
							   <strong>User ID</strong>
							   </td>
								 <td width="43%">
									<strong><input type="text" name="employeecode" class="txt_medium"/></strong></td>								 
									
							   </tr>
							   <tr>
							   <td width="57%">
							   <strong>Password</strong>
							   </td>
								 <td width="43%">
									<strong><input type="password" name="password" class="txt_medium"/></strong></td>
								
							   <tr>
								 <td colspan="3">&nbsp;</td>
							   </tr>
							   <tr>
								 <td colspan="2" align="center">
									 <input type="submit" value="Log in" Class="btn_medium" />						
							   </tr>
							   <tr>
								 <td colspan="3">
									<input name="chkRemember" id="chkRemember" type="checkbox" value="checkbox" />
									 Remember my ID on this computer
						   </td>
							   </tr>
						   </table></td>
						 </tr>
					 </table></td>
				   </tr>
				   <tr>
					 <td><img name="login_main_r6_c3" src="resources/images/login_main_r6_c3.jpg" width="352" height="14" border="0" alt=""></td>
				   </tr>
				 </table> 
			   </td>
			   <td background="resources/images/login_main_r4_c6.jpg">&nbsp;</td>
			 </tr>
		   </table></td>
		  </tr>
		  <tr>
			<td valign="top">&nbsp;</td>
		  </tr>
		  <tr>
		   <td align="center" valign="top">Prepared by:<br>
			 <strong><a href="http://up.nic.in" target="_parent" class="bold style1">National Informatics Centre</a></strong><br>
		Govt. of India<br>
		Ministry of Communications and Information Technology <br>
		&amp;<br>
		National Informatics Centre Services Inc.</td>
		  </tr>
		</table>
</form>
	</body>
</html>

 

 
 