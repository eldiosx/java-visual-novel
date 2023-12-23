module org.ignisus.visual_novel {
	requires transitive javafx.controls; // UI Controls
	requires transitive javafx.media; // APIs for audio
	requires transitive gdx; // API GDX for mediaplayer .ogg
	requires transitive jorbis; // API for ogg
	requires transitive javafx.fxml; // FXML
	requires transitive javafx.graphics; // CSS
	requires transitive java.sql; // SQL
	requires transitive java.desktop; // AWT and Swing

	opens org.ignisus.visual_novel to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a la raiz
	opens org.ignisus.visual_novel.prologue to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a prologue
	opens org.ignisus.visual_novel.ep1 to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a ep1
	opens org.ignisus.visual_novel.ep2 to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a ep2
	opens org.ignisus.visual_novel.end to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a end

	exports org.ignisus.visual_novel to javafx.graphics, javafx.fxml, jdx; // Abrir el paquete a los modulos a la raiz
	exports org.ignisus.visual_novel.prologue to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a prologue
	exports org.ignisus.visual_novel.ep1 to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a ep1
	exports org.ignisus.visual_novel.ep2 to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a ep2
	exports org.ignisus.visual_novel.end to javafx.graphics, javafx.fxml, jdx; // Exportar el paquete a los modulos a end
}
