package clinicaveterinaria.entidades;


import java.time.LocalDate;

public class Visita {
    
    LocalDate fechaVisita;
    String formaPago;
    String sintomas;
    String afeccion;
    Double pesoActual;

    public void registrarVisita() {
    }

    public Visita(LocalDate fechaVisita, String formaPago, String sintomas, String afeccion, Double pesoActual) {
        this.fechaVisita = fechaVisita;
        this.formaPago = formaPago;
        this.sintomas = sintomas;
        this.afeccion = afeccion;
        this.pesoActual = pesoActual;
    }

    public LocalDate getFechaVisita() {
        return fechaVisita;
    }

    public void setFechaVisita(LocalDate fechaVisita) {
        this.fechaVisita = fechaVisita;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getAfeccion() {
        return afeccion;
    }

    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    @Override
    public String toString() {
        return "Visita{" + "fechaVisita=" + fechaVisita + ", formaPago=" + formaPago + ", sintomas=" + sintomas + ", afeccion=" + afeccion + ", pesoActual=" + pesoActual + '}';
    }

    
}
