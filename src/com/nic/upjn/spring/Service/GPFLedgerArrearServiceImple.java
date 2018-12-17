package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.GPFLedgerArrearDAO;
import com.nic.upjn.spring.dto.GPFLedgerArrearDTO;
import com.nic.upjn.spring.entity.AdvRecDetailsEntity;
import com.nic.upjn.spring.entity.GPFLedgerEntity;
import com.nic.upjn.spring.entity.GPFOpeningBalanceEntity;
import com.nic.upjn.spring.entity.GPFWithdrawalEntity;
import com.nic.upjn.spring.entity.GpfArrearEntity;

@Service("GPFLedgerArrearService")
public class GPFLedgerArrearServiceImple implements GPFLedgerArrearService {

	@Autowired
	GPFLedgerArrearDAO dao;

	@SuppressWarnings("rawtypes")
	@Override
	public List<?> getList(String condition, String namedQuery) {

		List list = null;
		list = dao.getList(condition, namedQuery);
		return list;
	}

	@Override
	public int AddOpeningBalance(GPFLedgerArrearDTO dto) {

		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List getgpfvalue(String pp_EmployeemasterID, String startYear, String endYear) {

		List list = null;
		list = dao.getgpfvalue(pp_EmployeemasterID, startYear, endYear);
		return list;
	}

	@Override
	public List getarrearamount(String pp_EmployeemasterID, String month, String year) {

		List list = null;
		list = dao.getarrearamount(pp_EmployeemasterID, month, year);
		return list;
	}

	@Override
	public List getwithdrawals(String pp_EmployeemasterID, String month, String year) {

		List list = null;
		list = dao.getwithdrawals(pp_EmployeemasterID, month, year);
		return list;
	}

	@Override
	public List getinterestrate(String month,String year) {
		List result = null;
		result = dao.getinterestrate(month,year);

		return result;
	}

	@Override
	public List getadvrec(String pp_EmployeemasterID, String month, String year) {
		List list = null;
		list = dao.getadvrec(pp_EmployeemasterID, month, year);
		return list;
	}

	@Override
	public List gettempwithdrawal(String pp_EmployeemasterID, String month, String year) {
		List list = null;
		list = dao.gettempwithdrawal(pp_EmployeemasterID, month, year);
		return list;
	}

	@Override
	public int insertintoGPFledger(GPFLedgerEntity gpfLedgerEntity) {
		
		int result = 0;
		try {
                result = dao.insertintoGPFledger(gpfLedgerEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List getgpfledgerreport(String ppemployeemasterid,String startyear,String endyear) {
		List list = null;
		list = dao.getgpfledgerreport(ppemployeemasterid,startyear,endyear);
		return list;
	}

	@Override
	public List getemployeedetails(String employeecode) {
		List list = null;
		list = dao.getemployeedetails(employeecode);
		return list;
	}

	@Override
	public List getopeningbalance(String ppemployeemasterid, String year) {
		List list = null;
		list = dao.getopeningbalance(ppemployeemasterid,year);
		return list;
	}

	@Override
	public int insertopeningbalance(GPFLedgerArrearDTO dto, String gpfacno, String ppemployeemasterID) {
		int result = 0;
		try{
			GPFOpeningBalanceEntity entity = new GPFOpeningBalanceEntity();
			entity.setGPF_ACCNO(gpfacno);
			entity.setOPENING_BALANCE(Long.parseLong(dto.getOpeningbalance()));
			entity.setPP_EMPLOYEEMASTERID(Long.parseLong(ppemployeemasterID));
			entity.setFINANCIAL_YEAR(dto.getFinanceYear());
			
			
			result = dao.insertopeningbalance(entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertArrear(GpfArrearEntity entity) {
		int result = 0;
		try{
			result = dao.insertArrear(entity);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int insertwithdrawal(GPFWithdrawalEntity entity) {
		int result = 0;
		try {
                result = dao.insertwithdrawal(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public int updatearrearingpfledger(long pP_EMPLOYEEMASTERID, long month, long year, long arrearamount) {
		int result = 0;
		try{
			result = dao.updatearrearingpfledger(pP_EMPLOYEEMASTERID,month,year,arrearamount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updatewithdrawalingpfledger(long pp_EMPLOYEEMASTERID, long month, long year, long amount) {
		int result = 0;
		try{
			result = dao.updatewithdrawalingpfledger(pp_EMPLOYEEMASTERID,month,year,amount);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}
