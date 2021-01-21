
public class Controller {
	

	FinestraDisponibilità Disp;
	SimulazioneDatabase Sim;
	public double NuovaDisponibilità;
	public double PrezzoTotale;
	
	
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
	}
	
	public Controller() {
		Disp=new FinestraDisponibilità(this);
		Sim= new SimulazioneDatabase(this);
		Disp.setVisible(true);
	}
	
//	public void RefreshFinestraDisponibilità(){
//		Disp.setVisible(true);
//		Disp.dispose();
//		if(Sim.getDisponibilitàInMagazzino()>0) {
//			Disp = new FinestraDisponibilità(this);
//			Disp.setVisible(true);
//		}
//	}
//	
	
	public String CalcolaPrezzo() {
		PrezzoTotale=((Disp.getPrezzoAlKiloDouble())*(Disp.getQuantitàDaSottrarreDouble()));
		return ""+PrezzoTotale+"€";
	}
	
	public String SottraiQuantità() {
		if(Disp.getQuantitàDaSottrarreDouble()>Sim.getDisponibilitàInMagazzino()) {
			return"Non ci sono abbastanza scorte";
		}
		else {	
		NuovaDisponibilità=((Sim.getDisponibilitàInMagazzino())-(Disp.getQuantitàDaSottrarreDouble()));
		if(NuovaDisponibilità>0) {
		Sim.setDisponibilitàInMagazzino(NuovaDisponibilità);
		return ""+NuovaDisponibilità;
		}
		else {
			return"Abbiamo esaurito le scorte in magazzino";	
		}	
		}
	}
}
