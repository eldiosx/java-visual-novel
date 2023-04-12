module java {
	requires javafx.controls;
	requires javafx.media;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
