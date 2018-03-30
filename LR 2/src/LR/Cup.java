package LR;

import javax.swing.JOptionPane;

/**
 *Класс для хранения содержимого чашки
 */
public class Cup extends Objectiv
{
	/**
	 * Cup_Volume-объём чашки
	 */
	protected static double cup_volume=0;
	/**
	 * Cup_Content-содержимое чашки
	 */
	protected static String cup_content=new String();
	Cup()
	{
		
	}
	/**
	 * Функция для заполнения чашки чем-либо
	 * @param string-содержимое чем нужно заполнить
	 * @param volume-объем
	 */
	void fill_cup(String string, double volume)
	{
		cup_volume+=volume;
		cup_content+=" ";
		cup_content+=string;
		mass+=volume*0.998;
	}
}
