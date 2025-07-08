package Utilities;

import Models.ProductoEcologico;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import Models.ProductoLimpieza;
import Models.ProductoQuimico;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonSave {

    private static final String RUTA_JSON = "src/DatosFormularios/productosProximosVencer.json";

    public static void guardarProductos(List<ProductoLimpieza> productos) {
    List<Map<String, String>> listaExportable = new ArrayList<>();

    for (ProductoLimpieza p : productos) {
        // Guardo los datos del producto como pares clave-valor.
        Map<String, String> datos = new HashMap<>();
        datos.put("nombreComercial", p.getNombreComercial());
        datos.put("concentracion", p.getConcentración());
        datos.put("fechaVencimiento", p.getFechaVencimiento().toString());
        
        //Detecto si el producto es químico o ecológico y agrega el tipo y su dato extra.
        if (p instanceof ProductoQuimico quimico) {
            datos.put("tipo", "ProductoQuimico");
            datos.put("advertencia", quimico.getTipoAdvertencia().name());
        } else if (p instanceof ProductoEcologico ecologico) {
            datos.put("tipo", "ProductoEcologico");
            datos.put("etiqueta", ecologico.getEtiqueta().name());
        } else {
            datos.put("tipo", "Desconocido");
        }
        
        //- Agrega ese mapa a una lista llamada listaExportable que seria la definitiva
        listaExportable.add(datos);
    }

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(listaExportable);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_JSON))) {
        writer.write(json);
        System.out.println("Lista serializada a JSON en: " + RUTA_JSON);
    } catch (IOException e) {
        System.err.println("Error al guardar JSON: " + e.getMessage());
    }
}

    public static void leerProductos() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_JSON))) {
            Gson gson = new Gson();
            Map[] productos = gson.fromJson(br, Map[].class);

            System.out.println("Productos leídos desde JSON:");
            for (Map producto : productos) {
                System.out.println(producto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer JSON: " + e.getMessage());
        }
    }
}
