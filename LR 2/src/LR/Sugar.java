package LR;

import javax.swing.JOptionPane;

import LR.Cup;

/**
 * ����� ��� ���������� ������
 */
public class Sugar extends Objectiv
{
	/**
	 * ������ ��� �������� ������ �� �����
	 * @param s-������ ������� ����� ���������
	 * @return	1-����� 0-������
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
	Sugar()
	{
		
	}
	/**
	 * ������� ��� ���������� ������
	 * @param temp-���������� ������
	 */
	void fill_sugar(String temp, Cup temp_cup)
	{
		if(isDigit(temp)==1)
		{
			if(Integer.parseInt(temp)*30>=300)
			{
				JOptionPane.showMessageDialog(null,"���� ������� ������� ������� ���������� ������","������",JOptionPane.ERROR_MESSAGE);
				temp_cup.fill_cup("�����", 60);
			}
			else
			{
				temp_cup.fill_cup("�����", 30*Integer.parseInt(temp));
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null,"���� ������� �������� ����������","������",JOptionPane.ERROR_MESSAGE);
			temp_cup.fill_cup("�����", 60);
		}
	}
}
