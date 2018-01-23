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
public class AI extends Player{
    
    private int level;
    private GameControl gameControl;
    
    public AI (String symbol, int value,int level, GameControl gameControl){
        super("Computer", symbol, value);
        this.level=level;
        this.gameControl=gameControl;
    }
    
    public void turn()
    {
        if(level==2)
        {
            checkWinLose();
        }
        if(level==3){
            cheaten();
        }
        
        randomTurn();
    }
    
    private void randomTurn(){
        Random random = new Random();
            int row, col;
            do{
                row = random.nextInt(3);
                col = random.nextInt(3);
            }
            while(gameControl.getField()[row][col].getValue()!=0);
            gameControl.setFieldPositionAndValidateGameState(row, col);
    }
    
    private void checkWinLose(){
        
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gameControl.getField()[i][j].getValue()==0){
                       if(gameControl.checkFieldSums(2*this.getValue(),i,j)){
                           gameControl.setFieldPositionAndValidateGameState(i, j);
                           return;
                       }
                    }
                }
            }
              for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gameControl.getField()[i][j].getValue()==0){
                       if(gameControl.checkFieldSums(-2*this.getValue(),i,j)){
                           gameControl.setFieldPositionAndValidateGameState(i,j);
                             return;
                       }
                    }
                }
            }
    }
    
    private void cheaten(){        
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gameControl.getField()[i][j].getValue()==0){
                       if(gameControl.checkFieldSums(2*this.getValue(),i,j)){
                           gameControl.setFieldPositionAndValidateGameState(i, j);
                       }
                    }
                }
            }
              for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(gameControl.getField()[i][j].getValue()==0){
                       if(gameControl.checkFieldSums(-2*this.getValue(),i,j)){
                           gameControl.setFieldPositionAndValidateGameState(i, j);
                       }
                    }
                }
            }
    }
}
