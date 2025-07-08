package Models;

import Enums.Advertencia;
import Exceptions.DatoErroneoException;
import Interfaces.ISerializableCsv;
import java.time.LocalDate;


public class ProductoQuimico extends ProductoLimpieza implements ISerializableCsv{
    private Advertencia tipoAdvertencia;

    public ProductoQuimico(Advertencia tipoAdvertencia, String nombreComercial, String concentración, LocalDate fechaVencimiento) {
        super(nombreComercial, concentración, fechaVencimiento);
        this.tipoAdvertencia = tipoAdvertencia;
    }
    
    public ProductoQuimico() {
    }


    public Advertencia getTipoAdvertencia() {
        return tipoAdvertencia;
    }

    public void setTipoAdvertencia(Advertencia tipoAdvertencia) {
        this.tipoAdvertencia = tipoAdvertencia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProductoQuimico{");
        sb.append(super.toString());
        sb.append("tipoAdvertencia=").append(tipoAdvertencia);
        sb.append('}');
        return sb.toString();
    }
    
    public String toCSV(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toCSV()).append(", ProductoQuimico");    

        sb.append(",").append(this.tipoAdvertencia);
        
        return sb.toString();
    }
    
    @Override
    public ProductoQuimico fromCSV(String line) {
        String[] result = line.split(",");

        String nombre = result[0];
        String concentracion = result[1];
        LocalDate fecha = LocalDate.parse(result[2]);
        String tipo = result[3];
        
        String advertenciaTexto = result[4].trim();
        try {
        tipoAdvertencia = Advertencia.valueOf(advertenciaTexto);
        } catch (IllegalArgumentException e) {
        throw new DatoErroneoException("Advertencia inválida: " + advertenciaTexto);
        }

        return new ProductoQuimico( tipoAdvertencia, nombre, concentracion, fecha);
    }
    
}
