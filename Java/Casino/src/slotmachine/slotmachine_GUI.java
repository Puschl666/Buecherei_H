package slotmachine;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author pusch
 */
public class slotmachine_GUI extends JDialog implements ActionListener {
    private Container contentPane;
    private JButton  trigger;
    private JLabel lblMoney, roller1, roller2, roller3;
    private int count;
    private final slotmachine_logic logic;
    private String imagepath;
    private String roller1Value="seven", roller2Value="seven", roller3Value="seven";
    private final ImageIcon[] imageArr = new ImageIcon[9];
    private final ImageIcon hebel1 = new ImageIcon("src\\resources\\Slotmachine\\hebel1.png"), hebel2= new ImageIcon("src\\resources\\Slotmachine\\hebel2.png");      
    //Konstruktor Einarmiger Bandit Oberfläche
    public slotmachine_GUI(int money2){
       super();
       //Instanz der Logikklasse erstellen
             
       setTitle("Slotmachine");
       setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
       setModalityType(ModalityType.APPLICATION_MODAL);
       setResizable(false);
       
       logic = new slotmachine_logic();
       createImageArray();
       initializeLayout();
    }
    private void initializeLayout(){
       setContentPane(new JLabel(new ImageIcon("src\\resources\\Slotmachine\\slotmachine.jpg")));
       contentPane = getContentPane();
       
       lblMoney = new JLabel("Guthaben: "+ String.valueOf(main_menu.main_menu.getMoney()));
       roller1 = new JLabel("");
       roller2 = new JLabel("");
       roller3 = new JLabel("");
       roller1 = new JLabel(new ImageIcon("src\\resources\\Slotmachine\\seven.png"));
       roller2 = new JLabel(new ImageIcon("src\\resources\\Slotmachine\\seven.png"));
       roller3 = new JLabel(new ImageIcon("src\\resources\\Slotmachine\\seven.png"));
       trigger=new JButton();
       trigger.setIcon(hebel1);
       
       contentPane.add(lblMoney);
       contentPane.add(roller1);
       contentPane.add(roller2);
       contentPane.add(roller3);
       contentPane.add(trigger);
       
       lblMoney.setBounds(0, 0, 200, 20);
       roller1.setBounds(130, 235, 118, 145);
       roller2.setBounds(260,235, 118, 145);
       roller3.setBounds(395, 235, 118, 145);
       trigger.setBounds(530, 70, 70, 295);
       trigger.addActionListener(this);
    }
    private void createImageArray(){
     //Befüllt das ImageArray mit den Bildern
         for(int i=0;i<9;i++){
            switch(i){
                case 0: imagepath = "src\\resources\\Slotmachine\\cherry.png"; break;
                case 1: imagepath = "src\\resources\\Slotmachine\\strawberry.png"; break;
                case 2: imagepath = "src\\resources\\Slotmachine\\citrone.png"; break;
                case 3: imagepath = "src\\resources\\Slotmachine\\orange.png"; break;
                case 4: imagepath = "src\\resources\\Slotmachine\\prune.png"; break;
                case 5: imagepath = "src\\resources\\Slotmachine\\grape.png"; break;
                case 6: imagepath = "src\\resources\\Slotmachine\\bell.png"; break;
                case 7: imagepath = "src\\resources\\Slotmachine\\melone.png"; break;
                case 8: imagepath = "src\\resources\\Slotmachine\\seven.png"; break;
            }
             imageArr[i] = new ImageIcon(imagepath);
        }
}
     @Override       
    public void actionPerformed(ActionEvent e) {
        if(count<1){                         //Hebel wird gezogen und das Bild wir auf Hebel gezogen gesetzt
             trigger.setIcon(hebel2);
             main_menu.main_menu.setMoney(main_menu.main_menu.getMoney() - 10);      //Zieht den gesetzen Betrag(immer 10) vom Guthaben ab
             count=1;                           //Wird zum feststellen der Hebelposition genutzt
        }
        else{       //Hebel wird "losgelassen"
            roller1Value=logic.rolling();
            roller2Value=logic.rolling();
            roller3Value=logic.rolling();
           logic.checkWin(roller1Value, roller2Value, roller3Value);
           refreshFrame();              //Erst beim "loslassen" müssen die Rollen aktualisiert werden
        }
    }
    //Aktualisiert das Frame
    private void refreshFrame(){
         lblMoney.setText("Guthaben: " + String.valueOf(main_menu.main_menu.getMoney()));           //Zeigt das aktuelle Guthaben an
         getImage();                                                                                //Holt Bilder für die Rollen
         trigger.setIcon(hebel1);                                                                   //Hebel auf Ausgangsposition
         count=0;                                                                                  //Setzt Hebelcounter zurück
         if(logic.checkLose()){
            dispose();
         }
    }
    //Funktion, die die Bilder für die Rollen liefert
    private void getImage(){
        ImageIcon result = imageArr[0];
                switch(roller1Value){
                    case "cherry":      result = imageArr[0]; break;
                    case "strawberry":  result = imageArr[1]; break;
                    case "citrone":     result = imageArr[2]; break;
                    case "orange":      result = imageArr[3]; break;
                    case "prune":       result = imageArr[4]; break;
                    case "grape":       result = imageArr[5]; break;
                    case "bell":        result = imageArr[6]; break;
                    case "melone":      result = imageArr[7]; break;
                    case "seven":       result = imageArr[8]; break;
                }      roller1.setIcon(result);
                switch(roller2Value){
                    case "cherry":      result = imageArr[0]; break;
                    case "strawberry":  result = imageArr[1]; break;
                    case "citrone":     result = imageArr[2]; break;
                    case "orange":      result = imageArr[3]; break;
                    case "prune":       result = imageArr[4]; break;
                    case "grape":       result = imageArr[5]; break;
                    case "bell":        result = imageArr[6]; break;
                    case "melone":      result = imageArr[7]; break;
                    case "seven":       result = imageArr[8]; break;
                }  roller2.setIcon(result);
                switch(roller3Value){
                    case "cherry":      result = imageArr[0]; break;
                    case "strawberry":  result = imageArr[1]; break;
                    case "citrone":     result = imageArr[2]; break;
                    case "orange":      result = imageArr[3]; break;
                    case "prune":       result = imageArr[4]; break;
                    case "grape":       result = imageArr[5]; break;
                    case "bell":        result = imageArr[6]; break;
                    case "melone":      result = imageArr[7]; break;
                    case "seven":       result = imageArr[8]; break;
                }   roller3.setIcon(result);
    }
}