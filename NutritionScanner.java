//Ke Zhang; 500832394

import java.util.List;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class NutritionScanner 
{
	private static NutritionChart nutritionChart;
	private static ArrayList<FoodType> items;
	private static List<FoodType> list;
	/** 
	 * Class constructor.
	 */
	public NutritionScanner()
	{
		nutritionChart = new NutritionChart();
		items = new ArrayList<FoodType>();
		list = new ArrayList<FoodType>();
	}
	/** 
	  * clear() method empty the ArrayList.
	  */ 
	public void clear() 
	{
		items.clear();
	}
	//return the List
	public List<FoodType> List()
	{
		list = items;
		return list;
	}
	/**
	 * scanFoodCode() method adds a new food type to the ArrayList if it have not been add before, 
	 * else increment the measure variable.
	 */
	public void scanFoodCode(int foodCode)
	{
		FoodType newFood = nutritionChart.getFoodType(foodCode);
		if(!items.contains(newFood)) 
		{
			items.add(newFood);
		}
		else {
			for(int i=0;i<items.size();i++) 
			{
				if(items.get(i).getFoodCode()==foodCode) 
				{
					items.get(i).Measure();
				}
			}
		}
	}
	/**
	 * display all the text
	 * @param area, nutrition Panel is updated as each time the button in GroceryStoreFrame is clicked.
	 */
	public void displayAll(JTextArea displayArea)
	{
		displayArea.setText(null);
		if(items.size()>0) //if the ArrayList is not empty
		{
			for (int i = 0; i < items.size(); i++)
			{
				displayArea.append(items.get(i).display()+  "\n");
			}
		}
	}
}
