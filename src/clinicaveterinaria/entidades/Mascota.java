package clinicaveterinaria.entidades;

import java.time.LocalDate;

public class Mascota {

    int idMascota;
    int idCliente;
    String alias;
    String sexo;
    String especie;
    String raza;
    String color;
    LocalDate nacimiento;
    Double pesoPromedio;
    Double pesoActual;
    Boolean estadoMascota;

    public Mascota() {
    }

     public Mascota(String alias, String sexo, String especie, String raza, String color, LocalDate nacimiento) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.nacimiento = nacimiento;
     }
     
    public Mascota(String alias, String sexo, String especie, String raza, String color, LocalDate nacimiento, Double pesoPromedio, Double pesoActual, Boolean estadoMascota) {
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.nacimiento = nacimiento;
        this.pesoPromedio = pesoPromedio;
        this.pesoActual = pesoActual;
        this.estadoMascota = estadoMascota;
    }

    public Mascota(int idMascota, int idCliente, String alias, String sexo, String especie, String raza, String color, LocalDate nacimiento, Double pesoPromedio, Double pesoActual, Boolean estadoMascota) {
        this.idMascota = idMascota;
        this.idCliente = idCliente;
        this.alias = alias;
        this.sexo = sexo;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.nacimiento = nacimiento;
        this.pesoPromedio = pesoPromedio;
        this.pesoActual = pesoActual;
        this.estadoMascota = estadoMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Double getPesoPromedio() {
        return pesoPromedio;
    }

    public void setPesoPromedio(Double pesoPromedio) {
        this.pesoPromedio = pesoPromedio;
    }

    public Double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(Double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public Boolean getEstadoMascota() {
        return estadoMascota;
    }

    public void setEstadoMascota(Boolean estadoMascota) {
        this.estadoMascota = estadoMascota;
    }

    @Override
    public String toString() {
        return "Mascota{" + "idMascota=" + idMascota + ", alias=" + alias + ", sexo=" + sexo + ", especie=" + especie + ", raza=" + raza + ", color=" + color + ", nacimiento=" + nacimiento + ", pesoPromedio=" + pesoPromedio + ", pesoActual=" + pesoActual + ", estadoMascota=" + estadoMascota + '}';
    }

}
