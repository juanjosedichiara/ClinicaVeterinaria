package accesoDatos;

import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MascotaData {

    private Connection con = null;

    public MascotaData() {
        con = Conexion.getConexion();
    }
    //REVISAR ESTE METODO PORQUE NO FUNCIONA
    public void altaMascota(Mascota mascota, Cliente cliente) {
        String sql = "INSERT INTO mascota (idCliente, alias, sexo, especie, raza, color, nacimiento, "
                + "pesoPromedio, pesoActual, estadoMascota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, mascota.getAlias());
            ps.setString(3, mascota.getSexo());
            ps.setString(4, mascota.getEspecie());
            ps.setString(5, mascota.getRaza());
            ps.setString(6, mascota.getColor());
            ps.setDate(7, Date.valueOf(mascota.getNacimiento()));
            ps.setDouble(8, mascota.getPesoPromedio());
            ps.setDouble(9, mascota.getPesoActual());
            ps.setBoolean(10, mascota.getEstadoMascota());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                mascota.setIdMascota(rs.getInt(1));
                System.out.println("Mascota agregada con éxito");
                System.out.println("ID: " + mascota.getIdMascota());
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion con la tabla mascota");
        }
    }

    public void modificarMascota(Mascota mascota) {
        String sql = "UPDATE `mascota` SET `alias`=? ,sexo=?, especie=?, raza=?, color=?, nacimientro=?, presoPromedio=?, pesoActual=?, estadoMascota=? WHERE idMascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getAlias());
            ps.setString(2, mascota.getSexo());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getColor());
            ps.setDate(6, Date.valueOf(mascota.getNacimiento()));
            ps.setDouble(7, mascota.getPesoPromedio());
            ps.setDouble(8, mascota.getPesoActual());
            ps.setBoolean(9, mascota.getEstadoMascota());
            ps.setInt(10, mascota.getIdMascota());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modificacion de mascota exitosa");
        }

    }

    public void eliminarMascota(int idMascota) {
        String sql = "DELETE FROM `mascota` WHERE idMascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            int elimMascota = ps.executeUpdate();

            if (elimMascota == 1) {
                System.out.println("Mascota eliminada exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
