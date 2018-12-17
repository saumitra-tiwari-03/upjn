package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.FwaBankaccount;

public interface OfficeBankAccountDAO {

	List retrieveBankAccountList(Integer rmOfficeid);

	boolean saveaccountinfo(FwaBankaccount fwabankaccount);

	List populateofficeaccount(String wherecondition, String namedQuery);

	int editaccountinfo(FwaBankaccount fwabankaccount);

	boolean deleteaccountinfo(String id);

}
