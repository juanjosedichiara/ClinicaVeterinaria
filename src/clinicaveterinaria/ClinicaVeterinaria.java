package clinicaveterinaria;

import accesoDatos.ClienteData;
import accesoDatos.Conexion;
import accesoDatos.MascotaData;
import accesoDatos.TratamientoData;
import accesoDatos.VisitaData;
import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import clinicaveterinaria.entidades.Tratamiento;
import clinicaveterinaria.entidades.Visita;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class ClinicaVeterinaria {

    public static void main(String[] args) {
        //Connection conexion= Conexion.getConexion();  //Prueba de Conexion

        ClienteData cliData = new ClienteData();
        MascotaData masData = new MascotaData();
        VisitaData visData = new VisitaData();
        Mascota mascota = new Mascota("Chimuelo", "Masculino", "Gato", "Criollo", "Manchado", LocalDate.of(2018, Month.APRIL, 25), 0.0, 2.4, true);
        Cliente cliente = new Cliente(36277295, "Lopez", "Romina", "Casablanca 111", 75666852, "Juan Perez 261552266", mascota, true);
        //cliData.altaCliente(cliente); //Prueba para Agregar un Nuevo Cliente
        Cliente cli1 = cliData.consultarClientesPorDNI(36277295);
        Mascota masc1 = masData.consultarMascotaPorId(1);
        
        Visita visita = new Visita(10,LocalDate.now(), "contado", "fiebre", "Infeccion", 500.4, "1");
        TratamientoData tratData = new TratamientoData();
        //cliData.eliminarCliente(2); //Prueba para Eliminar el cliente con ID 2
        //cliData.modificarCliente(cliente);  //Prueba para Modificar los datos de un Cliente

        //masData.altaMascota(mascota, cli1); // Prueba para Agregar una Nueva Mascota

        //cliData.eliminarClienteConMascota(cli1, masc1);
        
        //System.out.println(cli1);
        
        //visData.registrarVisita(visita, masc1.getIdMascota(),visita.getIdTratamiento());
    }

}
