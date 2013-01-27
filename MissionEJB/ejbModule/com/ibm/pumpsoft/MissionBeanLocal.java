package com.ibm.pumpsoft;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface MissionBeanLocal {

	int countMission();

	int countMissionType(short type);

	ArrayList<String> getMissionList(short type, int start, int end);

	String getMissionContent(int id);

	int countUserHavingMission(String id);

	ArrayList<String> getUserHavingMission(String id);

	int countUserHadMission(String id);

	ArrayList<String> getUserHadMission(String id, int start, int end);

	int countUserMission(String id);

	ArrayList<String> getUserMission(String id, int start, int end);

	ArrayList<String> getHavingMissionS(String id);

	int insertMission(String name, Short type, int goal, int point, String url,
			String description);

	int insertMissionInstance(String id);

	int insertMissionUser(String id, String instance_id, String article_id);

	int updateMissionAP(int point, int mission_id);

	int updateMissionET(int mission_id);

	String getLatelyMissionInstance();

}
