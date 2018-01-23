package Roulette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class OptionFrame extends JDialog implements ActionListener
{
	private Container contentPane;
	private JTextField txfName1;
	public JLabel JBank, JGesetzt;
	private JRadioButton RouletteButton;
	private JButton btnFirst12, btnSecond12, btnThird12, btnOdd, btnEven, btnOneto18, btn19to36, btnRed, btnBlack;
	private JButton btnRed1, btnBlack2, btnRed3, btnBlack4, btnRed5, btnBlack6, btnRed7, btnBlack8, btnRed9, btnBlack10, btnBlack11, btnRed12, btnBlack13, btnRed14, btnBlack15, btnRed16, btnBlack17, btnRed18, btnRed19, btnBlack20, btnRed21, btnBlack22, btnRed23, btnBlack24, btnRed25, btnBlack26, btnRed27, btnBlack28, btnBlack29, btnRed30, btnBlack31, btnRed32, btnBlack33, btnRed34, btnBlack35, btnRed36;
	private JButton btnZero, btnPlay, btnExit;
	private JPanel pnlCenter, pnlSouth, pnlSouther, pnlNorth, pnlSouthEast, pnlSouthWest;

	private int zwButton;
	private int zwBetrag;
	private BetragFrame betragFrame;
        
	private int bank;
	private boolean playable = false;
        
	public OptionFrame()		
	{
		super();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
                setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		 setTitle("Roulette");
                bank = main_menu.main_menu.getMoney();
                
		contentPane=getContentPane();
		btnPlay = new JButton("Play");
		btnRed1 = new JButton(" 1 ");
		btnBlack2 = new JButton(" 2 ");
		btnRed3 = new JButton(" 3 ");
		btnBlack4 = new JButton(" 4 ");
		btnRed5 = new JButton(" 5 ");
		btnBlack6 = new JButton(" 6 ");
		btnRed7 = new JButton(" 7 ");
		btnBlack8 = new JButton(" 8 ");
		btnRed9 = new JButton(" 9 ");
		btnBlack10 = new JButton("10");
		btnBlack11 = new JButton("11");
		btnRed12 = new JButton("12");
		btnBlack13 = new JButton("13");
		btnRed14 = new JButton("14");
		btnBlack15 = new JButton("15");
		btnRed16 = new JButton("16");
		btnBlack17 = new JButton("17");
		btnRed18 = new JButton("18");
		btnRed19 = new JButton("19");
		btnBlack20 = new JButton("20");
		btnRed21 = new JButton("21");
		btnBlack22 = new JButton("22");
		btnRed23 = new JButton("23");
		btnBlack24 = new JButton("24");
		btnRed25 = new JButton("25");
		btnBlack26 = new JButton("26");
		btnRed27 = new JButton("27");
		btnBlack28 = new JButton("28");
		btnBlack29 = new JButton("29");
		btnRed30 = new JButton("30");
		btnBlack31 = new JButton("31");
		btnRed32 = new JButton("32");
		btnBlack33 = new JButton("33");
		btnRed34 = new JButton("34");
		btnBlack35 = new JButton("35");
		btnRed36 = new JButton("36");
		
		//Button Hintergrund Rot einfürben
		btnRed1.setBackground(Color.red);
		btnRed3.setBackground(Color.red);
		btnRed5.setBackground(Color.red);
		btnRed7.setBackground(Color.red);
		btnRed9.setBackground(Color.red);
		btnRed12.setBackground(Color.red);
		btnRed14.setBackground(Color.red);
		btnRed16.setBackground(Color.red);
		btnRed18.setBackground(Color.red);
		btnRed19.setBackground(Color.red);
		btnRed21.setBackground(Color.red);
		btnRed23.setBackground(Color.red);
		btnRed25.setBackground(Color.red);
		btnRed27.setBackground(Color.red);
		btnRed30.setBackground(Color.red);
		btnRed32.setBackground(Color.red);
		btnRed34.setBackground(Color.red);
		btnRed36.setBackground(Color.red);
		
		//Button Hintergrund Schwarz einf�rben
		btnBlack2.setBackground(Color.black);
		btnBlack4.setBackground(Color.black);
		btnBlack6.setBackground(Color.black);
		btnBlack8.setBackground(Color.black);
		btnBlack10.setBackground(Color.black);
		btnBlack11.setBackground(Color.black);
		btnBlack13.setBackground(Color.black);
		btnBlack15.setBackground(Color.black);
		btnBlack17.setBackground(Color.black);
		btnBlack20.setBackground(Color.black);
		btnBlack22.setBackground(Color.black);
		btnBlack24.setBackground(Color.black);
		btnBlack26.setBackground(Color.black);
		btnBlack28.setBackground(Color.black);
		btnBlack29.setBackground(Color.black);
		btnBlack31.setBackground(Color.black);
		btnBlack33.setBackground(Color.black);
		btnBlack35.setBackground(Color.black);
		
		//schwarze Button Schriftfarbe weiß färben
		btnBlack2.setForeground(Color.white);
		btnBlack4.setForeground(Color.white);
		btnBlack6.setForeground(Color.white);
		btnBlack8.setForeground(Color.white);
		btnBlack10.setForeground(Color.white);
		btnBlack11.setForeground(Color.white);
		btnBlack13.setForeground(Color.white);
		btnBlack15.setForeground(Color.white);
		btnBlack17.setForeground(Color.white);
		btnBlack20.setForeground(Color.white);
		btnBlack22.setForeground(Color.white);
		btnBlack24.setForeground(Color.white);
		btnBlack26.setForeground(Color.white);
		btnBlack28.setForeground(Color.white);
		btnBlack29.setForeground(Color.white);
		btnBlack31.setForeground(Color.white);
		btnBlack33.setForeground(Color.white);
		btnBlack35.setForeground(Color.white);
		
		btnZero = new JButton("                              0                              ");
		
		btnFirst12 = new JButton("1st 12");
		btnSecond12 = new JButton("2nd 12");
		btnThird12 = new JButton("3rd 12");
		btnOdd = new JButton("ODD");
		btnEven = new JButton("EVEN");
		btnRed = new JButton("RED");
		btnBlack = new JButton("BLACK");
		btnOneto18 = new JButton("1 - 18");
		btn19to36 = new JButton("19 - 36");
		
		btnRed.setBackground(Color.red);
		btnBlack.setBackground(Color.black);
		btnBlack.setForeground(Color.white);
		
		RouletteButton = new JRadioButton("Roulette",true);
		txfName1 = new JTextField(50);
		JBank = new JLabel("bank");
		JGesetzt = new JLabel("Gesetzter Betrag:             ");
		
		pnlCenter = new JPanel();
		pnlNorth = new JPanel();
		pnlSouthEast = new JPanel();
		pnlSouthWest = new JPanel();
		pnlSouth = new JPanel();
		
		pnlSouther = new JPanel();
		
		//Layout for Panels setzen
		contentPane.setLayout(new BorderLayout());
		pnlCenter.setLayout(new FlowLayout());
		pnlNorth.setLayout(new FlowLayout());
		pnlSouthEast.setLayout(new GridLayout(1, 1));
		pnlSouthWest.setLayout(new GridLayout(1, 1));
		
		pnlSouth.setLayout(new GridLayout(2, 2));
		pnlSouther.setLayout(new GridLayout(3, 2));
		
		//Panels befüllen
		pnlCenter.add(btnRed1);
		pnlCenter.add(btnBlack2);
		pnlCenter.add(btnRed3);
		pnlCenter.add(btnBlack4);
		pnlCenter.add(btnRed5);
		pnlCenter.add(btnBlack6);
		pnlCenter.add(btnRed7);
		pnlCenter.add(btnBlack8);
		pnlCenter.add(btnRed9);
		pnlCenter.add(btnBlack10);
		pnlCenter.add(btnBlack11);
		pnlCenter.add(btnRed12);
		pnlCenter.add(btnBlack13);
		pnlCenter.add(btnRed14);
		pnlCenter.add(btnBlack15);
		pnlCenter.add(btnRed16);
		pnlCenter.add(btnBlack17);
		pnlCenter.add(btnRed18);
		pnlCenter.add(btnRed19);
		pnlCenter.add(btnBlack20);
		pnlCenter.add(btnRed21);
		pnlCenter.add(btnBlack22);
		pnlCenter.add(btnRed23);
		pnlCenter.add(btnBlack24);
		pnlCenter.add(btnRed25);
		pnlCenter.add(btnBlack26);
		pnlCenter.add(btnRed27);
		pnlCenter.add(btnBlack28);
		pnlCenter.add(btnBlack29);
		pnlCenter.add(btnRed30);
		pnlCenter.add(btnBlack31);
		pnlCenter.add(btnRed32);
		pnlCenter.add(btnBlack33);
		pnlCenter.add(btnRed34);
		pnlCenter.add(btnBlack35);
		pnlCenter.add(btnRed36);
		pnlNorth.add(btnZero);
		pnlSouth.add(btnFirst12);
		pnlSouth.add(btnSecond12);
		pnlSouth.add(btnThird12);
		pnlSouther.add(btnEven);
		pnlSouther.add(btnOdd);
		pnlSouther.add(btnRed);
		pnlSouther.add(btnBlack);
		
		pnlSouthWest.add(btnOneto18);
		pnlSouthWest.add(btn19to36);
		
		pnlSouthEast.add(btnPlay);
		pnlSouthEast.add(JBank);
		pnlSouthEast.add(JGesetzt);
		
		//Listerner Aktivieren
		btnPlay.addActionListener(this);
		btnRed1.addActionListener(this);
		btnBlack2.addActionListener(this);
		btnRed3.addActionListener(this);
		btnBlack4.addActionListener(this);
		btnRed5.addActionListener(this);
		btnBlack6.addActionListener(this);
		btnRed7.addActionListener(this);
		btnBlack8.addActionListener(this);
		btnRed9.addActionListener(this);
		btnBlack10.addActionListener(this);
		btnBlack11.addActionListener(this);
		btnRed12.addActionListener(this);
		btnBlack13.addActionListener(this);
		btnRed14.addActionListener(this);
		btnBlack15.addActionListener(this);
		btnRed16.addActionListener(this);
		btnBlack17.addActionListener(this);
		btnRed18.addActionListener(this);
		btnRed19.addActionListener(this);
		btnBlack20.addActionListener(this);
		btnRed21.addActionListener(this);
		btnBlack22.addActionListener(this);
		btnRed23.addActionListener(this);
		btnBlack24.addActionListener(this);
		btnRed25.addActionListener(this);
		btnBlack26.addActionListener(this);
		btnRed27.addActionListener(this);
		btnBlack28.addActionListener(this);
		btnBlack29.addActionListener(this);
		btnRed30.addActionListener(this);
		btnBlack31.addActionListener(this);
		btnRed32.addActionListener(this);
		btnBlack33.addActionListener(this);
		btnRed34.addActionListener(this);
		btnBlack35.addActionListener(this);
		btnRed36.addActionListener(this);
		btnRed.addActionListener(this);
		btnBlack.addActionListener(this);
		btnEven.addActionListener(this);
		btnOdd.addActionListener(this);
		btnOneto18.addActionListener(this);
		btn19to36.addActionListener(this);
		btnFirst12.addActionListener(this);
		btnSecond12.addActionListener(this);
		btnThird12.addActionListener(this);
		
		//Panels auf das Hauptfenster setzen
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		contentPane.add(pnlSouthEast, BorderLayout.EAST);
		contentPane.add(pnlSouthWest, BorderLayout.WEST);
		contentPane.add(pnlSouth, BorderLayout.BEFORE_FIRST_LINE);
		contentPane.add(pnlSouther, BorderLayout.SOUTH);
		
	    
                JBank.setText("  Bank: "+getbank()+" ");
		betragFrame = new BetragFrame(this);
	    
		this.repaint();
		this.validate();
	}
	
	public boolean isPlayable() {
		return playable;
	}
	public void setPlayable(boolean playable) {
		this.playable = playable;
	}
	public void setBank(int bank) 
	{
		this.bank = bank;
                main_menu.main_menu.setMoney(bank);
	}
	//Getter
	public int getbank()
	{
		return bank;
	}
	public int zwBetrag()
	{
		return zwBetrag;
	}
	public int zwButton()
	{
		return zwButton;
	}
	//Verweisen auf einzelne Frames
	@Override
	public void actionPerformed(ActionEvent e)
	{
		Object source = e.getSource();
		if(source==btnPlay)
		{
			if(playable){
			GameFrame gameFrame = new GameFrame(this, betragFrame);
			gameFrame.setLocation(1360, 100);
			gameFrame.setSize(500,775);
			gameFrame.setVisible(true);
			}
			else{
				JOptionPane.showConfirmDialog(null, "Kein Betrag gesetzt --- Sie muessen erst auf EINE Zahlen/Button setzen", "Kein gesetzter Betrag-Fehler",JOptionPane.CLOSED_OPTION);
			}
		}
		else if(source==btnExit)
		{
			dispose();
		}
		else if(source==btnRed1)
		{
			zwButton = 1;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);			
		}
		else if(source==btnBlack2)
		{
			zwButton =2;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed3)
		{
			zwButton =3;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack4)
		{
			zwButton =4;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed5)
		{
			zwButton =5;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack6)
		{
			zwButton =6;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed7)
		{	
			zwButton =7;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack8)
		{
			zwButton =8;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed9)
		{
			zwButton =9;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack10)
		{
			zwButton =10;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack11)
		{
			zwButton =11;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed12)
		{
			zwButton =12;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack13)
		{
			zwButton =13;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed14)
		{
			zwButton =14;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack15)
		{
			zwButton =15;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed16)
		{
			zwButton =16;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack17)
		{
			zwButton =17;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed18)
		{
			zwButton =18;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed19)
		{
			zwButton =19;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack20)
		{
			zwButton =20;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed21)
		{
			zwButton =21;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack22)
		{
			zwButton =22;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed23)
		{
			zwButton =23;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack24)
		{
			zwButton =24;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed25)
		{
			zwButton =25;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack26)
		{
			zwButton =26;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed27)
		{
			zwButton =27;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack28)
		{
			zwButton =28;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack29)
		{
			zwButton =29;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed30)
		{
			zwButton =30;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack31)
		{
			zwButton =31;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed32)
		{
			zwButton =32;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack33)
		{
			zwButton =33;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed34)
		{
			zwButton =34;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack35)
		{
			zwButton =35;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed36)
		{
			zwButton =36;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnRed)
		{
			zwButton=37;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnBlack)
		{
			zwButton=38;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnEven)
		{
			zwButton=39;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnOdd)
		{
			zwButton=40;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnFirst12)
		{
			zwButton=41;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnSecond12)
		{
			zwButton=42;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnThird12)
		{
			zwButton=43;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btnOneto18)
		{
			zwButton=44;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		else if(source==btn19to36)
		{
			zwButton=45;
			betragFrame.setLocation(910, 100);
			betragFrame.setSize(180,150);
			betragFrame.setVisible(true);
		}
		this.repaint();
		this.validate();
	}
}