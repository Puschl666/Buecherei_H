package Roulette;

public class GameControl 
{
	//random Zahl generieren
	private int randomNum = 1 + (int)(Math.random() * 36);
	public int randomNum()
	{
		return randomNum;
	}
}