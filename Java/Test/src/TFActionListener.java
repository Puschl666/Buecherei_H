import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TFActionListener implements ActionListener {
	private Testfenster tf;
	
	public TFActionListener(Testfenster tf){
		this.tf=tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		Object source = ae.getSource();
		
		if(source==tf.getBtnOk())
		{
			tf.setLblAusgabe(tf.getTxfEingabe());
		}
		
		else
		{
			if(source==tf.getBtnEnde())
			{
				System.exit(0);
			}
		}	
	}

}
