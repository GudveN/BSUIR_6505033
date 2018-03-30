package LR;

import LR.Cup;

/**
 * Класс имитирующий чайник
 */
public class Kettle extends Objectiv
{
	/**
	 * Volume_Kettle-объем чайника
	 */
	protected static double volume_kettle=0;
	/**
	 * Temepature-температура чайника
	 */
	protected static double temperature=0;
	Kettle()
	{
		
	}
	/**
	 * Функция для заполнения чайника водой и его нагрев
	 * @param t_Water-температура воды предпочитаемая пользователем
	 */
	void fill_kettle(int t_Water, Cup temp_cup)
	{
		volume_kettle=300-temp_cup.cup_volume;
		fill_water(t_Water);
		if(temperature==t_Water)
		{
			temp_cup.fill_cup("Вода", volume_kettle);
		}
	}
	/**
	 * Функция нагрева чайника
	 * @param t_Water-температура воды предпочитаемая пользователем
	 */
	void fill_water(int t_Water)
	{
		temperature=t_Water; 
	}
}
