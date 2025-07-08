package Models;

import Interfaces.ISerializableCsv;
import Validaciones.ValidadorProductosLimpieza;
import java.time.LocalDate;


public abstract class ProductoLimpieza implements ISerializableCsv{
    protected String nombreComercial;
    protected String concentracion;
    protected LocalDate fechaVencimiento;

    public ProductoLimpieza(String nombreComercial, String concentracion, LocalDate fechaVencimiento) {
        this.nombreComercial = nombreComercial;
        this.concentracion = concentracion;
        this.fechaVencimiento = fechaVencimiento;
    }

    
    
    public ProductoLimpieza() {
    }


    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        ValidadorProductosLimpieza.validarNombre(nombreComercial);
        this.nombreComercial = nombreComercial;
    }

    public String getConcentración() {
        return concentracion;
    }

    public void setConcentración(String concentración) {
        ValidadorProductosLimpieza.validarConcentracion(concentracion);
        this.concentracion = concentración;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        ValidadorProductosLimpieza.ValidarFechaVencimiento(fechaVencimiento);
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nombreComercial=").append(nombreComercial);
        sb.append(", concentraci\u00f3n=").append(concentracion);
        sb.append(", fechaVencimiento=").append(fechaVencimiento);
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public String toCSV(){
        return nombreComercial + "," + concentracion + "," + fechaVencimiento;
    }
}
