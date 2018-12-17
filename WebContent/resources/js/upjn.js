
$(document).ready(function() {
 
	$('#district').change(function(event) {
		var districtname1 = $("select#district").val();
		var ofid = $("select#hm").val();
		$.get('/UPJN/OfficeSelectionController1', {
			districtname : districtname1,
			ofname : ofid
		}, function(jsonResponse) {
			var select = $('#hmap');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select Office Name]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});
	});
});


$(document).ready(function() {
	 
	$('#placedistrict').change(function(event) {
		var placedistrict = $("select#placedistrict").val();
	
		$.get('/UPJN/PlaceMaster', {
			 districtID : placedistrict
			
		}, function(jsonResponse) {
			var select = $('#placeName');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});
	});
});


$(document).ready(function() {
	 
	$('#hm3').change(function(event) {
		var officeLevelId = $("select#hm3").val();
		
		$.get('/UPJN/ParentofficeListByID', {
			officeLevelId : officeLevelId
			
		}, function(jsonResponse) {
			var select = $('#ParentOfficeId');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});
	});
});


$(document).ready(function() {
	 
	$('#masOfficelevelid').change(function(event) {
		var masOfficelevelid = $("select#masOfficelevelid").val();
		
		$.get('/UPJN/OfficeNameListByID', {
			masOfficelevelid : masOfficelevelid 
			
		}, function(jsonResponse) {
			var select = $('#rmOfficeid');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
			
		});
	});
});



$(document).ready(function() {
	 
	$('#rmOfficeid').change(function(event) {
		var rmOfficeid = $("select#rmOfficeid").val();
		
		$.get('/UPJN/EmployeeNameListByID', {
			rmOfficeid : rmOfficeid
			
		}, function(jsonResponse) {
			var select = $('#EmployeeNameID');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
			
		});
	});
});

/*-------------------*/

$(document).ready(function() {

	$('#catPayListID').change(function(event) {
	        var catPayListID = $("select#catPayListID").val();
	       
	        $.post('/UPJN/populateHRA', {
	        	syspayID : catPayListID
	        }, function(response) {
	         	var HRA=response[0];
	        	var CCA=response[1];
	        	var Payscale=response[2];
	        	
	        	  var select = $('#hraList');
	        select.find('option').remove();
	        $('<option>').val('-1').text('[Select HRA]').appendTo(select);
	          $.each(HRA, function(index, value) {
	          $('<option>').val(index).text(value).appendTo(select);
	          
	      });
	          var select = $('#ccaList');
		        select.find('option').remove();
		        $('<option>').val('-1').text('[Select CCA]').appendTo(select);
		          $.each(CCA, function(index, value) {
		          $('<option>').val(index).text(value).appendTo(select);
		          
		      });
		          var select = $('#sysPayScaleList');
			        select.find('option').remove();
			        $('<option>').val('-1').text('[Select Payscale]').appendTo(select);
			          $.each(Payscale, function(index, value) {
			          $('<option>').val(index).text(value).appendTo(select);
			          
			      });
	          
	        });
	        });
	});

$(document).ready(function() {

	$('#hraList').change(function(event) {
	        var catPayListID = $("select#catPayListID").val(); 
	       
	        $.post('/UPJN/populateCCA', {
	        	syspayID : catPayListID
	        }, function(response) {

	        var select = $('#ccaList');
	        select.find('option').remove();
	        $('<option>').val('-1').text('[Select CCA]').appendTo(select);
	          $.each(response, function(index, value) {
	          $('<option>').val(index).text(value).appendTo(select);
	          
	      });
	          
	        });
	        });
	});



/*-------------------*/


$(document).ready(function() {
	 
	$('#loanname').change(function(event) {
		var loanid = $("select#loanname").val();
		
	
		$.post('/UPJN/getLoanShortName', {
			pp_LoanMasterID : loanid
			
		}, function(jsonResponse) {
			
		 document.getElementById("loanShortName").value=jsonResponse;
		});
	});
});



$(document).ready(function() {
	 
	$('#emp_type').change(function(event) {
		var _mas_EmploymentTypeID = $("select#emp_type").val();
		
		$.post('/UPJN/getMasEmploymentsubtyList', {
			_mas_EmploymentTypeID : _mas_EmploymentTypeID
			
		}, function(jsonResponse) {
			var select = $('#employeementcategory');
			select.find('option').remove();
			$('<option>').val('-1').text('[Select Category]').appendTo(select);
			$.each(jsonResponse, function(index, value) {
				$('<option>').val(index).text(value).appendTo(select);
			});
		});
	});
});



