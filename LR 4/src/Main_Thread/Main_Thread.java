package Main_Thread;

import Thread.Side_Thread;

/**
 * Class performs a selection of roots.
 * @author GudveN
 */
public class Main_Thread implements Runnable 
{
	/**
	 * The array of coefficients
	 * @see Side_Thread#Factor
	 */
	protected int[] equation = {0,0,0,0};
	/**
	 * Array of roots of the equation
	 * @see Side_Thread#Parametrs
	 */
	public int[] answer = {0,0,0};
	/**
	 * Variable to control the selection
	 * @see Main_Thread#find_answer()
	 */
	protected int choice;
	/**
	 * The class object for the calculation of the equation.
	 * @see Side_Thread
	 */
	public Side_Thread obj;
	
	/**
	 * Default constructor
	 */
	public Main_Thread()
	{
		
	}
	
	/**
	 * Function to initialize parameters.
	 * @param temp_equation - The buffer array of coefficients {@link Main_Thread#equation}
	 * @param temp - buffer variable to control the selection {@link Main_Thread#choice}
	 * @param temp_obj - object to aggregate {@link Main_Thread#obj}
	 */
	protected void set_mass(int[] temp_equation, int temp, Side_Thread temp_obj)
	{
		equation=temp_equation;
		choice=temp;
		obj=temp_obj;
	}
	
	/**
	 * Function for the selection of roots
	 * @return answer - array of roots
	 * @see Side_Thread#func()
	 */
	public int[] find_answer()
	{
		obj.set_mass_factor(equation);
		
		if(equation[0]==0 && equation[1]==0 && equation[2]==0)
			choice=0;
		
		int i,j,k;
		int i_begin=-20, j_begin=-20, k_begin=-20;
		int i_end=20, j_end=20, k_end=20;
		
		switch(choice) 
		{
	    case 1:
	    {
	    	if(equation[0]==0)
	    		break;
	    	if(equation[1]==0)
	    	{
	    		j_begin=0;
	    		j_end=1;
	    	}
	    	if(equation[2]==0)
	    	{
	    		k_begin=0;
	    		k_end=1;
	    	}
    		for(k=k_begin ; k<k_end ; k++)
    			for(j=j_begin ; j<j_end ; j++)
    	    		for(i=i_begin ; i<i_end ; i++)
		    		{
			    		obj.set_mass_parametrs(i,j,k);
			    	    Thread t1= new Thread(obj,Integer.toString(choice));
			    		t1.start();
			    		try{
			    			t1.join();
			            }
			            catch (InterruptedException e){
			            	System.out.println("CASE 1 CATCH");
			            	obj.flag=0;
							return answer;
						}
						if(obj.flag==1)
						{
							answer[0]=i;
							answer[1]=j;
							answer[2]=k;
							return answer;
						}
		            } 
			break;
	    }
		case 2:
		{
			if(equation[1]==0)
	    		break;
			if(equation[0]==0)
	    	{
	    		i_begin=0;
	    		i_end=1;
	    	}
	    	if(equation[2]==0)
	    	{
	    		k_begin=0;
	    		k_end=1;
	    	}
			for(i=i_begin ; i<i_end ; i++)
		    	for(k=k_begin ; k<k_end ; k++)
				    for(j=j_begin ; j<j_end ; j++)
		    		{
			    		obj.set_mass_parametrs(i,j,k);
			    		Thread t2= new Thread(obj,Integer.toString(choice));
			    		t2.start();
			            try{
				    		t2.join();
			            }
		            	catch (InterruptedException e){
		            		System.out.println("CASE 2 CATCH");
							obj.flag=0;
							return answer;
						}
				    	if(obj.flag==1)
						{
								answer[0]=i;
								answer[1]=j;
								answer[2]=k;
								return answer;
						}
		    		}
			break;
		}
		case 3:
		{
			if(equation[2]==0)
	    		break;
			if(equation[0]==0)
	    	{
	    		i_begin=0;
	    		i_end=1;
	    	}
	    	if(equation[1]==0)
	    	{
	    		j_begin=0;
	    		j_end=1;
	    	}
			for(i=i_begin ; i<i_end ; i++)
		    	for(j=j_begin ; j<j_end ; j++)
		    		for(k=k_begin ; k<k_end ; k++)
		    		{
		    			obj.set_mass_parametrs(i, j, k);
		    			Thread t3= new Thread(obj,Integer.toString(choice));
		    			t3.start();
		            	try {
						t3.join();
		            	}
		            	catch (InterruptedException e){
							System.out.println("CASE 3 CATCH");
							obj.flag=0;
							return answer;
						}
						if(obj.flag==1)
						{
							answer[0]=i;
							answer[1]=j;
							answer[2]=k;
							return answer;
						}
		    		}
			break;
		}
		default:			
			break;
		}
		return answer;		
	}
	
	@Override
	public void run() 
	{
		find_answer();
		return;	
	}

}
