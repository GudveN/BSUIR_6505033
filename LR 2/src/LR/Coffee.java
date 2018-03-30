package LR;

import javax.swing.JOptionPane;
import LR.Cup;


/**
 *Класс для создания кофе
 *
 */
public class Coffee extends Objectiv
{
	/**
	 * taste-вкус кофе
	 */
	protected static String taste;
	
	/**
	 * Стандартный конструктор
	 */
	Coffee()
	{
		
	}
	
	/**
	 * Функция для заполнения кружки кофем
	 * @param dev-вкус кофе который хочет пользователь
	 */
	void fill_coffee(String dev, Cup temp_cup)
	{
		taste=dev;
		temp_cup.fill_cup(dev, 20.5);
	}
}
