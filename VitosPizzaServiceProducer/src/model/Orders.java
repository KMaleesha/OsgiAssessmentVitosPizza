package model; // create the model package

public class Orders { //create the Order class

	private String fname; // create variable for the Orders class
	private int orderId;
	private String cname;
	private double total;
	private String city;

	public Orders(int orderId, String fname, String cname, double total, String city) { //constructor
		super();
		this.orderId = orderId;
		this.cname = cname;
		this.total = total;
		this.city = city;
	}

	public String getFname() { // generate getters and setters
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}