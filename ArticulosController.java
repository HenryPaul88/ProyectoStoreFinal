/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author henry
 */
public class ArticulosController implements Initializable {

    @FXML
    private ImageView idPelicula;
    @FXML
    private ImageView idMusica;
    @FXML
    private ImageView idImagenes;
    @FXML
    private ImageView idSerie;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        Image img = new Image("imagenes/imagenes.jpg");
        idPelicula = new ImageView();
        idPelicula.setImage(img);
        idPelicula.setVisible(true);
        idPelicula.setFitWidth(100);
        idPelicula.setFitHeight(100);

    }

}
