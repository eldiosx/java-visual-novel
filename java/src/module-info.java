module java {
	requires javafx.controls;
	requires javafx.media;
	requires java.desktop;
	requires javafx.fxml;
	requires java.sql;
	requires mysql.connector.j;
	
	opens application to javafx.graphics, javafx.fxml;
}
