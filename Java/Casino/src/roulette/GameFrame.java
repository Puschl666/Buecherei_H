package Roulette;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameFrame extends JDialog implements ActionListener 
{
	private Container contentPane;
	private JPanel pnlCenter, pnlSouth, pnlNorth;
	private JButton btnEXIT;
	private JLabel JRnd, GBetrag, gesButton;
	private int zuweisung;

	private OptionFrame optionframe;
	private GameControl gamecontrol=new GameControl();
	private BetragFrame betragFrame;
	
	private int Erg;
	public GameFrame(OptionFrame optionframe, BetragFrame betragframe) 
	{
		this.optionframe = optionframe;
		this.betragFrame = betragframe;
		
		contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 3));
		setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		pnlSouth = new JPanel();
		pnlCenter = new JPanel();
		pnlNorth = new JPanel();
		btnEXIT = new JButton("Zurueck zum Spiel + Geldbetrag aktuallisieren");
		GBetrag = new JLabel("Gewinn:");
		gesButton = new JLabel("gedrückter Button:");
		pnlCenter.setLayout(new FlowLayout());
		pnlSouth.setLayout(new FlowLayout());
		pnlNorth.setLayout(new FlowLayout());
		contentPane.add(pnlCenter);
		contentPane.add(pnlSouth);
		contentPane.add(pnlNorth);
		//Laden Des Bildes
		Image image2 = Toolkit.getDefaultToolkit().getImage("src\\resources\\Roulette\\giphy.gif");
		ImageIcon picture2 = new ImageIcon(image2);
		JLabel nameRoullete = new JLabel(picture2);
		pnlCenter.add(nameRoullete);
		JRnd = new JLabel("randomNR");
		
		pnlSouth.add(JRnd);
		pnlSouth.add(GBetrag);
		pnlNorth.add(btnEXIT);
		pnlSouth.add(gesButton);
		contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 3));
		btnEXIT.addActionListener(this);
		
		//RandomZahl
		JRnd.setText("   Gerollte Zahl ist:  "+gamecontrol.randomNum()+" ");
		gesButton.setText("   Ihre Zahl war:  "+optionframe.zwButton());
	//Button Zuweisung
	if(optionframe.zwButton()<=36)
	{
		zuweisung=1;
	}
	else if(optionframe.zwButton()==37)
	{
		gesButton.setText("   Ihre Farbe war: Red");
		zuweisung=2;
	}
	else if(optionframe.zwButton()==38)
	{
		gesButton.setText("   Ihre Farbe war: Black");
		zuweisung=3;
	}
	else if(optionframe.zwButton()==39)
	{
		gesButton.setText("   Ihre Wahl war: ");
		zuweisung=4;
	}
	else if(optionframe.zwButton()==40)
	{
		gesButton.setText("   Ihre Wahl war: ");
		zuweisung=5;
	}
	else if(optionframe.zwButton()==41)
	{
		gesButton.setText("   Ihre Wahl war: FIRST 12");
		zuweisung=6;
	}
	else if(optionframe.zwButton()==42)
	{
		gesButton.setText("   Ihre Wahl war: SECOND 12");
		zuweisung=7;
	}
	else if(optionframe.zwButton()==43)
	{
		gesButton.setText("   Ihre Wahl war: THIRD 12");
		zuweisung=8;
	}
	else if(optionframe.zwButton()==44)
	{
		gesButton.setText("   Ihre Wahl war: FIRST 18");
		zuweisung=9;
	}
	else if(optionframe.zwButton()==45)
	{
		gesButton.setText("   Ihre Wahl war: SECOND 18");
		zuweisung=10;
	}
	switch(zuweisung)
	{
	//einzelne Buttons 1-36
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 1:
			if(gamecontrol.randomNum()==optionframe.zwButton())
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*35);
				Erg=Erg*35;
				optionframe.setBank(optionframe.getbank()+Erg);				
			}
			else if(gamecontrol.randomNum()!=optionframe.zwButton())
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);				
			}
			break;
		case 2:
		{
			//Abfrage auf Red Buttons/ positiver Betrag
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			
			//Verneinte Abfrage! Negativ Betrag
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			else if(gamecontrol.randomNum()!=1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		case 3:
		{
			//Abfrage auf Black Buttons/ positiver Betrag
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText("   Gerollte Zahl ist:  BLACK "+gamecontrol.randomNum()+" ");
			}
			
			//Verneinte Abfrage! Negativ Betrag
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()!=1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()!=36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("   Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText("   Gerollte Zahl ist:  RED "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		case 4:
		{
			//abpr�fen auf gerade zahlen
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}
			//abpr�fen auf nicht gerade Zahlen
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  "+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText("  Verlust:  -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: EVEN "+gamecontrol.randomNum()+" ");
			}	
		}
		break;
		// checken auf ODD
		///////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 5:
		{
			if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn:  +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			
			//Abfrage auf Even Zahlen
			////////////////////////////////////////////////////////////////////////////////////////////////////
			
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: ODD "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		//Prüfung auf FIRST 12
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 6:
		{
			if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
		//Abpr�fen auf 13-36
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		
		//Abpr�fen auf Second 12
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 7:
		{
			if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			//Abprüfen auf 1-12 u. 25-36
			////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		//Abprüfen auf Third 12
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 8:
		{
			if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*3);
				Erg=Erg*3;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			//Abpr�fen auf 1-24
			///////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		//Abfrage auf 1-18
		///////////////////////////////////////////////////////////////////////////////////////////////
		case 9:
		{
			if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}	
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			//Abprüfen auf 19-36
			////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
		}
		break;
		//Abfrage auf 19-36
		////////////////////////////////////////////////////////////////////////////////////////////////////////
		case 10:
		{
			if(gamecontrol.randomNum()==19)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==20)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==21)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==22)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==23)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==24)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==25)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==26)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==27)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==28)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==29)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==30)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==31)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==32)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==33)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==34)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==35)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==36)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Gewinn +"+ Erg*2);
				Erg=Erg*2;
				optionframe.setBank(optionframe.getbank()+Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			//Abpr�fen auf 1-18
			///////////////////////////////////////////////////////////////////////////////////////////////////
			else if(gamecontrol.randomNum()==1)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==2)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==3)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==4)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==5)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==6)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==7)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==8)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==9)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==10)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==11)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==12)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==13)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==14)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==15)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==16)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==17)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
			else if(gamecontrol.randomNum()==18)
			{
				Erg=betragFrame.MBetrag();
				GBetrag.setText(" Verlust -"+ Erg);
				optionframe.setBank(optionframe.getbank()-Erg);
				JRnd.setText(" Gerollte Zahl ist: "+gamecontrol.randomNum()+" ");
			}
		}
		break;
	}
		this.repaint();
		this.validate();
	}
	public int getZuweisung() {
		return zuweisung;
	}
	public void setZuweisung(int zuweisung) {
		this.zuweisung = zuweisung;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
			Object source = e.getSource();
		if(source==btnEXIT)
		{
			Erg=1;
			optionframe.JBank.setText("  Bank: "+optionframe.getbank()+" ");
			optionframe.setPlayable(false);
			dispose();
		}
	}
}