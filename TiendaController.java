
package Controlador;


import Modelo.Articulo;
import Modelo.Peliculas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Modelo.ProductCarrito;
import Modelo.Series;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author henry
 */
public class TiendaController implements Initializable {

//TODO solo utilizo objestos ojo::

    private static DecimalFormat df = new DecimalFormat(".##");

    @FXML
    private ComboBox<String> idArticulosCombo;
    @FXML
    private Label idBienvenido;

    private ObservableList<String> combo;


    @FXML
    private TableView<Object> addTable;

    @FXML
    private TableView<ProductCarrito> addTableCarrito;

    @FXML
    private TableColumn<Object, String> idNombre;

    @FXML
    private TableColumn<Object, String> idGenero;

    @FXML
    private TableColumn<Object, String> idDirector;

    @FXML
    private TableColumn<Object, String> idDescripcion;

    @FXML
    private TableColumn<Object, String> idPrecio;

    //productos carrrito
    @FXML
    private TableColumn<Object, String> idName;

    @FXML
    private TableColumn<Object, String> idType;

    @FXML
    private TableColumn<Object, String> idCost;

    @FXML
    private TextField ptotalPrice;

    double lasValue = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        combo = FXCollections.observableArrayList("Peliculas", "Series", "Fotos", "Musicas");
        idArticulosCombo.setItems(combo);

    }

    @FXML
    public void añadirArticulo(ActionEvent event) {
        try {
            Parent rootiniciarSesion = FXMLLoader.load(getClass().getResource("/Vista/Productos.fxml"));
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

    //todo estas son las tablas con sus respectivos indicadores de columna
    public void tablePeliculas() {
        idNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        idDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
        idDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        idPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

    }

    // todo estas son las tablas con sus respectivos indicadores de columna
    public void tableSeries() {
        idNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        idPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        idDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        idDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
    }

    @FXML
    public void getcombo(ActionEvent event) {

        String articuloElejido = idArticulosCombo.getValue();
        BufferedReader bw;

        String[] datos;
        String linea;
        String fichero;

//todo::: prefiro usar el swith sorry master

        switch (articuloElejido) {

            case "Peliculas": {
                addTable.getItems().clear();
                tablePeliculas();

                fichero = "/Users/thomyrick/IdeaProjects/android/peliculas.txt";

                File f = new File(fichero);

                try {
                    if (f.exists()) {
                        bw = new BufferedReader(new FileReader(fichero));
                        while (bw.ready()) {
                            linea = bw.readLine();
                            datos = linea.split(":");

                            Peliculas movie = new Peliculas(datos[0], datos[1], datos[2], datos[3], datos[4]);

                            addTable.getItems().addAll(movie);

                        }

                    }
                } catch (IOException ex) {
                    Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "Series": {

                //fixme este es el que borra la list
                addTable.getItems().clear();
                tableSeries();
                fichero = "/Users/thomyrick/IdeaProjects/android/series.txt";

                File f = new File(fichero);

                try {
                    if (f.exists()) {
                        bw = new BufferedReader(new FileReader(fichero));
                        while (bw.ready()) {
                            linea = bw.readLine();
                            datos = linea.split(":");


                            Series movie = new Series(datos[0], datos[1], datos[2], datos[3],datos[4]);

//esto lo que hace es agregar los elemetos en el items de addTable
                            addTable.getItems().addAll(movie);

                        }

                    }
                } catch (IOException ex) {
                    Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;
            }
            case "Fotos":
                addTable.getItems().clear();

                fichero = "/Users/thomyrick/IdeaProjects/android/series.txt";
                tableSeries();
                File f = new File(fichero);

                try {
                    if (f.exists()) {
                        bw = new BufferedReader(new FileReader(fichero));
                        while (bw.ready()) {
                            linea = bw.readLine();
                            datos = linea.split(":");




                        }

                    }
                } catch (IOException ex) {
                    Logger.getLogger(RegistarseController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "Musicas":

                break;
        }

    }

    @FXML
    private void añadirCompra(ActionEvent event) {
        tableCarrito();
        ObservableList<Object> seleProduct;
        seleProduct = addTable.getSelectionModel().getSelectedItems();


        String articuloElejido = idArticulosCombo.getValue();


        String productData = seleProduct.toString();

        int totalCost = 0;


        switch (articuloElejido) {

            case "Peliculas":

                String[] rest = productData.split(",");

                String namePeli = rest[0];
                namePeli = namePeli.substring(namePeli.indexOf("'"));

                String costPeli = rest[rest.length - 1];

                costPeli = costPeli.substring(costPeli.indexOf("'") + 1, costPeli.indexOf("$"));

                totalCost = totalCost + Integer.parseInt(costPeli);


                ProductCarrito pelicula = new ProductCarrito(namePeli, "Pelicula", costPeli + "$");

                addTableCarrito.getItems().addAll(pelicula);

                break;

            case "Series":

                String[] restSerie = productData.split(",");

                String nameSerie = restSerie[0];
                nameSerie = nameSerie.substring(nameSerie.indexOf("'"));

                String costSerie = restSerie[restSerie.length - 1];

                costSerie = costSerie.substring(costSerie.indexOf("'") + 1, costSerie.indexOf("$"));

                totalCost = totalCost + Integer.parseInt(costSerie);

                ProductCarrito serie = new ProductCarrito(nameSerie, "Serie", costSerie + "$");

                addTableCarrito.getItems().addAll(serie);

                break;
            default:

        }


        double inputValue = Double.parseDouble(String.valueOf(totalCost));

        lasValue=lasValue+inputValue;

        ptotalPrice.setText(df.format(lasValue));



    }

    public void borrarProducto(ActionEvent event){
        ObservableList<ProductCarrito> allProductos,productSelectinado;


        allProductos= addTableCarrito.getItems();
        productSelectinado= addTableCarrito.getSelectionModel().getSelectedItems();
        String resta=productSelectinado.get(0).getPrecio().replace("$","");
        System.out.println("producto borrado ::: "+resta);

        int diferencia=Integer.parseInt(resta);

        lasValue=lasValue-diferencia;
        ptotalPrice.setText(df.format(lasValue));
        //Fixme que cuando queda solo un producto en al lista y borras el unico salta un error porque ?
        productSelectinado.forEach(allProductos::remove);





    }

    // todo estas son las tablas carrito
    public void tableCarrito() {
        idName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        idType.setCellValueFactory(new PropertyValueFactory<>("type"));
        idCost.setCellValueFactory(new PropertyValueFactory<>("precio"));
    }


}
