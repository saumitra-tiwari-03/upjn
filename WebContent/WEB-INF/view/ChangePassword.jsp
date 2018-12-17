<%-- ******************************** JSP FOR CHANGING PASSWORDS **************************

==========================================================================
 * Description 	: This JSP is responsible for the operations related to Change of Password.
 * Date			: 04/03/2016
 * Author		: VIKAS SINGH
 * Review By 	: 
 * Review Date	:  
==========================================================================

  --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM- Change Password</title>
<script type="text/javascript">
	
</script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 600px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px; overflow-x: auto;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div align="center"
			style="height: 100%; width: 79%; float: left; padding-top: 10px; overflow-x: auto;">

			<form action="/UPJN/newpassword">
				<input type="hidden" name="ppEmployeemasterid"
					value="${ppEmployeemasterid}">
				<table width="95%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td align="center" valign="top"><table width="100%"
								border="0" cellspacing="1" cellpadding="1">
								<tr>
									<td valign="top"><table width="100%" border="0"
											cellspacing="3" cellpadding="3">
											<tr>
												<td valign="top" class="table_bg">
													<table border="0" width="100%">

														<tr>
															<td class="msg" colspan="4">${msg}</td>
														</tr>

														<tr>

															<td class="table_head" colspan="4">Role management -
																Change Password</td>
														</tr>

														<tr>
															<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
															<td align="right" class="error_normal">* Fields are
																required</td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Current
																Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" name="currentpassword"
																id="currentpassword" class="txt_medium" maxlength="15"
																required /> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">New
																Password</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="password" name="newpassword" id="newpassword"
																class="txt_medium" maxlength="15" required /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Confirm
																New Password</td>

															<td class="cell_bg" valign="top" align="left"><input
																type="password" id="Confirmpassword"
																name="Confirmpassword" class="txt_medium" maxlength="15"
																required /> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>

															<td colspan="4" align="center" valign="top"
																class="cell_bg"><input type="submit" value="Submit"
																class="btn_medium"> <input type="reset"
																value="Reset" class="btn_medium"></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td></td>
														</tr>
													</table>
												</td>
											</tr>
										</table></td>
								</tr>
							</table></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>