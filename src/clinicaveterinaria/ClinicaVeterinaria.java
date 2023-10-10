package clinicaveterinaria;

import accesoDatos.ClienteData;
import accesoDatos.Conexion;
import accesoDatos.MascotaData;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class ClinicaVeterinaria {

    public static void main(String[] args) {
        //Connection conexion= Conexion.getConexion();  //Prueba de Conexion

        ClienteData cliData = new ClienteData();
        MascotaData masData = new MascotaData();
        Mascota mascota = new Mascota("Chimuelo", "Masculino", "Gato", "Criollo", "Manchado", LocalDate.of(2018, Month.APRIL, 25), 0.0, 2.4, true);
        Cliente cliente = new Cliente(36277295, "Lopez", "Romina", "Casablanca 111", 75666852, "Juan Perez 261552266", mascota, true);
        //cliData.altaCliente(cliente); //Prueba para Agregar un Nuevo Cliente
        Cliente cli1 = cliData.consultarClientesPorDNI(36277295);
        Mascota masc1 = masData.consultarMascotaPorId(12);
        //cliData.eliminarCliente(2); //Prueba para Eliminar el cliente con ID 2
        //cliData.modificarCliente(cliente);  //Prueba para Modificar los datos de un Cliente

        //masData.altaMascota(mascota, cli1); // Prueba para Agregar una Nueva Mascota

        //cliData.eliminarClienteConMascota(cli1, masc1);
    }

}
