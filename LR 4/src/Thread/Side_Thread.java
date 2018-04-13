package Thread;

import Main_Thread.Main_Thread;

/**
 * Class for calculating the equation and check the roots.
 * @author GudveN
 */
public class Side_Thread implements Runnable 
{  
	
	/**
	 * The array of coefficients {@link Main_Thread#equation}
	 */
	protected int[] Factor = new int [4];
	/**
	 * An array of supposed roots
	 * @see Main_Thread#find_answer()
	 */
	protected int[] Parametrs = new int [3];
	/**
	 * Flag. True - roots are found. False - roots not found
	 */
	public int flag=0;
	
	/**
	 * Function to initialize the coefficients.
	 * @param temp_facotr - buffer coefficients {@link Side_Thread#Factor}
	 */
	public void set_mass_factor(int[] temp_facotr)
	{
		Factor=temp_facotr;
	}
	/**
	 * Function to initialize the assumed roots of the equation.
	 * @param a - first supposed root.
	 * @param b - second supposed root.
	 * @param c - third supposed root.
	 * @see Main_Thread#find_answer()
	 */
	public void set_mass_parametrs(int a, int b, int c)
	{
		Parametrs[0]=a;
		Parametrs[1]=b;
		Parametrs[2]=c;
	}
	
	/**
	 * Function to calculate the function and check our roots
	 * @return 1 - roots are found 0 - roots not found
	 */
	public int func()
	{	
		if(Factor[0]*Parametrs[0]+Factor[1]*Parametrs[1]+Factor[2]*Parametrs[2]==Factor[3])
			return 1;
		else
			return 0;	
	}
	
	@Override
    public void run()
	{
            flag=func();
    }
}