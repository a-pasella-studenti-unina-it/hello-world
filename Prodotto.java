import java.util.*;

public class Prodotto {
	
	private String NomeProdotto;
	private int Disponibilit�;
	private String Marca;
	private String CodiceID;
	private double PrezzoAlKilo;
	private double Quantit�;
	private Date DataDiScadenza;
	
	
	public ArrayList<Carrello> IlCarrello= new ArrayList<Carrello>();
	
	

	public int getDisponibilit�() {
		return Disponibilit�;
	}
	public void setDisponibilit�(int disponibilit�) {
		Disponibilit� = disponibilit�;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getCodiceID() {
		return CodiceID;
	}
	public void setCodiceID(String codiceID) {
		CodiceID = codiceID;
	}
	public double getPrezzoAlKilo() {
		return PrezzoAlKilo;
	}
	public void setPrezzoAlKilo(double prezzoAlKilo) {
		PrezzoAlKilo = prezzoAlKilo;
	}
	public double getQuantit�() {
		return Quantit�;
	}
	public void setQuantit�(double quantit�) {
		Quantit� = quantit�;
	}
	
	public String getNomeProdotto() {
		return NomeProdotto;
	}
	public void setNomeProdotto(String nomeProdotto) {
		NomeProdotto = nomeProdotto;
	}
	public Date getDataDiScadenza() {
		return DataDiScadenza;
	}
	public void setDataDiScadenza(Date dataDiScadenza) {
		DataDiScadenza = dataDiScadenza;
	}
	
	public void CalcolaPrezzo(){
	}
	
	public Prodotto() {
		
	}
	

}
