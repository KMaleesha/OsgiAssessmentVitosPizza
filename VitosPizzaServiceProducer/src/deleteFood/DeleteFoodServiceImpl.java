package deleteFood; 

import model.Food;
import java.util.Iterator;


import datastore.Datastore;

public class DeleteFoodServiceImpl implements DeleteFoodService{ // implement the deleteFoodService interface class

	@Override
	public synchronized int deleteFood(String foodCode) { 

		
		Iterator<Food> iterator = Datastore.foodList.iterator(); // take the data from the datastore for checkouts
	    while (iterator.hasNext()) { // iterate for the next one
	        Food food = iterator.next(); 
	        if (food.getFood_code().equals(foodCode)) { //Get food code from the datastore and check the validity. 
	        	
	        	iterator.remove(); //condition is true: remove the food item from the datastore 
	        	return 1; //iterate to the start of the while loop
	        }
		}
		return -1;//exit from the while loop
	}	

}
