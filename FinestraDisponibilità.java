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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class FinestraDisponibilitą extends JFrame {

	private JPanel contentPane;
	private JTextField Quantitą_TF;
	public Controller IlController;
	private double QuantitąDaSottrarreDouble;
	private JTextField PrezzoAlKilo_TF;
	private JTextField PrezzoTot_TF;
	private JTextField DispInMagazzino_TF;
	private double PrezzoAlKiloDouble;
	private JTextField textField;
	
	
	
	public void setQuantitąDaSottrarreDouble(double quantitąDaSottrarreDouble) {
		QuantitąDaSottrarreDouble = 0.0;
	}
	public double getQuantitąDaSottrarreDouble() {
		return QuantitąDaSottrarreDouble;
	}
	
	public double getPrezzoAlKiloDouble() {
		return PrezzoAlKiloDouble;
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
		Frutta_JLb.setBounds(10, 63, 78, 14);
		contentPane.add(Frutta_JLb);
		
		JLabel Quantitą_JLb = new JLabel("Quantit\u00E0 che desidera aquistare:");
		Quantitą_JLb.setBounds(10, 88, 190, 14);
		contentPane.add(Quantitą_JLb);
		
		Quantitą_TF = new JTextField();
		Quantitą_TF.setHorizontalAlignment(SwingConstants.CENTER);
		Quantitą_TF.setToolTipText("Inserire quantit\u00E0 desiderata");
		Quantitą_TF.setBounds(198, 88, 86, 20);
		contentPane.add(Quantitą_TF);
		Quantitą_TF.setColumns(10);
		
		JButton CalcolaPrezzoButton = new JButton("Calcola Prezzo");
		CalcolaPrezzoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PrezzoAlKiloString = PrezzoAlKilo_TF.getText();
				try {
					PrezzoAlKiloDouble = Double.parseDouble(PrezzoAlKiloString);	
				}
				catch (NumberFormatException Nfe){
					System.err.println("");
				}
				PrezzoTot_TF.setText(c.CalcolaPrezzo());
				c.setQuantitąTfToZero();
				CalcolaPrezzoButton.setEnabled(false);
			}
		});
		CalcolaPrezzoButton.setBounds(10, 145, 126, 23);
		contentPane.add(CalcolaPrezzoButton);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String QuantitąDaSottrarreString=Quantitą_TF.getText();
				try {
					QuantitąDaSottrarreDouble = Double.parseDouble(QuantitąDaSottrarreString);	
				}
				catch (NumberFormatException Nfe){
					System.err.println("");
				}
				DispInMagazzino_TF.setText(c.SottraiQuantitą());
				ConfermaButton.setEnabled(false);
				Quantitą_TF.setEditable(false);
//				if((c.SottraiQuantitą().equals("Non ci sono abbastanza scorte"))){
//					Quantitą_TF.setEditable(false);
//					ConfermaButton.setEnabled(false);
//					CalcolaPrezzoButton.setEnabled(false);
//				}
			}
		});
		ConfermaButton.setBounds(294, 88, 109, 23);
		contentPane.add(ConfermaButton);
		
		JLabel PrezzoAlKilo_JLb = new JLabel("Prezzo al Kilo:");
		PrezzoAlKilo_JLb.setBounds(10, 120, 94, 14);
		contentPane.add(PrezzoAlKilo_JLb);
		
		PrezzoAlKilo_TF = new JTextField();
		PrezzoAlKilo_TF.setHorizontalAlignment(SwingConstants.CENTER);
		PrezzoAlKilo_TF.setText("2.00");
		PrezzoAlKilo_TF.setEditable(false);
		PrezzoAlKilo_TF.setBounds(94, 117, 35, 20);
		contentPane.add(PrezzoAlKilo_TF);
		PrezzoAlKilo_TF.setColumns(10);
		
		
		
		JLabel PrezzoTot_JLb = new JLabel("Prezzo Totale:");
		PrezzoTot_JLb.setBounds(10, 179, 109, 14);
		contentPane.add(PrezzoTot_JLb);
		
		PrezzoTot_TF = new JTextField();
		PrezzoTot_TF.setText("0,00\u20AC");
		PrezzoTot_TF.setEditable(false);
		PrezzoTot_TF.setHorizontalAlignment(SwingConstants.CENTER);
		PrezzoTot_TF.setBounds(94, 176, 61, 20);
		contentPane.add(PrezzoTot_TF);
		PrezzoTot_TF.setColumns(10);
		
		JLabel DispInMagazzino_JLb = new JLabel("Disponibilit\u00E0 in magazzino:");
		DispInMagazzino_JLb.setBounds(10, 11, 257, 14);
		contentPane.add(DispInMagazzino_JLb);
		
		DispInMagazzino_TF = new JTextField();
		DispInMagazzino_TF.setText("100");
		DispInMagazzino_TF.setHorizontalAlignment(SwingConstants.LEFT);
		DispInMagazzino_TF.setEditable(false);
		DispInMagazzino_TF.setBounds(165, 8, 250, 20);
		contentPane.add(DispInMagazzino_TF);
		DispInMagazzino_TF.setColumns(10);
		
		JButton AcquistaDiNuovoButton = new JButton("Acquista di nuovo");
		AcquistaDiNuovoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
//				if((c.SottraiQuantitą().equals("Non ci sono abbastanza scorte")) || (c.SottraiQuantitą().equals("Abbiamo esaurito le scorte in magazzino"))){
//					AcquistaDiNuovoButton.setEnabled(false);
//				}
//				else {
//					Quantitą_TF.setText("");
//					ConfermaButton.setEnabled(true);
//					CalcolaPrezzoButton.setEnabled(true);
//					Quantitą_TF.setEditable(true);
//				}
//				
			}
		});
		AcquistaDiNuovoButton.setBounds(268, 189, 147, 30);
		contentPane.add(AcquistaDiNuovoButton);
		

		JButton TornaHomeButton = new JButton("Torna alla home");
		TornaHomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.TornaAllaHome();
			}
		});
		TornaHomeButton.setBounds(268, 230, 147, 30);
		contentPane.add(TornaHomeButton);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("\u20AC");
		textField.setBounds(133, 117, 16, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
	

}
