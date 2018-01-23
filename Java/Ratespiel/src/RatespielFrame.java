import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RatespielFrame extends JFrame implements ActionListener, KeyListener {

	private Container contentPane;
	private JLabel lblInfo;
	private JLabel lblVersuche;
	private JTextField txfEingabe;
	private JButton btnOk;
	private JButton btnNew;
	private JPanel pnlSouth;
	private Spielsteuerung spiel;
	
	public RatespielFrame(){
		super("Zahlenratespiel");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblInfo = new JLabel("Ich denke mir eine Zahl zwischen 1 und 100 .... Rate mal");
		lblVersuche = new JLabel("Versch 1:");
		txfEingabe = new JTextField(10);
		btnOk = new JButton("OK");
		btnNew = new JButton("Neu");
		btnNew.setVisible(false);
		pnlSouth = new JPanel(new GridLayout(1,2));
		pnlSouth.add(btnNew);
		pnlSouth.add(btnOk);
		
		btnOk.addActionListener(this);
		btnNew.addActionListener(this);
		txfEingabe.addKeyListener(this);
		
		contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(lblInfo, BorderLayout.NORTH);
		contentPane.add(lblVersuche, BorderLayout.WEST);
		contentPane.add(txfEingabe, BorderLayout.CENTER);
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		spiel = new Spielsteuerung();
		
	}
	
		@Override
		public void actionPerformed (ActionEvent ae){
			Object source = ae.getSource();
			
			if(source==btnOk)
			{
				btnOkClick();
				
			}
			else if(source ==btnNew)
			{
				spiel.neuesSpiel();
				lblInfo.setText("Ich denke mir eine Zahl zwischen 1 und 100 .... Rate mal");
				lblVersuche.setText("Versuche " + String.valueOf(spiel.getAnzVersuche()) + ":");	
				txfEingabe.setText("");
				btnNew.setVisible(false);
			}
			
		}
		public void keyTyped(KeyEvent ke)
		{
			
		}
		public void keyPressed(KeyEvent ke)
		{
			Object source = ke.getSource();
			if(source==txfEingabe)
			{
				if (ke.getKeyCode()==KeyEvent.VK_ENTER)
				{
					btnOkClick();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		public void btnOkClick()
		{
			try{
				if(spiel.isSpielende())
				{
					System.exit(0);
				}
				else{
					int zahl = Integer.parseInt(txfEingabe.getText());
					switch(spiel.spielZug(zahl)){
					case 0: lblInfo.setText("Richtig geraten!!!");
							lblVersuche.setText("Versuche " + String.valueOf(spiel.getAnzVersuche()) + ":");
							btnNew.setVisible(true);
							btnOk.setText("Ende");
							break;
					case 1: lblInfo.setText("Zu groﬂ!!!");
							lblVersuche.setText("Versuche " + String.valueOf(spiel.getAnzVersuche()) + ":");
							break;
					case -1:lblInfo.setText("Zu klein!!!");
							break;
					}
				}
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Fehler" , 0);
			}
			txfEingabe.selectAll();
		}
}
