package Prop;

import javax.swing.JOptionPane;

import Abstrac_Prop.Abstract_Objectiv;
import Abstrac_Prop.Objectiv;

/**
 *Class describing the Cup
 */
public class Cup extends Abstract_Objectiv
{
	/**
	 * Property - volume of the cup
	 */
	private static double cup_volume=0;
	private static String cup_content=new String();	
	public Cup()
	{
		
	}
	/**
	 * The function fills the Cup  {@link Cup#cup_volume}, {@link Cup#cup_content}
	 * @param string - Content 
	 * @param volume - Volume
	 */
	public void fill_cup(String string, double volume)
	{
		cup_volume+=volume;
		cup_content+=string;
		cup_content+=" ";
		mass+=volume*0.998;
	}
	/**
	 * Function return volume of cup {@link Cup#cup_volume}
	 * @return volume of cup
	 */
	public static double getCup_volume() 
	{
		return cup_volume;
	}
	/**
	 * The function initializes the volume of the cup {@link Cup#cup_volume}
	 * @param cup_volume
	 */
	public static void setCup_volume(double cup_volume) 
	{
		Cup.cup_volume = cup_volume;
	}
	/**
	 * Function return content of the cup {@link Cup#cup_content}
	 * @return content of the cup
	 */
	public static String getCup_content() 
	{
		return cup_content;
	}
	/**
	 * The function initializes the content of the cup {@link Cup#cup_content}
	 * @param cup_content
	 */
	public static void setCup_content(String cup_content) 
	{
		Cup.cup_content = cup_content;
	}
}
