package generateBill;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

import org.osgi.framework.ServiceReference;

import checkFoodCodeValidity.CheckFoodCodeValidityImpl;
import datastore.Datastore;

import model.Food;
import model.Orders;

public class GenerateBillServiceImpl implements GenerateBillService {
	@SuppressWarnings("static-access")

	
	public void generateBill() {

		String backToHome = null;
		@SuppressWarnings("unused")
		ServiceReference generateBillServiceReference;
			
		// Declare the object and initialize with
        // predefined standard input object
		Scanner input = new Scanner(System.in); 


		System.out.println("---------------------Welcome Cashier --------------------" + "\n"); //print welcome message

		System.out.println("Enter Food id");
		String id = input.nextLine();
		CheckFoodCodeValidityImpl codeValidity = new CheckFoodCodeValidityImpl();
		if (codeValidity.checkFoodCodeValidity(id) == false) {

			System.out.println("Invalid Food Code.Please re-enter a correct code");
			id = input.nextLine();// integer input
			validFoodId(id); // check valid is valid food

		}else {
			validFoodId(id);
			
		}

	}
	public void validFoodId(String id) {
		
				double amount, subtotal, fullcost, cost;
				Scanner input = new Scanner(System.in); // Declare the object and initialize with
		        // predefined standard input object
		
		System.out.println("Enter Food Quantity ");
			
		int qty = input.nextInt();// integer input
		

		for (Food price : Datastore.foodList) {
		if (price.getFood_code().equals(id)) {// get food price from Array list
		amount = qty * price.getFood_price(); // calculate amount 

		System.out.println("Do want extra flavours ? Cheese or Chicken "); 
		 
		 input.nextLine();
		String flavor = input.nextLine();

		if (flavor.equalsIgnoreCase("y") || flavor.equalsIgnoreCase("yes")) {
			double fl =200;
			subtotal = amount + fl; //if want extra flavors calculate price with flavors 

			System.out.println("Do want Delivery ?  ");
			String delivery = input.nextLine();
			
				double dp =100;
			if(delivery.equalsIgnoreCase("y") || delivery.equalsIgnoreCase("yes")) {
				fullcost =	subtotal + dp ;  // when customer want to deliver calculate price with delivery cost
				
				System.out.println("Enter Delivery City ?  ");
				String city = input.nextLine(); // get customer delivery city
				
			 System.out.println("Enter Customer name  ");
				  			String cname = input.nextLine(); // ask customer name 
				
				  			 
			    System.out.println("---------------------Welcome Customer  --------------------" + "\n");
				  
				   
				   System.out.println("  Food Name          		:  "+ price.getFood_name());
				   System.out.println("  Food Customer Name         	:  "+ cname);
				   System.out.println("  Food Price Rs.     		:  "+price.getFood_price() );
				   System.out.println("  Food Quantity      		:   "+qty          );
				   System.out.println("  Extra Flavors Rs.  		:  "+fl          );
				   System.out.println("  Delivery Price Rs.         	:  "+dp          );
				   System.out.println("  Total Price Rs.    		: "+fullcost);
				  
				System.out.println("---------------------Thank You !!!--------------------" + "\n");
				double t = fullcost ;
				
				
				Orders newOrder = new Orders(Datastore.deliveryOrderList.size() + 1, price.getFood_name(), cname, t, city);
				Datastore.deliveryOrderList.add(newOrder); // pass the delivery food details to order array list  
				
				
				
			
		}else if(delivery.equalsIgnoreCase("n") || delivery.equalsIgnoreCase("no")  ) 
			{
			
			
			  System.out.println("---------------------Welcome Customer  --------------------" + "\n");
			  
				   System.out.println("  Food Name          		: "+ price.getFood_name());
				   System.out.println("  Food Quantity      		:  "+qty          );
				   System.out.println("  Food Price Rs.     		: "+price.getFood_price() );	   
				   System.out.println("  Extra Flavors Rs.  		:  "+fl          );
				   System.out.println("  Total Price Rs.    		: "+subtotal);

				  
			System.out.println("---------------------Thank You !!!--------------------" + "\n");
			   
			
		}			

		} else if (flavor.equalsIgnoreCase("n") || flavor.equalsIgnoreCase("no")) {
			System.out.println("Do want Delivery ?  ");
			String delivery = input.nextLine();
					
				double dp =100;
			
			if (delivery.equalsIgnoreCase("y") || delivery.equalsIgnoreCase("yes")) {
				cost = amount + dp;

				System.out.println("Enter Delivery City ?  ");
				String city = input.nextLine();//ask customer's delivery city
				System.out.println("Enter Customer name  "); // ask customer's name 
				String cname = input.nextLine();

				System.out.println("---------------------Welcome Customer  --------------------" + "\n");

				   System.out.println("  Food Name          		:  "+ price.getFood_name());
				   System.out.println("  Food Customer Name         	:  "+ cname);
				   System.out.println("  Food Quantity      		:  "+qty          );
				   System.out.println("  Food Price Rs.     		:  "+price.getFood_price() );	   
				   System.out.println("  Delivery Price Rs.         	:   "+dp          );
				   System.out.println("  Total Price Rs.    		: "+cost);


				System.out.println("---------------------Thank You !!--------------------" + "\n");

				double t = cost ;
				
				Orders newOrder = new Orders(Datastore.deliveryOrderList.size() + 1, price.getFood_name(), cname, t, city);
				Datastore.deliveryOrderList.add(newOrder);// pass the delivery food details to order array list  
																								 

				// check

			} else if (delivery.equalsIgnoreCase("n") || delivery.equalsIgnoreCase("no")) { //if customer dosen't need to extra flavors or delivery  
				System.out.println("Enter Customer name  ");
				String cname = input.nextLine();

				System.out.println("---------------------Welcome Customer  --------------------" + "\n");
				
				   System.out.println("  Food Name          		:  "+ price.getFood_name());
				   System.out.println("  Food Customer Name         	:  "+ cname);
				   System.out.println("  Food Quantity      		:  "+qty          );
				   System.out.println("  Food Price Rs.     		:  "+price.getFood_price() );
				   System.out.println("  Total Price Rs.    		: "+amount);

				System.out.println("---------------------Thank You !!--------------------" + "\n");

			}

		}
//	}else
//	{
//		System.out.println(" invalid id ");
//		while (!(backToHome.equals("0")));
//		
//	}
	 }
  }

	}

	@Override
	public List<Food> displayItems() {
		// TODO Auto-generated method stub
		return null;
	}

}