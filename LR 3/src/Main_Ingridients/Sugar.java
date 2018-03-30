package Main_Ingridients;

import javax.swing.JOptionPane;

import Abstrac_Prop.Objectiv;

/**
 * Class describing Sugar
 * @author GudveN
 *
 */
public class Sugar extends Objectiv
{	
	/**
	 * Amount of sugar
	 */
	private static int number_sugar=0;
	/**
	 * Default constructor
	 */
	public Sugar(){}
	/**
	 * Function return amount of sugar {@link Sugar#number_sugar}
	 * @return
	 */
	public static int getNumber_sugar() 
	{
		return number_sugar;
	}
	/**
	 * The function initializes the number of sugar {@link Sugar#number_sugar}
	 * @param number_sugar
	 */
	public static void setNumber_sugar(int number_sugar) 
	{
		Sugar.number_sugar = number_sugar;
	}
}
