package symulator;

import javafx.scene.control.Alert;

public class pokazBlad extends RuntimeException {
    public pokazBlad(String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Błąd");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
