package generateBill;

import java.util.List;

import org.osgi.framework.BundleContext;

import model.Food;

public interface GenerateBillService {

	public List<Food> displayItems();//return the item list with item details

	public void generateBill();//generate bill method 
	

	

}
