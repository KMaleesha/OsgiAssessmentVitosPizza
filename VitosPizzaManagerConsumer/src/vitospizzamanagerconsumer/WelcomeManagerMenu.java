package vitospizzamanagerconsumer;

import java.util.Scanner;

import addDeliveryGuy.AddDeliveryGuyService;
import searchFood.SearchFoodService;
import checkFoodCodeValidity.CheckFoodCodeValidity;
import checkFoodCodeValidity.CheckFoodCodeValidityImpl;
import viewMenu.ViewMenuService;
import model.DeliveryGuy;
import model.Food;
import datastore.Datastore;

public class WelcomeManagerMenu {
	
	// Welcome menu of Cashier
	private boolean exit = false;
	Scanner scannerobj = new Scanner(System.in);

	//create the method of startCashier || display cashier menu
	public void startManager(ViewMenuService viewMenuService,SearchFoodService searchFoodService) {
		String NavigateToHome = null;
		do { 
			int selection = 6; 
			do {
				System.out.println("-------------------- Welcome to Vito's Pizza ------------ "); //display manager menu
				System.out.println("Choose Service that you need ");
				System.out.println("01. View Food Menu");
				System.out.println("02. Search Food");
				System.out.println("03. Add a Delivery Person");
				System.out.println("04. Exit");
				System.out.println("Choose Option Number");
				selection = Integer.valueOf(scannerobj.nextLine());
				if (selection == 4) {  // Exits from the cashier consumer program
					exit = true;
				}

				if (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
					System.out.println("Please enter a valid selection");
				}
			} while (selection != 1 && selection != 2 && selection != 3 && selection != 4);

			String backToHome = null;
			if (selection == 1) { //if option one true
				do {                                       //view food menu
					viewMenuService.viewMenu();
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = scannerobj.nextLine();
				}
				while (!(backToHome.equals("0")));  // end task when press 0

			}

			else if (selection == 2) { //if option two true 
				do {                                           //search food
					System.out.println("Enter the Name of the Food You Need to Search ");
					String foodName = scannerobj.nextLine();
					int success = searchFoodService.searchFood(foodName);
					if (success == -1)
						System.out.println("Invalid Food Name");

					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = scannerobj.nextLine();
				}
				while (!(backToHome.equals("0")));  // end task when press 0
				
			} else if (selection == 3) { // if option 3 true
				do {                                        //add new delivery person
					System.out.println("Enter name");
					String name = scannerobj.nextLine();
					System.out.println("Enter City");
					String city = scannerobj.nextLine();
					
					// add new record to the datastore
					DeliveryGuy deliveryobj = new DeliveryGuy(name, city, Datastore.deliveryguy.size() + 1 );
					//AddDeliveryGuyService.addFood(foodObj);
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = scannerobj.nextLine();
				
				}
				while (!(backToHome.equals("0")));  // end task when press 0
				
			}else if (selection == 4) { // if option 4  exit
				return;
			}
		} while (!exit); // exit

	}

}
