/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import clinicaveterinaria.entidades.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ClienteData {
    private Connection con = null;
    
    public ClienteData(){
        con = Conexion.getConexion();
    }
    
    public void altaCliente(Cliente cliente){
            String sql = "INSERT INTO cliente (documento, apellido, nombre, direccion, telefono, contacto, estadoCliente)"
                    + "+  VALUES (?,?,?,?,?,?,?)";
           
            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                ps.setInt(2,cliente.getDocumento());
                ps.setString(3, cliente.getApellido());
                ps.setString(4, cliente.getNombre());
                ps.setString(5, cliente.getDireccion());
                ps.setInt(6, cliente.getTelefono());
                ps.setString(7, cliente.getContacto());
                ps.setBoolean(8, cliente.getEstadoCliente());
                
                ps.executeUpdate();
                
                ps.close();
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Error en la conexion con la tabla cliente");
        }
    }
    
    public void eliminarCliente(int idCliente){
        String sql = "DELETE FROM cliente WHERE idCliente = ?";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            
            int elimCliente = ps.executeUpdate();
            
            if (elimCliente == 1) {
                System.out.println("Cliente eliminado exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla cliente para dar la baja al cliente");

        }
    }
    
    public void modificarCliente(Cliente cliente) {
    String sql = "UPDATE cliente SET documento = ?, apellido = ?, nombre = ?, direccion = ?, telefono = ?, contacto = ?, id_mascota = ?, estadoCliente = ? WHERE idCliente = ?";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getIdCliente());
            ps.setInt(2, cliente.getDocumento());
            ps.setString(3, cliente.getApellido());
            ps.setString(4, cliente.getNombre());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getTelefono());
            ps.setString(7, cliente.getContacto());
            ps.setBoolean(8, cliente.getEstadoCliente());
            
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas == 1) {
                System.out.println("Datos del cliente modificados exitosamente.");
            } 
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla cliente para modificar los datos del cliente");
     
        }
    }
    
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
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla cliente");
        }
        return clientesEncontrados;
    }
    
     public List<Cliente> consultarClientesPorNombreApellido(String nombre, String apellido) {
        List<Cliente> clientesEncontrados = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nombre = ? AND apellido = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            
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
            JOptionPane.showMessageDialog(null, "No se puede acceder a la tabla cliente");
        }
        return clientesEncontrados;
    }
    
}

