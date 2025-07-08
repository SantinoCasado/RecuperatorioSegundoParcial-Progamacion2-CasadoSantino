package Controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import Models.ProductoLimpieza;
import Utilities.JsonSave;
import java.util.ArrayList;

public class FiltradoController implements Initializable {
    @FXML
    private ListView<ProductoLimpieza> listViewFiltrados;

    @FXML
    private Button btnGuardar;

    private List<ProductoLimpieza> productosFiltrados;

    public void setProductosFiltrados(List<ProductoLimpieza> productos) {
        this.productosFiltrados = productos;
        listViewFiltrados.getItems().setAll(productos);
    }

    @FXML
    public void guardarFiltrados() {
        if (productosFiltrados == null || productosFiltrados.isEmpty()) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setTitle("Sin productos");
            alerta.setHeaderText(null);
            alerta.setContentText("No hay productos filtrados para guardar.");
            alerta.showAndWait();
            return;
        }

        JsonSave.guardarProductos(productosFiltrados);

        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Guardado exitoso");
        alerta.setHeaderText(null);
        alerta.setContentText("Los productos filtrados fueron guardados en formato JSON.");
        alerta.showAndWait();
    
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}