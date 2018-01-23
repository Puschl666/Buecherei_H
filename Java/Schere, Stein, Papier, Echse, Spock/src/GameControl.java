import java.util.ArrayList;
import java.util.Random;

public class GameControl {
	private int wCom;
	private int erg;
	private Random zufall;
	private ArrayList statList ;
	private ModelFile StatisticModel;
	private int wBen;
	
	public GameControl()
	{
		zufall = new Random();
		wCom = 0;
		erg=42;
		//Erzeugen der ArrayList
		statList = new ArrayList();
		StatisticModel = new ModelFile();
		//Daten aus Datei laden...
		StatisticModel.load();
	}
	public void spielende(){
		StatisticModel.save(statList);
	}
	
	public int spielzug(int eingabe){
		wBen = eingabe;
		wCom = zufall.nextInt(5)+1;
		erg = (int)(wBen==wCom ? 0 : Math.pow(-1, (wBen - wCom + 5) % 5));
		//Statistikobjekt erzeugen
		Statistics stat = new Statistics(wBen, wCom, erg);
		//der ArrayList hinzufügen
		statList.add(stat);
		return erg;
	}
	public int getwCom()
	{
		return wCom;
	}
	public ArrayList getArrayList(){
		return statList;
	}
}
