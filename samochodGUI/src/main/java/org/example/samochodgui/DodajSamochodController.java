package org.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {

    @FXML private TextField modelTextField;
    @FXML private TextField registrationTextField;
    @FXML private TextField weightTextField;
    @FXML private TextField speedTextField;

    @FXML private ComboBox<SilnikSpec> engineComboBox;
    @FXML private ComboBox<SkrzyniaSpec> gearboxComboBox;
    @FXML private ComboBox<SprzegloSpec> clutchComboBox;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    public static class SilnikSpec {
        String nazwa;
        double waga;
        double cena;
        int maxObroty;

        public SilnikSpec(String nazwa, double waga, double cena, int maxObroty) {
            this.nazwa = nazwa;
            this.waga = waga;
            this.cena = cena;
            this.maxObroty = maxObroty;
        }
        @Override public String toString() {
            return nazwa;
        }
    }

    public static class SkrzyniaSpec {
        String nazwa;
        double waga;
        double cena;
        int iloscBiegow;

        public SkrzyniaSpec(String nazwa, double waga, double cena, int iloscBiegow) {
            this.nazwa = nazwa;
            this.waga = waga;
            this.cena = cena;
            this.iloscBiegow = iloscBiegow;
        }
        @Override public String toString() {
            return nazwa;
        }
    }

    public static class SprzegloSpec {
        String nazwa;
        double waga;
        double cena;

        public SprzegloSpec(String nazwa, double waga, double cena) {
            this.nazwa = nazwa;
            this.waga = waga;
            this.cena = cena;
        }
        @Override public String toString() {
            return nazwa;
        }
    }
    @FXML
    public void initialize() {
        ObservableList<SilnikSpec> silniki = FXCollections.observableArrayList(
                new SilnikSpec("Diesel 1.9 (wolny)", 200.0, 5000.0, 4000),
                new SilnikSpec("V8 (umiarkowany)", 350.0, 20000.0, 6000),
                new SilnikSpec("Benzyna 2.0 (szybki)", 160.0, 8000.0, 8000),
                new SilnikSpec("Elektryczny (najszybszy)", 100.0, 15000.0, 10000)

        );
        engineComboBox.setItems(silniki);
        engineComboBox.getSelectionModel().selectFirst();

        ObservableList<SkrzyniaSpec> skrzynie = FXCollections.observableArrayList(
                new SkrzyniaSpec("5-biegowa", 50.0, 1500.0, 5),
                new SkrzyniaSpec("6-biegowa", 60.0, 2500.0, 6),
                new SkrzyniaSpec("8-biegowy", 90.0, 6000.0, 8)
        );
        gearboxComboBox.setItems(skrzynie);
        gearboxComboBox.getSelectionModel().selectFirst();

        ObservableList<SprzegloSpec> sprzegla = FXCollections.observableArrayList(
                new SprzegloSpec("Lekkie", 15.0, 500.0),
                new SprzegloSpec("Ciężkie", 50.0, 1500.0)
        );
        clutchComboBox.setItems(sprzegla);
        clutchComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();

        SilnikSpec selectedEngine = engineComboBox.getValue();
        SkrzyniaSpec selectedGearbox = gearboxComboBox.getValue();
        SprzegloSpec selectedClutch = clutchComboBox.getValue();

        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());

            HelloController.addCarToList(model, registration, weight, speed,
                    selectedEngine, selectedGearbox, selectedClutch);

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Niepoprawne dane liczbowe");
            alert.showAndWait();
        }
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}