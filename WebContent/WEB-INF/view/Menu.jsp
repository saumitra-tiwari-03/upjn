<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>U.P JAL NIGAM</title>
<link href="resources/css/upjn.css" rel="stylesheet" type="text/css">

<SCRIPT language=JavaScript src="resources/js/tree.js"></SCRIPT>

<SCRIPT language=JavaScript 
src="resources/js/tree_tpl.js"></SCRIPT>

<%=session.getAttribute("abc")%>
</head>

</html>

<!-- Old Menu -->

<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/dtree.css" rel="stylesheet" />
<script src="resources/js/jquery-2.1.1.min.js"></script>
<script src="resources/js/dtree.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        $(".dTree").dTree();
    });  
    
    
    
</script>
<title>U.P JAL NIGAM</title>
</head>
<body>
	<div class="dTree">
		<ul>
			<ul>
				<li><a href="#">Home</a></li>

			</ul>
			<li><a href="#">Personnel</a>
				<ul>
					<li><a href="#">H.O.Activities</a>
						<ul>
							<li><a href="#">Appointment</a>
								<ul>
									<li><a href="/UPJN/getcombolist">New</a></li>
									<li><a href="/UPJN/getEmployeeList">Edit</a></li>
								</ul></li>
							<li><a href="#">Posting</a>
								<ul>
									<li><a href="/UPJN/getPostingList">New</a></li>
									<li><a href="/UPJN/getPostingListForEdit">Edit</a></li>
								</ul></li>
							<li><a href="/UPJN/EmployeeJoining">Employee Joining</a></li>
						</ul></li>

					<li><a href="#">Employee Status</a>
						<ul>
							<li><a href="/UPJN/searchEmployee">Search</a></li>
							<li><a href="/UPJN/serviceBookEmployeeSearch">Service
									Book</a></li>
						</ul></li></li>
			<li><a href="#">Posting Status</a>
				<ul>
					<li><a href="/UPJN/transferEmployee">Transfer</a></li>
					<li><a href="/UPJN/relievefortransfer">Relieve Employee</a></li>
					<li><a href="/UPJN/joinEmployeeList">Join Employee</a></li>
					<li><a href="/UPJN/RelieveEL">EL(Relieve/Joining)</a></li>
				</ul></li>
			<li><a href="#">Service Status</a>
				<ul>
					<li><a href="#">Suspension</a>
						<ul>
							<li><a href="/UPJN/suspensionDetails">Suspension</a></li>
							<li><a href="/UPJN/reinstateSuspentionEmpList">Re-Instate
									Suspension</a></li>
						</ul></li>
					<li><a href="#">Termination</a>
						<ul>
							<li><a href="/UPJN/employeeTerminationDetails">Termination</a></li>
							<li><a href="/UPJN/reinstateEmployeeTerminationDetails">Re-Instate
									Termination</a></li>
						</ul></li>

					<li><a href="#">Deputation</a>
						<ul>
							<li><a href="/UPJN/relievefordeputation">Relieve for
									Deputation</a></li>
							<li><a href="/UPJN/resumeAfterDeuptation">Resume After
									Deputation</a></li>
						</ul></li>

					<li><a href="/UPJN/relieveFromService">Relieve from
							Service</a></li>
				</ul></li>
			<li><a href="#">Reports</a>
				<ul>
					<li><a href="/UPJN/OfficewiseEmpRepForm">Office Wise
							Employee List</a></li>
					<li><a href="/UPJN/EmpSupAnuRepForm">Employee to be Super
							Annuated</a></li>
					<li><a href="/UPJN/EmpDepRepForm">Employee on Deputation</a></li>
					<li><a href="/UPJN/RetEmpRepForm">Retired Employees List</a></li>
				</ul></li>
		</ul>
		<li><a href="#">Delete Employee</a></li>
		<li><a href="/UPJN//DAForm.do">DA MASTER</a></li>
		<li><a href="#">Role Management</a>
			<ul>
				<li><a href="/UPJN/officeMaster">Office Master</a></li>
				<li><a href="/UPJN/assignOfficeAdmin">Assign Office
						Admin(SU)</a></li>
				<li><a href="/UPJN/defineRoleInfo">Define Role(OA)</a></li>
				<li><a href="/UPJN/CreateUser">Create User(OA)</a></li>
				<li><a href="/UPJN/ModifyUserRoles">Modify User Roles(OA)</a></li>
				<li><a href="/UPJN/changepassword">Change Password</a></li>
				<li><a href="/UPJN/OfficeBankAccountbegin">Open Office Bank
						Account</a></li>
			</ul></li>
		<li><a href="#">Pension</a>
			<ul>
				<li><a href="#">Entry of Existing Pensioner</a></li>
				<li><a href="#">New Pension Application Form</a></li>
				<li><a href="#">New Family Pension Application Form</a></li>
				<li><a href="#">Revise Part-V(To Finalize Pension)</a></li>
				<li><a href="#">Update Pension Detail(Office Level)</a></li>
				<li><a href="#">Life Certificate and Payment Info</a></li>
				<li><a href="#">Process Pension</a></li>
				<li><a href="#">Lock/Delete Pension Bills</a></li>
				<li><a href="#">Monthly Pension Report</a></li>
				<li><a href="#">Pension Bill Advice</a></li>
				<li><a href="#">Commutation Calculator</a></li>
				<li><a href="#">ViewPension Status</a></li>
				<li><a href="#">HO Activity</a>
					<ul>
						<li><a href="#">Update Pension Detail</a></li>
						<li><a href="#">Sanction Pension</a></li>
					</ul></li>
			</ul></li>
		<li><a href="#">Pay Roll</a>
			<ul>
				<li><a href="#">PayRoll Information</a>
					<ul>
						<li><a href="/UPJN/sectionMaster">Open Office Sections</a></li>
						<li><a href="/UPJN/assignSectionandRegister">Assign
								Section & Register</a></li>
						<li><a href="/UPJN/selectRegister">Pay Bill Preparation</a></li>
						<li><a href="/UPJN/searchEmployeePayroll">Search Employee</a>
						</li>
						<li><a href="/UPJN/deletePayBill">Delete Pay Bill</a></li>
						<li><a href="#">Reports</a>
							<ul>
								<li><a href="/UPJN/PaySlipRepForm">Pay Slip Report</a></li>
								<li><a href="/UPJN/OfficeSummaryRepForm">OfficeSummaryReport</a></li>
								<li><a href="#">Partly Paid/Unpaid Employee Report</a></li>
								<li><a href="/UPJN//BillAdvice.do">Bill Advice Report</a></li>
								<li><a href="/UPJN/DeductionLoanSchedule.do">Deduction/Loan
										Schedules</a></li>
								<li><a href="/UPJN/MonthlyPayReport">Monthly Pay Report</a></li>
								<li><a href="/UPJN/MonthlyCheckListForm">Monthly
										Checklist</a></li>
								<li><a href="/UPJN/YearlyPayReportForm">Yearly Pay
										Report</a></li>
								<li><a href="/UPJN/LoanAlertReportForm">Loan Alert
										Report</a></li>
								<li><a href="/UPJN/MonPaySumRepForm">Monthly Pay
										Summary</a></li>
							</ul></li>
						<li><a href="#">Issue LPC</a></li>
						<li><a href="/UPJN/lockPayBill">Lock Pay Bill</a></li>
					</ul></li>
			</ul></li>
		<li><a href="#">Pension Registration</a>
			<ul>
				<li><a href="pensionEmployeeVerification">Employee Verification</a></li>
				<li><a href="#">Edit Employee Registration</a></li>
				<li><a href="#">Document Verification</a></li>
			</ul></li>
		<li><a href="#">PLAN & PROGRESS</a>
			<ul>
				<li><a href="#">Monthly Progress</a>
					<ul>
						<li><a href="#">Financial</a>
							<ul>
								<li><a href="#">Entry Form</a></li>
								<li><a href="#">Finance Report</a></li>
								<li><a href="#">Edit Entry Form</a></li>
								<li><a href="#">Lock Monthly FPR</a></li>
								<li><a href="#">Unlock Monthly FPR</a></li>
							</ul></li>
					</ul></li>
			</ul></li>
		<li><a href="#">Master</a>
			<ul>
				<li><a href="/UPJN/ManageDistrict.do">District Master</a></li>

				<li><a href="#">Pay Allowance Master</a></li>
				<li><a href="#">Personnel and Payroll Masters</a>
					<ul>
						<li><a href="/UPJN/designation.do">Designation Master</a></li>
						<li><a href="/UPJN/QualificationTrainingMaster">Qualification
								Training Master</a></li>
						<li><a href="/UPJN/HeadQuarterMaster">Head Quarter Master</a></li>
						<li><a href="/UPJN/PayScaleMaster">Pay Scale Master</a></li>
						<li>
							<!-- <a href="/UPJN/DeductionMaster"> --> <a href="#">Deduction
								Master</a>
						</li>
						<li><a href="/UPJN/LoanMaster.do">Loan Master</a></li>
						<li><a href="#">Allowance Head Master</a></li>
					</ul></li>
				<li><a href="#">Manage Bank Master</a></li>
			</ul></li>
		<li><a href="#">View Log Files</a></li>

		<li><a href="#">GPF</a>
			<ul>
				<li><a href="/UPJN/gpfledgerform">GPF LEDGER - OPENING
						BALANCE</a></li>
				<li><a href="/UPJN/gpfledgerarrearform">GPF LEDGER - ARREAR
						ENTRY</a></li>
				<li><a href="/UPJN/gpfwithdrawalbegin">GPF LEDGER - WITHDRAWAL ENTRY
						</a></li>
				<li><a href="/UPJN/gpfledgerReportbegin">GPF LEDGER REPORT</a></li>
			</ul></li>
			
			<li><a href="#">DA Arrear</a>
			<ul>
				<li><a href="/UPJN/DAArrearEmployeeWiseForm"> Employee Wise 
						</a></li>
						<li><a href="/UPJN/DAArrearRegisterWiseForm">Register Wise 
						</a></li>
			</ul></li>

		</ul>

	</div>
</body>
</html> --%>