import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class LR 
{
	protected Shell shell;
	private Text Left;
	private Text Right;
	
	public int checkString(String string) 
	{
        try 
        {
            Integer.parseInt(string);
        } 
        catch (Exception e) 
        {
            return 0;
        }
        return 1;
    }
	
	static double SIN(double x)
	{
		return Math.sin(x);
	}
	
	static double integral(double left, double right)
	{
		if(left>right)
		{
			double buffer;
			buffer=left;
			left=right;
			right=buffer;
		}
    	int stepNumber;
    	stepNumber=10;   		
    	double sum = 0.0;   		
    	double stepSize = (right - left) / stepNumber;  		
    	int i;
    	for (i = 1; i < stepNumber; i++)
    		sum += SIN(left + i * stepSize) * stepSize;    		
    	sum += SIN(left) * stepSize/2;	
    	sum += SIN(left + i * stepSize) * stepSize/2;   		
    	return sum;
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			LR window = new LR();
			window.open();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void open() 
	{		
		Display display = Display.getDefault();
		shell = new Shell();
		shell.setSize(315, 150);
		shell.setText("Метод трапеций");
		shell.setLayout(new GridLayout(4, false));
		
		Label func = new Label(shell, SWT.NONE);
		func.setText("sin(x)dx");
		func.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		
		Label Left_label = new Label(shell, SWT.NONE);
		Left_label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		Left_label.setText("Начало интервала");
		
		Left = new Text(shell, SWT.BORDER);
		Left.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label Right_label = new Label(shell, SWT.NONE);
		Right_label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		Right_label.setText("Конец интервала");
		
		Right = new Text(shell, SWT.BORDER);
		Right.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		Label Temp_Label = new Label(shell, SWT.NONE);
		Temp_Label.setText("Интеграл");
		
		Label Result = new Label(shell, SWT.NONE);
		Result.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		Result.setText("0");
		
		Button b = new Button(shell, SWT.NONE);
		b.setText("Интегрировать");
		b.addListener(SWT.Selection, new Listener() 
		{
			public void handleEvent(Event e) 
			{
				
				double sum=0;
				if(checkString(Left.getText())==1 && checkString(Right.getText())==1)
				{
					sum=integral(Double.parseDouble(Left.getText()),Double.parseDouble(Right.getText()));
					Result.setText(Double.toString(sum));
				}
				else
					Result.setText("Error");
			}
		});
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) 
		{
			if (!display.readAndDispatch()) 
			{
				display.sleep();
			}
		}
	}
}
