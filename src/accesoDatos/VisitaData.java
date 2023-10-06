package accesoDatos;

import clinicaveterinaria.entidades.Mascota;
import clinicaveterinaria.entidades.Tratamiento;
import clinicaveterinaria.entidades.Visita;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitaData {

    private Connection con = null;

    public VisitaData() {
        con = Conexion.getConexion();
    }

    //Agregar una Nueva Visita
    public void registrarVisita() {
        Visita visita = new Visita();
        Mascota mascota = new Mascota();
        Tratamiento tratamiento = new Tratamiento();
        LocalDate fechaVisita = LocalDate.now(); // Almacena en la variable fechaVisita la fecha actual

        String sql = "INSERT INTO `visitas`(idMascota, idTratamiento, fechaVisita, "
                + "formaPago, sintomas, afeccion, pesoActual) "
                + "VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, mascota.getIdMascota());
            ps.setInt(2, tratamiento.getIdTratamiento());
            ps.setDate(3, Date.valueOf(fechaVisita));
            ps.setString(4, visita.getFormaPago());
            ps.setString(5, visita.getSintomas());
            ps.setString(6, visita.getAfeccion());
            ps.setDouble(7, visita.getPesoActual());

            int exitoso = ps.executeUpdate();
            if (exitoso == 1) {
                System.out.println("Se registró la visita Correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    //Listar historial de Visitas por Mascota
    public List<Visita> historialDeVisitasPorId(int idMascota) {
        List<Visita> visita = new ArrayList<>();
        String sql = "SELECT idVisitas, idTratamiento, fechaVisita, formaPago, "
                + "sintomas, afeccion, pesoActual FROM `visitas` WHERE idMascota = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Visita vis = new Visita();
                Tratamiento tra = new Tratamiento();
                vis.setIdVisita(rs.getInt("idVisitas"));
                tra.setIdTratamiento(rs.getInt("idTratamiento"));
                vis.setFechaVisita(rs.getDate("fechaVisita").toLocalDate());
                vis.setFormaPago(rs.getString("formaPago"));
                vis.setSintomas(rs.getString("sintomas"));
                vis.setAfeccion(rs.getString("afeccion"));
                vis.setPesoActual(rs.getDouble("pesoActual"));

                visita.add(vis);
            }
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return visita;
    }

        //Libro Histórico de Visitas de la Veterinaria
    public List<Visita> libroDeVisitas() {
        List<Visita> visita = new ArrayList<>();
        String sql = "SELECT * FROM visitas";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Visita vis = new Visita();
                Tratamiento tra = new Tratamiento();
                Mascota masc = new Mascota();
                vis.setIdVisita(rs.getInt("idVisitas"));
                masc.setIdMascota(rs.getInt("idMascota"));
                tra.setIdTratamiento(rs.getInt("idTratamiento"));
                vis.setFechaVisita(rs.getDate("fechaVisita").toLocalDate());
                vis.setFormaPago(rs.getString("formaPago"));
                vis.setSintomas(rs.getString("sintomas"));
                vis.setAfeccion(rs.getString("afeccion"));
                vis.setPesoActual(rs.getDouble("pesoActual"));

                visita.add(vis);
            }
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return visita;
    }
}
