package blackjack;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionFrame extends JDialog implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Container contentPane;
	private JButton btnkarteFordern,btnneuesSpiel,btnKartenHalten;
	private JLabel nameSpieler,nameDealer,punkteSpieler,punkteDealer,dummyCenter2,dummyCenter4;
	private JLabel[] dealerKarte = new JLabel[8],spielerKarte = new JLabel[8];
	private JTextField ergebnis,summeSpieler,summeDealer,ergebnisShort,bank,kontoStand;
	private JPanel pnlCenter,pnlSouth,pnlNorth;
	private GameControl gameControl;
	private int zaehlerSpieler = 0;
	private boolean spielende= false;
        
	public OptionFrame(){
		super();
                setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
                setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                setTitle("BlackJack");
                setResizable(false);
                
		contentPane = getContentPane();
		btnkarteFordern = new JButton("Neue Karte");
		btnneuesSpiel = new JButton("Neues Spiel");
		btnKartenHalten = new JButton("Karten behalten");
		nameDealer = new JLabel("Dealerkarten:");
		nameSpieler = new JLabel("Spielerkarten:");
		punkteSpieler = new JLabel("Punkte Spieler: ");
		punkteDealer = new JLabel("Punkte Dealer: ");
		dummyCenter2 = new JLabel("");
		dummyCenter4 = new JLabel("");

		gameControl = new GameControl();

		spielerKarte[0] = new JLabel(gameControl.karteZiehen(1));
		spielerKarte[1] = new JLabel(gameControl.karteZiehen(1));

		for(int i=2;i<8;i++){
			spielerKarte[i] = new JLabel(gameControl.coverAusgeben());
		}
		dealerKarte[0] = new JLabel(gameControl.karteZiehen(2));
		
		for(int i=1;i<8;i++){
			dealerKarte[i] = new JLabel(gameControl.coverAusgeben());
		}
                
                main_menu.main_menu.setMoney(main_menu.main_menu.getMoney()-10);
                
		ergebnis = new JTextField(150);
		ergebnis.setText("Hier koennte Ihre Werbung stehen");
		ergebnis.setEditable(false);
		ergebnisShort = new JTextField(50);
		ergebnisShort.setText("Ergebnis");
		ergebnisShort.setEditable(false);
		
                 bank = new JTextField(50);
                 bank.setText("Bank: ");
                 bank.setEditable(false);
                 
                 kontoStand = new JTextField(50);
                 kontoStand.setText(main_menu.main_menu.getMoney()+"");
                 kontoStand.setEditable(false);
                
		summeDealer = new JTextField(50);
		summeDealer.setText("0");
		summeDealer.setEditable(false);
		
		summeSpieler = new JTextField(50);
		summeSpieler.setText("0");
		summeSpieler.setEditable(false);

		pnlCenter = new JPanel();
		pnlSouth = new JPanel();
		pnlNorth = new JPanel();

		//Layout für Panels setzen
		contentPane.setLayout(new BorderLayout());
		pnlNorth.setLayout(new GridLayout(2,6));
		pnlSouth.setLayout(new GridLayout(2,6));
		pnlCenter.setLayout(new GridLayout(4, 1));

		pnlSouth.add(nameSpieler);
		pnlNorth.add(nameDealer);
		for(int i=0;i<8;i++){
			pnlNorth.add(dealerKarte[i]);
			pnlSouth.add(spielerKarte[i]);
		}

		pnlCenter.add(btnneuesSpiel);
		pnlCenter.add(btnkarteFordern);
		pnlCenter.add(btnKartenHalten);
		pnlCenter.add(punkteSpieler);
		pnlCenter.add(summeSpieler);
		pnlCenter.add(bank);
		pnlCenter.add(punkteDealer);
		pnlCenter.add(summeDealer);
		pnlCenter.add(kontoStand);
		pnlCenter.add(ergebnis);
		pnlCenter.add(ergebnisShort);

		contentPane.add(pnlNorth, BorderLayout.NORTH);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		contentPane.add(pnlCenter, BorderLayout.CENTER);

		btnkarteFordern.addActionListener(this);
		btnneuesSpiel.addActionListener(this);
		btnKartenHalten.addActionListener(this);
                
		summeSpieler.setText(gameControl.getSummeSpieler()+"");
		summeDealer.setText(gameControl.getSummeDealer()+"");
                
		ergebnisTextAusgabe();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object source = ae.getSource();
		if(source == btnkarteFordern){
			//Die Asse vom Spieler seperieren
			gameControl.setAsZuordnung(1);
			if(!(gameControl.getSummeSpieler()>21)&&!spielende){
			switch(zaehlerSpieler){
			case 0:
				spielerKarte[2].setIcon(gameControl.karteZiehen(1));
				ergebnisTextAusgabe();
				summeSpieler.setText(gameControl.getSummeSpieler()+"");
				zaehlerSpieler++;
				break;
			case 1:
				spielerKarte[3].setIcon(gameControl.karteZiehen(1));
				ergebnisTextAusgabe();
				summeSpieler.setText(gameControl.getSummeSpieler()+"");
				zaehlerSpieler++;
				break;
			case 2:
				spielerKarte[4].setIcon(gameControl.karteZiehen(1));
				ergebnisTextAusgabe();
				summeSpieler.setText(gameControl.getSummeSpieler()+"");
				zaehlerSpieler++;
				break;
			case 3:
				spielerKarte[5].setIcon(gameControl.karteZiehen(1));
				ergebnisTextAusgabe();
				summeSpieler.setText(gameControl.getSummeSpieler()+"");
				zaehlerSpieler++;
				break;
			}
			}
		}
		if(source == btnneuesSpiel){
                    if(main_menu.main_menu.getMoney()>=10){
                        main_menu.main_menu.setMoney(main_menu.main_menu.getMoney()-10);
			gameControl.kartenLoeschen();
			gameControl.resetSummen();
			gameControl.resetAsZaehler();
			gameControl.setEnde(0);
			spielerKarte[0].setIcon(gameControl.karteZiehen(1));
			spielerKarte[1].setIcon(gameControl.karteZiehen(1));
			dealerKarte[0].setIcon(gameControl.karteZiehen(2));
			dealerKarte[1].setIcon(gameControl.coverAusgeben());
			for(int i=2;i<8;i++){
				spielerKarte[i].setIcon(gameControl.coverAusgeben());
				dealerKarte[i].setIcon(gameControl.coverAusgeben());
			}
			summeSpieler.setText(gameControl.getSummeSpieler()+"");
			summeDealer.setText(gameControl.getSummeDealer()+"");
			spielende = false;
			if(gameControl.getEnde()==3){
				ergebnisTextAusgabe();
				gameControl.setEnde(0);
			}
			else{
			zaehlerSpieler = 0;
			ergebnis.setText("Hier koennte Ihre Werbung stehen");
			ergebnisShort.setText("Ergebnis");
			}
                        kontoStand.setText(main_menu.main_menu.getMoney()+"");
                    }
                    else{
                        JOptionPane.showConfirmDialog(null, "Sie haben nicht genügend Geld", "No Money",JOptionPane.CLOSED_OPTION);
                        dispose();
                    }
		}
		if(source == btnKartenHalten){
			if(!spielende){
                            spielende=true;
			//Die Asse vom Dealer seperieren
                            gameControl.setAsZuordnung(2);
                            int ende = 0;
                            for(int i=1;i<8;i++){
				dealerKarte[i].setIcon(gameControl.karteZiehen(2));
				ergebnisTextAusgabe();
				ende=gameControl.getEnde();
				if(ende==2||ende==4||ende==5||ende==6||ende==7){
					i=8;
				}
				summeDealer.setText(gameControl.getSummeDealer()+"");
                            }
			}
		}
	}
	public void ergebnisTextAusgabe(){
		int ende = gameControl.getEnde();
		switch(ende){
		case 0: 
				break;
		case 1:
				ergebnis.setText("Ihre Karten sind ueber 21");
				ergebnisShort.setText("Sie verlieren.");
				spielende = true;
				break;
		case 2: 
				ergebnis.setText("Der Dealer ist ueber 21.");
				ergebnisShort.setText("Sie gewinnen!");
				spielende = true;
                                main_menu.main_menu.setMoney(main_menu.main_menu.getMoney()+20);
                                kontoStand.setText(main_menu.main_menu.getMoney()+"");
				break;
		case 3:
				ergebnis.setText("Black Jack! Glueckwunsch!");
				ergebnisShort.setText("Sie gewinnen!");
				spielende = true;
                                main_menu.main_menu.setMoney(main_menu.main_menu.getMoney()+25);
                                kontoStand.setText(main_menu.main_menu.getMoney()+"");
				break;
		case 4: 
				ergebnis.setText("Der Dealer hat Black Jack.");
				ergebnisShort.setText("Sie verlieren.");
				spielende = true;
				break;
		case 5:
				ergebnis.setText("Der Dealer hat bessere Karten");
				ergebnisShort.setText("Sie verlieren.");
				spielende = true;
				break;
		case 6:
				ergebnis.setText("Sie haben die besseren Karten");
				ergebnisShort.setText("Sie gewinnen!");
				spielende = true;
                                main_menu.main_menu.setMoney(main_menu.main_menu.getMoney()+20);
                                kontoStand.setText(main_menu.main_menu.getMoney()+"");
				break;
		case 7:
				ergebnis.setText("Beide Karten sind gleich gut.");
				ergebnisShort.setText("Sie verlieren.");
				spielende = true;
				break;
		}
	}
}