package org.example.samochodgui;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import symulator.*;

public class HelloController implements Listener {

    private Samochod aktywneAuto;
    private ObservableList<Samochod> flota = FXCollections.observableArrayList();
    private static HelloController instancja;

    @FXML private ComboBox<Samochod> wyborAutaBox;
    @FXML private ImageView carImageView;

    @FXML private TextField modelTextField;
    @FXML private TextField nrRejestracyjnyField;
    @FXML private TextField wagaTextField;
    @FXML private TextField predkoscField;
    @FXML private TextField currentSpeedField;
    @FXML private TextField gearboxNameField;
    @FXML private TextField biegField;
    @FXML private TextField engineNameField;
    @FXML private TextField obrotyField;
    @FXML private TextField clutchStateField;

    @FXML private TextField silnikCenaField;
    @FXML private TextField sprzegloCenaField;
    @FXML private TextField skrzyniaCenaField;

    @FXML private AnchorPane mapPane;

    public HelloController() {
        instancja = this;
    }

    @FXML
    public void initialize() {
        mapPane.setOnMouseClicked((MouseEvent event) -> {
            if (aktywneAuto != null) {
                aktywneAuto.jedzDo(new Pozycja(event.getX(), event.getY()));
            }
        });

        wyborAutaBox.setItems(flota);

        wyborAutaBox.setOnAction(event -> {
            if (aktywneAuto != null) {
                aktywneAuto.removeListener(this);
            }

            aktywneAuto = wyborAutaBox.getSelectionModel().getSelectedItem();

            if (aktywneAuto != null) {
                aktywneAuto.addListener(this);
                refresh();
            } else {
                modelTextField.setText("");
            }
        });

        try {
            Image img = new Image(getClass().getResourceAsStream("/images/car.jpg"));
            carImageView.setImage(img);
            carImageView.setFitWidth(50);
            carImageView.setPreserveRatio(true);
        } catch (Exception e) {
            System.out.println("Nie znaleziono obrazka car.jpg");
        }
    }

    @Override
    public void update() {
        Platform.runLater(this::refresh);
    }

    private void refresh() {
        if (aktywneAuto == null) return;
        //ogolne
        modelTextField.setText(aktywneAuto.getModel());
        nrRejestracyjnyField.setText(aktywneAuto.getNrRejestracyjny());
        wagaTextField.setText(String.valueOf(aktywneAuto.getWaga()));
        predkoscField.setText(String.valueOf(aktywneAuto.getMaxPredkosc()));
        currentSpeedField.setText(String.valueOf(aktywneAuto.getAktualnaPredkosc())); // Zakładam że getAktualnaPredkosc zwraca double
        //silnik
        engineNameField.setText(aktywneAuto.silnik.getNazwa());
        obrotyField.setText(String.valueOf(aktywneAuto.silnik.getObroty()));
        silnikCenaField.setText(String.valueOf(aktywneAuto.silnik.getCena()));
        //skrzynia
        gearboxNameField.setText(aktywneAuto.skrzynia.getNazwa());
        biegField.setText(aktywneAuto.skrzynia.getAktualnyBieg() + " / " + aktywneAuto.skrzynia.getIloscBiegow());
        skrzyniaCenaField.setText(String.valueOf(aktywneAuto.skrzynia.getCena()));
        //sprzeglo
        String sprzegloStatus = aktywneAuto.sprzeglo.isWcisniete() ? "Wcisniete" : "Zwolnione";
        clutchStateField.setText(sprzegloStatus);
        sprzegloCenaField.setText(String.valueOf(aktywneAuto.sprzeglo.getCena()));
        //pozycja
        Pozycja p = aktywneAuto.getPozycja();
        carImageView.setTranslateX(p.getX());
        carImageView.setTranslateY(p.getY());
    }

    public void dodajSamochod(Samochod nowySamochod) {
        flota.add(nowySamochod);
        wyborAutaBox.getSelectionModel().select(nowySamochod);
    }

    public static void addCarToList(String model, String registration, double weight, int speed, String engineName, String gearboxName) {
        if (instancja != null) {
            Silnik nowySilnik = new Silnik(engineName, 150, 2000, 6000);
            SkrzyniaBiegow nowaSkrzynia = new SkrzyniaBiegow(gearboxName, 50, 1500, 6);
            Sprzeglo noweSprzeglo = new Sprzeglo("Standard", 20, 500);

            Samochod auto = new Samochod(model, registration, weight, speed, nowySilnik, nowaSkrzynia, noweSprzeglo);

            instancja.dodajSamochod(auto);

            System.out.println("Dodano auto: " + model);
        }
    }

    @FXML
    protected void usunAutoF() {
        if (aktywneAuto != null) {
            aktywneAuto.removeListener(this);
            flota.remove(aktywneAuto);
            aktywneAuto = null;

            if (!flota.isEmpty()) {
                wyborAutaBox.getSelectionModel().selectFirst();
            } else {
                wyborAutaBox.getSelectionModel().clearSelection();
            }
            System.out.println("Usunięto auto");
        }
    }

    @FXML
    public void dodajAutoF() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("dodaj-view.fxml"));
            GridPane dialogContent = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Nowy Samochód");
            stage.setScene(new Scene(dialogContent));
            stage.showAndWait();
        } catch (Exception e) {
            pokazBlad(e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML private void wlaczAutoF(){
        if (aktywneAuto != null) {
            aktywneAuto.wlacz();
        }
    }
    @FXML private void wylaczAutoF(){
        if (aktywneAuto != null) {
            aktywneAuto.wylacz();
        }
    }
    @FXML private void zwiekszBiegF() {
        if (aktywneAuto != null) {
            try {
                aktywneAuto.zwiekszBieg();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }
    @FXML private void zmniejszBiegF() {
        if (aktywneAuto != null) {
            try {
                aktywneAuto.zmniejszBieg();
            } catch (Exception e) {
                pokazBlad(e.getMessage());
            }
        }
    }
    @FXML private void nacisnijSprzeglo() {
        if (aktywneAuto != null) {
            aktywneAuto.sprzeglo.wcisnij();
            refresh();
        }
    }
    @FXML private void zwolnijSprzeglo() {
        if (aktywneAuto != null) {
            aktywneAuto.sprzeglo.zwolnij();
            refresh();
        }
    }
    @FXML private void dodajGazu() {
        if (aktywneAuto != null) {
            aktywneAuto.silnik.zwiekszObroty();
            refresh();
        }
    }
    @FXML private void ujmijGazu() {
        if (aktywneAuto != null) {
            aktywneAuto.silnik.zmniejszObroty();
            refresh();
        }
    }
    private void pokazBlad(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText("Operacja niedozwolona");
        alert.setContentText(message);
        alert.showAndWait();
    }
}