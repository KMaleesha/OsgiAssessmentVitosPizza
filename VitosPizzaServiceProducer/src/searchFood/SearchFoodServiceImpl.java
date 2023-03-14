package searchFood;

import java.util.Iterator; //import java util package

import datastore.Datastore;//import datastore 
import model.Food; //import food model

public class SearchFoodServiceImpl implements SearchFoodService{ 
	
	@Override
	public int searchFood(String foodName) {
		Iterator<Food> iterator = Datastore.foodList.iterator(); //get data from datastore 
	    while (iterator.hasNext()) { //iterate while loop
	        Food food = iterator.next();
	        if (food.getFood_name().equalsIgnoreCase(foodName)) { //check the equality with input food name with the food name in the datastore 
	        
	        	System.out.println("Food Code:"+"\t" +"Food Name:"+"\t" + "Food Price:"+"\t");
	        	System.out.println(food.getFood_code()+"\t         "+food.getFood_name()+"\t         "+food.getFood_price()+"\t"+"\n");//get the data and print the data
	        	return 1;
	        }
		}
		return -1;//exit from the while loop
	}

}
