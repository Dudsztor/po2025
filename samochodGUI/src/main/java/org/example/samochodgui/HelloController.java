package org.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import symulator.Samochod;

import java.util.Optional;

public class HelloController {
    private Samochod aktywneAuto;
    private ObservableList<Samochod> flota = FXCollections.observableArrayList();

    @FXML private ComboBox<Samochod> wyborAutaBox;
    @FXML private TextField nrRejestracyjnyField;
    @FXML private TextField predkoscField;
    @FXML private TextField biegField;

    @FXML private Button wlaczBtn;
    @FXML private Button wylaczBtn;
    @FXML private Button zwiekszBiegBtn;
    @FXML private Button zmniejszBiegBtn;
    @FXML private Button dodajAutoBtn;
    @FXML private Button usunAutoBtn;

    @FXML private ImageView carImageView;

    @FXML
    public void initialize() {
        wyborAutaBox.setItems(flota);

        try {
            var imageStream = getClass().getResourceAsStream("/images/car.jpg");

            if (imageStream == null) {
                System.out.println("BŁĄD: Nie znaleziono pliku! Upewnij się, że plik jest w: src/main/resources/images/car.jpg");
            } else {
                Image carImage = new Image(imageStream);
                carImageView.setImage(carImage);
                carImageView.setFitWidth(100);
                carImageView.setPreserveRatio(true);
                System.out.println("Sukces: Załadowano obrazek.");
            }
        } catch (Exception e) {
            System.out.println("Wystąpił wyjątek: " + e.getMessage());
        }
    }

    @FXML
    public void dodajAutoF() {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("dodaj-view.fxml"));
            GridPane dialogContent = loader.load();

            DodajSamochodController dialogController = loader.getController();

            Dialog<Samochod> dialog = new Dialog<>();
            dialog.setTitle("Nowy Samochód");
            dialog.setHeaderText("Wprowadź dane pojazdu");
            dialog.getDialogPane().setContent(dialogContent);

            ButtonType dodajBtnType = new ButtonType("Dodaj", ButtonBar.ButtonData.OK_DONE);
            dialog.getDialogPane().getButtonTypes().addAll(dodajBtnType, ButtonType.CANCEL);

            dialog.setResultConverter(dialogButton -> {
                if (dialogButton == dodajBtnType) {
                    return dialogController.getNoweAuto();
                }
                return null;
            });

            Optional<Samochod> result = dialog.showAndWait();
            result.ifPresent(noweAuto -> {
                flota.add(noweAuto);
                wyborAutaBox.getSelectionModel().select(noweAuto);
                wybierzAutoF();
                System.out.println("Dodano auto: " + noweAuto);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void wybierzAutoF() {
        aktywneAuto = wyborAutaBox.getSelectionModel().getSelectedItem();
        refresh();
    }

    @FXML
    protected void usunAutoF(){
        Samochod doUsuniecia = wyborAutaBox.getSelectionModel().getSelectedItem();
        if (doUsuniecia != null) {
            flota.remove(doUsuniecia);
            aktywneAuto = null;
            refresh();
            System.out.println("Usunięto auto");
        }
    }

    private void refresh() {
        if (aktywneAuto != null) {
            if(nrRejestracyjnyField != null) nrRejestracyjnyField.setText(aktywneAuto.getNrRejestracyjny());
            if(predkoscField != null) predkoscField.setText(String.valueOf(aktywneAuto.getMaxPredkosc()) + " km/h");

            if(biegField != null) {
                String infoBieg = aktywneAuto.skrzynia.aktualnyBieg + " / " + aktywneAuto.skrzynia.iloscBiegow;
                biegField.setText(infoBieg);
            }
        } else {
            if(nrRejestracyjnyField != null) nrRejestracyjnyField.setText("");
            if(predkoscField != null) predkoscField.setText("");
            if(biegField != null) biegField.setText("");
        }
    }

    @FXML
    private void wlaczAutoF(){
        if(aktywneAuto != null) {
            aktywneAuto.wlacz();
            refresh();
        }
    }
    @FXML
    private void wylaczAutoF(){
        if(aktywneAuto != null) {
            aktywneAuto.wylacz();
            refresh();
        }
    }
    @FXML
    private void zwiekszBiegF(){
        if(aktywneAuto != null) {
            aktywneAuto.zwiekszBieg();
            refresh();
        }
    }
    @FXML
    private void zmniejszBiegF(){
        if(aktywneAuto != null) {
            aktywneAuto.zmniejszBieg();
            refresh();
        }
    }
}