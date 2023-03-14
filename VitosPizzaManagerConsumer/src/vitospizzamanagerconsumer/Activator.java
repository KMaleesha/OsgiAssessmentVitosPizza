package vitospizzamanagerconsumer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import addFood.AddFoodService;
import addFood.AddFoodServiceImpl;
import deleteFood.DeleteFoodService;
import deleteFood.DeleteFoodServiceImpl;
import searchFood.SearchFoodService;
import searchFood.SearchFoodServiceImpl;
import updateFood.UpdateFoodService;
import updateFood.UpdateFoodServiceImpl;
import viewMenu.ViewMenuService;
import viewMenu.ViewMenuServiceImpl;
import vitospizzamanagerconsumer.WelcomeManagerMenu;
import org.osgi.framework.ServiceReference;


public class Activator implements BundleActivator {

	ServiceRegistration viewMenuServiceReference;
	ServiceRegistration searchFoodServiceReference;
	
	
	public void start(BundleContext bundleContext) throws Exception {  //Life cycle method-start
		System.out.println("--------Start Vito's Pizza  Manager Service--------");
		
		ViewMenuService viewMenuService = new ViewMenuServiceImpl();   //Register "ViewMenuService" service
		viewMenuServiceReference = bundleContext.registerService(ViewMenuService.class.getName(),viewMenuService,null);
		SearchFoodService searchFoodService = new SearchFoodServiceImpl();    //Register "SearchFoodService" service
		searchFoodServiceReference = bundleContext.registerService(SearchFoodService.class.getName(),searchFoodService,null);
		WelcomeManagerMenu welcomeCM = new WelcomeManagerMenu();
		welcomeCM.startManager(viewMenuService,searchFoodService);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {   //Life cycle method -stop
		System.out.println("--------Stop Vito's Pizza  Manager Service--------");
		
	}

}
