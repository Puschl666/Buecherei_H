package main_menu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author pusch
 */
public class main_menu extends JDialog implements ActionListener{
    private Container contentPane;
    private JButton startSlotMachine,startBlackJack,startRoulette ;
    private JLabel slot_machine, black_jack, roulette, lblMoney,title;
    private static int money = 5000;
 
    // Konstruktor für Main Menü
    public main_menu(){
       super();
        
       setTitle("Casino");
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       setResizable(false);
       
       initializeLayout();
    }
    private void initializeLayout(){
       setContentPane(new JLabel(new ImageIcon("src\\resources\\Main_Menu\\Casino.jpg")));
       contentPane = getContentPane();
          
       Color txtColor = new Color (255, 0, 0);
       Font txtFont = new Font("Courier New", 1, 20); //Initializes the font
       
       title = new JLabel(new ImageIcon("src\\resources\\Main_Menu\\Logo.png"));
       lblMoney = new JLabel("Guthaben: "+ String.valueOf(getMoney())); 
       lblMoney.setFont(txtFont);
       lblMoney.setForeground(txtColor);
       lblMoney.setSize(150, 150);
       slot_machine = new JLabel("");
       roulette = new JLabel("");
       black_jack = new JLabel("");
       slot_machine = new JLabel(new ImageIcon("src\\resources\\Main_Menu\\slotmachine.jpg"));
       roulette = new JLabel(new ImageIcon("src\\resources\\Main_Menu\\roulette.jpg"));
       black_jack = new JLabel(new ImageIcon("src\\resources\\Main_Menu\\blackjack.jpg"));
       startSlotMachine=new JButton("Einarmiger Bandit");
       startRoulette=new JButton("Roulette");
       startBlackJack=new JButton("Black Jack");
       
       contentPane.add(title);
       contentPane.add(lblMoney);
       contentPane.add(slot_machine);
       contentPane.add(roulette);
       contentPane.add(black_jack);
       contentPane.add(startSlotMachine);
       contentPane.add(startRoulette);
       contentPane.add(startBlackJack);
       
       title.setBounds(150,0,500,200);
       lblMoney.setBounds(0,0,200,20);
       slot_machine.setBounds(50, 200, 200, 200);
       roulette.setBounds(280,200, 200, 200);
       black_jack.setBounds(520, 200, 200, 200);
       startSlotMachine.setBounds(70, 400, 150, 30);
       startSlotMachine.addActionListener(this);
       startRoulette.setBounds(310, 400, 150, 30);
       startRoulette.addActionListener(this);
       startBlackJack.setBounds(550, 400, 150, 30);
       startBlackJack.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
            //Source abfragen
            if (source == startSlotMachine){        //Starte Einarmiger Bandit
                if(getMoney()>=10){
                    slotmachine.slotmachine_GUI gameFrame = new slotmachine.slotmachine_GUI(getMoney());
                    gameFrame.setLocation(500,300);
                    gameFrame.setSize(650,500);
                    gameFrame.setVisible(true);
                  }
                else{
                    JOptionPane.showConfirmDialog(null, "Sie haben nicht genügend Geld", "No Money", JOptionPane.CLOSED_OPTION);
                 }
            }
            else if(source == startBlackJack){      //Starte BlackJack
                if(getMoney()>=10){
                    blackjack.OptionFrame gameFrame = new blackjack.OptionFrame();
                    gameFrame.setLocation(500,300);
                    gameFrame.setSize(600,900);
                    gameFrame.setVisible(true);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Sie haben nicht genügend Geld", "No Money", JOptionPane.CLOSED_OPTION);
                 }
            }
            else{
                Roulette.OptionFrame optionFrame = new Roulette.OptionFrame();
		optionFrame .setLocation(300,300);
		optionFrame.setSize(1060,430);
		optionFrame.setVisible(true);
            }   
            refreshFrame();         //Nach Spielende wird das Guthaben im Hauptmenü aktualisiert
    }
    private void refreshFrame(){
         lblMoney.setText("Guthaben: " + String.valueOf(getMoney()));
     }
    public static int getMoney() {
        return money;
    }
    public static void setMoney(int aMoney) {
        money = aMoney;
    }
}