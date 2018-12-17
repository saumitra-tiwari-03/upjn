package com.nic.upjn.spring.Service;

import java.util.List;
import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;

public interface QualificationTrainingMasterService {

	int AddQualification(PpQualificationmaster ppQualificationmaster);

	int AddTraining(PpTrainingtypemaster ppTrainingtypemaster);

    List getList(String condition, String namedQuery);

	int editQualification(PpQualificationmaster ppQualificationmaster);

	int editTraining(PpTrainingtypemaster ppTrainingtypemaster);

	boolean deleteQualification(String ppQualificationmasterid);

	boolean deleteTraining(String ppTrainingtypemasterid);

}
