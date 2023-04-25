package application.ep1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Stage2 {
	   @FXML // fx:id="cuchillo"
	    private Button cuchillo; // Value injected by FXMLLoader

	    @FXML // fx:id="cuerpo"
	    private Button cuerpo; // Value injected by FXMLLoader

	    @FXML // fx:id="mano"
	    private Button mano; // Value injected by FXMLLoader

	    @FXML // fx:id="myButton2"
	    private Button myButton2; // Value injected by FXMLLoader

	    @FXML // fx:id="myButton21111"
	    private Button myButton21111; // Value injected by FXMLLoader

	    @FXML // fx:id="sala"
	    private Button sala; // Value injected by FXMLLoader

	    @FXML // fx:id="sangre"
	    private Button sangre; // Value injected by FXMLLoader

	    @FXML // fx:id="suelo"
	    private Button suelo; // Value injected by FXMLLoader

	    @FXML // fx:id="textocuchillo"
	    private Label textocuchillo; // Value injected by FXMLLoader

	    @FXML // fx:id="textocuerpo"
	    private Label textocuerpo; // Value injected by FXMLLoader

	    @FXML // fx:id="textomano"
	    private Label textomano; // Value injected by FXMLLoader

	    @FXML // fx:id="textosala"
	    private Label textosala; // Value injected by FXMLLoader

	    @FXML // fx:id="textosangre"
	    private Label textosangre; // Value injected by FXMLLoader

	    @FXML // fx:id="textosuelo"
	    private Label textosuelo; // Value injected by FXMLLoader
	    
	    
	    int cont =0;
	@FXML
	public void initialize() {
		
		//Evento boton de suelo
		suelo.setOnAction(event -> {
			try {
				textosuelo.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		});
		
		//Evento boton de sala
		sala.setOnAction(event -> {
			try {
				textosala.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		});
		
		//Evento boton de mano
		mano.setOnAction(event -> {
			try {
				textomano.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//Evento boton de cuchillo
		cuchillo.setOnAction(event -> {
			try {
				textocuchillo.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		});
		
		//Evento boton de sangre
		sangre.setOnAction(event -> {
			try {
				textosangre.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		});
		
		//Evento boton de cuerpo
		cuerpo.setOnAction(event -> {
			try {
				textocuerpo.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cont++;
		});
		
		}
/*
	public static void buclebotones () {
		int cont =0;
		while (cont<=4) {
			cont++;
		}
	}
*/
	
}


