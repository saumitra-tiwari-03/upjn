package com.nic.upjn.spring.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.DeductionMasterDAO;

@Service("DeductionMasterService")
public class DeductionMasterServiceImple implements DeductionMasterService{

	@Autowired
	 DeductionMasterDAO dao;
		
	@Override
	public List getList(String condition, String namedQuery) {
          List list = null;	
		list = dao.getList(condition,namedQuery);	
		return list;
	}

}
