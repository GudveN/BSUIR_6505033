package Main_Ingridients;

import Abstrac_Prop.Objectiv;

/**
 * Class describing coffee
 * @author GudveN
 *
 */
public class Coffee extends Objectiv
{
	/**
	 * Property - taste of the coffee
	 */
	private static String taste="";	
	/**
	 * Default Constructor
	 */
	public Coffee()
	{
	}

	/**
	 * Function return String - taste of the coffee {@link Coffee#taste}
	 * @return taste of the coffee
	 */
	public static String getTaste() 
	{
		return taste;
	}
	/**
	 * The function initializes the taste of coffee {@link Coffee#taste}
	 * @param taste of the coffee
	 */
	public static void setTaste(String taste) 
	{
		Coffee.taste = taste;
	}
}
