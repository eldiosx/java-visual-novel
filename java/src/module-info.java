module java {
	requires javafx.controls;
	requires javafx.media;
	requires javafx.fxml;
	requires java.sql;
	requires mysql.connector.j;
//	requires java.desktop;
//	requires mysql.connector.j;
	
	opens application to javafx.graphics, javafx.fxml;
}
