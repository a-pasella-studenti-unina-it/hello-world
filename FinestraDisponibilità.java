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

public class FinestraDisponibilità extends JFrame {

	private JPanel contentPane;
	private JTextField Quantità_TF;
	public Controller IlController;
	private double QuantitàDaSottrarreDouble;
	private JTextField PrezzoAlKilo_TF;
	private JTextField PrezzoTot_TF;
	private JTextField DispInMagazzino_TF;
	private double PrezzoAlKiloDouble;
	private JTextField textField;
	private String DispInMagazzinoString;
	
	
	
	public void setQuantitàDaSottrarreDouble(double quantitàDaSottrarreDouble) {
		QuantitàDaSottrarreDouble = 0.0;
	}
	public double getQuantitàDaSottrarreDouble() {
		return QuantitàDaSottrarreDouble;
	}
	
	public double getPrezzoAlKiloDouble() {
		return PrezzoAlKiloDouble;
	}
	


	/**
	 * Create the frame.
	 */
	public FinestraDisponibilità(Controller c) {
		
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
		
		JLabel Quantità_JLb = new JLabel("Quantit\u00E0 che desidera aquistare:");
		Quantità_JLb.setBounds(10, 88, 190, 14);
		contentPane.add(Quantità_JLb);
		
		Quantità_TF = new JTextField();
		Quantità_TF.setHorizontalAlignment(SwingConstants.CENTER);
		Quantità_TF.setToolTipText("Inserire quantit\u00E0 desiderata");
		Quantità_TF.setBounds(198, 88, 86, 20);
		contentPane.add(Quantità_TF);
		Quantità_TF.setColumns(10);
		
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
				if((DispInMagazzinoString.equals("Queste erano le ultime scorte in magazzino"))){
					PrezzoTot_TF.setText(PrezzoTot_TF.getText());
					c.setQuantitàTfToZero();
					CalcolaPrezzoButton.setEnabled(false);
				};
			}
		});
		CalcolaPrezzoButton.setBounds(10, 145, 126, 23);
		contentPane.add(CalcolaPrezzoButton);
		
		JButton ConfermaButton = new JButton("Conferma");
		ConfermaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String QuantitàDaSottrarreString=Quantità_TF.getText();
				try {
					QuantitàDaSottrarreDouble = Double.parseDouble(QuantitàDaSottrarreString);	
				}
				catch (NumberFormatException Nfe){
					System.err.println("");
				}
				DispInMagazzinoString=c.SottraiQuantità();
				DispInMagazzino_TF.setText(DispInMagazzinoString);
				if((DispInMagazzinoString.equals("Non ci sono abbastanza scorte"))){
					Quantità_TF.setEditable(false);
					ConfermaButton.setEnabled(false);
					CalcolaPrezzoButton.setEnabled(false);
				}
					else {
						DispInMagazzino_TF.setText(DispInMagazzinoString);
						ConfermaButton.setEnabled(false);
						Quantità_TF.setEditable(false);
					}
				
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
				if((DispInMagazzinoString.equals("Non ci sono abbastanza scorte")) || (DispInMagazzinoString.equals("Queste erano le ultime scorte in magazzino"))){
					AcquistaDiNuovoButton.setEnabled(false);
				}
				else {
					Quantità_TF.setText("");
					c.setQuantitàTfToZero();
					ConfermaButton.setEnabled(true);
					CalcolaPrezzoButton.setEnabled(true);
					Quantità_TF.setEditable(true);
				}
				
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
