package clinicaveterinaria.entidades;

import java.time.LocalDate;

public class Tratamiento {

    int idTratamiento;
    String tipo;
    String descripcion;
    LocalDate fechaInicio;
    LocalDate fechaFin;
    double importe;
    boolean estadoTratamiento;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Tratamiento(int idTratamiento, boolean estadoTratamiento) {
        this.idTratamiento = idTratamiento;
        this.estadoTratamiento = estadoTratamiento;
    }

    public Tratamiento(String tipo, String descripcion, double importe, boolean estadoTratamiento) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.importe = importe;
        this.estadoTratamiento = estadoTratamiento;
    }

    public Tratamiento(int idTratamiento, String tipo, String descripcion, double importe, boolean estadoTratamiento) {
        this.idTratamiento = idTratamiento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.importe = importe;
        this.estadoTratamiento = estadoTratamiento;
    }

    public Tratamiento(int idTratamiento, String tipo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, double importe, boolean estadoTratamiento) {
        this.idTratamiento = idTratamiento;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.estadoTratamiento = estadoTratamiento;
    }

    public Tratamiento(String tipo, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, double importe, boolean estadoTratamiento) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.importe = importe;
        this.estadoTratamiento = estadoTratamiento;
    }
    
    public int getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(int idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(boolean estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + idTratamiento + ", tipo=" + tipo + ", descripcion=" + descripcion + ", importe=" + importe + ", estadoTratamiento=" + estadoTratamiento + '}';
    }

}
