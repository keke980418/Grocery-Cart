//Ke Zhang; 500832394

import java.util.ArrayList;
import javax.swing.JTextArea;

public class GroceryCart
{	
	private static ArrayList<GroceryItem> list;
	private int index = 0;
	/** 
	  * Class constructor
	  */
	public GroceryCart()
	{
		list = new ArrayList<GroceryItem>();
	}
	//fills up the cart.
	public void fill()
	{ 
		addItem(new GroceryItem("Bananas", 3.25, 11405));	
		addItem(new GroceryItem("Apple", 2.99, 11235));
		addItem(new GroceryItem("Grapes", 4.72, 12356));
		addItem(new GroceryItem("Apple", 2.99, 11235));
		addItem(new Meat("Steak", 11.99, 2, 10965));
		addItem(new Dairy("Milk", 5.98, 1, 10354));
		addItem(new GroceryItem("Carrots", 3.99, 10789));
		addItem(new Meat("Roast Beef", 13.99, 4, 10965));
		addItem(new GroceryItem("Pear", 3.49, 26507));
		addItem(new GroceryItem("Peach", 3.69, 80738));
		addItem(new GroceryItem("Ice Cream", 6.99, 98643));
		addItem(new GroceryItem("Potato Chips", 2.99, 64532));
		addItem(new Dairy("Yogurt", 3.95, 2.0, 98422));
	}
	public int listSize()
	{
		return list.size();
	}
	//adds item in ArrayList.
	public void addItem(GroceryItem item)
	{
		list.add(item);
	}
	//remove the top item from the ArrayList.
	public GroceryItem removeTopItem ()
	{
		GroceryItem topItem = list.get(index);
		list.remove(index);
		return topItem;
	}
	/**
	 * display the text
	 * @param area, GroceryCart item is updated as each time the button in GroceryStoreFrame is clicked.
	 */
	public void display(JTextArea area)
	{
		area.setText(null);
		for (int i = 0; i < list.size(); i++)
		{
			area.append(list.get(i).getLabel()+"\n");
		}	
	}
	//takes in next grocery item without remove it, and stores in the new list with further access.
	public GroceryItem nextGroceryItem()
	{
		GroceryItem nextItem = list.get(index);
		index++; //increment the index each time, as the button is clicked
//		if(index == list.size())
//		{
//			reset();
//		}
		return nextItem;
	}
	//resets index to zero
//	public void reset()
//	{
//		index = 0;
//	}
}