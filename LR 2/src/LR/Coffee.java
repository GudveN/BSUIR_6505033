package LR;

import javax.swing.JOptionPane;
import LR.Cup;


/**
 *����� ��� �������� ����
 *
 */
public class Coffee extends Objectiv
{
	/**
	 * taste-���� ����
	 */
	protected static String taste;
	
	/**
	 * ����������� �����������
	 */
	Coffee()
	{
		
	}
	
	/**
	 * ������� ��� ���������� ������ �����
	 * @param dev-���� ���� ������� ����� ������������
	 */
	void fill_coffee(String dev, Cup temp_cup)
	{
		taste=dev;
		temp_cup.fill_cup(dev, 20.5);
	}
}
