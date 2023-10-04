/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import clinicaveterinaria.entidades.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class TratamientoData {
    private Connection con = null;
    
    public TratamientoData(){
         con = Conexion.getConexion();
    }
    
   //Agregar tratamiento a la base de datos
    public void agregarTratamiento (Tratamiento tratamiento){
        String sql="INSERT INTO tratamiento(tipo, descripcion, fechaInicio, fechaFin) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tratamiento.getTipo());
            ps.setString(2, tratamiento.getDescripcion());
            
            // Convertir LocalDate a java.sql.Date
            java.sql.Date fechaInicio = java.sql.Date.valueOf(tratamiento.getFechaInicio());
            java.sql.Date fechaFin = java.sql.Date.valueOf(tratamiento.getFechaFin());
            
            ps.setDate(3, fechaInicio);
            ps.setDate(4, fechaFin);
        
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                    tratamiento.setIdTratamiento(generatedKeys.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    //Eliminar tratamiento en la base de datos por su id
    public void eliminarTratamiento(int idTratamiento) {
        String sql = "DELETE FROM tratamiento WHERE idTratamiento = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idTratamiento);

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Registra el error en la consola
            ex.printStackTrace();
        }
    }
    
    //Modificar datos de un tratamiento en la base de datos 
   public void modificarTratamiento(Tratamiento tratamiento) {
        String sql = "UPDATE tratamiento SET tipo = ?, descripcion = ?, fechaInicio = ?, fechaFin = ? WHERE idTratamiento = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tratamiento.getTipo());
            ps.setString(2, tratamiento.getDescripcion());
            // Convierte LocalDate a java.sql.Date
            java.sql.Date fechaInicio = java.sql.Date.valueOf(tratamiento.getFechaInicio());
            java.sql.Date fechaFin = java.sql.Date.valueOf(tratamiento.getFechaFin());

            ps.setDate(3, fechaInicio);
            ps.setDate(4, fechaFin);
            ps.setInt(5, tratamiento.getIdTratamiento());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Registra el error en la consola
            ex.printStackTrace();
        }
   }
   
   public Tratamiento consultarTratamientoPorId(int idTratamiento) {
    Tratamiento tratamientoEncontrado = null;
    String sql = "SELECT * FROM tratamiento WHERE idTratamiento = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idTratamiento);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tratamientoEncontrado = new Tratamiento();
            tratamientoEncontrado.setIdTratamiento(rs.getInt("idTratamiento"));
            tratamientoEncontrado.setTipo(rs.getString("tipo"));
            tratamientoEncontrado.setDescripcion(rs.getString("descripcion"));
            tratamientoEncontrado.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            tratamientoEncontrado.setFechaFin(rs.getDate("fechaFin").toLocalDate());
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return tratamientoEncontrado;
}
   
   public List<Tratamiento> consultarTratamientosPorTipo(String tipo) {
    List<Tratamiento> tratamientosEncontrados = new ArrayList<>();
    String sql = "SELECT * FROM tratamiento WHERE tipo = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
            tratamiento.setTipo(rs.getString("tipo"));
            tratamiento.setDescripcion(rs.getString("descripcion"));
            tratamiento.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
            tratamiento.setFechaFin(rs.getDate("fechaFin").toLocalDate());
            
            tratamientosEncontrados.add(tratamiento);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return tratamientosEncontrados;
}

   public List<Tratamiento> obtenerTodosLosTratamientos() {
    List<Tratamiento> tratamientos = new ArrayList<>();
    String sql = "SELECT * FROM tratamiento";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Tratamiento tratamiento = new Tratamiento();
            tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
            tratamiento.setTipo(rs.getString("tipo"));
            tratamiento.setDescripcion(rs.getString("descripcion"));

            // Convierte java.sql.Date a LocalDate
            java.sql.Date fechaInicioSQL = rs.getDate("fechaInicio");
            java.sql.Date fechaFinSQL = rs.getDate("fechaFin");

            tratamiento.setFechaInicio(fechaInicioSQL.toLocalDate());
            tratamiento.setFechaFin(fechaFinSQL.toLocalDate());

            tratamientos.add(tratamiento);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return tratamientos;
}

}
