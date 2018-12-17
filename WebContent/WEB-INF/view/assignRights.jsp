
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>U.P JAL NIGAM assign Rights</title>

<script src="<c:url value="/resources/js/jquery-1.11.1.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">
<link type="text/css" rel="stylesheet"
	href="resources/css/dhtmlgoodies_calendar.css" media="screen"></link>
<script language="javascript" src="resources/js/validation.js"></script>
<script language="javascript" src="resources/js/popcalendar.js"></script>
<script language="javascript" src="resources/js/NEW_NEW.js"></script>
<script type="text/javascript"
	src="resources/js/dhtmlgoodies_calendar.js"></script>




</head>

<body style="margin: 0px 0px 0px 0px;">

	<div style="height: 100%; width: 100%;">

		<div
			style="height: 100px; width: 100%; border-bottom: gray solid 4px;">
			<%@ include file="/WEB-INF/view/Header.jsp"%>
		</div>

		<div
			style="height: 700px; width: 20%; float: left; border-right: gray solid 1px; padding-top: 10px;">
			<%@ include file="/WEB-INF/view/Menu.jsp"%>
		</div>

		<div style="height: 100%; width: 79%; float: left; padding-top: 10px;">
			 <form action="/UPJN/assignRoles">
			  <input type="hidden" name="rmRoleid" value="${rmRoleid}">
				<table style="border: 0px solid black; width: 100%;">
                    <tr>
					<td valign="top" class="msg">
						${mes}
					</td>
				</tr>
					<tr>
						<td align="left" valign="top" class="error">${app_msg}</td>
					</tr>


					<tr>
						<td valign="top"><table
								style="width: 90%; border: 0px solid black;">
								<tr>
									<td align="center" valign="top"><table
											style="width: 100%; border: 0px;">
											<tr>
												<td valign="top"><table
														style="width: 100%; border: 0px;">
														<tr>
															<td valign="top" class="table_bg"><table
																	style="width: 100%; border: 0px;">
																	<tr>


																		<td width="95%" align="left" valign="top"
																			class="table_head">Define Role - Assign Rights</td>

																	</tr>
																</table>
																<table style="width: 100%;" border="0">
																	<tr>
																		<td colspan="3" valign="top" class="cell_bg">&nbsp;</td>
																		<td colspan="2" valign="top" class="error_normal">
																		</td>
																	</tr>
																	<tr>
																		<td align="left" colspan="2" class="bold">
																			Assign Right(s) for  : ${roleName}</td>
																	</tr>
																	
																	<tr>
																		<td align="left" colspan="3" class="bold"></td>
																	</tr>
																	<tr>
																		<td width="95%" align="left" valign="top"
																			class="table_head"></td>
																	</tr>

																	<c:set value="${Links}" var="list" />
																	<c:set value="${roleRightsList}" var="list1" />

																	<c:forEach items="${Links}" var="list">

																		<%
																			boolean check = false;
																		%>
																		<c:choose>
																			<c:when test="${list.links==null}">
																				<tr>
																					<td align="left" valign="top" class="bold"
																						colspan="4"><c:if test="${list.linklevel==1}" />
																						<c:if test="${list.linklevel==2}" /> <c:if
																							test="${list.linklevel==3}" /> <c:if
																							test="${list.linklevel==4}" /> <c:if
																							test="${list.linklevel==5}" /></td>
																				</tr>
																				<tr>
																					<td align="left" valign="top" class="bold"
																						colspan="4">${list.menuname} </td>
																				</tr>
																			</c:when>
																			<c:otherwise>

																				<tr>

																					<td align="left" valign="top" class="cell_bg"
																						colspan="4">&nbsp;&nbsp;&nbsp;<c:if test="${list.linklevel==1}" />
																						<c:if test="${list.linklevel==2}" /> <c:if
																							test="${list.linklevel==3}" /> <c:if
																							test="${list.linklevel==4}" /> <c:if
																							test="${list.linklevel==5}" />

																					<c:forEach items="${roleRightsList}" var="list1">
																						<c:if
																							test="${list1.rmMenuitemid==list.rmMenuitemid}">
																							<input type="checkbox" checked="checked"
																								name="rmMenuitemid" value="${list.rmMenuitemid}">${list.menuname}
																							<br>
																							<%
																								check = true;
																							%>
																						</c:if>
																					</c:forEach>

																					<%
																						if (check == false) {
																					%>
																					<input type="checkbox" name="rmMenuitemid"
																						value="${list.rmMenuitemid}">${list.menuname}</td>
																					<%
																						}
																					%>
																				</tr>
																			</c:otherwise>
																		</c:choose>

																	</c:forEach>
																</table>
													</table>
										</table></td>
								</tr>
							</table></td>
					</tr>
					<tr>
						<td colspan="5" align="center" valign="top" class="cell_bg"><input
							type="submit" class="btn_medium" value="Assign" />
					</tr>
					<tr>
						<td height="30" valign="top">&nbsp;</td>
					</tr>
				</table>

			</form>

		</div>

	</div>


</body>

</html>