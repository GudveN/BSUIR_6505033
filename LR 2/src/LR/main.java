package LR;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JOptionPane;

import LR.Coffee;
import LR.Cup;
import LR.Kettle;
import LR.Objectiv;
import LR.Student;
import LR.Sugar;

/**
 * 
 * @author GudveN
 * @version 1.0
 *
 */
public class main 
{
	private JFrame frame;
	private JTextField textField;
	
	String temp= new String("");
	
	Objectiv temp_object=new Objectiv();
	Coffee temp_coffee=new Coffee();
	Cup temp_cup=new Cup();
	Kettle temp_kettle=new Kettle();
	Sugar temp_sugar=new Sugar();
	
	/**
	 * Функция для проверки строки на наличие числа
	 * @param 	String-строка для проверки
	 * @return	1-число 0-строка
	 * @throws 	NumberFormatException
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
	 * @param args Начальные параметры
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			
			public void run() 
			{
				try 
				{
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public main() 
	{
		initialize();
	}
	
	/**
	 * Функция по pсозданию GUI
	 */
	private void initialize() 
	{
		temp=JOptionPane.showInputDialog("Введите имя студента");
		if(isDigit(temp)==1)
		{
			JOptionPane.showMessageDialog(frame,"Было введено неверное имя","Ошибка",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		if (temp==null)
		{
			JOptionPane.showMessageDialog(frame,"Было введено неверное имя","Ошибка",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(7 ,2 ,20 ,20));
		
		JLabel lblNewLabel = new JLabel("Симулятор чашки Шрёдингера");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel);
		
		JButton Button_1 = new JButton("Сделать кофе");
		Button_1.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(Button_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		frame.getContentPane().add(progressBar);
		
		JButton Button_2 = new JButton("Вылить содержимое из чашки");
		Button_2.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(Button_2);
		
		JLabel lblNewLabel_1 = new JLabel("Температура воды");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_1);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(2);
	    slider.setMajorTickSpacing(20);
	    slider.setPaintLabels(true);
		frame.getContentPane().add(slider);
		
		JLabel lblNewLabel_3 = new JLabel("Количество кубиков сахара");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Кофе");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox.addItem("Lavazza");
		comboBox.addItem("Paulig");
		comboBox.addItem("Jardin");
		comboBox.addItem("EGOISTE");
		comboBox.addItem("Nescafe");
		comboBox.addItem("Nespresso");
		frame.getContentPane().add(comboBox);
		
		JSeparator separator = new JSeparator();
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("Пусто");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0 мл");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel_5);
		
		Button_1.addActionListener(new ActionListener() 
		{	 
			public void actionPerformed(ActionEvent event) 
			{
				temp_coffee.mass=40;
				temp_coffee.taste="";
				
				temp_kettle.volume_kettle=0;
				temp_kettle.temperature=0;
				
				temp_cup.cup_volume=0;
				temp_cup.cup_content="";
				
				progressBar.setValue(0);
				lblNewLabel_4.setText("Пусто");
				lblNewLabel_5.setText("0 мл");
							
				Student temp_student=new Student(temp,temp_object);
				temp_student.make_coffee(frame,progressBar,slider.getValue(),textField.getText(),comboBox.getSelectedItem().toString(), temp_sugar, temp_coffee, temp_kettle,temp_cup);
				
				String copy = new String();
				copy+=temp_cup.cup_volume;
				copy+=" ";
				copy+="мл";
				
				lblNewLabel_4.setText(temp_cup.cup_content);
				lblNewLabel_5.setText(copy);
				
			}			 
		});
		
		Button_2.addActionListener(new ActionListener() 
		{	 
			public void actionPerformed(ActionEvent event) 
			{
				temp_coffee.mass=40;
				temp_coffee.taste="";
				
				temp_kettle.volume_kettle=0;
				temp_kettle.temperature=0;
				
				temp_cup.cup_volume=0;
				temp_cup.cup_content="";
				
				progressBar.setValue(0);
				lblNewLabel_4.setText("Пусто");
				lblNewLabel_5.setText("0 мл");
			}			 
		});
		

		

	}
}
