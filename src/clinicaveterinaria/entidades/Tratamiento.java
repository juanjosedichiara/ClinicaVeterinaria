package clinicaveterinaria.entidades;

public class Tratamiento  {
    int idTratamiento;
    String tipo;
    String descripcion;
    Double importe;
    Boolean estadoTratamiento;

    public Tratamiento() {
    }

    public Tratamiento(int idTratamiento, String tipo, String descripcion, Double importe, Boolean estadoTratamiento) {
        this.idTratamiento = idTratamiento;
        this.tipo = tipo;
        this.descripcion = descripcion;
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

    public Double getImporte() {
        return importe;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public Boolean getEstadoTratamiento() {
        return estadoTratamiento;
    }

    public void setEstadoTratamiento(Boolean estadoTratamiento) {
        this.estadoTratamiento = estadoTratamiento;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamiento=" + idTratamiento + ", tipo=" + tipo + ", descripcion=" + descripcion + ", importe=" + importe + ", estadoTratamiento=" + estadoTratamiento + '}';
    }

  
}
