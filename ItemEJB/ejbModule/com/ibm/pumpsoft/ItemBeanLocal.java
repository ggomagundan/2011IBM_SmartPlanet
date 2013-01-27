package com.ibm.pumpsoft;
import java.util.ArrayList;
import javax.ejb.Local;

@Local
public interface ItemBeanLocal {

	String getLatelyItem();

	int countItem();

	ArrayList<String> getItemList(int start, int end);

	int countUserItem(String id);

	ArrayList<String> getUserInventory(String id, int start, int end);

	int insertItem(String name, String description, int price, String url,
			int count);

	int insertItemUser(String id, int plant_id);

	int buyItem(int count, int item_id, String user_id);

	int useItem(int count, String user_id, int item_id, int point,
			int user_plant_id);

}
