package vitospizzaadminconsumer; 

import java.util.Scanner;

import addFood.AddFoodService;
import checkFoodCodeValidity.CheckFoodCodeValidityImpl;
import datastore.Datastore;
import deleteFood.DeleteFoodService;
import model.DeliveryGuy;
import model.Food;
import searchFood.SearchFoodService;
import updateFood.UpdateFoodService;
import viewMenu.ViewMenuService;

public class WelcomeAdminMenu {
	
		private boolean exit = false; 
		Scanner scannerobj = new Scanner(System.in);

		public void startManager(UpdateFoodService updateFoodService, DeleteFoodService deleteFoodService,         //create the method of StartManager || display manager menu
				ViewMenuService viewMenuService, AddFoodService addFoodService, SearchFoodService searchFoodService) { 
			String NavigateToHome = null; 
			do {
				int selection = 6;
				do {
					System.out.println("-------------------- Welcome to Vito's Pizza ------------ "); // print the menu screen
					System.out.println("Choose Service that you need ");
					System.out.println("01. Add Food Items");
					System.out.println("02. Update Food Items");
					System.out.println("03. Delete Food Items");
					System.out.println("04. View Food Menu");
					System.out.println("05. Search Food");
					System.out.println("06. Exit");
					System.out.println("Choose Option Number");
					selection = Integer.valueOf(scannerobj.nextLine());
					if (selection == 6) {                // Exits from the Admin consumer program
						exit = true;
					}

					if (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6) { //if not 1,2,3,4,5,6 
						System.out.println("Please enter a valid selection"); 
					}
				} while (selection != 1 && selection != 2 && selection != 3 && selection != 4 && selection != 5 && selection != 6);

				String backToHome = null;
				if (selection == 1) { // if condition 01
					do {                                        //add new food 
						System.out.println("Enter food code");
						String food_code = scannerobj.nextLine();
						System.out.println("Enter name");
						String name = scannerobj.nextLine();
						System.out.println("Enter price");
						double price = Double.valueOf(scannerobj.nextDouble());
						Food foodObj = new Food(food_code, name, price);
						addFoodService.addFood(foodObj);
						System.out.println("Successfully added Food ");
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						scannerobj.nextLine();
						backToHome = scannerobj.nextLine();
					}
					while (!(backToHome.equals("0"))); // end task when press 0

				}

				else if (selection == 2) { // if condition 2
					do {                                                      // update food details
						WelcomeAdminMenu managerMenu = new WelcomeAdminMenu();
						System.out.println("*** Update food details ***");
						System.out.println("");
						viewMenuService.viewMenu();
						System.out.println("");
						System.out.println("Enter Code of food that you need to update");
						String food_code = scannerobj.nextLine();
						CheckFoodCodeValidityImpl codeValidity = new CheckFoodCodeValidityImpl();
						if (codeValidity.checkFoodCodeValidity(food_code) == false) {  //food code not equal for the food code in the datastore

							System.out.println("Invalid Food Code.Please re-enter a correct code");
							food_code = scannerobj.nextLine();
							managerMenu.updateFoodView(viewMenuService, updateFoodService, food_code); // re-enter the food code 
 
						} else { // if condition true
							managerMenu.updateFoodView(viewMenuService, updateFoodService, food_code);
						}
						System.out.println("Successfully updated Food "); // success message
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome = scannerobj.nextLine(); //redirect to home menu
					}
					while (!(backToHome.equals("0"))); //end task when press 0
					
				} else if (selection == 3) { //  if condition 3
					do {                                          //Delete food from datastore
						viewMenuService.viewMenu();   
						System.out.println("Enter the Code of the Food You Need to Remove ");
						String foodCode = scannerobj.nextLine();
						int success = deleteFoodService.deleteFood(foodCode); 
						if (success == 1) {
							System.out.println("Food Successfully Removed");
						} else {
							System.out.println("Invalid Food Code");
						}
						
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome = scannerobj.nextLine();
					}

					while (!(backToHome.equals("0")));//end task when press 0
					
				} else if (selection == 4) { //  if condition 4
					do {
						viewMenuService.viewMenu(); //view food menu
						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome = scannerobj.nextLine();
					}

					while (!(backToHome.equals("0"))); //end task when press 0
					
				} else if (selection == 5) { //  if condition 4
					do {
						System.out.println("Enter the Name of the Food You Need to Search ");
						String foodName = scannerobj.nextLine(); 
						int success = searchFoodService.searchFood(foodName); //Search Food
						if (success == -1)
							System.out.println("Invalid Food Name");

						System.out.println("Press 0 to navigate back to home or press any other key to continue....");
						backToHome = scannerobj.nextLine();
					}
					while (!(backToHome.equals("0"))); //end task when press 0
					
				}else if (selection == 6) {
					return;
				}
			} while (!exit); //exit from Manager 

		}

		public void updateFoodView(ViewMenuService viewMenuService, UpdateFoodService updateFoodService, String food_code) { //update food function

			System.out.println("");                  //print options
			System.out.println("01. Update name");
			System.out.println("02. Update price");
			System.out.println("Enter your option");
			String update_option = scannerobj.nextLine();
			System.out.println("");
			if (update_option.equals("01") || update_option.equals("1")) { //if option 1
				System.out.println("Enter new name");                          //update name
				String food_newName = scannerobj.nextLine();
				System.out.println(updateFoodService.updateFood(food_code, food_newName, "null"));
				System.out.println("");
				viewMenuService.viewMenuItem(food_code);

			} else if (update_option.equals("02") || update_option.equals("2")) { // else option 2
				System.out.println("Enter new price");                             // update price
				String food_newPrice = scannerobj.nextLine();
				System.out.println(updateFoodService.updateFood(food_code, "null", food_newPrice));
				System.out.println("");
				viewMenuService.viewMenuItem(food_code);

			}

		}

}
