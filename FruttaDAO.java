import java.sql.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class FruttaDAO {
	
	LinkedList<Frutta> frutti = new LinkedList<Frutta>();
	ListIterator<Frutta> iterator = frutti.listIterator();
	
	public FruttaDAO(){
	try {
		Class.forName("org.postgresql.Driver");
	} catch(ClassNotFoundException e) {
		System.out.println("Class not found!\n"+e);
	}
	
	try {
		
		Connection conn = DriverManager.getConnection("jdbc:postgresql://database-1.cyzurhfwamck.us-east-2.rds.amazonaws.com:5432/progetto", "postgres", "progettooobd");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM prodotto, frutta WHERE prodotto.codice_id=frutta.id;");
	
		
		while(rs.next()) {
			
			Frutta f = new Frutta();
			
			f.setNomeProdotto(rs.getString("nome_prodotto"));
			f.setMarca(rs.getString("marca"));
			f.setCodiceID(rs.getString("codice_id"));
			f.setPrezzoAlKilo(rs.getDouble("prezzo"));
     		f.setDataDiScadenza(rs.getDate("data_scadenza"));
			f.setDisponibilit‡(rs.getInt("disponibilita"));
			f.setDataDiRaccolta(rs.getDate("data_raccolta"));
			f.setModalit‡DiConservazione(rs.getString("modalita_conservazione"));
			
			frutti.add(f);
		
		}
		
			rs.close();
			st.close();
			conn.close();
		
	} catch(SQLException e) {
		System.out.println("SQL Exception\n"+e);
	}
	

}
	
	public LinkedList<Frutta> ConnessioneDB(Frutta frutta) {
		
		int i = 0;
		
		while(i!=2) {
		frutta.setNomeProdotto(frutti.get(i).getNomeProdotto());
		frutta.setMarca(frutti.get(i).getMarca());
		frutta.setCodiceID(frutti.get(i).getCodiceID());
		frutta.setPrezzoAlKilo(frutti.get(i).getPrezzoAlKilo());
		frutta.setDataDiScadenza(frutti.get(i).getDataDiScadenza());
		frutta.setDisponibilit‡(frutti.get(i).getDisponibilit‡());
		frutta.setDataDiRaccolta(frutti.get(i).getDataDiRaccolta());
		frutta.setModalit‡DiConservazione(frutti.get(i).getModalit‡DiConservazione());
		
		frutti.add(frutta);
		i++;
		}
		
		return frutti;
	}
	}