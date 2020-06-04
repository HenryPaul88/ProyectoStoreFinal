/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author henry
 */
public class PagarProductosController implements Initializable {

    @FXML
    private TableView<String> tablaProductos;
    @FXML
    private TableColumn<String,String> columnaProductos;
    @FXML
    private Label precioTotal;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tablaProductos=new TableView();
        //columnaProductos = new TableColumn<String,String>("First Name"," ");
    }    

    
    
    @FXML
    private void confirmarPago(ActionEvent event) {
    }
    
}
