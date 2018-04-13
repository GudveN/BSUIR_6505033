package Controller;

import Main_Thread.Main_Thread;
import Thread.Side_Thread;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

/**
 * The class which controls the thread.
 * @author GudveN
 *
 */
public class Controller implements Runnable
{
	/**
	 * An array of objects that calculate the equation.{@link Side_Thread}
	 */
	public Side_Thread [] smass= { new Side_Thread(),new Side_Thread(),new Side_Thread()};
	/**
	 * An array of objects that perform the selection the roots of the equation.{@link Main_Thread}
	 */
	public Main_Thread [] mmass= { new Main_Thread(), new Main_Thread(), new Main_Thread()};
	/**
	 * Button that starts the selection the roots of the equation.
	 */
	public Button btn;
	/**
	 * Button that shows the result of our selection.
	 */
	public Button btn1;
	
	/**
	 * Constructor with parameters.
	 * @param temp - Button that starts the selection the roots of the equation. {@link Controller#btn}
	 * @param temp1 - Button that shows the result of our selection. {@link Controller#btn1}
	 */
	public Controller(Button temp, Button temp1)
	{
		btn=temp;
		btn1=temp1;
	}
	
	@Override
	public void run() 
	{
			
			Platform.runLater(new Runnable()
			{
                @Override
                public void run() 
                {
                	btn.setDisable(true);
                	btn1.setDisable(true);
                }
            });
			
			Thread t1= new Thread(mmass[0],"t1");
	    	Thread t2= new Thread(mmass[1],"t1");
	    	Thread t3= new Thread(mmass[2],"t2");
	    	smass[0].flag=0;
	    	smass[1].flag=0;
	    	smass[2].flag=0;
	    	t1.start();
	    	t2.start();
	    	t3.start();
	    	do{
	    		if(smass[0].flag==1 || smass[1].flag==1 || smass[2].flag==1)
	    		{
	    			if(t1.isAlive()==true)
	    			{
	    				System.out.println("IF 1");
	    				t1.interrupt();
	    			}
	    			if(t2.isAlive()==true)
	    			{
	    				System.out.println("IF 2");
	    				t2.interrupt();
	    			}
	    			if(t3.isAlive()==true)
	    			{
	    				System.out.println("IF 3");
	    				t3.interrupt();
	    			}
	    			System.out.println("Сработало завершение");
	    			break;
	    		}
	    	}
	    	while(t1.isAlive()==true || t2.isAlive()==true || t3.isAlive()==true);
			
	    	Platform.runLater(new Runnable()
			{
                @Override
                public void run() 
                {
            		String temp = new String("A = ");
                	if(mmass[0].obj.flag==1 || mmass[1].obj.flag==1 || mmass[2].obj.flag==1)
	            	{
	            		if(mmass[0].obj.flag==1)
	            		{
	            			temp+=Integer.toString(mmass[0].answer[0]);
	            			temp+=" B = ";
	            			temp+=Integer.toString(mmass[0].answer[1]);
	            			temp+=" C = ";
	            			temp+=Integer.toString(mmass[0].answer[2]);
	            		}
	            		else if(mmass[1].obj.flag==1)
	            		{
	            			temp+=Integer.toString(mmass[1].answer[0]);
	            			temp+=" B = ";
	            			temp+=Integer.toString(mmass[1].answer[1]);
	            			temp+=" C = ";
	            			temp+=Integer.toString(mmass[1].answer[2]);
	            		}
	            		else if(mmass[2].obj.flag==1)
	            		{
	            			temp+=Integer.toString(mmass[2].answer[0]);
	            			temp+=" B = ";
	            			temp+=Integer.toString(mmass[2].answer[1]);
	            			temp+=" C = ";
	            			temp+=Integer.toString(mmass[2].answer[2]);
	            		}
	            		
	            	}
	            	else
	            	{
	            		temp="NONE";
	            	}
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("The roots are found.");
                    alert.setHeaderText("Results:");
                    alert.setContentText(temp);
             
                    alert.showAndWait();
                	btn.setDisable(false);
                	btn1.setDisable(false);
                }
            });
			return;
		
		
	}

}
