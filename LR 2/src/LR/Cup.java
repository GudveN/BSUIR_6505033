package LR;

import javax.swing.JOptionPane;

/**
 *����� ��� �������� ����������� �����
 */
public class Cup extends Objectiv
{
	/**
	 * Cup_Volume-����� �����
	 */
	protected static double cup_volume=0;
	/**
	 * Cup_Content-���������� �����
	 */
	protected static String cup_content=new String();
	Cup()
	{
		
	}
	/**
	 * ������� ��� ���������� ����� ���-����
	 * @param string-���������� ��� ����� ���������
	 * @param volume-�����
	 */
	void fill_cup(String string, double volume)
	{
		cup_volume+=volume;
		cup_content+=" ";
		cup_content+=string;
		mass+=volume*0.998;
	}
}
