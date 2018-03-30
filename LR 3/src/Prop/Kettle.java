package Prop;

import Abstrac_Prop.Abstract_Objectiv;
import Abstrac_Prop.Objectiv;
import Prop.Cup;

/**
 * Class describing the Kettle
 */
public class Kettle extends Abstract_Objectiv
{
	/**
	 * Volume of the Kettle
	 */
	private static double volume_kettle=0;
	/**
	 * Temperature of the water
	 */
	private static double temperature=0;
	/**
	 * Default constructor
	 */
	public Kettle()
	{
		
	}
	/**
	 * The function of filling the kettle
	 * @param t_Water - Temperature of the water
	 * @param temp_cup - object-cup
	 * @see Kettle#fill_water(Cup)
	 */
	public void fill_kettle(int t_Water, Cup temp_cup)
	{
		fill_water(temp_cup);
		temperature_up(t_Water);
		if(getTemperature()==t_Water)
		{
			temp_cup.fill_cup("Вода", getVolume_kettle());
		}
	}
	/**
	 * The function fills a cup
	 * @param temp_cup object-cup
	 * @see Kettle#fill_kettle(int, Cup)
	 */
	void fill_water(Cup temp_cup)
	{
		volume_kettle=300-temp_cup.getCup_volume();
	}
	
	/**
	 * The function of heating water {@link Kettle#temperature}
	 * @param t_Water temeperature of the water
	 */
	void temperature_up(int t_Water)
	{
		SET_T(t_Water);
	}
	
	/**
	 * A function of changing the temperature {@link Kettle#temperature}
	 * @param t_Water temeperature of the water
	 */
	private void SET_T(int t_Water)
	{
		temperature = t_Water;
	}
	
	/**
	 * Function return volume of kettle {@link Kettle#volume_kettle}
	 * @return volume of kettle
	 */
	public static double getVolume_kettle() 
	{
		return volume_kettle;
	}
	/**
	 * The function initializes volume of kettle {@link Kettle#volume_kettle}
	 * @param volume_kettle
	 */
	public static void setVolume_kettle(double volume_kettle) 
	{
		Kettle.volume_kettle = volume_kettle;
	}
	/**
	 * Function return temperature of kettle {@link Kettle#temperature}
	 * @return temperature of kettle
	 */
	public static double getTemperature() 
	{
		return temperature;
	}
	/**
	 * The function initializes the temperature of kettle {@link Kettle#temperature}
	 * @param temperature of kettle
	 */
	public static void setTemperature(double temperature) 
	{
		Kettle.temperature = temperature;
	}
}
