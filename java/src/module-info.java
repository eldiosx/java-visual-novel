module java {
	requires javafx.controls;
	requires javafx.media;
	requires javafx.fxml;
	requires java.sql;
	requires java.desktop;
//	requires mysql.connector.j;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application.Ep1 to javafx.graphics, javafx.fxml;
}
