import java.util.Random;

public class Spielsteuerung {
	private int zufallszahl;
	private int anzVersuche;
	private boolean spielende;
	private Random zufall;
	
	public Spielsteuerung()
	{
		// Zufallsobjekt erzeugen
		zufall=new Random();
		//neus Spiel
		neuesSpiel();
	}
	
	public void neuesSpiel()
	{
		//Zufallszahl erzeugen
		zufallszahl=zufall.nextInt(99)+1;
		//Versuche initialisieren
		setAnzVersuche(1);
		//Spielende
		setSpielende(false);
	}
	public int spielZug(int zahl){
		//ergebnis = 0 richtig
		//ergebnis = 1 zu groﬂ
		//ergebnis =-1 zu klein
		
		if(zahl==zufallszahl)
		{
			setSpielende(true);
			return 0;
		}
		else
		{
			setAnzVersuche(getAnzVersuche() + 1);
			if(zahl<zufallszahl)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	}

	public int getAnzVersuche() {
		return anzVersuche;
	}

	public void setAnzVersuche(int anzVersuche) {
		this.anzVersuche = anzVersuche;
	}

	public boolean isSpielende() {
		return spielende;
	}

	public void setSpielende(boolean spielende) {
		this.spielende = spielende;
	}
	
}
