package com.nic.upjn.spring.dao;

import java.util.List;

public interface DAArrearDAO {

	List getList(String wherecondition, String namedQuery);

	List getDADetails(String startDate, String endDate);

	List getpayamount(String employeecode, String startYear, String endYear);

}
