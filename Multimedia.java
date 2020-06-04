
package Controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author henry
 */

public class Multimedia implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void registarse(ActionEvent evento) {
        try {
            // Cargo la ventana
            Parent rootRegistrarse = FXMLLoader.load(getClass().getResource("/Vista/Registrarse.fxml"));

            // Creo el Scene
            Scene scene = new Scene(rootRegistrarse);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void iniciarSesion(ActionEvent evento) {
        try {
            Parent rootiniciarSesion = FXMLLoader.load(getClass().getResource("/Vista/IniciarSesion.fxml"));
            Scene scene = new Scene(rootiniciarSesion);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void quienesSomos(ActionEvent evento) {
        try {
            Parent rootquienesSomos = FXMLLoader.load(getClass().getResource("/Vista/QuienesSomos.fxml"));
            Scene scene = new Scene(rootquienesSomos);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }

    public void articulos(ActionEvent evento) {

        try {
            Parent rootarticulos = FXMLLoader.load(getClass().getResource("/Vista/Articulos.fxml"));
            Scene scene = new Scene(rootarticulos);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }
    }
}
