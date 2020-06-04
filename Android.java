/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author henry
 */
public class Android extends Application {
    Set<Cliente> clientes;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vista/Multimedia.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        cargarDatos();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    public void cargarDatos() {

        clientes = new HashSet();
        String fichero = "/Users/thomyrick/IdeaProjects/android/clientes.txt";
        File f = new File(fichero);
        try {
            if (f.exists()) {
                String[] datos;
                String linea;
                BufferedReader bw = new BufferedReader(new FileReader(fichero));
                while (bw.ready()) {
                    linea = bw.readLine();
                    datos = linea.split(":");
                    String nombre = datos[0];
                    String apellidos = datos[1];
                    String email = datos[2];
                    String telefono = datos[3];
                    String direccion = datos[4];
                    String localidad = datos[5];
                    if (clientes.add((Cliente) new Cliente(nombre, apellidos, email, telefono, direccion, localidad)))
                        System.out.println("lista actualizada");
                }
                bw.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
