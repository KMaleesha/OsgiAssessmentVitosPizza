package addFood; // Create a new package for add food Service Producer

import datastore.Datastore; //import data from datastore
import model.Food; // import the food model from models package 

public class AddFoodServiceImpl implements AddFoodService { //call the interface class and implement the AddFoodServiceImpl class
	
	@Override
	public void addFood(Food newFood) { //create the addFood method to add a new food to the datastore
		Datastore.foodList.add(newFood); // store the insert data in the datastore
		}

}
