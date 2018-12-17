<%-- ******************************** JSP FOR CHANGING PASSWORDS **************************

==========================================================================
 * Description 	: This JSP is responsible for the operations related to PayScale Master.
 * Date			: 10/11/2016
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
<title>U.P JAL NIGAM- PayScale Master</title>
<script type="text/javascript">

function getDependantCombo(){

    		var sysPaycategoryid = $("select#sysPaycategoryid").val();

    		$.post('/UPJN/getPayScaleList', {
    			sysPaycategoryid : sysPaycategoryid,
    		} ),
     		  function(response) {

                
       		  
    	      /*  var payscalelist = $('#payscalelist');
    	         select.find('option').remove();
    	        $('<option>').val('-1').text('[Select]').appendTo(select);
    	          $.each(response, function(index, value) {
    	          $('<option>').val(index).text(value).appendTo(select);	           
    	      }); 	   */ 
 }   
}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#sysPaycategoryid").val($("#sys_Paycategoryid").val());
		$("#myTable").tablesorter();
		
	});
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

			<c:if test="${payscaledetail == null}">
				<form action="/UPJN/insertPayScale" id="PayScaleMaster">
			</c:if>
			<c:if test="${payscaledetail != null}">
				<form action="/UPJN/editPayScale">
			</c:if>


			<!--  -->

			<c:forEach items="${payscaledetail}" var="a">
				<tr>
					<td><input type="hidden" id="sys_Paycategoryid"
						value="${a.sysPaycategoryid}"> <input type="hidden"
						name="pp_PayScaleMasterID" value="${a.ppPayscalemasterid}">
					</td>
				</tr>
			</c:forEach>

			<!--  -->

			<table width="95%" border="0" align="center" cellpadding="0"
				cellspacing="0">
				<tr>
					<td align="center" valign="top"><table width="100%" border="0"
							cellspacing="1" cellpadding="1">
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

														<td class="table_head" colspan="4">Master - Pay Scale
															Master</td>
													</tr>

													<tr>
														<td colspan="2" valign="top" class="cell_bg">&nbsp;</td>
														<td align="right" class="error_normal">* Fields are
															required</td>
													</tr>

													<!-- ----------------------------------------In case of New---------------------------------------------------------- -->

													<c:if test="${payscaledetail == null}">
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Pay
																Category</td>
															<td class="cell_bg" valign="top" align="left"><select
																name="sysPaycategoryid" class="cmb_medium"
																onchange="getDependantCombo();">
																	<option value="-1">Select PayCategory</option>
																	<c:forEach var="d" items="${paycategorylist}">
																		<option value="${d.sysPaycategoryid}">${d.paycategory}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Pay
																Scale</td>
															<td class="cell_bg" valign="top" align="left"><input
																type="text" name="payscale" id="payscale"
																class="txt_medium" maxlength="15" required /> <span
																class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Default
																Increment</td>

															<td class="cell_bg" valign="top" align="left"><input
																type="text" id="defaultincrement"
																name="defaultincrement" class="txt_medium"
																maxlength="15" required /> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Min
																Amount</td>

															<td class="cell_bg" valign="top" align="left"><input
																type="text" id="minamt" name="minamt" class="txt_medium"
																maxlength="15" required /> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Max
																Amount</td>

															<td class="cell_bg" valign="top" align="left"><input
																type="text" id="maxamt" name="maxamt" class="txt_medium"
																maxlength="15" required /> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>
													</c:if>

													<!-- ----------------------------------------In case of Edit---------------------------------------------------------- -->

													<c:if test="${payscaledetail != null}">
														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Pay
																Category</td>
															<td class="cell_bg" valign="top" align="left"><select
																id="sysPaycategoryid" name="sysPaycategoryid"
																class="cmb_medium" onchange="getDependantCombo();">
																	<option value="-1">Select PayCategory</option>
																	<c:forEach var="d" items="${paycategorylist}">
																		<option value="${d.sysPaycategoryid}">${d.paycategory}</option>
																	</c:forEach>
															</select> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>



														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Pay
																Scale</td>
															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${payscaledetail}" var="a">
																	<input type="text" name="payscale" id="payscale"
																		value="${a.payscale}" class="txt_medium"
																		maxlength="15" required />
																</c:forEach> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>



														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Default
																Increment</td>

															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${payscaledetail}" var="a">
																	<input type="text" id="defaultincrement"
																		name="defaultincrement" class="txt_medium"
																		value="${a.defaultincrement}" maxlength="15" required />
																</c:forEach> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Min
																Amount</td>

															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${payscaledetail}" var="a">
																	<input type="text" id="minamt" name="minamt"
																		value="${a.minamt}" class="txt_medium" maxlength="15"
																		required />
																</c:forEach> <span class="star">*</span></td>
														</tr>


														<tr>
															<td></td>
														</tr>

														<tr>
															<td class="cell_bg" valign="top">&nbsp;</td>
															<td class="cell_bg" valign="top" align="left">Max
																Amount</td>

															<td class="cell_bg" valign="top" align="left"><c:forEach
																	items="${payscaledetail}" var="a">
																	<input type="text" id="maxamt" name="maxamt"
																		value="${a.maxamt}" class="txt_medium" maxlength="15"
																		required />
																</c:forEach> <span class="star">*</span></td>
														</tr>

														<tr>
															<td></td>
														</tr>
													</c:if>
													<!-- ----------------------------------------------------------------------------- -->

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

			<br>
			<script type="text/javascript" src="resources/js/tablesorter.js"></script>

			<!-- --------------------------------------------------------------------------- -->

			<table width="90%" class="table_bg" cellpadding="3" cellspacing="3"
				border="0" align="center">
				<tr>
					<td>
						<div style="overflow-y: scroll; height: 400px">
							<table width="100%" id="myTable" cellpadding="0" cellspacing="1"
								border="0" class="tablesorter">

								<thead id="h" align="center">
									<tr>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Pay Scale</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Default Increment</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Min Amount</th>
										<th id="t" width="20%"><img alt=""
											src="resources/images/sort.gif">Max Amount</th>

										<th id="t" width="20%">Action</th>
									</tr>
								</thead>

								<tbody id="b" align="center">
									<c:forEach items="${payscalelist}" var="list">
										<tr>
											<td>${list.payscale}</td>
											<td>${list.defaultincrement}</td>
											<td>${list.minamt}</td>
											<td>${list.maxamt}</td>
											<td><a
												href="/UPJN/populatePayScale?ppPayscalemasterid=<c:out value="${list.ppPayscalemasterid}"/>">
													<u>Edit</u>
											</a> || <a
												href="/UPJN/deletePayScale?ppPayscalemasterid=<c:out value="${list.ppPayscalemasterid}"/>&sysPaycategoryid=<c:out value="${list.sysPaycategoryid}"/>"
												onclick="javascript:return confirm('Are you sure you want to delete ?');">
													<u>Delete</u>
											</a></td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
			</table>

			<!-- ---------------------------------------------------------------------------- -->

			</form>
		</div>
	</div>

</body>
</html>