//Ke Zhang; 500832394

import java.util.Comparator;

/**
 *This class FoodTypeSugarComparator implement Comparator of FoodType,
 *it sorts the Sugar of the FoodType item from large to small (descending).
 */
public class FoodTypeSugarComparator implements Comparator<FoodType>
{
	/** 
	  * compareTo() method that compares two FoodType items with their Sugar,
	  * sort it from large to small (descending).
	  * @return -1 if this Sugar is larger than the other Sugar, 
      *        	1 if this Sugar is smaller than the other Sugar, and
	  *    		0 if this Sugar is same as the other Sugar.
	  */
	public int compare(FoodType a, FoodType b)
	{
		if (a.getSugar() > b.getSugar()) 
			return -1;
		if (a.getSugar() < b.getSugar()) 
			return 1;
			return 0;
	}
}

