//Ke Zhang; 500832394

import java.util.ArrayList;

public class NutritionChart 
{
	private static ArrayList<FoodType> types;
	/** 
	 * Class constructor.
	 */
	public NutritionChart()
	{
		//add items into an new ArrayList.
		types = new ArrayList<FoodType> ();  
		types.add(new FoodType("Bananas", 11405, 180, 20, 0, 25));
		types.add(new FoodType("Apple", 11235, 80, 22, 0, 20));
		types.add(new FoodType("Grapes", 12356, 120, 15, 0, 15));
		types.add(new FoodType("Apple", 11235, 80, 22, 0, 20));
		types.add(new FoodType("Beef", 10965, 250, 0, 15, 8));
		types.add(new FoodType("Milk", 10354, 90, 4, 0, 16));
		types.add(new FoodType("Carrots", 10789, 15, 4, 0, 16));
		types.add(new FoodType("Beef", 10965, 250, 0, 15, 8));
		types.add(new FoodType("Pear", 26507, 90, 30, 0, 20 ));
		types.add(new FoodType("Peach", 80738, 64, 40, 0, 30));
		types.add(new FoodType("Ice Cream", 98643, 180, 230, 0, 20));
		types.add(new FoodType("Potato Chips", 64532, 150, 10, 90, 70));
		types.add(new FoodType("Yogurt", 98422, 120, 3, 0, 14));
	}
	/** 
	 * getFoodType() takes in foodCode and to check if it is duplicate,
	 * @return  the item, if it is not duplicated,
	 * 			null, if it is duplicated.
	 */
	public FoodType getFoodType(int foodCode)
	{
		for(int i = 0; i< types.size(); i++)
		{
			if(types.get(i).getFoodCode() == foodCode) 
			{
				return types.get(i);
			}
		}
		return null;
	}
}
