<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>U.P JAL NIGAM-Employee Information Search</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
</head>

<body>
	<form action="/UPJN/searchList" method="post">


		<table border="0" cellpadding="0" cellspacing="0" width="100%">

			<tr>
				<td valign="top"><table width="80%" border="0" align="center"
						cellpadding="0" cellspacing="0">
						<tr>
							<td align="center" valign="top"><table width="100%"
									border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td valign="top"><table width="100%" border="0"
												cellspacing="1" cellpadding="1">
												<tr>
													<td valign="top" class="table_bg"><table width="100%"
															border="0" cellspacing="1" cellpadding="3">
															<tr>
																<td align="left" valign="top" class="table_head">
																Employee Search</td>
															</tr>
														</table>
														<table width="100%" border="0" cellspacing="1"
															cellpadding="3">
															<tr>
																<td colspan="5" valign="top" class="table_bg"></td>
															</tr>
															<tr>
																<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td width="3%" valign="top" class="cell_bg">&nbsp;</td>
																<td width="43%" align="left" valign="top"
																	class="cell_bg">Employee Code</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="employeecode" class="txt_medium"
																	maxlength="250">
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">
																	Employee Name</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="employeename" class="txt_medium"
																	maxlength="250"></td>
															</tr>
															<tr>
																<td valign="top" class="cell_bg">&nbsp;</td>
																<td align="left" valign="top" class="cell_bg">Father Name</td>
																<td align="left" valign="top" class="cell_bg"><input
																	type="text" name="fathername" class="txt_medium"
																	maxlength="250"></td>
															</tr>
																				
															<tr>
																<td colspan="5" valign="top" class="cell_bg">&nbsp;</td>
															</tr>
															<tr>
																<td colspan="5" align="center" valign="top"
																	class="cell_bg"><input type="submit"
																	class="btn_medium" value="Submit" /> <input
																	type="reset" class="btn_medium" value="Reset" /></td>
															</tr>
														</table></td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="30" valign="top">&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>