
	function dateformat() {
		var x = document.getElementById("hmap").value;
		$("#hmap").value(x);
		alert(x);
	}

	function onlynumbers() {
		var x = document.getElementById("employeecode").value;
		if (isNaN(x)) {
			alert("Alphabets and Special characters are not allowed");
			return false;
		}
	}

	function onlycharacters() {
		var w = document.getElementById("firstname").value;
		var x = document.getElementById("middlename").value;
		var y = document.getElementById("lastname").value;
		var z = document.getElementById("fathername").value;

		if (!isNaN(w) || !isNaN(x) || !isNaN(y) || !isNaN(z)) {
			alert("Names cannot be a Numeric value");
			return false;
		}
	}

 function validate_edit_details(){

		var w = document.getElementById("currentdate").value;
		var x = document.getElementById("dateofbirth").value;
		var y = document.getElementById("appointmentfiledate").value;		
		var z = document.getElementById("datejoining").value;
		var a = document.getElementById("effectivedatjoin").value;
		var msg = new String();

		var retVal = compareDates_in(x, w);
		if ((retVal == 1) || (retVal == 2)) { // 'Date of Birth' > 'Current Date'
			msg = "Date of Birth should be less than current date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(y, w);

		if ((retVal == 1)) { // If 'Appointment Date' > 'Current Date'	
			msg = "Appointment Letter Date should be less than or equal to Current Date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(z, w);

		if ((retVal == 1)) { // If 'Joining Date' > 'Current Date'	
			msg = "Joining date should be less than or equal to Current Date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(a, w);

		if ((retVal == 1)) { // If 'Effective Date' > 'Current Date'	
			msg = "Effective Date of Appointment should be less than current date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(x, y);

		if ((retVal == 1)) { // If 'Appointment Date' > 'Date Of Birth'	
			msg = "'Effective Date of Appointment' should be less than 'Date of Birth'";
			alert(msg);
			return false;
		}

		var mode = document.getElementById("hmap").value;
		
		if (mode == -1) {
			alert("Please select Mode of Appointment");
			return false;
		}
		
		var e_type = document.getElementById("hmap1").value;
		
		if (e_type == -1) {
			alert("Please select Employment Type");
			return false;
		}
		
		var designation = document.getElementById("designation").value;

		if (designation == "") {
			alert("Please select Mode of Appointment and Employment type again...!!");
			return false;
		}
	 }

 function validate_details(){

		var w = document.getElementById("currentdate").value;
		var x = document.getElementById("dateofbirth").value;
		var y = document.getElementById("appointmentfiledate").value;		
		var z = document.getElementById("datejoining").value;
		var a = document.getElementById("effectivedatjoin").value;
		var msg = new String();

		var retVal = compareDates_in(x, w);
		if ((retVal == 1) || (retVal == 2)) { // 'Date of Birth' > 'Current Date'
			msg = "Date of Birth should be less than current date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(y, w);

		if ((retVal == 1)) { // If 'Appointment Date' > 'Current Date'	
			msg = "Appointment Letter Date should be less than or equal to Current Date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(z, w);

		if ((retVal == 1)) { // If 'Joining Date' > 'Current Date'	
			msg = "Joining date should be less than or equal to Current Date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(a, w);

		if ((retVal == 1)) { // If 'Effective Date' > 'Current Date'	
			msg = "Effective Date of Appointment should be less than current date";
			alert(msg);
			return false;
		}

		retVal = compareDates_in(x, y);

		if ((retVal == 1)) { // If 'Appointment Date' > 'Date Of Birth'	
			msg = "'Effective Date of Appointment' should be less than 'Date of Birth'";
			alert(msg);
			return false;
		}

		var mode = document.getElementById("new_modeofapp").value;
		
		if (mode == -1) {
			alert("Please select Mode of Appointment");
			return false;
		}
		
		var e_type = document.getElementById("emp_type").value;
		
		if (e_type == -1) {
			alert("Please select Employment Type");
			return false;
		}
		
		var designation = document.getElementById("designation").value;

		if (designation == -1) {
			alert("Please select Designation");
			return false;
		}
		
	 }
