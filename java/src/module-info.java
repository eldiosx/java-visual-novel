module java {
	requires javafx.controls;
	requires javafx.media;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
