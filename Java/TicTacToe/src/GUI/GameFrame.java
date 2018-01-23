/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CTL.GameControl;
import CTL.GameParameters;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author pusch
 */
public class GameFrame extends JDialog implements ActionListener{

   private Container contentPane;
   private ArrayList<TTTButton> buttonList = new ArrayList<TTTButton>();
   private GameControl gameControl;

   public GameFrame(GameParameters gameParameters)
   {
       super();
       setTitle("Tic Tac Toe");
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setModalityType(ModalityType.APPLICATION_MODAL);
       
       
       contentPane = getContentPane();
       contentPane.setLayout(new GridLayout(3,3));
       
       //Buttons erzeugen
       for(int row=0;row<3;row++)
       {
           for(int col=0;col<3;col++){
               TTTButton btn = new TTTButton(col, row);
               btn.setName("btn"+String.valueOf(row)+String.valueOf(col));
               btn.setFont(new Font("Dialog",1,100));
               btn.setBackground(Color.white);
               btn.addActionListener(this);
               contentPane.add(btn);
               buttonList.add(btn);
           }
       }
       //GameControl erzeugen
       gameControl=new GameControl(gameParameters);
   }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        gameControl.setFieldPositionAndValidateGameState(((TTTButton)source).getRow(),((TTTButton)source).getCol());
        refreshFrame();
    }
    
    private void refreshFrame(){
        for(TTTButton btn : buttonList){
            btn.setText(gameControl.getField()[btn.getRow()][btn.getCol()].getSymbol());
            btn.setEnabled(gameControl.getField()[btn.getRow()][btn.getCol()].isEnabled());
        }
        
        //Ende erreicht?
        if(gameControl.getGameState()!=0){
            String ergebnis="";
            switch(gameControl.getGameState())
            {
                case 1: ergebnis="remis";
                        break;
                case 3:
                case -3:ergebnis=gameControl.getActPlayer().getName()+ " hat gewonnen";
                        break;
            }
            JOptionPane.showConfirmDialog(null,ergebnis, "Spielende", JOptionPane.CLOSED_OPTION);
            this.dispose();
        }
    }
}
