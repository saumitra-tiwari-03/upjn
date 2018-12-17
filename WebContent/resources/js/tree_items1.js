/* 
	the format of the tree definition file is simple,
		you can find specification in the Tigra Menu documentation at:
	
	
*/
var TREE_ITEMS = 
[
	['Home','null',
		['Personal & Payroll','null',
			['Personal Information','null',
				['H.O. Activities','null',
					['New Appointment','/ManageAppointment.do?method=begin'],
					['Manage Appointment','/ManageAppointment.do?method=getAppointmentList'],
					['Posting','/EmployeePosting.do?method=getEmployeeList'],
					['Edit Posting','/EmployeePosting.do?method=getEmployeeListForEdit'],
					['Resume After Deputation','/ResumeAfterDeputation.do?method=getEmployeeList'],
					['Re-instate (Suspension)','/ReinstateSuspension.do?method=getEmployeeList'],
					['Re-instate (Termination)','/ReinstateTermination.do?method=getEmployeeList'],
				],
			],
		],
		['Role Management','null',
			['Office Master','/ManageOffice.do?method=officeList'],
			['Assign Office Admin (SU)','/AssignOfficeAdmin.do?method=begin'],
			['Define Role (OA)','/DefineRole.do?method=begin'],
			['Create User (OA)','/CreateUser.do?method=begin'],
		],
	]
];
