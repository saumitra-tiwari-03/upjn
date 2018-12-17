function getDesignationCombo(){
				
				document.forms[0].method.value="getDesignationCombo";
				document.forms[0].submit();
			}

			function getEmploymentSubTypeCombo(){
		
				document.forms[0].method.value="getEmploymentSubTypeCombo";
				document.forms[0].submit();			
			}

			function manageSubTypeCombo(){

				var selItemIndex=document.forms[0].mas_EmploymentTypeID.value;
				var employmentType = document.forms[0].mas_EmploymentTypeID.options[selItemIndex].innerHTML;

				if (employmentType == "Regular") {
				
					document.forms[0].mas_EmploymentSubTypeID.disabled=true;

				} else {

					document.forms[0].mas_EmploymentSubTypeID.disabled=false;				
				}

			}

			function validateForm(){
				
				var msg = new String();
				// check for required Validations through struts validator
				var isValid=validateNewAppointmentActionForm(document.forms[0]);
				
				
				// Coding For Date Comparisons
				if (isValid) {

					var dob= document.forms[0].dateOfBirth.value;
					var fromDate = document.forms[0].appointmentFileDate.value;
					var toDate = document.forms[0].dateJoining.value;
				
					// Comapre 'Date Of Birth' & 'Appointment Date'
					var retVal=compareDates_in(dob, fromDate);

					if ((retVal == 1) || (retVal == 2)) { // If 'Appointment Date' > 'Date Of Birth'
					
						msg=msg+"'Date of Appointment' should be after 'Date of Birth'"+"\n";
						isValid = false;
					} 

					// Compare 'Appointment Date' & 'Joining Date'
					//retVal=compareDates_in(fromDate, toDate);
					
					//if (retVal == 1) { // If 'Appointment Date' > 'Joining Date'
					
					//	msg=msg+"'Date of Joining' should be on or after 'Date of Appointment'"+"\n";
					//	isValid = false;
					//}
						
				}
				
				if (!(isValid)) {
					
					if (!(msg == "")) {	

						alert (msg);
					}
					return false;
				}

			}