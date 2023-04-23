module java {
	requires transitive javafx.controls; //UI Controls
	requires transitive javafx.media; // APIs for audio
	requires transitive gdx; //API GDX for mediaplayer .ogg
	requires transitive jorbis; //API for ogg
	requires transitive javafx.fxml; // FXML
	requires transitive javafx.graphics; //CSS
	requires transitive java.sql; //SQL
	requires transitive java.desktop; // AWT and Swing
	requires transitive mysql.connector.j; //MySQL
	
	opens application to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos
	opens application.prologue to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos
	opens application.ep1 to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos
	exports application.prologue to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos
	exports application.ep1 to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos
    exports application to javafx.graphics, javafx.fxml, jdx;
    
    //TEST
	opens trash to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos
	exports trash to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos
}