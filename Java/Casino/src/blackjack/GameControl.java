package blackjack;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GameControl {
	private Karte[] stapel = new Karte[52];
	private int summeSpieler ,summeDealer,ende;
	private int asZuordnung = 0,asZaehlerSpieler=0,asZaehlerDealer=0;

 public GameControl() {
	for(int i=0;i<52;i++){
		stapel[i] = new Karte();
		stapel[i].kartennummer = i;
		stapel[i].zuordnung = 0;
		stapel[i].wert = kartenWertBestimmen(i);
	}	
}	
	public int getSummeSpieler() {
	return summeSpieler;
	}
	public void setAsZuordnung(int aszuordnung){
		asZuordnung = aszuordnung;
	}
	public int getSummeDealer() {
	return summeDealer;
	}	
	public int getEnde() {
		return ende;
	}
	public void setEnde(int ende) {
		this.ende = ende;
	}
	public int kartenWertBestimmen(int zwspeicher){
		int kartenWert=0;
		if(zwspeicher==0||zwspeicher==13||zwspeicher==26||zwspeicher==39){
			kartenWert = 11;
		}
		else if(zwspeicher>=1&&zwspeicher<=4||zwspeicher>=14&&zwspeicher<=17||zwspeicher>=27&&zwspeicher<=30||zwspeicher>=40&&zwspeicher<=43){
			kartenWert = 10;
		}
		else if(zwspeicher==5||zwspeicher==18||zwspeicher==31||zwspeicher==44){
			kartenWert = 9;
		}
		else if(zwspeicher==6||zwspeicher==19||zwspeicher==32||zwspeicher==45){
			kartenWert = 8;
		}
		else if(zwspeicher==7||zwspeicher==20||zwspeicher==33||zwspeicher==46){
			kartenWert = 7;
		}
		else if(zwspeicher==8||zwspeicher==21||zwspeicher==34||zwspeicher==47){
			kartenWert = 6;
		}
		else if(zwspeicher==9||zwspeicher==22||zwspeicher==35||zwspeicher==48){
			kartenWert = 5;
		}
		else if(zwspeicher==10||zwspeicher==23||zwspeicher==36||zwspeicher==49){
			kartenWert = 4;		
		}
		else if(zwspeicher==11||zwspeicher==24||zwspeicher==37||zwspeicher==50){
			kartenWert = 3;
		}
		else if(zwspeicher==12||zwspeicher==25||zwspeicher==38||zwspeicher==51){
			kartenWert = 2;
		}
		return kartenWert;
	}
	public int randomNumber(){
		int i;
		do{
			i = (int)(Math.random()*(52));
		}while(stapel[i].zuordnung != 0);
		
		return i;
		}
	public void summeBerechnen(int zuordnung) {
		int summe = 0;
		for(int i=0;i<52;i++){
			if(stapel[i].zuordnung==zuordnung){				
				summe+=stapel[i].wert;
			}
		}
		if(zuordnung==1){
			summeSpieler = summe;
		}
		else if(zuordnung==2){
			summeDealer = summe;
		}
	}
	public void summeVergleichen(int zuordnung){
		int summe=0;
		if(zuordnung==1){
			summe=summeSpieler;
		}
		else if(zuordnung==2){
			summe=summeDealer;
			if(summe>16&&summe<21){
				if(summeDealer>summeSpieler){
					ende = 5;
				}
				else if(summeDealer<summeSpieler){
					ende = 6;
				}
				else if(summeDealer==summeSpieler){
					ende = 7;
				}
			}
		}
		if(summe>21 ){
			if(asZaehlerSpieler>0&&asZuordnung==1){
				summe-=10;
				asZaehlerSpieler--;
				if(stapel[0].wert == 11 && stapel[0].zuordnung==1){
					stapel[0].wert = 1; 
				}
				else if(stapel[13].wert == 11 && stapel[13].zuordnung==1){
					stapel[13].wert = 1; 
				}
				else if(stapel[26].wert == 11 && stapel[26].zuordnung==1){
					stapel[26].wert = 1; 
				}
				else if(stapel[39].wert == 11 && stapel[39].zuordnung==1){
					stapel[39].wert = 1; 
				}
				summeSpieler = summe;
				}
			else if(asZaehlerDealer>0&&asZuordnung==2){
				summe-=10;
				asZaehlerDealer--;
				if(stapel[0].wert == 11 && stapel[0].zuordnung==2){
					stapel[0].wert = 1; 
				}
				else if(stapel[13].wert == 11 && stapel[13].zuordnung==2){
					stapel[13].wert = 1; 
				}
				else if(stapel[26].wert == 11 && stapel[26].zuordnung==2){
					stapel[26].wert = 1; 
				}
				else if(stapel[39].wert == 11 && stapel[39].zuordnung==2){
					stapel[39].wert = 1; 
				}
				summeDealer = summe;
				}
			}		
		if(summe>21){
			if(zuordnung==1){
				ende = 1;
			}
			else if(zuordnung==2){
				ende = 2;
			}
		}
		if(summe==21){
			if(zuordnung==1){
				ende = 3;
			}
			else if(zuordnung==2){
				ende = 4;
			}
		}
}
	public void sonderFallAs(int i,int zuordnung){
		if(stapel[i].wert==11){
			if(zuordnung==1){
				asZaehlerSpieler++;
			}
			else if(zuordnung==2){
				asZaehlerDealer++;
			}
		}
	}
	public ImageIcon karteZiehen(int zuordnung){
		int i = randomNumber();
		sonderFallAs(i,zuordnung);
		stapel[i].zuordnung = zuordnung;
		summeBerechnen(zuordnung);
		summeVergleichen(zuordnung);
		return karteAnzeigen(i);
	}
	public void kartenLoeschen(){
		for(int i=0;i<52;i++){
			stapel[i].kartennummer = i;
			stapel[i].zuordnung = 0;
			stapel[i].wert = kartenWertBestimmen(i);
		}	
	}
	public void resetAsZaehler(){
		asZaehlerDealer = 0;
		asZaehlerSpieler = 0;
	}
	public void resetSummen(){
		summeDealer = 0;
		summeSpieler = 0;
	}
	private ImageIcon karteAnzeigen(int random) {
		int farbe = 0;
		String kartenFarbe="";
		int zufallszahl = 0;
		if(random>=0&&random<=12){
			farbe = 1;
			zufallszahl = random;
		}
		else if(random>=13&&random<=25){
			farbe = 2;
			zufallszahl = random-13;			
		}
		else if(random>=26&&random<=38){
			farbe = 3;
			zufallszahl = random-26;
		}
		else if(random>=39&&random<=51){
			farbe =4;
			zufallszahl = random-39;
		}
		switch(farbe){
		
		case 1:
			kartenFarbe = "herz";
			break;
		case 2:
			kartenFarbe = "karo";
			break;
		case 3:
			kartenFarbe = "kreuz";
			break;
		case 4:
			kartenFarbe = "pik";
			break;
		}
		return kartenAusgeben(kartenFarbe, zufallszahl);
	}
	public ImageIcon kartenAusgeben(String farbe,int zahl){
        StringBuilder bildPfadHilfe = new StringBuilder();
        bildPfadHilfe.append("src/resources/BlackJack/");
        bildPfadHilfe.append(farbe);
        bildPfadHilfe.append(zahl);
        bildPfadHilfe.append(".gif");
        String bildPfad = bildPfadHilfe.toString();    
		Image image1 = Toolkit.getDefaultToolkit().getImage(bildPfad);
        ImageIcon picture1 = new ImageIcon(image1);
        return picture1;
	}
	public ImageIcon coverAusgeben(){
		Image image = Toolkit.getDefaultToolkit().getImage("src/resources/BlackJack/cover.gif");
                ImageIcon picture = new ImageIcon(image);
		return picture;
	}
}
