package Models;

import Enums.EtiquetaEcologica;
import Exceptions.DatoErroneoException;
import Interfaces.ISerializableCsv;
import java.time.LocalDate;


public class ProductoEcologico extends ProductoLimpieza implements ISerializableCsv{
    private EtiquetaEcologica etiqueta;

    public ProductoEcologico(EtiquetaEcologica etiqueta, String nombreComercial, String concentración, LocalDate fechaVencimiento) {
        super(nombreComercial, concentración, fechaVencimiento);
        this.etiqueta = etiqueta;
    }
    
    public ProductoEcologico(){
    }

    public EtiquetaEcologica getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(EtiquetaEcologica etiqueta) {
        this.etiqueta = etiqueta;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProudctoEcologico{");
        sb.append(super.toString());
        sb.append("EtiquetaEcologica=").append(etiqueta);
        sb.append('}');
        return sb.toString();
    }
    
    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toCSV()).append(", ProductoEcologico");    

        sb.append(",").append(this.etiqueta);
        
        return sb.toString();
    }
    
    @Override
    public ProductoEcologico fromCSV(String line) {
        String[] result = line.split(",");

        String nombre = result[0];
        String concentracion = result[1];
        LocalDate fecha = LocalDate.parse(result[2]);
        String tipo = result[3];
        
        String etiquetaTexto = result[4].trim();
        try {
        etiqueta = EtiquetaEcologica.valueOf(etiquetaTexto);
        } catch (IllegalArgumentException e) {
        throw new DatoErroneoException("Etiqueta inválida: " + etiquetaTexto);
        }

        return new ProductoEcologico(etiqueta, nombre, concentracion, fecha);
    }
    
}
