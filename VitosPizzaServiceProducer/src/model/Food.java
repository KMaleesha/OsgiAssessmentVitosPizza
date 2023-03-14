package model;	// Create a package for the model

public class Food {  // create  food class

	private String food_code, food_name; //take String variables for the attributes of food class
	private double food_price;			// take double variable		

	public Food(String food_code, String food_name, double food_price) {// constructor
		this.food_code = food_code;
		this.food_name = food_name;
		this.food_price = food_price;
	}

	public String getFood_code() { //generate setters and getters
		return food_code;
	}

	public void setFood_code(String food_code) {
		this.food_code = food_code;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public double getFood_price() {
		return food_price;
	}

	public void setFood_price(double food_price) {
		this.food_price = food_price;
	}

}
