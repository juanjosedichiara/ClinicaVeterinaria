
package accesoDatos;

import clinicaveterinaria.entidades.Tratamiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TratamientoData {
    private Connection con = null;
    
    public TratamientoData(){
         con = Conexion.getConexion();
    }
    
   //Agregar tratamiento a la base de datos
    public void agregarTratamiento(Tratamiento tratamiento) {
    String sql = "INSERT INTO tratamiento (tipo, descripcion, importe) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tratamiento.getTipo());
            ps.setString(2, tratamiento.getDescripcion());
            ps.setDouble(3, tratamiento.getImporte());

            int affectedRows = ps.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("La carga del tratamiento falló, no se agregó ningún registro.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idTratamiento = generatedKeys.getInt(1);
                    tratamiento.setIdTratamiento(idTratamiento);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
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
        String sql = "UPDATE tratamiento SET tipo = ?, descripcion = ?, importe = ? WHERE idTratamiento = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, tratamiento.getTipo());
            ps.setString(2, tratamiento.getDescripcion());
            ps.setDouble(3, tratamiento.getImporte());
            ps.setInt(4, tratamiento.getIdTratamiento());
            
            
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
   
   public int obtenerIdTratamientoPorTipo(String tipo) {
        String sql = "SELECT idTratamiento FROM tratamiento WHERE tipo = ?";
        int idTratamiento = -1; // Inicializamos con un valor que indique que no se encontró ningún tratamiento

            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, tipo);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    idTratamiento = rs.getInt("idTratamiento");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            return idTratamiento;
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
            tratamiento.setImporte(rs.getDouble("importe"));
            
            tratamientos.add(tratamiento);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    return tratamientos;
    }

}
