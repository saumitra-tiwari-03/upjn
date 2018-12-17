package com.nic.upjn.spring.Service;

import java.util.List;

import com.nic.upjn.spring.dto.PayScaleMasterDTO;
import com.nic.upjn.spring.entity.PpPayscalemaster;

@SuppressWarnings("rawtypes")
public interface PayScaleMasterService {

	List paycategorylist(String value, String namedQuery);

	boolean checkExistanceOfPayScale(String payscale);

	boolean AddPayScale(PpPayscalemaster ppPayscalemaster);

	List<PpPayscalemaster> getPayScaleList(short sysPaycategoryid);

	boolean EditPayScale(PpPayscalemaster ppPayscalemaster);

	boolean deletePayScale(String ppPayscalemasterid);




		
}
