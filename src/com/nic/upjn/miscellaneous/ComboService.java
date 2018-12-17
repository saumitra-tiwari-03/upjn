

/*==========================================================================
 * Description : ComboService class contains the Logic for different -2 Combo . 
 * Date:  
 * Author: RAM PRAKASH PANDEY
 * Review By : 
 * Review Date:  
 *==========================================================================
 */
package com.nic.upjn.miscellaneous;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import com.nic.upjn.spring.Service.EmployeeAppointmentService;
import com.nic.upjn.spring.Service.PostingStatusService;
import com.nic.upjn.spring.Service.ServiceStatusService;
import com.nic.upjn.spring.entity.MasEmploymenttype;
import com.nic.upjn.spring.entity.MasOfficelevel;
import com.nic.upjn.spring.entity.PpDesignationmaster;
import com.nic.upjn.spring.entity.RmOffice;
import com.nic.upjn.spring.entity.SysSubservicephasemaster;
import com.nic.upjn.spring.entity.ViewPpGetemployeesubtype;
@SuppressWarnings({"unchecked", "unused"})
public class ComboService {

	EmployeeAppointmentService employeeAppointmentService;
	String subPhasename;
	
/** Populate the dropDown of subPhasename **/  
	
	public HashMap<Integer, String> populateCombo(
			EmployeeAppointmentService employeeAppointmentService) {
		this.employeeAppointmentService = employeeAppointmentService;

		HashMap<Integer, String> hmap = new HashMap<Integer, String>();

		try {

			String json = null;

			List<SysSubservicephasemaster> list = (List<SysSubservicephasemaster>) employeeAppointmentService
					.getList("Appointment",
							"SysSubservicephasemaster.findByServicephasename");

			for (SysSubservicephasemaster sysSubservicephasemaster : list) {
				subPhasename = sysSubservicephasemaster.getSubphasename();
				hmap.put(
						Integer.parseInt(sysSubservicephasemaster
								.getSysSubservicephasemasterid() + ""),
						sysSubservicephasemaster.getSubphasename());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return hmap;

	}
	/** Populate the dropDown of MasEmploymenttype **/
	
	public HashMap<Integer, String> getmasEmploymenttype() {

		HashMap<Integer, String> hmap1 = new HashMap<Integer, String>();
		List<MasEmploymenttype> list1 = (List<MasEmploymenttype>) employeeAppointmentService
				.getList(null, "MasEmploymenttype");
		for (MasEmploymenttype masEmploymenttype : list1) {
			hmap1.put(
					Integer.parseInt(masEmploymenttype.getMasEmploymenttypeid()
							+ ""), masEmploymenttype.getEmploymenttype());

		}
		return hmap1;
	}

    /** Populate the dropDown of designationList **/
    
	public HashMap<Integer, String> pupulatetDesignationCombo(
			String employmenttypeid,
			EmployeeAppointmentService employeeAppointmentService) {

		String json = null;

		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		List<PpDesignationmaster> list1 = (List<PpDesignationmaster>) employeeAppointmentService
				.getList(Integer.parseInt(employmenttypeid),
						"PpDesignationmaster.findByemployementtype");
		for (PpDesignationmaster pp_DESIGNATIONMASTER : list1) {
			hmap2.put(
					Integer.parseInt(pp_DESIGNATIONMASTER
							.getPpDesignationmasterid() + ""),
					pp_DESIGNATIONMASTER.getDesignation());

		}
		return hmap2;
	}

    /** Populate the dropDown of designationList **/
	public HashMap<Integer, String> getDesignationcombocategoryList(
			String designationid,
			EmployeeAppointmentService employeeAppointmentService) {

		String json = null;

		HashMap<Integer, String> hmap2 = new HashMap<Integer, String>();

		List<ViewPpGetemployeesubtype> list2 = (List<ViewPpGetemployeesubtype>) employeeAppointmentService
				.getList(designationid,
						"ViewPpGetemployeesubtype.findByPpDesignationmasterid");
		for (ViewPpGetemployeesubtype viewPpGetemployeesubtype : list2) {
			hmap2.put(
					Integer.parseInt(viewPpGetemployeesubtype
							.getMasEmploymentsubtypeid() + ""),
					viewPpGetemployeesubtype.getEmploymentsubtype());

		}

		return hmap2;

	}
    /** Populate the dropDown of officeLevel **/
	public HashMap<Integer, String> officeAndDistrict(
			EmployeeAppointmentService employeeAppointmentService) {

		this.employeeAppointmentService = employeeAppointmentService;

		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		List<MasOfficelevel> list = (List<MasOfficelevel>) employeeAppointmentService
				.getList(null, "MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			hm1.put(masOfficelevel.getMasOfficelevelid(),
					masOfficelevel.getOfficelevel());

		}

		return hm1;
	}
    /** Populate the dropDown of officeLevel **/
	public HashMap<Integer, String> officeAndDistrict(
			ServiceStatusService serviceStatusService) {


		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		List<MasOfficelevel> list = (List<MasOfficelevel>) serviceStatusService
				.getList(null, "MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			hm1.put(masOfficelevel.getMasOfficelevelid(),
					masOfficelevel.getOfficelevel());

		}

		return hm1;
	}

    /** Populate the dropDown of officeList when the service class is ServiceStatusService**/
	public HashMap<String, String> office(int[] where_condtion,
			ServiceStatusService serviceStatusService) {

		HashMap<String, String> hmap = new HashMap<String, String>();

		List<RmOffice> list1 = (List<RmOffice>) serviceStatusService
				.getOfficeCombo(where_condtion, "RmOffice.findByOfficename");

		for (RmOffice rmOffice : list1) {
			hmap.put(rmOffice.getRmOfficeid() + "", rmOffice.getOfficename());

		}

		return hmap;

	}
    /** Populate the dropDown of officeList when the service class is EmployeeAppointmentService **/
	public HashMap<String, String> office(int[] where_condtion,
			EmployeeAppointmentService employeeAppointmentService) {

		HashMap<String, String> hmap = new HashMap<String, String>();

		List<RmOffice> list1 = (List<RmOffice>) employeeAppointmentService
				.getOfficeCombo(where_condtion, "RmOffice.findByOfficename");

		for (RmOffice rmOffice : list1) {
			hmap.put(rmOffice.getRmOfficeid() + "", rmOffice.getOfficename());

		}

		return hmap;

	}

    /** Populate the dropDown of officeList when the service class is EmployeeAppointmentService **/
	public HashMap<Integer, String> officeAndDistrict(
			PostingStatusService postingStatusService) {

		HashMap<Integer, String> hm1 = new HashMap<Integer, String>();
		List<MasOfficelevel> list = (List<MasOfficelevel>) postingStatusService
				.getList(null, "MasOfficelevel.findAll");

		for (MasOfficelevel masOfficelevel : list) {
			hm1.put(masOfficelevel.getMasOfficelevelid(),
					masOfficelevel.getOfficelevel());
		}

		return hm1;
	}

   /** Populate the dropDown of officeList when the service class is PostingStatusService **/
   public HashMap<String, String> office(int[] where_condtion,
			PostingStatusService postingStatusService) {

		HashMap<String, String> hmap = new HashMap<String, String>();

		List<RmOffice> list1 = (List<RmOffice>) postingStatusService
				.getOfficeCombo(where_condtion, "RmOffice.findByOfficename");

		for (RmOffice rmOffice : list1) {
			hmap.put(rmOffice.getRmOfficeid() + "", rmOffice.getOfficename());

		}

		return hmap;

	}

   public Date getFormatedDate(String currentDate)
   {
	   Date date = null;
   	try
   	 { 
   		  
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");	  
        date = df.parse(currentDate);
   		
   		
   	  } catch (Exception ex) 
   	  {
   	        System.out.println("Parse Exception");
   	  }
		return date;
   }
   
   
   public static  ComboService getInstance()
   {
	return new ComboService();
	   
   }

   
   /*public Date getDate(String currentDate)
   {
	   Date date = null;
   	try
   	 { 
   		  
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");	  
        date = df.format(currentDate);
   		
   		
   	  } catch (Exception ex) 
   	  {
   	        System.out.println("Parse Exception");
   	  }
		return date;
   }*/
   
}
