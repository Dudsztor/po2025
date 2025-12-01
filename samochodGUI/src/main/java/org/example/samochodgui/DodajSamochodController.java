package org.example.samochodgui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import symulator.Samochod;

public class DodajSamochodController {

    @FXML
    private TextField nazwaField;

    @FXML
    private TextField predkoscField;

    @FXML
    private TextField biegiField;

    public Samochod getNoweAuto() {
        try {
            String nazwa = nazwaField.getText();
            // Prosta walidacja pustej nazwy
            if (nazwa == null || nazwa.trim().isEmpty()) {
                return null;
            }

            int predkosc = Integer.parseInt(predkoscField.getText());
            int biegi = Integer.parseInt(biegiField.getText());

            // Tworzymy nowe auto z parametrami
            return new Samochod(nazwa, predkosc, biegi);
        } catch (NumberFormatException e) {
            System.out.println("Błąd: Wpisano niepoprawne liczby!");
            return null;
        }
    }
}