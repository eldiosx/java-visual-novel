package application.ep1;
import application.end.Credits;

import java.awt.event.ActionEvent;

import application.ConexionMySQL;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.*;
import java.beans.*;
import java.io.*;
import java.sql.*;
import com.mysql.cj.protocol.Resultset;

public class Stage2 {
	
		//Instanciamos la pantalla de creditos
		Credits credits = new Credits(); // Crea una instancia de la clase Main
		Stage stage = new Stage();
		
		//Instanciamos la clase ConexionMySQL
		ConexionMySQL conexion = new ConexionMySQL("root", "", "videojuego serie b");
		
	   @FXML // fx:id="cuchillo"
	    private Button cuchillo; // Value injected by FXMLLoader
	   

	    cuchillo = new Button("cuchillo");
	    textocuchillo = new Label();
	    	
    
		cuchillo.setOnAction(event2 -> {
	        
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
	        //Evento boton  continuar
	    	myButton2.setOnAction(event -> {
				// Asi podemos crear escenas que nos de la gana, util sobre todo para el LOAD
				try {
					// Crear un nuevo Stage
					credits.start(stage);

					// Ocultar el Stage principal
					MainEp1.hideStage(MainEp1.getPrimaryStage());
				} catch (Exception e) {
					e.printStackTrace();
				}

	        });
			
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
	            if (count >= 4) { //si ya se pulsaron 4 botones
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
	        for (Node node : cuerpo.getParent().getChildrenUnmodifiable()) {
	            if (node instanceof Button && !node.isDisabled()) { //si es un botón habilitado
	                ((Button) node).setDisable(true); //lo desactivamos
	            }
	        }
	    }
	}
	


