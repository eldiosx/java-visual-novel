module java {
	requires javafx.controls;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
}
