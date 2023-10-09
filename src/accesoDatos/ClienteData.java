package accesoDatos;

import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//MÉTODOS PARA INTERACTUAR CON LA BASE DE DATOS DE CLIENTE
public class ClienteData {

    private Connection con = null;

    public ClienteData() {
        con = Conexion.getConexion();
    }

    //Cargar un nuevo cliente en la base de datos 
    public void altaCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (documento, apellido, nombre, direccion, telefono, contacto, estadoCliente)"
                + " VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, cliente.getDocumento());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getNombre());
            ps.setString(4, cliente.getDireccion());
            ps.setInt(5, cliente.getTelefono());
            ps.setString(6, cliente.getContacto());
            ps.setBoolean(7, cliente.getEstadoCliente());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                // 1(uno): refiere a la columna de los id.
                cliente.setIdCliente(rs.getInt(1));
                System.out.println(cliente.getIdCliente());
                System.out.println("Cliente Agregado Exitosamente");
            }
            ps.close();

        } catch (SQLException ex) {
            //registra el error en la consola
            ex.printStackTrace();
        }
    }

    //Elimina un cliente de la base de datos por su ID.
    public void eliminarCliente(int idCliente) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);

            int elimCliente = ps.executeUpdate();

            if (elimCliente == 1) {
                System.out.println("Cliente eliminado exitosamente.");
            } else {
                System.out.println("Cliente No encontrado en la BD");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Elimina un cliente de la BD y cambia estado a false en tabla Mascota
    public void eliminarClienteConMascota(Cliente cliente, Mascota mascota) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        String sql1 = "UPDATE mascota SET estadoMascota= false WHERE idMascota= ? AND idCliente= ?";
        int confirmacion;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps.setInt(1, cliente.getIdCliente());
            ps1.setInt(1, mascota.getIdMascota());
            ps1.setInt(2, cliente.getIdCliente());

            confirmacion = JOptionPane.showConfirmDialog(null, "¿Desea eliminar las mascotas asociadas al cliente?");

            if (confirmacion == 0) {
                ps.executeUpdate();
                ps1.executeUpdate();
                System.out.println("Se eliminó al Cliente y a sus Mascotas exitosamente.");
                ps.close();
                ps1.close();
            } else if (confirmacion == 1) {
                ps.executeUpdate();
                System.out.println("Cliente eliminado exitosamente. No se eliminaron las mascotas asociadas");
                ps.close();
                ps1.close();
            } else if (confirmacion == 2) {
                return;
            } else {
                System.out.println("Cliente No encontrado en la BD");
            }

            ps.close();
            ps1.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Modifica los datos de un cliente en la base de datos.
    public void modificarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET apellido =?, nombre =?, "
                + "direccion =?, telefono =?, contacto =?, estadoCliente =? WHERE documento =?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getApellido());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getDireccion());
            ps.setInt(4, cliente.getTelefono());
            ps.setString(5, cliente.getContacto());
            ps.setBoolean(6, cliente.getEstadoCliente());
            ps.setInt(7, cliente.getDocumento());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas == 1) {
                System.out.println("Datos del cliente modificados exitosamente.");
            } else {
                System.out.println("Cliente no encontrado en la BD");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Consulta clientes por número de DNI.
    public List<Cliente> consultarClientesPorDNI(int dni) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDocumento(rs.getInt("documento"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

                clientesEncontrados.add(cliente);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientesEncontrados;
    }

    //Consulta clientes por nombre y apellido 
    //(insensible a mayúsculas/minúsculas y espacios en blanco adicionales).
    public List<Cliente> consultarClientesPorNombreApellido(String nombre, String apellido) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE UPPER (nombre) = UPPER (?) AND UPPER (apellido) = UPPER (?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre.trim().toUpperCase());
            ps.setString(2, apellido.trim().toUpperCase());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDocumento(rs.getInt("documento"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

                clientesEncontrados.add(cliente);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientesEncontrados;

    }

    //Obtiene todos los clientes de la base de datos.
    public List<Cliente> obtenerTodosLosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDocumento(rs.getInt("documento"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getInt("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;

    }

}
