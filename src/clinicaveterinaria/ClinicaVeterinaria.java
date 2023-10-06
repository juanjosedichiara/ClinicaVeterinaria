package clinicaveterinaria;

import accesoDatos.ClienteData;
import accesoDatos.Conexion;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class ClinicaVeterinaria {

    public static void main(String[] args) {
        //Connection conexion= Conexion.getConexion();  //Prueba de Conexion

        ClienteData cliData = new ClienteData();
        Mascota mascota = new Mascota("Coti", "Femenino", "Gatuna", "Siames", "Marron", LocalDate.of(2022, Month.FEBRUARY, 12), 0.0, 2.4, true);
        Cliente cliente = new Cliente(32665123, "Lucero Medina", "Juan Manuel", "San Martin 489", 261456777, "Maria Rosa Olguin 261545766", mascota, true);
        //cliData.altaCliente(cliente); //Prueba para Agregar un Nuevo Cliente

        //cliData.eliminarCliente(2); //Prueba para Eliminar el cliente con ID 2
        //cliData.modificarCliente(cliente);  //Prueba para Modificar los datos de un Cliente
        
        

    }

}
