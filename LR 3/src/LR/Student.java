package LR;

import java.lang.String;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import Abstrac_Prop.Abstract_Objectiv;
import Abstrac_Prop.Objectiv;
import Main_Ingridients.Coffee;
import Main_Ingridients.Sugar;
import Main_Ingridients.Tea;
import Prop.Cup;
import Prop.Kettle;
import Prop.Milk;

/**
 * Class describing the student.
 */
public class Student 
{
	/**
	 * Method that determines a string consisting of digits.
	 * @param s - String
	 * @return 1 - String 0 - Number
	 * @throws NumberFormatException
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
	
	/**
	 * Name of the Student
	 */
	protected static String Name;
	/**
	 * The object that the student has.
	 */
	protected Abstract_Objectiv object;
	/**
	 * Controller of the bar
	 */
	protected Controller_Bar Bar;

	/**
	 * Default Constructor
	 * @see Student#Student(String, Abstract_Objectiv)
	 */
	Student()
	{
	}
	/**
	 * Constructor with parameters
	 * @see Student#Student()
	 * @param temp - name of the student
	 * @param temp_object - object of the student
	 */
	Student(String temp, Abstract_Objectiv temp_object)
	{
		Name=new String(temp);
		object=temp_object;
	}
	/**
	 * Method that creates a new object {@link Student#object}
	 * @param temp_object - new object of the student
	 */
	void SetObject(Abstract_Objectiv temp_object)
	{
		object=temp_object;
	}
	/**
	 * Method of making coffee
	 * @param temp_sugar - preferred sugar {@link Sugar}
	 * @param temp_coffee - preferred coffee {@link Coffee}
	 * @param temp_tea - preferred tea		{@link Tea}
	 * @param temp_kettle - kettle			{@link Kettle}
	 * @param temp_milk - preferred milk	{@link Milk}
	 * @param temp_cup - preferred cup	{@link Cup}
	 * @param temp_object - object of the students	{@link Objectiv}
	 * @param temperaure - preferred temperature
	 * @param check	- tea or coffee
	 */
	void make_coffee(Sugar temp_sugar,Coffee temp_coffee,Tea temp_tea,Kettle temp_kettle,Milk temp_milk,Cup temp_cup, Objectiv temp_object,int temperaure, int check)
	{
		temp_object.fill(temp_coffee, temp_sugar, temp_tea, 1);
		temp_cup.fill_cup(temp_object.getString(), temp_object.getdouble());
		Bar.Bar.setValue(40);
		JOptionPane.showMessageDialog(null,"Сахар и кофе добавлены","Уведомление",JOptionPane.INFORMATION_MESSAGE);
		if(check==1)
		{
			temp_cup.fill_cup("Молоко", temp_milk.getMilk_volume());
			Bar.inc(20);
			JOptionPane.showMessageDialog(null,"Молоко добавлено","Уведомление",JOptionPane.INFORMATION_MESSAGE);
		}
		Bar.set_100();
		temp_kettle.fill_kettle(temperaure, temp_cup);
		JOptionPane.showMessageDialog(null,"Вода добавлена","Уведомление",JOptionPane.INFORMATION_MESSAGE);		
	}
	/**
	 * Method of making tea
	 * @param temp_sugar - preferred sugar {@link Sugar}
	 * @param temp_coffee - preferred coffee {@link Coffee}
	 * @param temp_tea - preferred tea	{@link Tea}
	 * @param temp_kettle - kettle	{@link Kettle}
	 * @param temp_milk - preferred milk {@link Milk}
	 * @param temp_cup - preferred cup {@link Cup}
	 * @param temp_object - object of the students {@link Objectiv}
	 * @param temperaure - preferred temperature
	 * @param check	- tea or coffee
	 */
	void make_tea(Sugar temp_sugar,Coffee temp_coffee,Tea temp_tea,Kettle temp_kettle,Milk temp_milk,Cup temp_cup, Objectiv temp_object,int temperaure, int check)
	{
		temp_object.fill(temp_coffee, temp_sugar, temp_tea, 0);
		temp_cup.fill_cup(temp_object.getString(), temp_object.getdouble());
		Bar.Bar.setValue(40);
		JOptionPane.showMessageDialog(null,"Сахар и чай добавлены","Уведомление",JOptionPane.INFORMATION_MESSAGE);
		if(check==1)
		{
			temp_cup.fill_cup("Молоко", temp_milk.getMilk_volume());
			Bar.inc(20);
			JOptionPane.showMessageDialog(null,"Молоко добавлено","Уведомление",JOptionPane.INFORMATION_MESSAGE);
		}
		Bar.set_100();
		temp_kettle.fill_kettle(temperaure, temp_cup);
		JOptionPane.showMessageDialog(null,"Вода добавлена","Уведомление",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	void setBar(Controller_Bar temp)
	{
		Bar=temp;
	}
	
	
}
