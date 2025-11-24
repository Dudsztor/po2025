package org.example.samochodgui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import symulator.Samochod;
import java.util.Random;

public class HelloController {
    private Samochod aktywneAuto;

    private ObservableList<Samochod> flota = FXCollections.observableArrayList();

    @FXML
    private ComboBox<Samochod> wyborAutaBox;

    @FXML
    public void initialize(){
        wyborAutaBox.setItems(flota);
        dodajAutoF();
    }

    @FXML
    public void dodajAutoF(){
        String losowyNr = "KPR " + new Random().nextInt(1000,9999);
        Samochod nowe = new Samochod(losowyNr);
        flota.add(nowe);

        wyborAutaBox.getSelectionModel().select(nowe);
        aktywneAuto = nowe;
        System.out.println("Dodano nowe auto: " + losowyNr);
    }
    @FXML
    protected void wybierzAutoF() {
        aktywneAuto = wyborAutaBox.getSelectionModel().getSelectedItem();
        if (aktywneAuto != null) {
            System.out.println("Wybrano: " + aktywneAuto);
        }
    }
    @FXML
    protected void usunAutoF(){
        Samochod doUsuniecia = wyborAutaBox.getSelectionModel().getSelectedItem();
        if (doUsuniecia != null) {
            flota.remove(doUsuniecia);
            aktywneAuto = null;
            System.out.println("Usunięto auto");
        }
    }

    public Button dodajAutoBtn;
    public Button usunAutoBtn;
    @FXML
    public Button wlaczBtn;
    public Button wylaczBtn;

    public Button zwiekszBiegBtn;
    public Button zmniejszBiegBtn;

    @FXML
    private void wlaczAutoF(){
        aktywneAuto.wlacz();
    }
    @FXML
    private void wylaczAutoF(){
        aktywneAuto.wylacz();
    }
    @FXML
    private void zwiekszBiegF(){
        aktywneAuto.zwiekszBieg();
    }
    @FXML
    private void zmniejszBiegF(){
        aktywneAuto.zmniejszBieg();
    }


}
