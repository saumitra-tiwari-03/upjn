package com.nic.upjn.spring.Service;

import java.util.List;

public interface DAArrearService {

	List getList(String wherecondition, String namedQuery);

	List getDADetails(String startDate, String endDate);

	List getpayamount(String employeecode, String startYear, String endYear);

}
