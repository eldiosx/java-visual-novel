module java {
	requires javafx.controls; //UI Controls
	requires javafx.media; // APIs for audio
	requires gdx; //API GDX for mediaplayer .ogg
	requires jorbis; //API for ogg
	requires javafx.fxml; // FXML
	requires javafx.graphics; //CSS
	requires java.sql; //SQL
	requires java.desktop; // AWT and Swing
	requires mysql.connector.j;
	requires javafx.base; //MySQL
	
	opens application to javafx.graphics, javafx.fxml;
	exports application.Ep1 to javafx.graphics, javafx.fxml;
	exports application.Prologue to javafx.graphics, javafx.fxml;
	exports application.Ep1Murder to javafx.graphics, javafx.fxml;
	opens application.Ep1 to javafx.fxml; // Agregar esta línea para abrir el paquete al módulo javafx.fxml
    exports application;
}
