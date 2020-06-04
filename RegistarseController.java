
package Controlador;

import Modelo.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class RegistarseController implements Initializable {
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idApellidos;
    @FXML
    private TextField idEmail;
    @FXML
    private TextField idTelefono;
    @FXML
    private TextField idDireccion;
    @FXML
    private TextField idLocalidad;
    Android a;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        a = new Android();
        a.clientes = new HashSet();

    }

    public void registrar(ActionEvent evento) {
        String fichero = "/Users/thomyrick/IdeaProjects/android/clientes.txt";

        if (idNombre.getText().isEmpty() ||
                idApellidos.getText().isEmpty() ||
                idEmail.getText().isEmpty() ||
                idTelefono.getText().isEmpty() ||
                idDireccion.getText().isEmpty() ||
                idLocalidad.getText().isEmpty()) {
            error();
        } else {
            if (guardarCliente()) {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                    bw.write(idNombre.getText() + ":");
                    bw.write(idApellidos.getText() + ":");
                    bw.write(idEmail.getText() + ":");
                    bw.write(idTelefono.getText() + ":");
                    bw.write(idDireccion.getText() + ":");
                    bw.write(idLocalidad.getText() + ":");
                    bw.newLine();
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.showAndWait();
        alert.setContentText("introducir contenido");
    }

    public boolean guardarCliente() {
        boolean registrado = false;
        String nombre = idNombre.getText();
        String apellidos = idNombre.getText();
        String email = idNombre.getText();
        String telefono = idNombre.getText();
        String direccion = idNombre.getText();
        String localidad = idNombre.getText();
        if (a.clientes.add((Cliente) new Cliente(nombre, apellidos, email, telefono, direccion, localidad))) {
            registrado = true;
            System.out.println("usuario registrado en array");
        } else {
            System.out.println("usuario repedito");
            registrado = false;
        }
        return registrado;
    }
}
