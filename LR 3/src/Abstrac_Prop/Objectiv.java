package Abstrac_Prop;

import javax.swing.JOptionPane;

import Main_Ingridients.Coffee;
import Main_Ingridients.Sugar;
import Main_Ingridients.Tea;
import Prop.Cup;

/**
 * Class - A class that describes the properties of an object.
 * @author GudveN
 */
public class Objectiv extends Abstract_Objectiv
{
	/**
	 * Default Constructor
	 */
	public Objectiv(){}
	/**
	 * Property - The contents of the object.
	 */
	protected static String String_Objectiv="";
	/**
	 * Property - The volume of the object.
	 */
	protected static double double_Objectiv=0;
	
	/**
	 * Method that determines a string consisting of digits.
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
	 * The method of filling the CUP.
	 * @param temp_coffee - The object of the Coffee
	 * @param temp_sugar - The object of the Sugar
	 * @param temp_tea - The object of the Tea
	 * @param check - 1 = Make coffee 0 = Make tea
	 */
	public void fill(Coffee temp_coffee, Sugar temp_sugar, Tea temp_tea, int check)
	{
		String_Objectiv="";
		double_Objectiv=0;
		if(temp_sugar.getNumber_sugar()*20>=200)
		{
			JOptionPane.showMessageDialog(null,"Было введено слишком большое количество сахара","Ошибка",JOptionPane.ERROR_MESSAGE);
			double_Objectiv+=temp_sugar.getNumber_sugar();
			String_Objectiv+="Сахар";
			String_Objectiv+=" ";
		}
		else
		{
			double_Objectiv+=40;
			String_Objectiv+="Сахар";
			String_Objectiv+=" ";
		}
		if(check==1)
		{
			double_Objectiv+=40;
			String_Objectiv+=temp_coffee.getTaste();
			String_Objectiv+=" ";
		}
		if(check==0)
		{
			double_Objectiv+=40;
			String_Objectiv+=temp_tea.getVariety();
			String_Objectiv+=" ";
		}	
		
	}
	
	/**
	 * Method that returns the contents of a Cup. {@link Objectiv#String_Objectiv}
	 * @return String - contents of a Cup
	 */
	public String getString() 
	{
		return String_Objectiv;
	}
	/**
	 * Method that returns the object volume {@link Objectiv#String_Objectiv}
	 * @return Double - object volume
	 */
	public double getdouble() 
	{
		return double_Objectiv;
	}
	/**
	 * The method resets the mass	{@link Abstract_Objectiv#mass}
	 */
	public void setMass() 
	{
		mass=0;		
	}
}
