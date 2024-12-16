package gui.guiWarenuebersicht;

import java.util.ArrayList;

import business.Getraenkemarkt;
import business.GetraenkemarktModel;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class WarenuebersichtView implements Observer {

	private WarenuebersichtControl getrCont;

	private WarenuebersichtControl warenuebersichtControl;
	private GetraenkemarktModel getrMod;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeGetraenke = new Label("Anzeige Getränke");
	private TextArea txtAnzeigeGetraenke = new TextArea();
	private Button btnAnzeigeGetraenke = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public WarenuebersichtView(WarenuebersichtControl warenuebersichtControl, Stage primaryStage,
			GetraenkemarktModel getraenkeModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige der Warenübersicht");
		primaryStage.show();
		this.warenuebersichtControl = warenuebersichtControl;

		// View als Observer hinzufuegen
		this.getrMod = GetraenkemarktModel.getInstance();
		getrMod.addObserver(this);

		// getraenkeModel.addObserver(this);

		this.initKomponenten();
		this.initListener();

	}

	@Override
	public void update() {
		//getrMod.zeigeGetraenkeMarktAn();
		zeigeGetraenkeAn();

	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeGetraenke.setLayoutX(310);
		lblAnzeigeGetraenke.setLayoutY(40);
		lblAnzeigeGetraenke.setFont(font);
		lblAnzeigeGetraenke.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeGetraenke);
// Textbereich
		txtAnzeigeGetraenke.setEditable(false);
		txtAnzeigeGetraenke.setLayoutX(310);
		txtAnzeigeGetraenke.setLayoutY(90);
		txtAnzeigeGetraenke.setPrefWidth(220);
		txtAnzeigeGetraenke.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeGetraenke);
		// Button
		btnAnzeigeGetraenke.setLayoutX(310);
		btnAnzeigeGetraenke.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeGetraenke);
	}

	private void initListener() {
		btnAnzeigeGetraenke.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeGetraenkeAn();
			}
		});
	}

	// Anpassen
	private void zeigeGetraenkeAn() {
		if (getrMod.getGetraenk().size() > 0) {
			StringBuffer text = new StringBuffer();
			// Erg�nzen: for each - Schleife ueber ArrayList
			for(int i = 0; i < getrMod.getGetraenk().size(); i++) {
				text.append(getrMod.getGetraenk());
			}
		
			this.txtAnzeigeGetraenke.setText(text.toString());
		}
		else {
			zeigeInformationsfensterAn(
					"Bisher wurde kein Getränk aufgenommen!");
		}
	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

}