package updateFood;

import java.util.ArrayList; //import the array list

import datastore.Datastore; //import the datastore
import model.Food; //import food model 

public class UpdateFoodServiceImpl implements UpdateFoodService {
	public String updateFood(String food_code, String newName, String newPrice) {
		String status = null;
		if (newName.equals("null")) {  //if user needs to update price get food code and new price as the input  
			for (Food food : Datastore.foodList) { //iterate through the food list and update price of the food with given food code 
				if (food.getFood_code().equals(food_code)) {
					food.getFood_price();
					food.setFood_price(Double.valueOf(newPrice));
					status = "Price updated successfully";
				}
			}

		} else if (newPrice.equals("null")) { //if user needs to update food name, get food code and new food name as the input
			for (Food food : Datastore.foodList) {  //iterate through the food list and update food  of the food with given food code 
				if (food.getFood_code().equals(food_code)) {
					food.setFood_name(newName);
					status = "Name updated successfully";
				}
			}

		}
		return status;

	}

}
