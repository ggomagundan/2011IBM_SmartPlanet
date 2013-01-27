package com.ibm.pumpsoftejb;
import javax.ejb.Local;

@Local
public interface LoginBeanLocal {

	int login(String id, String password);

	int insertUser(String id, String nickname, String passwd);

	String get(String id, String nickname, String passwd);

	int updateUserPoint(int point, String id);

	int updateUserGrade(int grade, String id);

	int getPoint(String id);

}
