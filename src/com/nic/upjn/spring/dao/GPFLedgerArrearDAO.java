package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.GPFLedgerEntity;
import com.nic.upjn.spring.entity.GPFOpeningBalanceEntity;
import com.nic.upjn.spring.entity.GPFWithdrawalEntity;
import com.nic.upjn.spring.entity.GpfArrearEntity;

public interface GPFLedgerArrearDAO {

	List getList(String condition, String namedQuery);

	List getgpfvalue(String pp_EmployeemasterID, String startYear, String endYear);

	List getarrearamount(String pp_EmployeemasterID, String month, String year);

	List getwithdrawals(String pp_EmployeemasterID, String month, String year);

	List getinterestrate(String month, String year);

	List getadvrec(String pp_EmployeemasterID, String month, String year);

	List gettempwithdrawal(String pp_EmployeemasterID, String month, String year);

	int insertintoGPFledger(GPFLedgerEntity gpfLedgerEntity);

	List getgpfledgerreport(String ppemployeemasterid, String startyear, String endyear);

	List getemployeedetails(String employeecode);

	List getopeningbalance(String ppemployeemasterid, String year);

	int insertopeningbalance(GPFOpeningBalanceEntity entity);

	int insertArrear(GpfArrearEntity entity);

	int insertwithdrawal(GPFWithdrawalEntity entity);

	int updatearrearingpfledger(long pP_EMPLOYEEMASTERID, long month, long year, long arrearamount);

	int updatewithdrawalingpfledger(long pp_EMPLOYEEMASTERID, long month, long year, long amount);


}
