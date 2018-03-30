package LR;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Abstrac_Prop.Objectiv;

import javax.swing.JOptionPane;

import LR.Student;
import Main_Ingridients.*;
import Prop.Cup;
import Prop.Kettle;
import Prop.Milk;

/**
 * The class that creates the GUI
 * @author GudveN
 * @version 1.0
 *
 */
public class GUI extends JFrame
{
	private JFrame frame;
	private JTextField textField;
	
	Objectiv temp_object=new Objectiv();
	Coffee temp_coffee=new Coffee();
	Cup temp_cup=new Cup();
	Kettle temp_kettle=new Kettle();
	Sugar temp_sugar=new Sugar();
	Tea temp_tea= new Tea();
	Milk temp_milk=new Milk();
	
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
	
	private void ClearCup(JLabel lblNewLabel_4, JLabel lblNewLabel_5,JProgressBar Bar)
	{
		temp_object.setMass();
		
		temp_coffee.setTaste("");
		
		temp_tea.setVariety("");
		
		temp_sugar.setNumber_sugar(0);
		
		temp_kettle.setVolume_kettle(0);
		temp_kettle.setTemperature(0);
		
		temp_cup.setCup_volume(0);
		temp_cup.setCup_content("");
		
		Bar.setValue(0);
		lblNewLabel_4.setText("Пусто");
		lblNewLabel_5.setText("0 мл");
	}

	/**
	 * main function
	 * @param args initial parameter
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			
			public void run() 
			{
				try 
				{
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public GUI() 
	{
		initialize();
	}
	
	/**
	 * Function that creates the GUI
	 */
	private void initialize() 
	{
		String temp=JOptionPane.showInputDialog("Введите имя студента");
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
		frame.setBounds(100, 100, 790, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{254, 254, 254, 0};
		gridBagLayout.rowHeights = new int[]{90, 90, 90, 90, 90, 90, 98, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton Button_1 = new JButton("Сделать кофе");
		Button_1.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_Button_1 = new GridBagConstraints();
		gbc_Button_1.fill = GridBagConstraints.BOTH;
		gbc_Button_1.insets = new Insets(0, 0, 5, 5);
		gbc_Button_1.gridx = 0;
		gbc_Button_1.gridy = 0;
		frame.getContentPane().add(Button_1, gbc_Button_1);
		
		JButton Button_2 = new JButton("Вылить содержимое из чашки");
		Button_2.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_Button_2 = new GridBagConstraints();
		gbc_Button_2.fill = GridBagConstraints.BOTH;
		gbc_Button_2.insets = new Insets(0, 0, 5, 5);
		gbc_Button_2.gridx = 1;
		gbc_Button_2.gridy = 0;
		frame.getContentPane().add(Button_2, gbc_Button_2);
		
		
		JButton Button_3 = new JButton("Сделать чай");
		Button_3.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_Button_3 = new GridBagConstraints();
		gbc_Button_3.fill = GridBagConstraints.BOTH;
		gbc_Button_3.insets = new Insets(0, 0, 5, 0);
		gbc_Button_3.gridx = 2;
		gbc_Button_3.gridy = 0;
		frame.getContentPane().add(Button_3, gbc_Button_3);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		GridBagConstraints gbc_progressBar = new GridBagConstraints();
		gbc_progressBar.fill = GridBagConstraints.BOTH;
		gbc_progressBar.gridwidth = 2;
		gbc_progressBar.insets = new Insets(0, 0, 5, 5);
		gbc_progressBar.gridx = 0;
		gbc_progressBar.gridy = 1;
		frame.getContentPane().add(progressBar, gbc_progressBar);
		
		JRadioButton Radio_Button = new JRadioButton("Молоко?");
		Radio_Button.setHorizontalAlignment(SwingConstants.CENTER);
		Radio_Button.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_Radio_Button = new GridBagConstraints();
		gbc_Radio_Button.fill = GridBagConstraints.BOTH;
		gbc_Radio_Button.insets = new Insets(0, 0, 5, 0);
		gbc_Radio_Button.gridx = 2;
		gbc_Radio_Button.gridy = 1;
		frame.getContentPane().add(Radio_Button, gbc_Radio_Button);
		
		JLabel lblNewLabel_1 = new JLabel("Температура воды");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		frame.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JSlider slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(2);
		slider.setMajorTickSpacing(20);
		slider.setPaintLabels(true);
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.gridwidth = 2;
		gbc_slider.fill = GridBagConstraints.BOTH;
		gbc_slider.insets = new Insets(0, 0, 5, 0);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 2;
		frame.getContentPane().add(slider, gbc_slider);
		
		JLabel lblNewLabel_3 = new JLabel("Количество кубиков сахара");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		frame.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		frame.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Кофе");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		frame.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Lavazza", "Paulig", "Jardin", "EGOISTE", "Nescafe", "Nespresso"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 20));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 4;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel = new JLabel("\u0427\u0430\u0439");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		frame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Arial", Font.BOLD, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Майский чай", "Ахмад", "Гринфилд", "Нури"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 5;
		frame.getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Пусто");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 2;
		gbc_lblNewLabel_4.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		frame.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("0 мл");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 6;
		frame.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		pack();
		
		
		Button_1.addActionListener(new ActionListener() 
		{	 
			public void actionPerformed(ActionEvent event) 
			{
				ClearCup(lblNewLabel_4,lblNewLabel_5, progressBar);
				
				int milk=0;
				int temperaure=0;
				
				if(isDigit(textField.getText())==0)
				{
					JOptionPane.showMessageDialog(null,"Были введены неверные данные","Ошибка",JOptionPane.ERROR_MESSAGE);
					temp_sugar.setNumber_sugar(2);
				}
				else
				{
					temp_sugar.setNumber_sugar(Integer.parseInt(textField.getText()));
				}
				
				temp_coffee.setTaste(comboBox.getSelectedItem().toString());
				temp_tea.setVariety(comboBox_1.getSelectedItem().toString());
				
				temperaure=slider.getValue();
				
				if(Radio_Button.isSelected())
					milk=1;
				else
					milk=0;		
				Student temp_student=new Student(temp,temp_object);
				Controller_Bar temp_bar = new Controller_Bar(progressBar);
				temp_student.setBar(temp_bar);
				temp_student.make_coffee(temp_sugar,temp_coffee,temp_tea,temp_kettle,temp_milk,temp_cup, temp_object,temperaure, milk);
								
				String copy = new String();
				copy+=temp_cup.getCup_volume();
				copy+=" ";
				copy+="мл";
				
				lblNewLabel_4.setText(temp_cup.getCup_content());
				lblNewLabel_5.setText(copy);
				
			}			 
		});
		
		Button_3.addActionListener(new ActionListener() 
		{	 
			public void actionPerformed(ActionEvent event) 
			{
				ClearCup(lblNewLabel_4,lblNewLabel_5,progressBar);
				
				int milk=0;
				int temperaure=0;
				
				if(isDigit(textField.getText())==0)
				{
					JOptionPane.showMessageDialog(null,"Были введены неверные данные","Ошибка",JOptionPane.ERROR_MESSAGE);
					temp_sugar.setNumber_sugar(2);
				}
				else
				{
					temp_sugar.setNumber_sugar(Integer.parseInt(textField.getText()));
				}
				
				temp_coffee.setTaste(comboBox.getSelectedItem().toString());
				temp_tea.setVariety(comboBox_1.getSelectedItem().toString());
				
				temperaure=slider.getValue();
				
				if(Radio_Button.isSelected())
					milk=1;
				else
					milk=0;		
				Student temp_student=new Student(temp,temp_object);
				Controller_Bar temp_bar = new Controller_Bar(progressBar);
				temp_student.setBar(temp_bar);
				temp_student.make_tea(temp_sugar,temp_coffee,temp_tea,temp_kettle,temp_milk,temp_cup, temp_object,temperaure, milk);
								
				String copy = new String();
				copy+=temp_cup.getCup_volume();
				copy+=" ";
				copy+="мл";
				
				lblNewLabel_4.setText(temp_cup.getCup_content());
				lblNewLabel_5.setText(copy);
				
			}			 
		});
		
		Button_2.addActionListener(new ActionListener() 
		{	 
			public void actionPerformed(ActionEvent event) 
			{
				ClearCup(lblNewLabel_4,lblNewLabel_5,progressBar);
			}			 
		});
		

	}
}
