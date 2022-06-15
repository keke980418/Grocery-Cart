//Ke Zhang; 500832394

public class FoodType implements Comparable<FoodType>
{
	private String label;
	private int foodCode;
	private int measure = 1;
	private int calories;
	private int sugar;
	private int fat;
	private int carbs;
	
	public FoodType() 
	{
		foodCode = 0;
		calories = 0;
		sugar = 0;
		fat = 0;
		carbs = 0;
	}
	 /** 
	   * Class constructor that takes a String and five integer of parameter.
	   */
	public FoodType(String label, int foodCode, int calories, int sugar, int fat, int carbs)
	{
		this.label = label;
		this.foodCode = foodCode;
		this.calories = calories;
		this.sugar = sugar;
		this.fat = fat;
		this.carbs = carbs;
	}
	
	public String getLabel()
	{
		return label;
	}
	public int getFoodCode()
	{
		return foodCode;
	}
	public int getCalories()
	{
		return calories * measure;
	}
	public int getSugar()
	{
		return sugar * measure;
	}
	public int getFat()
	{
		return fat * measure;
	}
	public int getCarbs()
	{
		return carbs * measure;
	}
	public int setMeasure()
	{
		return this.measure;	
	}
	public int Measure()
	{
		return measure++;
	}
	// compare Calories
	public int compareTo(FoodType other)
	{
		if(getCalories() > other.getCalories())
			return -1;
		if(getCalories() < other.getCalories())
			return 1;
			return 0;
	}
	 /** 
	   * display() method that returns a String with the names of the variables and their value*measure.
	   */
	public String display()
	{
		return getLabel().toLowerCase() + ": Cals " + getCalories() + " Sugar " + getSugar() + " Fat " + getFat() + " Carbs " + getCarbs();
	}
	
}
