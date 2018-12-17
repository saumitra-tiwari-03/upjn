package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.DAArrearDAO;

@Service("DAArrearService")
public class DAArrearServiceImple implements DAArrearService{

	@Autowired
	DAArrearDAO dao;
	
	@Override
	public List getList(String wherecondition, String namedQuery) {
		
		List list = null;
		
		list = dao.getList(wherecondition,namedQuery);
		
		return list;
	}

	@Override
	public List getDADetails(String startDate, String endDate) {
List list = null;
		
		list = dao.getDADetails(startDate,endDate);
		
		return list;
	}

	@Override
	public List getpayamount(String employeecode, String startYear, String endYear) {

		List list = null;
		list = dao.getpayamount(employeecode,startYear,endYear);	
		return list;
	}

}
