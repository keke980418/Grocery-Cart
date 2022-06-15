//Ke Zhang; 500832394

public class GroceryItem
{
	private String label;
	protected double price;
	private int foodCode;
	/** 
	  * Class constructor.
	  */
	public GroceryItem() 
	{
		label = "";
		price = 0.00;
		foodCode = 0;
	}
	/** 
	  * Class constructor that takes a String, a double and an integer of parameter.
	  */
	public GroceryItem(String label, double price, int foodCode)
	{
		this.label = label;
		this.price = price;
		this.foodCode = foodCode;
	}
	public String getLabel()
	{
		return label;
	}
	public double getPrice()
	{
		return price;
	}
	public int getFoodCode()
	{
		return foodCode;
	}
}
/** 
 * Class Dairy is a sub class of GroceryItem with additional variable volume.
 */
class Dairy extends GroceryItem
{
	private double volume;  
	public Dairy(String label, double price, double volume, int foodCode) 
	{
		super(label, price, foodCode); 	//gets information from super class.
		this.volume = volume;
	}
	//overrides the method getPrice() in super class
	public double getPrice()
	{
		return price * volume;
	}
}
/** 
 * Class Meat is a sub class of GroceryItem with additional variable weight.
 */
class Meat extends GroceryItem
{
	private double weight;	
	public Meat(String label, double price, double weight, int foodCode) 
	{
		super(label, price, foodCode);	//gets information from super class.
		this.weight = weight;
	}
	//overrides the method getPrice() in super class
	public double getPrice()		
	{
		return price * weight;
	}
}
