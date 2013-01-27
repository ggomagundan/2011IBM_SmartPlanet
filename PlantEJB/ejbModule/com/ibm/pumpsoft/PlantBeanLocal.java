package com.ibm.pumpsoft;
import java.util.ArrayList;

import javax.ejb.Local;

@Local
public interface PlantBeanLocal {

	int countPlant();

	ArrayList<String> getPlantList(int start, int end);

	int countUsePlant(String id);

	ArrayList<String> getUserPlantList(String id);



	int insertPlants(String name, String description, int price, String url,
			int count,  int max_mature, int step);

	int insertPlantUser(String id, int plant_id, String plant_article);

	int updateUserPlant(String id);

	int PlantUserTree(int id, double long_value, double lat_value,
			String article);

	ArrayList<String> getCurrentPlantList(String id);



}
