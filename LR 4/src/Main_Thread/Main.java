package Main_Thread;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import Controller.Controller;

/**
 * Main control class
 * @author GudveN
 * @version 1.0
 */
public class Main extends Application 
{
	
	/**
	 * Button that starts the selection the roots of the equation.
	 * @see Controller#btn
	 */
    Button Button1 = new Button("Calculate");
    /**
     * Button that shows the result of our selection.
     * @see Controller#btn1
     */
    Button Button2 = new Button("GET ANSWER");
    /**
     * An object of a class that controls threads.
     * @see Controller
     */
	Controller ctr = new Controller(Button1,Button2);
	
	/**
	 * Function to check if the input is correct.
	 * @param string1 - The first string to check.
	 * @param string2 - The second string to check.
	 * @param string3 - The third string to check.
	 * @param string4 - The fourth string to check.
	 * @return True - If the string have been validated. False - If the strings contain incorrect symbols.
	 */
	public boolean checkString(String string1,String string2,String string3,String string4) 
	{
        try 
        {
            Integer.parseInt(string1);
            Integer.parseInt(string2);
            Integer.parseInt(string3);
            Integer.parseInt(string4);
        } 
        catch(ClassCastException e)
        {
        	Alert alert = new Alert(AlertType.ERROR); 
    		alert.setTitle("Error alert");
    		alert.setHeaderText("Incorrect symbols");
    		alert.setContentText("Invalid type conversion!");
    		alert.showAndWait();
            return false;
        }
        catch(NumberFormatException e)
        {
        	Alert alert = new Alert(AlertType.ERROR); 
    		alert.setTitle("Error alert");
    		alert.setHeaderText("Incorrect symbols");
    		alert.setContentText("Incorrect conversion of a string to a numeric format!");
    		alert.showAndWait();
            return false;
        }
        catch (Exception e) 
        {
        	Alert alert = new Alert(AlertType.ERROR); 
    		alert.setTitle("Error alert");
    		alert.setHeaderText("Incorrect symbols");
    		alert.setContentText("One of the fields is empty or contains a letter!");
    		alert.showAndWait();
            return false;
        }
        return true;
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
	       GridPane root = new GridPane();
	 
	       root.setPadding(new Insets(20));
	       root.setHgap(10);
	       root.setVgap(15);
	       
	       Label labelTitle = new Label("Working with threads.");
	       GridPane.setHalignment(labelTitle, HPos.LEFT);
	       root.add(labelTitle, 0, 0, 4, 1);

	   	   Label LabelforDate = new Label("");
	       GridPane.setHalignment(LabelforDate, HPos.LEFT);
	       root.add(LabelforDate, 4, 0, 3, 1);
	       
	       TextField TextFieldA = new TextField("1");
	       TextFieldA.setMaxWidth(60);
	       
	       Label labelA = new Label("a + ");
	       
	       TextField TextFieldB = new TextField("2");
	       TextFieldB.setMaxWidth(60);
	       
	       Label labelB = new Label("b + ");
	       
	       TextField TextFieldC = new TextField("5");
	       TextFieldC.setMaxWidth(60);
	       
	       Label labelC = new Label("c = ");
	       
	       TextField TextFieldEqually = new TextField("10");
	       TextFieldEqually.setMaxWidth(60);
	 
	       GridPane.setHalignment(TextFieldA, HPos.CENTER);
	       root.add(TextFieldA, 0, 1);
	       
	       GridPane.setHalignment(labelA, HPos.CENTER);
	       root.add(labelA, 1, 1);
	 
	       GridPane.setHalignment(TextFieldB, HPos.CENTER);
	       root.add(TextFieldB, 2, 1);
	       
	       GridPane.setHalignment(labelB, HPos.CENTER);
	       root.add(labelB, 3, 1);
	       
	       
	       GridPane.setHalignment(TextFieldC, HPos.CENTER);
	       root.add(TextFieldC, 4, 1);
	       
	       GridPane.setHalignment(labelC, HPos.CENTER);
	       root.add(labelC, 5, 1);
	       
	       GridPane.setHalignment(TextFieldEqually, HPos.CENTER);
	       root.add(TextFieldEqually, 6, 1);
	       
	       Label labelAAnswer = new Label(" = a");
	       root.add(labelAAnswer, 1, 2);
	       
	       Label A_Answer = new Label("NONE");
	       GridPane.setHalignment(A_Answer, HPos.RIGHT);
	       root.add(A_Answer, 0, 2);
	       
	       Label labelBAnswer = new Label(" = b");
	       root.add(labelBAnswer, 3, 2);
	       
	       Label B_Answer = new Label("NONE");
	       GridPane.setHalignment(B_Answer, HPos.RIGHT);
	       root.add(B_Answer, 2, 2);
	       
	       Label labelCAnswer = new Label(" = c");
	       root.add(labelCAnswer, 5, 2);
	       
	       Label C_Answer = new Label("NONE");
	       GridPane.setHalignment(C_Answer, HPos.RIGHT);
	       root.add(C_Answer, 4, 2);
	       
	       root.add(Button1, 6, 2);
	       Button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
	       {
	            @Override
	            public void handle(MouseEvent mouseEvent) 
	            {
		            int [] number = new int [4];
		            if(checkString(TextFieldA.getText(), TextFieldB.getText(), TextFieldC.getText(),TextFieldEqually.getText())==false)
		            	return;
		            
		            number[0]=Integer.parseInt(TextFieldA.getText());
		            number[1]=Integer.parseInt(TextFieldB.getText()); 
		            number[2]=Integer.parseInt(TextFieldC.getText());
		            number[3]=Integer.parseInt(TextFieldEqually.getText());
		            
	            	Thread cont = new Thread(ctr,"CONTROLLER");
		            
		            ctr.mmass[0].set_mass(number, 1, ctr.smass[0]);
		            ctr.mmass[1].set_mass(number, 2, ctr.smass[1]);
		            ctr.mmass[2].set_mass(number, 3, ctr.smass[2]);
		            	
		            cont.start();
	            }
	        });
	       
	       Button2.setDisable(true);
	       root.add(Button2, 6, 3);
	       Button2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() 
	       {
	            @Override
	            public void handle(MouseEvent mouseEvent) 
	            {
	            	if(ctr.mmass[0].obj.flag==1 || ctr.mmass[1].obj.flag==1 || ctr.mmass[2].obj.flag==1)
	            	{
	            		if(ctr.mmass[0].obj.flag==1)
	            		{
	            			A_Answer.setText(Integer.toString(ctr.mmass[0].answer[0]));
		            		B_Answer.setText(Integer.toString(ctr.mmass[0].answer[1]));
		            		C_Answer.setText(Integer.toString(ctr.mmass[0].answer[2]));
	            		}
	            		else if(ctr.mmass[1].obj.flag==1)
	            		{
	            			A_Answer.setText(Integer.toString(ctr.mmass[1].answer[0]));
		            		B_Answer.setText(Integer.toString(ctr.mmass[1].answer[1]));
		            		C_Answer.setText(Integer.toString(ctr.mmass[1].answer[2]));
	            		}
	            		else if(ctr.mmass[2].obj.flag==1)
	            		{
	            			A_Answer.setText(Integer.toString(ctr.mmass[2].answer[0]));
		            		B_Answer.setText(Integer.toString(ctr.mmass[2].answer[1]));
		            		C_Answer.setText(Integer.toString(ctr.mmass[2].answer[2]));
	            		}
	            	}
	            	else
	            	{
	            		A_Answer.setText("NONE");
	            		B_Answer.setText("NONE");
	            		C_Answer.setText("NONE");
	            	}
	            }
	        });
	       
	       Scene scene = new Scene(root, 450, 170);
	       primaryStage.setTitle("Laboratory work ¹4");
	       primaryStage.setScene(scene);
	       primaryStage.show();
	       
	   }
	
	/**
	 * The main control function
	 * @param args - Initial data
	 */
	public static void main(String[] args) 
	{
		launch(args);
	}
}
