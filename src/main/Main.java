package main;

import gui.guiGetraenkemarkt.GetraenkemarktControl;
//import gui.guiWarenuebersicht.GetraenkemarktEinrichtungControl;
import gui.guiWarenuebersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new GetraenkemarktControl(primaryStage);

		// Stage fensterGetraenkemarktEinrichtung = new Stage ();

		// new GetraenkemarktEinrichtungControl(fensterGetraenkemarktEinrichtung);

		Stage fensterWarenuebersichtEinrichtung = new Stage();

		new WarenuebersichtControl(fensterWarenuebersichtEinrichtung);
	}

	public static void main(String[] args) {
		launch(args);
	}
}