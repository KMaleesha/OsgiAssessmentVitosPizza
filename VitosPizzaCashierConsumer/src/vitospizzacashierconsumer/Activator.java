package vitospizzacashierconsumer;

import searchFood.SearchFoodService;
import searchFood.SearchFoodServiceImpl;
import viewMenu.ViewMenuService;
import viewMenu.ViewMenuServiceImpl;

import java.util.Scanner;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import vitospizzacashierconsumer.WelcomeCashierMenu;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import generateBill.GenerateBillService;
import generateBill.GenerateBillServiceImpl;


public class Activator implements BundleActivator {

		ServiceReference generateBillServiceReference;
		ServiceRegistration viewMenuServiceReference;
		ServiceRegistration searchFoodServiceReference;

 public void start(BundleContext bundleContext) throws Exception {//Life cycle method-start
		System.out.println("--------Start Vito's Pizza Cashier Service-------- ");
		SearchFoodService searchFoodService = new SearchFoodServiceImpl();   //Register "SearchFoodService" service
		searchFoodServiceReference = bundleContext.registerService(SearchFoodService.class.getName(),searchFoodService,null);
		
		GenerateBillService generateBillService = new GenerateBillServiceImpl();   //Register "GenerateBillService" service
		generateBillServiceReference = bundleContext.getServiceReference(GenerateBillServiceImpl.class.getName());
		
		ViewMenuService viewMenuService = new ViewMenuServiceImpl();   //Register "ViewMenuService" service
		viewMenuServiceReference = bundleContext.registerService(ViewMenuService.class.getName(),viewMenuService,null);
		
		WelcomeCashierMenu welcomeCM = new WelcomeCashierMenu();    //Register "WelcomeCashierMenu" service
		welcomeCM.startCashier(generateBillService,searchFoodService,viewMenuService);
}

 public void stop(BundleContext bundleContext) throws Exception {//Life cycle method -stop
			System.out.println("--------Stop Vito's Pizza Cashier Service-------- ");
}

}