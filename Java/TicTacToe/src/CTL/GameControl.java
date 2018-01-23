/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTL;

import java.util.Random;

/**
 *
 * @author pusch
 */
public class GameControl {
    private GameParameters gameParameters;
    private FieldElement [][] field;
    private Player player1;
    private Player player2;
    private Player actPlayer;
    private int gameState;
    
    public GameControl(GameParameters gameParameters){
        this.gameParameters=gameParameters;
        
        //Array + benötigte Objekte erzeugen
        field = new FieldElement[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                field[i][j] = new FieldElement();
            }
        }
        
        String name;
        name=checkPlayerName(1);
        player1 = new Player(name, "X", 1);   
        
        //Spieler 2
       if(gameParameters.getMode()==2){
            name=checkPlayerName(2);
            player2 = new Player(name, "O", -1);
       }
       else{
           player2=new AI("O",-1, gameParameters.getLevel(), this);
       }
       
       //Zufälligen Spieler
       Random random = new Random();
       if(random.nextInt(2)==1){
            actPlayer=player1;
       } 
       else{
           actPlayer=player2;
       }
        
        gameState=0;
    }
    public String checkPlayerName(int player){
        String name="";
          if(player==1 && gameParameters.getName1().isEmpty()){
                name="Spieler 1";
            }
          if(player==2 && gameParameters.getName2().isEmpty()){
                name="Spieler 2";
          }
          return name;
    }
    
    public void setFieldPositionAndValidateGameState(int row, int col){
        //aktuellen Spieler auf das Feldelement setzen
        getField()[row][col].setFieldPosition(getActPlayer());
        
        //Spielende prüfen
        validateGameState();
        
        //Spieler wechseln wenn nicht Spielende
        if(getGameState()==0){
            switchActPlayer();
            if(gameParameters.getMode()==1 && actPlayer instanceof AI){
                ((AI)actPlayer).turn();
            }
        }
    }
    
    private void validateGameState(){
        checkFieldSums(3);
        if(getGameState()!=3){
            
            //Spieler 2 gewonnen
            checkFieldSums(-3);
            if(getGameState()!=-3){
                //remis
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        if(getField()[i][j].getValue()==0){
                            gameState=0;
                            return;
                        }
                    }
                }
                gameState=1;
                return;
            }
        }
        
    }
    
    boolean checkFieldSums(int sum, int row, int col){
        int summe;
        boolean result = false;
        //Zeilensummer
        summe=0;
        for(int i=0;i<3;i++){
            summe=summe + field[row][i].getValue();
        }
        if(summe==sum){
            result=true;
        }
        //Spaltensumme
        summe=0;
        for(int i=0;i<3;i++){
            summe=summe+field[i][col].getValue();
        }
        if(summe==sum){
            result=true;
        }
        
        //Diagonale
        if(col==row)
        {
            summe=0;
            for(int i=0;i<3;i++){
                summe=summe+field[i][i].getValue();
            }
            if(summe==sum){
                result=true;
            }
        }
        if(col==2&&row==0||col==0&&row==2||col==1&&row==1){
            summe=0;
            for(int i=0;i<3;i++){
                summe=summe+field[i][2-i].getValue();
            }
            if(summe==sum){
                result = true;
            }
        }
        
        return result;
    }
    
    private void checkFieldSums(int sum){
        int summe;
        //Zeilensummen
        for(int i=0;i<3;i++){
            summe=0;
            for(int j=0;j<3;j++){
                summe=summe+getField()[i][j].getValue();
            }
            if(sum==3||sum==-3){
                
                if(summe==sum){
                    gameState=summe;
                    return;
                }
            
            }
        }
         //Spaltesummen
        for(int i=0;i<3;i++){
            summe=0;
            for(int j=0;j<3;j++){
                summe=summe+getField()[j][i].getValue();
            }
            if(sum==3||sum==-3){
                
                if(summe==sum){
                    gameState=summe;
                    return;
                }
            
            }
        }
        //Diagonalsummen
        summe=0;
        for(int i=0;i<3;i++){
            summe=summe+getField()[i][i].getValue();
        }
         if(sum==3||sum==-3){
                
                if(summe==sum){
                    gameState=summe;
                    return;
                }
            
            }
        summe=0;
        for(int i=0;i<3;i++){
            summe=summe+getField()[i][2-i].getValue();
        }
         if(sum==3||sum==-3){
                
                if(summe==sum){
                    gameState=summe;
                    return;
                }
            
            }
    }
    
    private void switchActPlayer(){
        if(getActPlayer()==player1){
            actPlayer=player2;
        }
        else{
            actPlayer=player1;
        }
    }

    public FieldElement[][] getField() {
        return field;
    }

    public Player getActPlayer() {
        return actPlayer;
    }

    public int getGameState() {
        return gameState;
    }
    
    public boolean konamiCode(){
        boolean result = false;
        
        return result;
    }
}
