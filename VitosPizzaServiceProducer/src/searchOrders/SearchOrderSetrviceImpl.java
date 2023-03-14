package searchOrders;

import java.util.Iterator;//import java util package

import datastore.Datastore; //import datastore
import model.Orders; //import food model

public class SearchOrderSetrviceImpl  implements SearchOrderService{ // Implement the interface class
	
	public int SearchOrders(String CityName) {
		Iterator<Orders> iterator = Datastore.deliveryOrderList.iterator(); //get data from datastore
	    while (iterator.hasNext()) { //terminate the while loop till condition is true
	    	Orders order = iterator.next();
	        if (order.getCity().equals(CityName)) { //check the data with the stored data
	        
	        	System.out.println("City Name:"+"\t" +"Order ID:"+"\t" + "Customer Name:"+"\t");
	        	System.out.println(order.getCity()+"\t         "+order.getOrderId()+"\t         "+order.getCname()+"\t"+"\n");//if condition true: print the data
	        	return 1;
	        }
		}
		return -1;//exit from the while loop
	}


}
