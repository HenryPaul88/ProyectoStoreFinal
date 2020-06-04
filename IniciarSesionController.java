/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author henry
 */
public class IniciarSesionController implements Initializable {

    @FXML
    private TextField idNombre;
    @FXML
    private TextField idEmail;
    private String nombre, email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public boolean obtenerDatos() {
        String fichero = "/Users/thomyrick/IdeaProjects/android/clientes.txt";
        boolean valido = false;
        int cont = 0;
        try {
            BufferedReader bw = new BufferedReader(new FileReader(fichero));
            String[] datos;
            String frase;
            while (bw.ready()) {
                frase = bw.readLine();
                datos = frase.split(":");
                for (String dato : datos) {
                    if (dato.equals(idNombre.getText())) {
                        nombre = idNombre.getText();
                        cont++;
                    }
                    if (dato.equals(idEmail.getText())) {
                        email = idEmail.getText();
                        cont++;
                    }
                }
            }
            if (cont == 2)
                valido = true;
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valido;
    }



    public void entrar(ActionEvent evento) {
        if (obtenerDatos()) {
            try {
                Parent rootquienesSomos = FXMLLoader.load(getClass().getResource("/Vista/Tienda.fxml"));
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
        } else {
            System.out.println("error");
        }
    }

}
