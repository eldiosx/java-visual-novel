module java {
	requires javafx.controls;
	requires javafx.media;
	requires java.desktop;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
