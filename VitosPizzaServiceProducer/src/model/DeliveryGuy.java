package model;

public class DeliveryGuy {
	private String name, city; //create variable for the deliveryGuy class
	private int Id;
	
	public DeliveryGuy(String name, String city, int Id) { 
		this.setName(name); //set values for the constructor
		this.setCity(city);
		this.setId(Id);
	}

	public String getName() { // create getter methods and setter methods
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

}
