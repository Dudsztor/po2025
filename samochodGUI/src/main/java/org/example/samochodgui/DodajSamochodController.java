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

    @FXML private ComboBox<String> engineComboBox;
    @FXML private ComboBox<String> gearboxComboBox;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;

    @FXML
    public void initialize() {
        ObservableList<String> silniki = FXCollections.observableArrayList(
                "Diesel 1.9 TDI",
                "Benzyna 2.0 Turbo",
                "Elektryczny",
                "V8 5.0L"
        );
        engineComboBox.setItems(silniki);
        engineComboBox.getSelectionModel().selectFirst();

        ObservableList<String> skrzynie = FXCollections.observableArrayList(
                "Manualna 5-biegowa",
                "Manualna 6-biegowa",
                "Automat 8-biegowy"
        );
        gearboxComboBox.setItems(skrzynie);
        gearboxComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void onConfirmButton() {
        String model = modelTextField.getText();
        String registration = registrationTextField.getText();
        String selectedEngine = engineComboBox.getValue();
        String selectedGearbox = gearboxComboBox.getValue();

        double weight;
        int speed;

        try {
            weight = Double.parseDouble(weightTextField.getText());
            speed = Integer.parseInt(speedTextField.getText());

            HelloController.addCarToList(model, registration, weight, speed, selectedEngine, selectedGearbox);

            Stage stage = (Stage) confirmButton.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Błąd");
            alert.setHeaderText("Niepoprawne dane");
            alert.showAndWait();
        }
    }

    @FXML
    private void onCancelButton() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}