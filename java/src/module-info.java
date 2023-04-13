module java {
	requires javafx.controls;
	requires javafx.media;
	requires java.desktop;
	requires javafx.fxml;
	requires java.sql;
<<<<<<< Updated upstream
	requires mysql.connector.j;
=======
//	requires java.desktop;
//	requires mysql.connector.j;
>>>>>>> Stashed changes
	
	opens application to javafx.graphics, javafx.fxml;
}
