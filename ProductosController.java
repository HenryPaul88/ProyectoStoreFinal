/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author henry
 */
public class ProductosController implements Initializable {

    @FXML
    private CheckBox idPeliculas;
    @FXML
    private CheckBox idSeries;
    @FXML
    private CheckBox idFotos;
    @FXML
    private CheckBox idMusica;
    @FXML
    private TextField idNombre;
    @FXML
    private TextField idPrecio;
    @FXML
    private TextField idDescripcion;
    @FXML
    private TextField idDirector;
    @FXML
    private TextField idGenero;
    @FXML
    private TextField idCantante;
    @FXML
    private Button idAñadir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void insertar(ActionEvent event) {
        String fichero;
        if (idMusica.isSelected()) {
            try {
                fichero = "/Users/thomyrick/IdeaProjects/android/musica.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write(idNombre.getText() + ":");
                bw.write(idPrecio.getText() + ":");
                bw.write(idDescripcion.getText() + ":");
                bw.write(idGenero.getText() + ":");
                bw.write(idCantante.getText() + ":");
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (idPeliculas.isSelected()) {
            try {
                fichero = "/Users/thomyrick/IdeaProjects/android/peliculas.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write(idNombre.getText() + ":");
                bw.write(idPrecio.getText() + ":");
                bw.write(idDescripcion.getText() + ":");
                bw.write(idGenero.getText() + ":");
                bw.write(idDirector.getText() + ":");
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (idSeries.isSelected()) {
            try {
                fichero = "/Users/thomyrick/IdeaProjects/android/series.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write(idNombre.getText() + ":");
                bw.write(idPrecio.getText() + ":");
                bw.write(idDescripcion.getText() + ":");
                bw.write(idCantante.getText() + ":");
                bw.write(idDirector.getText() + ":");
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (idFotos.isSelected()) {
            try {
                fichero = "/Users/thomyrick/IdeaProjects/android/fotos.txt";
                BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));
                bw.write(idNombre.getText() + ":");
                bw.write(idPrecio.getText() + ":");
                bw.write(idDescripcion.getText() + ":");
                bw.write(idGenero.getText() + ":");
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @FXML
    public void musica(ActionEvent event) {

        if (idMusica.isSelected()) {
            idPeliculas.setVisible(false);
            idSeries.setVisible(false);
            idFotos.setVisible(false);
            idDirector.setVisible(false);

        } else {
            idPeliculas.setVisible(true);
            idSeries.setVisible(true);
            idFotos.setVisible(true);
            idDirector.setVisible(true);
        }
    }

    @FXML
    public void peliculas(ActionEvent event) {

        if (idPeliculas.isSelected()) {
            idMusica.setVisible(false);
            idSeries.setVisible(false);
            idFotos.setVisible(false);
            idCantante.setVisible(false);

        } else {
            idMusica.setVisible(true);
            idSeries.setVisible(true);
            idFotos.setVisible(true);
            idCantante.setVisible(true);
        }
    }

    @FXML
    public void series(ActionEvent event) {

        if (idSeries.isSelected()) {
            idMusica.setVisible(false);
            idPeliculas.setVisible(false);
            idFotos.setVisible(false);
            idCantante.setVisible(false);

        } else {
            idMusica.setVisible(true);
            idPeliculas.setVisible(true);
            idFotos.setVisible(true);
            idCantante.setVisible(true);
        }
    }

    @FXML
    public void fotos(ActionEvent event) {

        if (idFotos.isSelected()) {
            idMusica.setVisible(false);
            idPeliculas.setVisible(false);
            idDirector.setVisible(false);
            idCantante.setVisible(false);
            idSeries.setVisible(false);

        } else {
            idMusica.setVisible(true);
            idPeliculas.setVisible(true);
            idFotos.setVisible(true);
            idCantante.setVisible(true);
            idDirector.setVisible(true);
            idSeries.setVisible(true);
        }
    }

}
