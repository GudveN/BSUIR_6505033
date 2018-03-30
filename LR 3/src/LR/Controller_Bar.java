package LR;

import javax.swing.JProgressBar;

/**
 *Class of the controlling Progress Bar.
 * @author GudveN
 */
public class Controller_Bar 
{
	/**
	 * Bar - Progress Bar
	 */
	protected JProgressBar Bar;
	
	/**
	 * Default Constructor
	 * @see Controller_Bar#Controller_Bar(JProgressBar)
	 */
	public Controller_Bar()
	{
		
	}
	/**
	 * Constructor with parameters
	 * @param temp_bar
	 * @see Controller_Bar#Controller_Bar()
	 */
	public Controller_Bar(JProgressBar temp_bar)
	{
		Bar=temp_bar;
	}
	
	/**
	 * The method increases the ProgressBar on 33 {@link Controller_Bar#Bar}
	 */
	public void inc_33()
	{
		int temp=Bar.getValue();
		temp+=33;
		Bar.setValue(temp);
	}
	
	/**
	 * The method increases the ProgressBar on 25 {@link Controller_Bar#Bar}
	 */
	public void inc_25()
	{
		int temp=Bar.getValue();
		temp+=25;
		Bar.setValue(temp);
	}
	
	/**
	 * The method increases the ProgressBar on temp_inc {@link Controller_Bar#Bar}
	 * @param temp_inc
	 */
	public void inc(int temp_inc)
	{
		int temp=Bar.getValue();
		temp+=temp_inc;
		Bar.setValue(temp);
	}
	
	/**
	 * The method increases the ProgressBar to 100
	 */
	public void set_100()
	{
		Bar.setValue(100);
	}
	
	/**
	 * A method that equates Progress Bar
	 * @param temp_bar
	 */
	public void set_bar(JProgressBar temp_bar)
	{
		Bar=temp_bar;
	}

}
