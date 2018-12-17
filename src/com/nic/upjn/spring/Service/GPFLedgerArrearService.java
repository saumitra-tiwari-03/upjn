package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.GPFLedgerArrearDTO;
import com.nic.upjn.spring.entity.AdvRecDetailsEntity;
import com.nic.upjn.spring.entity.GPFLedgerEntity;
import com.nic.upjn.spring.entity.GPFWithdrawalEntity;
import com.nic.upjn.spring.entity.GpfArrearEntity;

public interface GPFLedgerArrearService {

	List<?> getList(String condition, String namedQuery);

	int AddOpeningBalance(GPFLedgerArrearDTO dto);

	List getgpfvalue(String pp_EmployeemasterID, String startyear, String endyear);

	List getarrearamount(String pp_EmployeemasterID, String month, String year);

	List getwithdrawals(String pp_EmployeemasterID, String month, String year);

	List getinterestrate(String arrearmonth, String arrearyear);

	List getadvrec(String pp_EmployeemasterID, String arrearmonth, String arrearyear);

	List gettempwithdrawal(String pp_EmployeemasterID, String arrearmonth, String arrearyear);

	int insertintoGPFledger(GPFLedgerEntity gpfLedgerEntity);

	List getgpfledgerreport(String ppemployeemasterid, String startYear, String endYear);

	List getemployeedetails(String employeecode);

	List getopeningbalance(String ppemployeemasterid, String year);

	int insertopeningbalance(GPFLedgerArrearDTO dto, String gpfacno,String ppemployeemasterid);

	int insertArrear(GpfArrearEntity entity);

	int insertwithdrawal(GPFWithdrawalEntity entity);

	int updatearrearingpfledger(long pP_EMPLOYEEMASTERID, long month, long year, long arrearamount);

	int updatewithdrawalingpfledger(long pp_EMPLOYEEMASTERID, long month, long year, long amount);

	

}
