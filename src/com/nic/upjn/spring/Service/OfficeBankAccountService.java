package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.entity.FwaBankaccount;

public interface OfficeBankAccountService {

	List retrieveBankAccountList(Integer rmOfficeid);

	boolean saveaccountinfo(FwaBankaccount fwabankaccount);

	List populateofficeaccount(String wherecondition, String namedQuery);

	int editaccountinfo(FwaBankaccount fwabankaccount);

	boolean deleteaccountinfo(String id);

}
