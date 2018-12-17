package com.nic.upjn.miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;


/**
 * This class is used to manipulate strings
 */
public final class CalenderUtils
{

	public static ArrayList populateMonth(){
		
		ArrayList monthList= new ArrayList();
		
		String[] monthName={"January","February","March","April","May","June","July","August","September","October","November","December"};

		for (int i=0;i<12;i++ ){
			HashMap month = new HashMap();
			month.put("value",monthName[i]);
			month.put("monthName",(i+1)+"");
			monthList.add(month);
		}

		return monthList;

	}// end method

	public static ArrayList populateYear(){
		
		ArrayList yearList= new ArrayList();

		Calendar calendar = new GregorianCalendar();
		Date dt = new Date();
		calendar.setTime(dt);
		int currYear =calendar.get(Calendar.YEAR);

		System.out.println("Current Year"+currYear);
		for (int i=-6;i<=3;i++ ){
			HashMap year = new HashMap();
			year.put("value",(currYear+i)+"");
			year.put("yearName",(currYear+i)+"");
			yearList.add(year);
		}
		
		
		return yearList;

	}// end method

	/**
	@Description : This method is used to get Month Name corresponding to a given number like 1,2........12.
	@Param		: Month Number As a String
	@Return		: Month Name As a String
	*/
	public static String getMonth(String str1){
		
		String str2=null;
		int temp = Integer.parseInt(str1);
		String[] monthName={"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i=0;i<12;i++){
			if(i==temp-1)
			str2=monthName[i];
		} 
		System.out.println(str2);
		return str2;
	}

	public static int compareTwoDate(String date1, String date2)	{

		GregorianCalendar cal1 = new GregorianCalendar( Integer.parseInt(date1.substring(0,date1.indexOf("/"))), Integer.parseInt(date1.substring(date1.indexOf("/")+1,date1.lastIndexOf("/"))),         Integer.parseInt(date1.substring(date1.lastIndexOf("/")+1)));
		GregorianCalendar cal2 = new GregorianCalendar(Integer.parseInt(date2.substring(0,date2.indexOf("/"))),     Integer.parseInt(date2.substring(date2.indexOf("/")+1,date2.lastIndexOf("/"))),          Integer.parseInt(date2.substring(date2.lastIndexOf("/")+1)));

		System.out.println(cal1+"============="+cal2);

		if(cal1.getTimeInMillis() > cal2.getTimeInMillis() ){
			return 1;
		}else if(cal1.getTimeInMillis() == cal2.getTimeInMillis() ){
			return 0;			
		}else{
			return -1;
		}

	}


	public static boolean isGreaterThanCurrentDate(String date1)	{

		GregorianCalendar cal1 = new GregorianCalendar(Integer.parseInt(date1.substring(date1.lastIndexOf("/")+1)), Integer.parseInt(date1.substring(date1.indexOf("/")+1,date1.lastIndexOf("/")))-1,       Integer.parseInt(date1.substring(0,date1.indexOf("/"))));

		Date d = new Date();

		if(cal1.getTimeInMillis() > d.getTime() ){
			return true;
		}else{
			return false;
		}

	}

	public static int daysInMonth(String month, String year)	{

		GregorianCalendar cal = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month)-1,1);
		int maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		return maxDaysInMonth;
	
	}
// This method r used for 2006-2007 List 
	public static ArrayList populateFromToYear(){
		
		ArrayList yearList= new ArrayList();

		Calendar calendar = new GregorianCalendar();
		Date dt = new Date();
		calendar.setTime(dt);
		int currYear =calendar.get(Calendar.YEAR);

		System.out.println("Current Year"+currYear);
		for (int i=-4;i<=1;i++ ){
			int j=currYear+i;
			HashMap year = new HashMap();
			year.put("value",(j)+"-"+(j+1)+"");
			year.put("yearName",(j)+"-"+(j+1)+"");
			yearList.add(year);
		}
		return yearList;

	}
	/**
	@Description : This method is used to get Difference of two dates in yy mm dd format.
	@inParam     : String(previousDate),String(lastDate)
	@return      : String[3](year at 0,month at 1,and day at 2) 
	*/
	public static String[] differenceInYYMMDD (String previousDate, String lastDate){
		
		System.out.println("previousDate "+previousDate);
		System.out.println("lastDate "+lastDate);

		String returnValue[]=new String[3];
		returnValue[0]="0";
		returnValue[1]="0";
		returnValue[2]="0";

		//Return 0 if invalid dates are passed
		//System.out.println("compareTwoDate("+lastDate+", "+previousDate+") "+compareTwoDate(lastDate, previousDate));
		/*if(compareTwoDate(lastDate, previousDate)==-1){
			return returnValue;
		} */

		if(previousDate==null || previousDate.trim().length()!=10){
			return returnValue;
		}
		if(lastDate==null || lastDate.trim().length()!=10){
			return returnValue;
		}

		// These varibles will used for target day,month and year. 
		int day=0,month=0,year=0;
		// Here we are extracting the day, month and year from the before date.
		int day_DateBefore = Integer.parseInt(previousDate.substring(0,2));
		int month_DateBefore = Integer.parseInt(previousDate.substring(3,5));
		int year_DateBefore = Integer.parseInt(previousDate.substring(6,10));
		// Here we are extracting the day, month and year from the after date.
		int day_DateAfter = Integer.parseInt(lastDate.substring(0,2));
		int month_DateAfter = Integer.parseInt(lastDate.substring(3,5));
		int year_DateAfter = Integer.parseInt(lastDate.substring(6,10));		
		// Here we are subtracting the days.
		if(day_DateAfter<day_DateBefore){
			month_DateAfter-=1;
			day_DateAfter+=30;
			day=day_DateAfter-day_DateBefore;
		}else{
			day=day_DateAfter-day_DateBefore;
		}
		// Here we are subtracting the months.
		if(month_DateAfter<month_DateBefore){
			year_DateAfter-=1;
			month_DateAfter+=12;
			month=month_DateAfter-month_DateBefore;
		}else{
			month=month_DateAfter-month_DateBefore;
		}
		// Here we are subtracting the years.
		year=year_DateAfter-year_DateBefore;
		System.out.println("years = "+year+" months = "+month+" days ="+day);
		returnValue[0]=""+year;
		returnValue[1]=""+month;
		returnValue[2]=""+day;
		return returnValue;
	}// end method

	/**
	@Description : This method is used to get previous month date from the given date.
	@inParam     : String(previousDate)
	@return      : String
	*/
	public static String getPreviousMonthDate(String date){
		int month = Integer.parseInt(date.substring(date.indexOf("/")+1,date.lastIndexOf("/")));
		int year = Integer.parseInt(date.substring(date.lastIndexOf("/")+1));
		if(month == 1){
			month = 12;
			year = year - 1;
		}else{
			month = month - 1;
		}
		return "01"+month+"/"+year;
	} // end method
	// this method is used to getting system date .example ..... 15 March 2007
	public static String getRunDate(){
		String runDate = "";
		String months[]={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		Calendar calendar = Calendar.getInstance();
		runDate = calendar.get(Calendar.DATE)+" "+months[calendar.get(Calendar.MONTH)]+" "+calendar.get(Calendar.YEAR);
		return runDate;
	}//
	public static String getDateInDDMMYYYY(){
		java.util.Date dt = new java.util.Date();
		int currYear  = dt.getYear() + 1900;
		int currMonth = dt.getMonth();
		int currDate  = dt.getDate();
		String currentDate = ((currDate <= 9)?"0" + currDate: "" + currDate) + "/" +((currMonth < 9)? "0" + (currMonth + 1) : "" + (currMonth + 1)) + "/" + currYear;
		System.out.println("date = " + currentDate);
		return currentDate;
	}//
}