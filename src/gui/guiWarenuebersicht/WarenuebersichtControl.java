package gui.guiWarenuebersicht;

import business.GetraenkemarktModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {
	private WarenuebersichtView warenuebersichtView;
	private GetraenkemarktModel getraenkeModel;

	public WarenuebersichtControl(Stage primaryStage) {
		this.getraenkeModel = GetraenkemarktModel.getInstance();
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, getraenkeModel);
	}
}