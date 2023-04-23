package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Loader extends Stage {
	private ProgressBar progressBar;
//Esto pues es un loader basico que funciona de verdad :D recogiendo el estado del Main
	public Loader() {
		progressBar = new ProgressBar();
		progressBar.setPrefWidth(300);
		progressBar.setPrefHeight(30);
		progressBar.setProgress(0);

		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.getChildren().add(progressBar);

		Scene scene = new Scene(root, 300, 50);
		setScene(scene);
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}
}
