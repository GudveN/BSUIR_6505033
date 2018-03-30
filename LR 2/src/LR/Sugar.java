package LR;

import javax.swing.JOptionPane;

import LR.Cup;

/**
 * Класс для добавления сахара
 */
public class Sugar extends Objectiv
{
	/**
	 * Фунция для проверки строки на число
	 * @param s-строка которую нужно проверить
	 * @return	1-число 0-строка
	 */
	private static int isDigit(String s) throws NumberFormatException 
	{
	    try 
	    {
	        Integer.parseInt(s);
	        return 1;
	    } 
	    catch (NumberFormatException e)
	    {
	        return 0;
	    }
	}	
	Sugar()
	{
		
	}
	/**
	 * Функция для добавления сахара
	 * @param temp-количество сахара
	 */
	void fill_sugar(String temp, Cup temp_cup)
	{
		if(isDigit(temp)==1)
		{
			if(Integer.parseInt(temp)*30>=300)
			{
				JOptionPane.showMessageDialog(null,"Было введено слишком большое количество сахара","Ошибка",JOptionPane.ERROR_MESSAGE);
				temp_cup.fill_cup("Сахар", 60);
			}
			else
			{
				temp_cup.fill_cup("Сахар", 30*Integer.parseInt(temp));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Было введено неверное количество","Ошибка",JOptionPane.ERROR_MESSAGE);
			temp_cup.fill_cup("Сахар", 60);
		}
	}
}
