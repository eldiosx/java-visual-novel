module java {
	requires javafx.controls; //UI Controls
	requires javafx.media; // APIs for audio
	requires gdx; //API GDX for mediaplayer .ogg
	requires jorbis; //API for ogg
	requires javafx.fxml; // FXML
	requires javafx.graphics; //CSS
	requires java.sql; //SQL
	requires java.desktop; // AWT and Swing
	requires mysql.connector.j; //MySQL
	
	opens application to javafx.graphics, javafx.fxml;
	exports application.Ep1 to javafx.graphics, javafx.fxml;
	//Pendiente de comprobar
	exports application.Ep1NinaMuerta to javafx.graphics, javafx.fxml;
	exports application.Prologue to javafx.graphics, javafx.fxml;
}
