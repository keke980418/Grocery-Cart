//Ke Zhang; 500832394

import java.util.Comparator;

/**
  *This class FoodTypeCarbsComparator implement Comparator of FoodType,
  *it sorts the Carbohydrate of the FoodType item from large to small (descending).
  */
public class FoodTypeCarbsComparator implements Comparator<FoodType>
{
	/** 
	  * compareTo() method that compares two FoodType items with their Carbohydrate,
	  * sort it from large to small (descending).
	  * @return -1 if this Carbohydrate is larger than the other Carbohydrate, 
      *        	1 if this Carbohydrate is smaller than the other Carbohydrate, and
	  *    		0 if this Carbohydrate is same as the other Carbohydrate.
	  */
	public int compare(FoodType a, FoodType b)
	{
		if (a.getCarbs() > b.getCarbs()) 
			return -1;
		if (a.getCarbs() < b.getCarbs()) 
			return 1;
			return 0;
	}
}
