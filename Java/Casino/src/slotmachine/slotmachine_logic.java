package slotmachine;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author pusch
 */
public class slotmachine_logic {
    private int win;
    private int winFactor;
    
    public slotmachine_logic(){
        super();
    }
    //Funktion um einen zufälligen Wert für die Rolle zu ermitteln
    public String rolling(){
        Random rand = new Random();
        int zufall = rand.nextInt(8)+1;     //Zufällige Zahl generieren, anhand derer der Wert für die Rolle ermittelt wird
        String result="";
        switch(zufall){ //Gibt den Wert für die Rolle, anhand der vorher generierten Zufallszahl, zurück
            case 0: result = "cherry";
                    break;
            case 1: result = "strawberry";
                    break;
            case 2: result = "citrone";
                    break;
            case 3: result = "orange";
                    break;
            case 4: result = "prune";
                    break;
            case 5: result = "grape";
                    break;
            case 6: result = "bell";
                    break;
            case 7: result = "melone";
                    break;
            case 8: result = "seven";
                    break;
        }
        return result;
    }
    //Prüft nach jedem Spiel, ob gewonnen wurde
    public void checkWin(String rollerValue1, String rollerValue2, String rollerValue3){
        winFactor = 0;
        if(rollerValue1.equals(rollerValue2) && rollerValue1.equals(rollerValue3)){ //Nur wenn alle 3 Rollen, den gleichen Wert haben, hat man gewonnen
            switch(rollerValue1){
                case "cherry":      winFactor=1; break;
                case "strawberry":  winFactor=2; break;
                case "citrone":     winFactor=3; break;
                case "orange":      winFactor=4; break;
                case "prune":       winFactor=5; break;
                case "grape":       winFactor=6; break;
                case "bell":        winFactor=7; break;
                case "melone":      winFactor=8; break;
                case "seven":       winFactor=9; break;
            }
            if (winFactor > 0){
                calcWin();
            }
        }  
    }    
    //Berechnet den Gewinn und aktualisiert das Guthaben
    private void calcWin(){
        win= 10 *winFactor;  
        main_menu.main_menu.setMoney(main_menu.main_menu.getMoney() + win);
    }
    public boolean checkLose(){
        boolean result = false;
        if(main_menu.main_menu.getMoney()<10){                                                      //Prüft ob Geld übrig ist für ein neues Spiel
            JOptionPane.showConfirmDialog(null,"Sie haben leider kein Guthaben mehr", "Spielende", JOptionPane.CLOSED_OPTION);
            result = true;
        }
        return result;
    }
}