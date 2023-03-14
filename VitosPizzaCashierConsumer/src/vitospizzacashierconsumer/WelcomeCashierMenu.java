package vitospizzacashierconsumer;

import java.util.Scanner;
import addFood.AddFoodService;
import addFood.AddFoodServiceImpl;
import generateBill.GenerateBillService;
import searchFood.SearchFoodService;
import viewMenu.ViewMenuService;

public class WelcomeCashierMenu {

	private boolean exit = false;
	Scanner scannerobj = new Scanner(System.in);

	//create the method of startCashier || display cashier menu
	public void startCashier( GenerateBillService generateBillService,SearchFoodService searchFoodService ,ViewMenuService viewMenuService) {
		do {
			int selection = 4;  
			do {
				System.out.println("-------------------- Welcome to Vito's Pizza ------------ "); //display cashier menu
				System.out.println("Choose Service that you need ");
				System.out.println("01. Generate Bill");
				System.out.println("02. View List");
				System.out.println("03. Search Food");
				System.out.println("04. Exit");
				System.out.println("Choose Option Number");
				selection = Integer.valueOf(scannerobj.nextLine());
				if (selection == 4) {// Exits from the cashier consumer program
					exit = true;
				}
				if (selection != 1 && selection != 2 && selection != 3 && selection != 4) {
					System.out.println("Please enter a valid selection");
				}
			} while (selection != 1 && selection != 2 && selection != 3 && selection != 4);

			String backToHome = null;
			if (selection == 1) {//navigate to generate bill producer 
				do {
					generateBillService.generateBill(); //generate bill
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					
					
					backToHome = scannerobj.nextLine();
				}

				while (!(backToHome.equals("0"))); // end task when press 0

			}

			else if (selection == 2) { //navigate to view menu service producer 
				do {

					viewMenuService.viewMenu();
					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = scannerobj.nextLine();
				}

				while (!(backToHome.equals("0")));

			} else if (selection == 3) { //navigate to search food service producer
				do {                                                                       // search food items
					System.out.println("Enter the Name of the Food You Need to Search ");
					String foodName = scannerobj.nextLine();
					int success = searchFoodService.searchFood(foodName);
					if (success == -1)                            // if condition true: 
						System.out.println("Invalid Food Name");  // print statement

					System.out.println("Press 0 to navigate back to home or press any other key to continue....");
					backToHome = scannerobj.nextLine();
				}

				while (!(backToHome.equals("0")));  // end task when press 0
			} else if (selection == 4) {  
				return;
			}

		} while (!exit); //exit from Manager 
	}

}
