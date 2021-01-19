import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraDisponibilitą extends JFrame {

	private JPanel contentPane;
	private JTextField Quantitą_TF;
	public Controller IlController;
	private int QuantitąDaSottrarreInt;
	
	public int getQuantitąDaSottrarreInt() {
		return QuantitąDaSottrarreInt;
	}
	

	/**
	 * Create the frame.
	 */
	public FinestraDisponibilitą(Controller c) {
		
		IlController=c;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Frutta_JLb = new JLabel("Frutta");
		Frutta_JLb.setBounds(10, 117, 78, 14);
		contentPane.add(Frutta_JLb);
		
		JLabel Quantitą_JLb = new JLabel("Quantit\u00E0 che desidera aquistare:");
		Quantitą_JLb.setBounds(10, 142, 190, 14);
		contentPane.add(Quantitą_JLb);
		
		Quantitą_TF = new JTextField();
		Quantitą_TF.setToolTipText("Inserire quantit\u00E0 desiderata");
		Quantitą_TF.setBounds(197, 139, 86, 20);
		contentPane.add(Quantitą_TF);
		Quantitą_TF.setColumns(10);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=Quantitą_TF.getText();
				try {
					QuantitąDaSottrarreInt = Integer.parseInt(s);		
				}
				catch (NumberFormatException Nfe){
					System.err.println("errore");
				}
				//c.StampaNuovaDisp();
				c.ApriJDialog();
			}
		});
		ConfermaButton.setBounds(293, 138, 109, 23);
		contentPane.add(ConfermaButton);
	}
	
}
