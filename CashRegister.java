//Ke Zhang; 500832394

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JTextArea;

public class CashRegister
{
	private static ArrayList<GroceryItem> list;
	private static GroceryCart groceryCart = new GroceryCart();
	 /** 
	   * Class constructor
	   */
	public CashRegister()
	{
		list = new ArrayList<GroceryItem>();
	}
	/** 
	  * clear() method empty the ArrayList.
	  */ 
	public void clear() 
	{
		list.clear();
	}
	/**
	 * scanItem() method adds the given grocery item object to the GroceryItem list.
	 */
	public void scanItem()
	{
		GroceryItem item = groceryCart.removeTopItem();
		list.add(item);
	}
	/**
	 * display all the text
	 * @param area, CashRegister Panel is updated as each time the button in GroceryStoreFrame is clicked.
	 */
	public void displayAll(JTextArea area) 
	{
		area.setText(null);
		if(list.size()>0) 
		{
			double total = 0;
			for (int i = 0; i < list.size(); i++)
			{
				area.append(list.get(i).getLabel() + "       " + list.get(i).getPrice() + "\n");
				total = (total + list.get(i).getPrice())*100/100.00;
			}	
			area.append("\n");
			area.append("-------------------" + "\n");
			area.append("Total:      " + total + "\n");   
			area.append("\n");
			Calendar time = Calendar.getInstance();	//gets current time.
			area.append(time.getTime().toString());
		}
	}
}
	
