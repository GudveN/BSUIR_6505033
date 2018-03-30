package Prop;

import Abstrac_Prop.Abstract_Objectiv;

/**
 * Class describing the Kettle
 */
public class Milk extends Abstract_Objectiv
{
	/**
	 * Constant volume of milk
	 */
	private static int milk_volume=50;
	/**
	 * Default constructor
	 */
	public Milk(){}
	/**
	 * Function return volume of milk {@link Milk#milk_volume}
	 * @return volume of milk
	 */
	public static int getMilk_volume()
	{
		return milk_volume;
	}
	/**
	 * The function initializes the volume of milk {@link Milk#milk_volume}
	 * @param milk_volume
	 */
	public static void setMilk_volume(int milk_volume) 
	{
		Milk.milk_volume = milk_volume;
	}
}
