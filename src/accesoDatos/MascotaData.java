package accesoDatos;

import clinicaveterinaria.entidades.Cliente;
import clinicaveterinaria.entidades.Mascota;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MascotaData {

    private Connection con = null;

    public MascotaData() {
        con = Conexion.getConexion();
    }

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
        String sql = "UPDATE `mascota` SET `alias`=? ,sexo=?, especie=?, raza=?, color=?, "
                + "nacimiento=?, presoPromedio=?, pesoActual=?, estadoMascota=? WHERE idMascota=?";
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

            int modificar = ps.executeUpdate();

            if (modificar == 1) {
                System.out.println("Modificación de Mascota exitosa");
            } else {
                System.out.println("No se pudo realizar la modificación");
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("Error en la conexion con la tabla mascota");
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
            } else {
                System.out.println("Error al intentar eliminar la mascota");
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Mascota consultarMascotaPorId(int idMascota) {
        Mascota mascota = new Mascota();

        String sql = "SELECT * FROM mascota WHERE idMascota = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setIdCliente(rs.getInt("idCliente"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColor(rs.getString("color"));
                mascota.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                mascota.setPesoPromedio(rs.getDouble("pesoPromedio"));
                mascota.setPesoActual(rs.getDouble("pesoActual"));
                mascota.setEstadoMascota(rs.getBoolean("estadoMascota"));
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mascota;
    }

    public List<Mascota> obtenerMascotasPorIdCliente(int idCliente) {
        List<Mascota> mascotas = new ArrayList<>();

        String sql = "SELECT * FROM mascota WHERE idCliente = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(rs.getInt("idMascota"));
                mascota.setIdCliente(rs.getInt("idCliente"));
                mascota.setAlias(rs.getString("alias"));
                mascota.setSexo(rs.getString("sexo"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColor(rs.getString("color"));
                mascota.setNacimiento(rs.getDate("nacimiento").toLocalDate());
                mascota.setPesoPromedio(rs.getDouble("pesoPromedio"));
                mascota.setPesoActual(rs.getDouble("pesoActual"));
                mascota.setEstadoMascota(rs.getBoolean("estadoMascota"));
                mascotas.add(mascota);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mascotas;
    }

    public double calcularDiferenciaDePeso(int idMascota, LocalDate fechaConsulta) {
        double diferenciaPeso = 0.0;
        LocalDate fechaConsultaAnterior = null;
        double pesoConsultaAnterior = 0.0;

        String sql = "SELECT fechaVisita, pesoActual FROM visitas WHERE idMascota = ? AND fechaVisita < ? ORDER BY fechaVisita DESC LIMIT 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            ps.setDate(2, Date.valueOf(fechaConsulta));

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                fechaConsultaAnterior = rs.getDate("fechaVisita").toLocalDate();
                pesoConsultaAnterior = rs.getDouble("pesoActual");
            }

            if (fechaConsultaAnterior != null) {
                // Calcular la diferencia de peso si se encontró una consulta anterior
                diferenciaPeso = pesoConsultaAnterior - consultarMascotaPorId(idMascota).getPesoActual();
            }

            rs.close();
            ps.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return diferenciaPeso;
    }

    //Actualiza el peso promedio de la mascota
    public double actualizarPesoPromedio(int idMascota) {
        MascotaData mascotaData = new MascotaData();
        Mascota masc = mascotaData.consultarMascotaPorId(idMascota); //Se crea una nueva mascota con los datos de la tabla

        double pesoPromedio = masc.getPesoPromedio(); // La variable almacena el peso promedio contenido en la tabla
        double pesoActual = masc.getPesoActual(); //La var pesoActual almacena el peso cargado en la tabla mascota
        double nuevoPesoPromedio = (pesoActual + pesoPromedio) / 2;

        String sql = "UPDATE mascota SET pesoPromedio = ? WHERE idMascota= ?";
        String sql1 = "SELECT pesoActual FROM visitas WHERE idMascota= ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql1);

            ps.setDouble(1, nuevoPesoPromedio);
            ps.setInt(2, idMascota);

            ps1.setInt(1, idMascota);

            ps.executeUpdate();
            ResultSet rs = ps1.executeQuery();
            
            if(rs.next()){
                List <Double> pesos = new ArrayList();
                pesos.add(rs.getDouble("pesoActual"));
                int cantidadDePesos= pesos.size();
                
                ///FALTA TERMINAR Y CORREGIR EL CODIGO DEFINITIVO
            }

            ps.close();

        } catch (SQLException ex) {
            System.out.println("No se pudo conectar a la tabla Mascota" + ex);
        }

        return pesoPromedio;
    }

}
