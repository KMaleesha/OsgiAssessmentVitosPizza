package addDeliveryGuy; // Create a new package for add delivery guy service Producer

import datastore.Datastore; //import data from datastore
import model.DeliveryGuy; // import delivery guy model from model package

public class AddDeliveryGuyImpl implements AddDeliveryGuyService{ //call the interface class and implement the AddDeliveryGuyImpl class

	@Override
	public void addDeliveryGuy(DeliveryGuy newDeliveryGuy) { //create a method to add a delivery guy
		Datastore.deliveryguy.add(newDeliveryGuy);//pass the delivery guy details to array list
	}
	
}
