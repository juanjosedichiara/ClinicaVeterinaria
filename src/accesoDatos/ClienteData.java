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
            ps.setLong(5, cliente.getTelefono());
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
//        String sql = "DELETE FROM cliente WHERE idCliente = ?";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idCliente);
//
//            int elimCliente = ps.executeUpdate();
//
//            if (elimCliente == 1) {
//                System.out.println("Cliente eliminado exitosamente.");
//            } else {
//                System.out.println("Cliente No encontrado en la BD");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }


    //PARA PROBAR INACTIVOS _ BORRADO LOGICO 
        String sql = "UPDATE cliente SET estadoCliente = 0 WHERE idCliente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);

            int resultado = ps.executeUpdate();

            if (resultado == 1) {
                System.out.println("Cliente marcado como inactivo exitosamente.");
            } else {
                System.out.println("Cliente no encontrado en la BD.");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Elimina una Mascota de la BD y cambia estado a false en tabla Cliente 
    public void eliminarClienteConMascota(Cliente cliente, Mascota mascota) {
         String sql1 = "UPDATE mascota SET estadoMascota = 0 WHERE idMascota = ?";
            String sql2 = "UPDATE cliente SET estadoCliente = 0 WHERE idCliente = ?";

            try {
                // Elimina físicamente a la mascota
                PreparedStatement ps1 = con.prepareStatement(sql1);
                ps1.setInt(1, mascota.getIdMascota());
                ps1.executeUpdate();
                ps1.close();

                // Cambia el estado del cliente a 0 (inactivo)
                PreparedStatement ps2 = con.prepareStatement(sql2);
                ps2.setInt(1, cliente.getIdCliente());
                ps2.executeUpdate();
                ps2.close();

                System.out.println("Se cambió el estado del Cliente y sus mascotas exitosamente.");
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
            ps.setLong(4, cliente.getTelefono());
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
    public Cliente consultarClientesPorDNI(int dni) {

        Cliente cliente = new Cliente();

        String sql = "SELECT * FROM cliente WHERE documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setDocumento(rs.getInt("documento"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }

    public int obtenerIdClientePorDNI(int dni) {
        // Valor predeterminado si no se encuentra un cliente
        int idCliente = -1; 
        String sql = "SELECT idCliente FROM cliente WHERE documento = ?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, dni);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idCliente = rs.getInt("idCliente");
                }

                rs.close();
                ps.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        return idCliente;
    }

    public Cliente consultarClientePorId(int idCliente) {
        String sql = "SELECT * FROM cliente WHERE idCliente = ?";
        Cliente cliente = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                   int id = rs.getInt("idCliente");
                   int documento = rs.getInt("documento");
                   String apellido = rs.getString("apellido");
                   String nombre = rs.getString("nombre");
                   String direccion = rs.getString("direccion");
                   long telefono = rs.getLong("telefono");
                   String contacto = rs.getString("contacto");
                   boolean estadoCliente = rs.getBoolean("estadoCliente");

                   cliente = new Cliente(id, documento, apellido, nombre, direccion, telefono, contacto, estadoCliente);
                }


            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
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
                cliente.setTelefono(rs.getLong("telefono"));
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

    public List<Cliente> obtenerClientesActivos() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE estadoCliente = 1";

        try {
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setDocumento(rs.getInt("documento"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setTelefono(rs.getLong("telefono"));
                    cliente.setContacto(rs.getString("contacto"));
                    clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
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
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientes;

    }
         public List<Cliente> obtenerClientesInactivos() {
        List<Cliente> clientesInactivos = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE estadoCliente = 0";

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
                cliente.setTelefono(rs.getLong("telefono"));
                cliente.setContacto(rs.getString("contacto"));
                cliente.setEstadoCliente(rs.getBoolean("estadoCliente"));

                clientesInactivos.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientesInactivos;
    }

        public int obtenerEstadoClientePorDocumento(int documentoCliente) {
        int estadoCliente = -1; 

        String sql = "SELECT estadoCliente FROM cliente WHERE documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                estadoCliente = rs.getInt("estadoCliente");
            }else{
                estadoCliente=-1;
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estadoCliente;
        }

        public void activarCliente(int documentoCliente) {
        String sql = "UPDATE cliente SET estadoCliente = 1 WHERE documento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, documentoCliente);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas == 1) {
                System.out.println("Cliente activado exitosamente.");
            } else {
                System.out.println("Cliente no encontrado o ya activo en la BD");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
