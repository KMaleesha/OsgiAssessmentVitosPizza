package viewMenu;

import java.util.ArrayList;
import datastore.Datastore;
import model.Food;

public class ViewMenuServiceImpl implements ViewMenuService{ //implement the ViewMenuService interface class 
	public void viewMenu() { // display food code, name , price of all food items.
		System.out.println("--------------------------Vito's Food Menu -----------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t");
		System.out.print("Food Code");
		System.out.print("\t");
		System.out.print("Food Name");
		System.out.print("\t");
		System.out.println("Food Price");
		System.out.println("------------------------------------------------------------------");
		for (Food food : Datastore.foodList) {
			System.out.print("\t");
			System.out.print(food.getFood_code());
			System.out.print("\t\t");
			System.out.print(food.getFood_name());
			System.out.print("\t\t");
			System.out.println(food.getFood_price());
		}
		System.out.println("------------------------------------------------------------------");

	}

	public void viewMenuItem(String food_code) { // display food code, name , price of a given food item.
		System.out.println("--------------------------Vito's Food Menu -----------------------");
		System.out.println("------------------------------------------------------------------");
		System.out.print("\t");
		System.out.print("Food Code");
		System.out.print("\t");
		System.out.print("Food Name");
		System.out.print("\t");
		System.out.println("Food Price");
		System.out.println("------------------------------------------------------------------");
		for (Food food : Datastore.foodList) {
			if(food.getFood_code().equals(food_code)) {
			System.out.print("\t");
			System.out.print(food.getFood_code());
			System.out.print("\t\t");
			System.out.print(food.getFood_name());
			System.out.print("\t\t");
			System.out.println(food.getFood_price());
		}
		
		}
		System.out.println("------------------------------------------------------------------");
	}

}
