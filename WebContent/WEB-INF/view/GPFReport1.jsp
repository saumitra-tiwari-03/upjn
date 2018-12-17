<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GPFReport</title>

<script src="<c:url value="/resources/js/upjn.js" />"></script>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function printpage() {
		//Get the print button and put it into a variable
		var printButton = document.getElementById("printpagebutton");
		//Set the print button visibility to 'hidden' 
		printButton.style.visibility = 'hidden';
		//Print the page content
		window.print()
		//Set the print button to 'visible' again 
		//[Delete this line if you want it to stay hidden after printing]
		printButton.style.visibility = 'visible';
	}
</script>
<script type="text/javascript">
	var debugScript = true;

	function computeTableColumnTotal(tableId, colNumber) {
		// find the table with id attribute tableId
		// return the total of the numerical elements in column colNumber
		// skip the top row (headers) and bottom row (where the total will go)

		var result = 0;

		try {
			var tableElem = document.getElementById(tableId);
			var tableBody = document.getElementById("tbodydata");
			var i;

			//   alert("start");
			/* var howManyRows = tableBody.rows.length; */
			var howManyRows = document.getElementById("gpftable").rows.length;

			//    alert(howManyRows);

			for (i = 4; i < (howManyRows - 2); i++) // skip top 3 and last row (hence i=1, and howManyRows-1)
			{
				var thisTrElem = tableBody.rows[i];
				var thisTdElem = thisTrElem.cells[colNumber];
				var thisTextNode = thisTdElem.childNodes.item(0);
				if (debugScript) {
					//       window.alert("text is " + thisTextNode.data);
				} // end if

				// try to convert text to numeric
				var thisNumber = parseFloat(thisTextNode.data);
				// if you didn't get back the value NaN (i.e. not a number), add into result
				if (!isNaN(thisNumber))
					result += thisNumber;
			} // end for
			//  alert(result);
		} // end try
		catch (ex) {
			window.alert("Exception in function computeTableColumnTotal()\n"
					+ ex);
			result = 0;
		} finally {
			return result;
		}

	}

	function finishTable() {
		if (debugScript)
		//	window.alert("Beginning of function finishTable");

		var tableElemName = "gpftable";

	//	window.alert(tableElemName);

		var totalsalary = computeTableColumnTotal("gpftable", 2);
//		window.alert(totalsalary);

		var totalarrear = computeTableColumnTotal("gpftable", 3);
	//	window.alert(totalarrear);

		var totalrecamount = computeTableColumnTotal("gpftable", 5);
	//	window.alert(totalrecamount);

		var totaldeposit = computeTableColumnTotal("gpftable", 6);
	//	window.alert(totaldeposit);

		var totaltempwdl = computeTableColumnTotal("gpftable", 7);
	//	window.alert(totaltempwdl);

		var totalfinalwdl = computeTableColumnTotal("gpftable", 8);
	//	window.alert(totalfinalwdl);

		var totalbalance = computeTableColumnTotal("gpftable", 9);
	//	window.alert(totalbalance);

		var totalintamount = computeTableColumnTotal("gpftable", 11);
	//	window.alert(totalintamount);

		var openingbalance = document.getElementById("openingbalance").value;
	//	window.alert(openingbalance);

		var closingbalance1 = (totalbalance + totalintamount);
	//	window.alert(closingbalance1);

		var closingbalance = (openingbalance * 1) + closingbalance1;
	//	window.alert(closingbalance);

		try {
			var totalSalaryElem = document.getElementById("totalsalary");
			totalSalaryElem.innerHTML = totalsalary;

			var totalarrearElem = window.document.getElementById("totalarrear");
			totalarrearElem.innerHTML = totalarrear;

			var totalrecamountElem = window.document
					.getElementById("totalrecamount");
			totalrecamountElem.innerHTML = totalrecamount;

			var totaldepositElem = document.getElementById("totaldeposit");
			totaldepositElem.innerHTML = totaldeposit;

			var totaltempwdlElem = window.document
					.getElementById("totaltempwdl");
			totaltempwdlElem.innerHTML = totaltempwdl;

			var totalfinalwdlElem = window.document
					.getElementById("totalfinalwdl");
			totalfinalwdlElem.innerHTML = totalfinalwdl;

			var totalbalanceElem = document.getElementById("totalbalance");
			totalbalanceElem.innerHTML = totalbalance;

			var totalintamountElem = window.document
					.getElementById("totalintamount");
			totalintamountElem.innerHTML = totalintamount;

			var closingbalanceElem = window.document
					.getElementById("closingbalance");
			closingbalanceElem.innerHTML = closingbalance;

			//window.alert("Inside Try");

		} catch (ex) {
			window.alert("Exception in function finishTable()\n" + ex);
		}

		return;
	}
</script>
<body onload="finishTable();">
	<table border="0" align="center" width="100%">
		<tr>
			<td width="100px" class="table_head"><img
				src="resources/images/up-jal-nigam-logo.jpg"
				style="height: 80px; width: 80px"></td>

			<td align="left" valign="top" class="table_head">STATEMENT OF
				GPF ACCOUNT <br>
				<table style="margin-top: 10px;" width="100%" border="0">


					<c:forEach items="${employeedata}" var="a">
						<tr>
							<td>Emp Code</td>
							<td>${ecode}</td>
							<td>GPF A/C No.</td>
							<td>${a.GPFACNO}</td>
							<td align="right">All figures in Rs.</td>

						</tr>
						<tr>
							<td>Name</td>
							<td>${a.EMPLOYEENAME}</td>
							<td>Designation</td>
							<td>${a.DESIGNATION}</td>
							<td>${a.OFFICENAME}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>



		<tr>
			<td colspan="2">
				<table border="0" width="100%"
					style="border-bottom: 1px solid black; border-top: 1px solid black;"
					id="gpftable">
					<tbody id="tbodydata">
						<tr>
							<th colspan="2" style="border-bottom: 1px solid black;">&nbsp;</th>
							<th colspan="2" style="border-bottom: 1px solid black;"
								align="center">Subscription From</th>
							<th colspan="2" style="border-bottom: 1px solid black;"
								align="center">Advance Recovery</th>
							<th rowspan="2" style="border-bottom: 1px solid black;"
								align="center">Total Deposit</th>
							<th colspan="2" align="center"
								style="border-bottom: 1px solid black;">Withdrawal</th>
							<th rowspan="2" style="border-bottom: 1px solid black;"
								align="center">Balance</th>
							<th colspan="2" align="center"
								style="border-bottom: 1px solid black;">Interest</th>
						</tr>
						<tr>
							<th style="border-bottom: 1px solid black;" align="center">Month</th>
							<th style="border-bottom: 1px solid black;" align="center">Year</th>
							<th style="border-bottom: 1px solid black;" align="center">Salary</th>
							<th style="border-bottom: 1px solid black;" align="center">Arrear</th>
							<th style="border-bottom: 1px solid black;" align="center">Instl
								No</th>
							<th style="border-bottom: 1px solid black;" align="center">Amount</th>
							<th style="border-bottom: 1px solid black;" align="center">Temp</th>
							<th style="border-bottom: 1px solid black;" align="center">Final</th>
							<th style="border-bottom: 1px solid black;" align="center">Rate</th>
							<th style="border-bottom: 1px solid black;" align="center">Amount</th>
						</tr>
						<tr>
							<th style="border-bottom: 1px solid black;" colspan="2"
								align="center">1</th>
							<th style="border-bottom: 1px solid black;" align="center">2</th>
							<th style="border-bottom: 1px solid black;" align="center">3</th>
							<th style="border-bottom: 1px solid black;" align="center">4</th>
							<th style="border-bottom: 1px solid black;" align="center">5</th>
							<th style="border-bottom: 1px solid black;" align="center">6</th>
							<th style="border-bottom: 1px solid black;" align="center">7</th>
							<th style="border-bottom: 1px solid black;" align="center">8</th>
							<th style="border-bottom: 1px solid black;">&nbsp;</th>
							<th style="border-bottom: 1px solid black;" align="center">9</th>
							<th style="border-bottom: 1px solid black;" align="center">10</th>
						</tr>
						<tr>
							<th style="border-bottom: 1px solid black;" colspan="9"
								align="left">Opening Balance brought forward from last
								Financial Year</th>
							<th colspan="3" style="border-bottom: 1px solid black;"
								align="left">${openingbalance}
								<input type="hidden" id="openingbalance" value="${openingbalance}">
								</th>
						</tr>
						<%
							int i = 1;
						%>
						<c:forEach items="${reportdata}" var="a">

							<c:set
								value="${((a.SALARY+a.ARREAR+a.AMOUNT)-a.FINAL_WITHDRAWAL)}"
								var="balance" />

							<tr>
								<c:set value="${(a.SALARY+a.ARREAR)+a.AMOUNT}"
									var="totaldeposit" />

								<c:set value="${(newbalance+totaldeposit)-a.FINAL_WITHDRAWAL}"
									var="newbalance" />

								<td align="left">${a.MONTHNAME}</td>
								<td align="center">${a.YEAR}</td>
								<td align="center">${a.SALARY}</td>
								<td align="center">${a.ARREAR}</td>
								<td align="center">${a.INSTL_NO}/${a.PA_NOOFINSTALLMENTS}</td>
								<td align="center">${a.AMOUNT}</td>
								<td align="center">${totaldeposit}</td>
								<td align="center">${a.TEMP_WITHDRAWAL}</td>
								<td align="center">${a.FINAL_WITHDRAWAL}</td>
								<%
									if (i == 1) {
								%>
								<td align="right"><c:choose>
										<c:when test="${newbalance == null}">${balance}</c:when>
										<c:otherwise>${newbalance}</c:otherwise>
									</c:choose></td>

								<td align="right">${a.INTEREST_RATE}%</td>
								<td align="right">${(newbalance*a.INTEREST_RATE)/100}</td>
								<%
									} else {
								%>
								<td align="right">${newbalance}</td>
								<td align="right">${a.INTEREST_RATE}%</td>
								<td align="right">${(newbalance*a.INTEREST_RATE)/100}</td>
								<%
									}
								%>
							</tr>
							<%
								i++;
							%>

						</c:forEach>

						<!-- Row for Totaling Values -->

						<tr>
							<td align="center" style="border-top: 1px solid black;"><b>
									TOTAL </b></td>
							<td align="center" style="border-top: 1px solid black;"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totalsalary"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totalarrear"></td>
							<td align="center" style="border-top: 1px solid black;"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totalrecamount"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totaldeposit"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totaltempwdl"></td>
							<td align="center" style="border-top: 1px solid black;"
								id="totalfinalwdl"></td>
							<td align="right" style="border-top: 1px solid black;"
								id="totalbalance"></td>
							<td align="right" style="border-top: 1px solid black;" id=""></td>
							<td align="right" style="border-top: 1px solid black;"
								id="totalintamount"></td>
						</tr>

						<tr>
							<td align="right" colspan="4"
								style="border-top: 1px solid black;"><b>CLOSING BALANCE</b></td>
							<td style="border-top: 1px solid black;"></td>
							<td style="border-top: 1px solid black;"></td>
							<td style="border-top: 1px solid black;"></td>
							<td style="border-top: 1px solid black;"></td>
							<td style="border-top: 1px solid black;"></td>
							<td align="right" id="closingbalance"
								style="border-top: 1px solid black; font-weight: bold;"></td>
							<td style="border-top: 1px solid black;"></td>
							<td style="border-top: 1px solid black;"></td>
						</tr>

					</tbody>
				</table>

			</td>
		</tr>
	</table>

	<table border="0" align="center" width="100%">

		<tr>
			<td colspan="2">Signature</td>

		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>

		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>

		</tr>


		<tr>
			<td align="center">Executive Engineer <br>Head Office<br>U
				P Jal Nigam Lucknow
			</td>
			<td align="center">Account Officer (GPF) <br>Head Office<br>U
				P Jal Nigam Lucknow
			</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">Above statement is valid if it bears the
				signature of the competent authority with seal of office.</td>
		</tr>

	</table>

	<!-- <input style="margin-left: 350px;" type="button"
		onclick="window.print();" value="Print"> -->
	<input id="printpagebutton" type="button" value="Print this page"
		onclick="printpage()" />

</body>
</html>