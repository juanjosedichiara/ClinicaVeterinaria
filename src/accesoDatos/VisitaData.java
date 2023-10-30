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
    public void registrarVisita(Visita visita, int idMascota, int idTratamiento) {
        //Visita visita = new Visita();
        //Mascota mascota = new Mascota();
        //Tratamiento tratamiento = new Tratamiento();
        LocalDate fechaVisita = LocalDate.now(); // Almacena en la variable fechaVisita la fecha actual

        String sql = "INSERT INTO visitas (idMascota, idTratamiento, duracion, fechaVisita, "
                + "formaPago, sintomas, afeccion, pesoActual) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, idMascota);
            ps.setInt(2, idTratamiento);
            ps.setString(3, visita.getDuracion());
            ps.setDate(4, Date.valueOf(fechaVisita));
            ps.setString(5, visita.getFormaPago());
            ps.setString(6, visita.getSintomas());
            ps.setString(7, visita.getAfeccion());
            ps.setDouble(8, visita.getPesoActual());

            int exitoso = ps.executeUpdate();
            if (exitoso == 1) {
                System.out.println("Se registró la visita Correctamente");
            }

            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//LocalDate fechaVisita = visita.getFechaVisita();
//
//        String sql = "INSERT INTO visitas (idMascota, idTratamiento, duracion, fechaVisita, "
//                + "sintomas, afeccion, pesoActual) "
//                + "VALUES (?,?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            if (fechaVisita != null){
//                java.sql.Date fechaVisitaSQL = java.sql.Date.valueOf(fechaVisita);
//    }
//            ps.setInt(1, idMascota);
//                ps.setInt(2, idTratamiento);
//                ps.setString(3, visita.getDuracion());
//                ps.setDate(4, fechaVisitaSQL);
//                ps.setString(5, visita.getSintomas());
//                ps.setString(6, visita.getAfeccion());
//                ps.setDouble(7, visita.getPesoActual());
//
//                ps.executeUpdate();
//
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    visita.setIdVisita(rs.getInt(1));
//                    System.out.println("Visita agregada con éxito");
//                    System.out.println("ID: " + visita.getIdVisita());
//                }
//                ps.close();
//                } else {
//            // Maneja el caso en el que la fecha de visita es nula
//            JOptionPane.showMessageDialog(null, "La fecha de visita es nula.", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        } catch (SQLException ex) {
//            
//            ex.printStackTrace();}
//        }

    }

    //Listar historial de Visitas por Mascota
    public List<Visita> historialDeVisitasPorId(int idMascota) {
        List<Visita> visita = new ArrayList<>();
        String sql = "SELECT idVisitas, idTratamiento, fechaVisita,"
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

    public Visita buscarVisitaPorId(int idVisita) {
        Visita visita = null;
        String sql = "SELECT * FROM visitas WHERE idVisitas = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVisita);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                visita = new Visita();
                Tratamiento tratamiento = new Tratamiento();
                Mascota mascota = new Mascota();
                visita.setIdVisita(rs.getInt("idVisitas"));
                mascota.setIdMascota(rs.getInt("idMascota"));
                tratamiento.setIdTratamiento(rs.getInt("idTratamiento"));
                visita.setFechaVisita(rs.getDate("fechaVisita").toLocalDate());
                visita.setFormaPago(rs.getString("formaPago"));
                visita.setSintomas(rs.getString("sintomas"));
                visita.setAfeccion(rs.getString("afeccion"));
                visita.setPesoActual(rs.getDouble("pesoActual"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return visita;
    }

    public void eliminarVisita(int idVisita) {
        String sql = "DELETE FROM `visita` WHERE idVisita=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVisita);
            int elimVisita = ps.executeUpdate();

            if (elimVisita == 1) {
                System.out.println("Visita eliminada exitosamente.");
            } else {
                System.out.println("Error al intentar eliminar la Vista");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

}
