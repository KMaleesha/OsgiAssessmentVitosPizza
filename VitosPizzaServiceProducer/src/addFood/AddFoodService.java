package addFood; // Create a new package for add food Service Producer

import model.Food; // import the food model from models package 

public interface AddFoodService { // create the interface class for AddFoodService
	public  void  addFood(Food newFood); // create the addFood method to add a new food
}
