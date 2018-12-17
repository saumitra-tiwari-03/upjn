/* 
	the format of the tree definition file is simple,
		you can find specification in the Tigra Menu documentation at:
	
	
*/
var TREE_ITEMS = [
	['Home', 'main.htm', 
		['Personal & Payroll', null,
			['Personal Information', null,    //
				['H.O. Activities',null,				 	
					['New Appointment','ManageAppointment.do?method=begin'],
					['Manage Appointment','ManageAppointment.do?method=getAppointmentList'],
					['Posting','EmployeePosting.do?method=getEmployeeList'],
					['Edit Posting','EmployeePosting.do?method=getEmployeeListForEdit'],
					['Resume After Deputation','ResumeAfterDeputation.do?method=getEmployeeList'],
					['Re-instate (Suspension)','ReinstateSuspension.do?method=getEmployeeList'],
					['Re-instate (Termination)','ReinstateTermination.do?method=getEmployeeList'],					
					['Update ACR Status','SearchEmployee.do?method=begin&root=searchEmployeeACR'],

				 ],
				['Service Book',null,
					['Service Book','SearchEmployee.do?method=begin&root=sb'],
					['Credit Leaves','ManageLeaveCredit.do?method=begin'],
					
				],
				['Employee Joining','EmployeeJoining.do?method=getJoiningList'],
				['Transfer',null,
					['Relieve Employee','RelieveForTransfer.do?method=begin'],
					['Join Employee','Tr_Joining.do?method=getJoiningList'],
				],
				['Issue No-Dues','IssueNoDues.do?method=begin'],
				['Leave Sanction','SearchSanctionOrderPage.do'],
				
				['Update Service Status',null,
					['Relieve For Deputation','RelieveForDeputation.do?method=begin'],
					['Suspension','SuspensionDetail.do?method=begin'],
					['Termination','TerminationDetail.do?method=begin'],
					['Relieve From Service','RelieveFromService.do?method=begin'],
				],
			],
			['Payroll Information', null,
				['Add Pay And Allowance Rules','AddPayAllowance.do?method=begin'],
			],
		],
		
		['Role Management', null,
			['Office Master','ManageOffice.do?method=officeList'],
			['Left Frame','LeftFrame.do'],
			['Assign Office Admin (SU)','AssignOfficeAdmin.do?method=begin'],
			['Define Role (OA)','DefineRole.do?method=begin'],
			['Create User (OA)','CreateUser.do?method=begin'],
			['Modify User Roles (OA)','ModifyUserRole.do?method=begin'],
			['Change Password','#'],
		],

		['Master',null,
			['District Master','ManageDistrict.do?method=begin'],
			['Pay Allowances Master','ManagePayAllowances.do?method=begin'],
			['Personnel & Payroll Masters',null,
				['Designation Master','designation.do?method=begin'],
				['Qualification Training Master','trainingQualification.do?method=begin'],
				['Place Master','ManagePlace.do?method=begin'],
					['Pay Scale Master','ManagePayScale.do?method=begin'],
			],

		],
	]
];

