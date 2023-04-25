package application.ep1;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
	    
	    
	    int count = 0;
	    boolean isRunning = true;

	    @FXML
	    public void initialize() {

			
	        //Evento boton de sangre
			suelo.setOnAction(event -> {
	            try {
	            	textosuelo.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });
			
	        //Evento boton de sangre
			sala.setOnAction(event -> {
	            try {
	            	textosala.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });

	        //Evento boton de sangre
			mano.setOnAction(event -> {
	            try {
	            	textomano.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });
			
	        //Evento boton de sangre
			cuchillo.setOnAction(event -> {
	            try {
	            	textocuchillo.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });

	        //Evento boton de sangre
	        sangre.setOnAction(event -> {
	            try {
	                textosangre.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });
	        
	        //Evento boton de sangre
	        cuerpo.setOnAction(event -> {
	            try {
	            	textocuerpo.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 3) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });

	    }

	    private void disableRemainingButtons() {
	        for (Node node : myButton2.getParent().getChildrenUnmodifiable()) {
	            if (node instanceof Button && !node.isDisabled()) { //si es un botón habilitado
	                ((Button) node).setDisable(true); //lo desactivamos
	            }
	        }
	    }
	}
	


