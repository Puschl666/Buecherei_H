/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CTL.GameParameters;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author pusch
 */
public class OptionFrame extends JFrame implements ActionListener {
    private Container contentPane;
    private JRadioButton rbtMulti, rbtSingle, rbtLevel1, rbtLevel2, rbtLevel3;
    private JLabel _Name1, _Name2;
    private JTextField txfName1, txfName2;
    private ButtonGroup btgMode, btgLevel;
    private JPanel pnlLevel, pnlNorth, pnlSouth, pnlCenter, pnlMode;
    private JButton btnOk;
    
    private GameParameters gameParameters;
    
    public OptionFrame(){
       super("Tic Tac Toe Options");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        contentPane = getContentPane();
        rbtMulti = new JRadioButton("Mulitplayer", true);
        rbtSingle = new JRadioButton("Singleplayer");
        rbtLevel1 = new JRadioButton("Level 1", true);
        rbtLevel2 = new JRadioButton("Level 2");
        rbtLevel3 = new JRadioButton("Level 3");
        _Name1 = new JLabel("Name Spieler 1:");
        _Name2 = new JLabel("Name Spieler 2:");
        txfName1 = new JTextField(50);
        txfName2= new JTextField(50);
        btgMode = new ButtonGroup();
        btgLevel = new ButtonGroup();
        pnlLevel = new JPanel();
        pnlMode = new JPanel();
        pnlNorth = new JPanel();
        pnlSouth = new JPanel();
        pnlCenter = new JPanel();
        btnOk = new JButton("OK");
        
        btnOk.addActionListener(this);
        rbtMulti.addActionListener(this);
        rbtSingle.addActionListener(this);
        rbtLevel1.addActionListener(this);
        rbtLevel2.addActionListener(this);
      
        //Groups und Panels befüllen
        btgMode.add(rbtMulti);
        btgMode.add(rbtSingle);
        
        btgLevel.add(rbtLevel1);
        btgLevel.add(rbtLevel2);
        btgLevel.add(rbtLevel3);
        
        pnlLevel.add(rbtLevel1);
        pnlLevel.add(rbtLevel2);
        pnlLevel.add(rbtLevel3);
        
        pnlMode.add(rbtMulti);
        pnlMode.add(rbtSingle);
        
        pnlNorth.add(rbtMulti);
        pnlNorth.add(rbtSingle);
        pnlNorth.add(_Name1);
        pnlNorth.add(txfName1);
        pnlNorth.add(_Name2);
        pnlNorth.add(txfName2);
        
        pnlCenter.add(pnlLevel);
        pnlSouth.add(btnOk);
        
        //Layout für Panels setzen
        contentPane.setLayout(new BorderLayout());
        pnlNorth.setLayout(new GridLayout(6,1));
        pnlSouth.setLayout(new FlowLayout());
        pnlCenter.setLayout(new FlowLayout());
        pnlLevel.setLayout(new GridLayout(1,1));
        pnlMode.setLayout(new GridLayout(2,1));
        
        //Panels auf das Hauptfenster setzen
        contentPane.add(pnlNorth, BorderLayout.NORTH);
        contentPane.add(pnlSouth, BorderLayout.SOUTH);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==btnOk)
        {
            int mode, level=0;
            if(rbtMulti.isSelected()){
                mode=2;
            }
            else{
                mode=1;
                if(rbtLevel2.isSelected()){
                    level=2;
                }
                if(rbtLevel1.isSelected()){
                    level=1;
                }
                else{
                    level=3;
                }
            }
          
            gameParameters = new GameParameters(mode, level, txfName1.getText(), txfName2.getText());
            GameFrame gameFrame = new GameFrame(gameParameters);
            gameFrame.setLocation(500,300);
            gameFrame.setSize(450,250);
            gameFrame.setVisible(true);
        }
        else{
            if(rbtSingle.isSelected())
            {
                contentPane.add(pnlCenter, BorderLayout.CENTER);
                pnlNorth.remove(_Name2);
                pnlNorth.remove(txfName2);
                
            }
            else
            {
                contentPane.remove(pnlCenter);
                pnlNorth.add(_Name2, BorderLayout.SOUTH);
                pnlNorth.add(txfName2, BorderLayout.SOUTH);
            }
            this.validate();
            this.repaint();
        }
    }
   
}
