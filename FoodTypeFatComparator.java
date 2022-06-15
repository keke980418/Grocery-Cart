//Ke Zhang; 500832394

import java.util.Comparator;

/**
*This class FoodTypeCarbsComparator implement Comparator of FoodType,
*it sorts the Carbohydrate of the FoodType item from large to small (descending).
*/
public class FoodTypeFatComparator implements Comparator<FoodType>
{
	/** 
	  * compareTo() method that compares two FoodType items with their Fat,
	  * sort it from large to small (descending).
	  * @return -1 if this Fat is larger than the other Fat, 
    *        	1 if this Fat is smaller than the other Fat, and
	  *    		0 if this Fat is same as the other Fat.
	  */
	public int compare(FoodType a, FoodType b)
	{
		if (a.getFat() > b.getFat()) 
			return -1;
		if (a.getFat() < b.getFat()) 
			return 1;
			return 0;
	}
}
