package com.ibm.pumpsoft;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface FriendBeanLocal {

	int getCountFriends(String id);

	ArrayList<String> getFriendsList(String id, int start, int end);

	String getSQL(String id, int start, int end);

	int isFriend(String id, String fid);

	String getUserInfo(String id);

	int insertFriend(String id, String f_id);

}
