package LR;

import java.lang.String;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import LR.Sugar;
import LR.Coffee;
import LR.Kettle;

/**
 * ����� �������
 */
public class Student 
{
	/**
	 * ��� ��������
	 */
	protected static String Name;
	protected Objectiv object;

	Student(String temp, Objectiv temp_object)
	{
		Name=new String(temp);
		object=temp_object;
	}
	void SetObject(Objectiv temp_object)
	{
		object=temp_object;
	}
	
	/**
	 * ������� ��� �������� ����
	 * @param frame-������� ����
	 * @param progressbar
	 * @param T_Water-����������� ���� �������������� �������������
	 * @param sugar-���������� ������
	 * @param type_coffee-��� ����
	 */
	void make_coffee(JFrame frame,JProgressBar progressbar,int T_Water, String sugar, String type_coffee,Sugar temp_sugar,Coffee temp_coffee,Kettle temp_kettle, Cup temp_cup)
	{
		temp_sugar.fill_sugar(sugar,temp_cup);
		
		JOptionPane.showMessageDialog(null,"����� ��������","������",JOptionPane.INFORMATION_MESSAGE);
		progressbar.setValue(33);
		
		temp_coffee.fill_coffee(type_coffee,temp_cup);
		
		JOptionPane.showMessageDialog(null,"���� ��������","������",JOptionPane.INFORMATION_MESSAGE);
		progressbar.setValue(66);
		
		temp_kettle.fill_kettle(T_Water,temp_cup);
		
		JOptionPane.showMessageDialog(null,"���� ���������","������",JOptionPane.INFORMATION_MESSAGE);
		progressbar.setValue(100);
	}
}
