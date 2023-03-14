package vitospizzadeliveryguyconsumer;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import searchOrders.SearchOrderService;
import searchOrders.SearchOrderSetrviceImpl;

public class Activator implements BundleActivator {
	
	ServiceRegistration searchDeliveryOrderServiceReference;
	
	public void start(BundleContext bundleContext) throws Exception {    //Life cycle method-start
		System.out.println("--------Start Vito's Pizza  Delivery Service-------- ");
		SearchOrderService searchorderservice = new SearchOrderSetrviceImpl();  //Register "SearchOrderService" service
		searchDeliveryOrderServiceReference = bundleContext.registerService(SearchOrderService.class.getName(),searchorderservice,null);
		WelcomeDeliveryGuyMenu welcomeDM = new WelcomeDeliveryGuyMenu();
		welcomeDM.startDeliveryGuy(searchorderservice);
	}

	public void stop(BundleContext bundleContext) throws Exception {      //Life cycle method -stop
		System.out.println(" --------Stop Vito's Pizza  Delivery Service--------");
	}

}
