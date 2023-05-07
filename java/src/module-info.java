 module java {
	requires transitive javafx.controls; // UI Controls
	requires transitive javafx.media; // APIs for audio
	requires transitive gdx; // API GDX for mediaplayer .ogg
	requires transitive jorbis; // API for ogg
	requires transitive javafx.fxml; // FXML
	requires transitive javafx.graphics; // CSS
	requires transitive java.sql; // SQL
	requires transitive java.desktop; // AWT and Swing
	requires transitive mysql.connector.j; // MySQL

	opens application to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a la raiz
	opens application.prologue to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a prologue
	opens application.ep1 to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a ep1
	opens application.ep2 to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a ep2
	opens application.end to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a end

	exports application to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a la raiz
	exports application.prologue to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a prologue
	exports application.ep1 to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a ep1
	exports application.ep2 to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a ep2
	exports application.end to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a end

	// TEST
	// opens trash to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los
	// modulos RAW
	// exports trash to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a
	// los modulos RAW
}