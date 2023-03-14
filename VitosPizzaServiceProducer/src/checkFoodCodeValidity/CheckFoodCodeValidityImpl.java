package checkFoodCodeValidity; // Create a new package for check food code validate Producer

import datastore.Datastore; //import data from datastore

import model.Food; // import the food model from models package 

public class CheckFoodCodeValidityImpl { //create the CheckFoodCodeValdityImpl class

	public Boolean checkFoodCodeValidity(String food_code) { // Create a boolean method CheckFoodCodeValidity and call the food_code variable
		boolean validity=false;
	//	boolean validity = Datastore.foodList.contains(food_code);
		
		for (Food food : Datastore.foodList) {
			if (food.getFood_code().equals(food_code)) { //check validity of the food code with the food code of datastore 
				validity=true;
			}
		}
		return validity; //return the validity value

	}

}
