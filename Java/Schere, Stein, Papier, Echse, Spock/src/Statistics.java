import java.time.LocalDateTime;

public class Statistics {
	private LocalDateTime dateTime;
	private int wBen;
	private int wCom;
	private int erg;
	
	//Konstruktor für´s Speichern
	public Statistics(int wBen, int wCom, int erg)
	{
		this.wBen = wBen;
		this.wCom = wCom;
		this.erg=erg;
		this.dateTime=LocalDateTime.now();
	}
	
	//Konstruktor für´s Laden
	public Statistics(LocalDateTime dateTime, int wBen, int wCom, int erg)
	{
		this.dateTime=dateTime;
		this.wBen=wCom;
		this.wCom=wCom;
		this.erg = erg;
		
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public int getwBen() {
		return wBen;
	}

	public int getwCom() {
		return wCom;
	}

	public int getErg() {
		return erg;
	}

	

}
