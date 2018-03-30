package Main_Ingridients;

import Abstrac_Prop.Objectiv;

/**
 * Class describing Sugar
 * @author GudveN
 *
 */
public class Tea extends Objectiv
{
	/**
	 * Property - variety of tea
	 */
	private static String variety="";
	/**
	 * Default Constructor
	 */
	public Tea(){}
	/**
	 * Function return variety of tea {@link Tea#variety}
	 * @return variety of tea
	 */
	public static String getVariety() 
	{
		return variety;
	}
	/**
	 * The function initializes the variety of tea {@link Tea#variety}
	 * @param variety of tea
	 */
	public static void setVariety(String variety) 
	{
		Tea.variety = variety;
	}
	
}
