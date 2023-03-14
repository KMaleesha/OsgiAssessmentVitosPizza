package datastore; 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.DeliveryGuy;
import model.Food;
import model.Orders;

public class Datastore {
	public static List<Food> foodList = new ArrayList<Food>();//food details saving array list
	public static List<Orders> deliveryOrderList = new ArrayList<Orders>();//delivery order details saving array list
	public static List<DeliveryGuy> deliveryguy = new ArrayList<DeliveryGuy>();//delivery guy details saving array list
}
