package LR;

import LR.Cup;

/**
 * ����� ����������� ������
 */
public class Kettle extends Objectiv
{
	/**
	 * Volume_Kettle-����� �������
	 */
	protected static double volume_kettle=0;
	/**
	 * Temepature-����������� �������
	 */
	protected static double temperature=0;
	Kettle()
	{
		
	}
	/**
	 * ������� ��� ���������� ������� ����� � ��� ������
	 * @param t_Water-����������� ���� �������������� �������������
	 */
	void fill_kettle(int t_Water, Cup temp_cup)
	{
		volume_kettle=300-temp_cup.cup_volume;
		fill_water(t_Water);
		if(temperature==t_Water)
		{
			temp_cup.fill_cup("����", volume_kettle);
		}
	}
	/**
	 * ������� ������� �������
	 * @param t_Water-����������� ���� �������������� �������������
	 */
	void fill_water(int t_Water)
	{
		temperature=t_Water; 
	}
}
