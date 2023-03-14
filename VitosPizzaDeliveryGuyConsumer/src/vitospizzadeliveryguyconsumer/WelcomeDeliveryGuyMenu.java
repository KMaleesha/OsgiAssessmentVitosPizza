package vitospizzadeliveryguyconsumer;

import java.util.Scanner;

import searchOrders.SearchOrderService; 

public class WelcomeDeliveryGuyMenu { //create WelcomeDeliveryGuyMenu class 
	
	// welcome Delivery Person Menu
	
	private boolean exit = false;
	Scanner DeliveryScanner = new Scanner(System.in);
	
	public void startDeliveryGuy(SearchOrderService searchorderservice) {
		String navigateToHome = null;
		do {
			int selection = 3;
			do {
				System.out.println("-------------------- Welcome to Vito's Pizza Delivery ----------------- "); // display Delivery Guy menu Class 
				System.out.println("Choose Service that you need ");
				System.out.println("01. Check Orders");
				System.out.println("02. Exit");
				System.out.println("Choose Option Number");
				selection = Integer.valueOf(DeliveryScanner.nextLine());
				
				if(selection == 2) {  
					exit = true;
				}
				
				if (selection != 1 && selection != 2 ) {
					System.out.println("Please enter a valid selection");
				}
				
			}while(selection != 1 && selection != 2 );
			
			String backToHome = null;
			if(selection == 1){ //navigate to check orders menu

				do {
					System.out.println("Enter City Name :  ");
					String CityName = DeliveryScanner.nextLine();
					int success = searchorderservice.SearchOrders(CityName);
					if (success == -1)
						System.out.println("Invalid City Name");
					
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = DeliveryScanner.nextLine();
					
				}while (!(backToHome.equals("0"))); // end task when press 0
				
			}else if (selection == 2) { // condition 2 navigate to exit 
				return;
			}
			
		}while(!exit); // exit
	}
}
