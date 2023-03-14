package vitospizzaadminconsumer;

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


public class Activator implements BundleActivator {
	
	ServiceRegistration updateFoodServiceReference; 
	ServiceRegistration deleteFoodServiceReference;
	ServiceRegistration viewMenuServiceReference;
	ServiceRegistration addFoodServiceReference;
	ServiceRegistration searchFoodServiceReference;


	public void start(BundleContext bundleContext) throws Exception {//Life cycle method-start
		System.out.println("--------Start Vito's Pizza Admin Service-------- ");
		UpdateFoodService updateFoodService = new UpdateFoodServiceImpl(); //Register "UpdateFoodService" service
		updateFoodServiceReference = bundleContext.registerService(UpdateFoodService.class.getName(),updateFoodService,null);
		
		AddFoodService addFoodService = new AddFoodServiceImpl();//Register "AddFoodService" service
		addFoodServiceReference = bundleContext.registerService(AddFoodService.class.getName(),addFoodService,null);
		
		ViewMenuService viewMenuService = new ViewMenuServiceImpl();//Register "ViewMenuService" service
		viewMenuServiceReference = bundleContext.registerService(ViewMenuService.class.getName(),viewMenuService,null);
		
		DeleteFoodService deleteFoodService = new DeleteFoodServiceImpl();//Register "DeleteFoodService" service
		deleteFoodServiceReference = bundleContext.registerService(DeleteFoodService.class.getName(),deleteFoodService,null);
		
		SearchFoodService searchFoodService = new SearchFoodServiceImpl();//Register "SearchFoodService" service
		searchFoodServiceReference = bundleContext.registerService(SearchFoodService.class.getName(),searchFoodService,null);
		
		WelcomeAdminMenu welcomeCM = new WelcomeAdminMenu();//Register "WelcomeAdminMenu" service
		welcomeCM.startManager(updateFoodService,deleteFoodService,viewMenuService,addFoodService, searchFoodService);
	}

	public void stop(BundleContext bundleContext) throws Exception {//Life cycle method -stop
		System.out.println("--------Stop Vito's Pizza Admin Service-------- ");
		updateFoodServiceReference.unregister();
	}

}
