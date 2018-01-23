package Roulette;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BetragFrame extends JDialog implements ActionListener 
{
	private Container contentPane;
	private JPanel pnlNorth, pnlSouth;
	private JTextField JBetrag;
	private GameControl gamecontrol=new GameControl();
	private OptionFrame optionframe;
	private JButton btnZurueck, btnSetzen;
	
	private int MBetrag;
	
	public BetragFrame(OptionFrame frame) 
	{ 
                setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
		optionframe = frame;

		JBetrag = new JTextField(7);
		pnlNorth = new JPanel();
		pnlSouth = new JPanel();
		btnZurueck = new JButton("zurueck");
		btnSetzen = new JButton("setzen");
		
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		contentPane.add(pnlSouth, BorderLayout.BEFORE_FIRST_LINE);
		pnlNorth.add(JBetrag);
		pnlSouth.add(btnZurueck);
		pnlSouth.add(btnSetzen);
		btnZurueck.addActionListener(this);
		btnSetzen.addActionListener(this);
		
		this.repaint();
		this.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
	Object source = e.getSource();
		if(source==btnZurueck)
		{
			dispose();
		}
		if(source==btnSetzen)
		{
			if(optionframe.getbank()>=Integer.parseInt(JBetrag.getText()) && Integer.parseInt(JBetrag.getText())!=0)
					{
							optionframe.JGesetzt.setText("  Gesetzter Betrag: "+JBetrag.getText()+" ");
							MBetrag=Integer.parseInt(JBetrag.getText());
							optionframe.setPlayable(true);
							dispose();
					}
			else{
			JOptionPane.showConfirmDialog(null, "Fehlerhafter Betrag --- Geben Sie einen gueltigen Betrag an --- Neue Eingabe", "Betrag-Fehler",JOptionPane.CLOSED_OPTION);
			}
		}
	}
	public int MBetrag()
	{
		return MBetrag;
	}
}

