package application.ep1;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import application.ConexionMySQL;
import application.end.Credits;
import application.ep2.Ep2;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Stage2 {
	
		//Instanciamos la pantalla de creditos
		Credits credits = new Credits(); // Crea una instancia de la clase Credits
		Ep2 ep2= new Ep2(); // Crea una instancia de la clase Ep2
		Stage stage = new Stage();
		
		// A partir de aquí son pruebas de SQL, no borrar
		public class Controlador implements Initializable {

		    // Instanciamos la clase ConexionMySQL
		    ConexionMySQL conexion = new ConexionMySQL("root", "Medac1234", "videojuego serie b");



		    public void initialize1(URL url, ResourceBundle rb) {
		        cuchillo.setOnAction(event -> {
		            try {
		                conexion.conectar();
		                String texto = "SELECT dialogo FROM dialogos WHERE COD_dialogo=3";
		                conexion.ejecutarInsertDeleteUpdate(texto);
		                ResultSet datos = conexion.ejecutarSelect(texto);

		                while (datos.next()) {
		                    String textoDialogo = datos.getString("dialogo");
		                    textocuchillo.setText(textoDialogo);
		                }
		            } catch (SQLException e1) {
		                e1.printStackTrace();
		            } finally {
		                try {
		                    conexion.desconectar();
		                } catch (SQLException e1) {
		                    e1.printStackTrace();
		                }
		            }
		        });
		    }

			@Override
			public void initialize(URL location, ResourceBundle resources) {
				// TODO Auto-generated method stub
				
			}
		}
	    @FXML
	    private Button cuchillo;

	    @FXML
	    private Label textocuchillo;


	    @FXML // fx:id="cuerpo"
	    private Button body; // Value injected by FXMLLoader

	    @FXML // fx:id="mano"
	    private Button hand; // Value injected by FXMLLoader

	    @FXML // fx:id="myButton2"
	    private Button myButton2; // Value injected by FXMLLoader

	    @FXML // fx:id="myButton21111"
	    private Button knife; // Value injected by FXMLLoader

	    @FXML // fx:id="sala"
	    private Button room; // Value injected by FXMLLoader

	    @FXML // fx:id="sangre"
	    private Button blood; // Value injected by FXMLLoader

	    @FXML // fx:id="suelo"
	    private Button floor; // Value injected by FXMLLoader
	    

	    private Button suelo; // Value injected by FXMLLoader
	   

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
	        //Evento boton  continuar
	    	myButton2.setOnAction(event -> {
				// Asi podemos crear escenas que nos de la gana, util sobre todo para el LOAD
				try {
					// Crear un nuevo Stage del episodio 2
					ep2.start (stage);
					
					// Ocultar el Stage principal (EP1)
					MainEp1.hideStage(MainEp1.getPrimaryStage());
					
					// Ocultar el Stage del EP2
					ep2.hideStage(ep2.getPrimaryStage());
					
					//Inicia los Créditos
					credits.start(stage);
					
				} catch (Exception e) {
					e.printStackTrace();
				}

	        });
			
	        //Evento boton de suelo
			floor.setOnAction(event -> {
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
			
	        //Evento boton de sala
			room.setOnAction(event -> {
	            try {
	            	textosala.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            count++; //incrementamos el contador
	            if (count >= 4) { //si ya se pulsaron 4 botones
	                disableRemainingButtons(); //desactivamos los botones restantes
	            }
	        });

	        //Evento boton de mano
			hand.setOnAction(event -> {
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
			
	        //Evento boton de cuchillo
			knife.setOnAction(event -> {
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
	        blood.setOnAction(event -> {
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
	        
	        //Evento boton de cadaver
	        body.setOnAction(event -> {
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
	        for (Node node : body.getParent().getChildrenUnmodifiable()) {
	            if (node instanceof Button && !node.isDisabled()) { //si es un botón habilitado
	                ((Button) node).setDisable(true); //lo desactivamos
	            }
	        }
	    }
	}
	


