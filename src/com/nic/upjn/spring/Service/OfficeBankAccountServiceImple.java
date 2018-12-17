package com.nic.upjn.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.upjn.spring.dao.OfficeBankAccountDAO;
import com.nic.upjn.spring.entity.FwaBankaccount;

@Service("OfficeBankAccountService")
public class OfficeBankAccountServiceImple implements OfficeBankAccountService {

	@Autowired
	OfficeBankAccountDAO dao;

	@Override
	public List retrieveBankAccountList(Integer rmOfficeid) {
		List list = null;

		list = dao.retrieveBankAccountList(rmOfficeid);

		return list;
	}

	@Override
	public boolean saveaccountinfo(FwaBankaccount fwabankaccount) {

		boolean result = dao.saveaccountinfo(fwabankaccount);

		return result;
	}



	@Override
	public List populateofficeaccount(String wherecondition, String namedQuery) {
		List list = null;

		list = dao.populateofficeaccount(wherecondition,namedQuery);

		return list;
	}

	@Override
	public int editaccountinfo(FwaBankaccount fwabankaccount) {
		int a = 0;
		
		a = dao.editaccountinfo(fwabankaccount);
		
		return a;
	}

	@Override
	public boolean deleteaccountinfo(String id) {
		boolean result = dao.deleteaccountinfo(id);

		return result;
	}

}
