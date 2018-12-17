package com.nic.upjn.spring.dao;

import java.util.List;

import com.nic.upjn.spring.entity.PpQualificationmaster;
import com.nic.upjn.spring.entity.PpTrainingtypemaster;

public interface QualificationTrainingMasterDAO {

	int AddQualification(PpQualificationmaster ppQualificationmaster);

	int AddTraining(PpTrainingtypemaster ppTrainingtypemaster);

	List getList(String condition, String namedQuery);

	int editQualification(PpQualificationmaster ppQualificationmaster);

	int editTraining(PpTrainingtypemaster ppTrainingtypemaster);

	Boolean deleteQualification(String ppQualificationmasterid);

	Boolean deleteTraining(String ppTrainingtypemasterid);

}
