package accesoDatos;

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
import javax.swing.table.DefaultTableModel;

public class MascotaData {

    private Connection con = null;

    public MascotaData() {
        con = Conexion.getConexion();
    }

    public void altaMascota(Mascota mascota, int idCliente) {
        String sql = "INSERT INTO mascota (idCliente, alias, sexo, especie, raza, color, nacimiento, "
                + "estadoMascota) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idCliente);
            ps.setString(2, mascota.getAlias());
            ps.setString(3, mascota.getSexo());
            ps.setString(4, mascota.getEspecie());
            ps.setString(5, mascota.getRaza());
            ps.setString(6, mascota.getColor());
            ps.setDate(7, Date.valueOf(mascota.getNacimiento()));
            ps.setBoolean(8,true);

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
                + "nacimiento=? WHERE idMascota=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, mascota.getAlias());
            ps.setString(2, mascota.getSexo());
            ps.setString(3, mascota.getEspecie());
            ps.setString(4, mascota.getRaza());
            ps.setString(5, mascota.getColor());
            ps.setDate(6, Date.valueOf(mascota.getNacimiento()));
            ps.setInt(7, mascota.getIdMascota());

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
//        String sql = "DELETE FROM `mascota` WHERE idMascota=?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idMascota);
//            int elimMascota = ps.executeUpdate();
//
//            if (elimMascota == 1) {
//                System.out.println("Mascota eliminada exitosamente.");
//            } else {
//                System.out.println("Error al intentar eliminar la mascota");
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }

    //PRUEBA DE INACTIVOS: BORRADO LOGICO DE MASCOTAS.
     String sql = "UPDATE mascota SET estadoMascota = 0 WHERE idMascota = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Mascota eliminada con éxito.");
            } else {
                System.out.println("No se pudo eliminar la mascota.");
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
    
    public int obtenerIdMascotaPorAlias(String alias) {
    int idMascota = -1; 
    String sql = "SELECT idMascota FROM mascota WHERE alias = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alias);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idMascota = rs.getInt("idMascota");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return idMascota;
    }

    public Mascota buscarMascotaPorAlias(String aliasMascota, int idCliente) {
    String sql = "SELECT * FROM mascota WHERE alias = ? AND idCliente = ?";
    Mascota mascota = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, aliasMascota);
            ps.setInt(2, idCliente);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mascota = new Mascota();
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

    public double actualizarPesoPromedio(int idMascota) {
    // Paso 1: Obtener todos los pesos registrados en las visitas para la mascota
    List<Double> pesosConsulta = new ArrayList<>();
    String sql = "SELECT pesoActual FROM visitas WHERE idMascota = ?";
    
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                double pesoConsulta = rs.getDouble("pesoActual");
                pesosConsulta.add(pesoConsulta);
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Paso 2: Calcular el nuevo peso promedio
        double pesoActualMascota = consultarMascotaPorId(idMascota).getPesoActual();
        double nuevoPesoPromedio = calcularPesoPromedio(pesosConsulta, pesoActualMascota);

        // Paso 3: Actualizar el valor del campo "pesoPromedio" en la tabla de mascotas
        String sqlActualizar = "UPDATE mascota SET pesoPromedio = ? WHERE idMascota = ?";

        try {
            PreparedStatement psActualizar = con.prepareStatement(sqlActualizar);
            psActualizar.setDouble(1, nuevoPesoPromedio);
            psActualizar.setInt(2, idMascota);
            psActualizar.executeUpdate();
            psActualizar.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return nuevoPesoPromedio;
    }

    // Método para calcular el peso promedio
    private double calcularPesoPromedio(List<Double> pesosConsulta, double pesoActualMascota) {
        if (pesosConsulta.isEmpty()) {
            return pesoActualMascota;
        }

        double sumaPesos = pesoActualMascota;
        for (Double pesoConsulta : pesosConsulta) {
            sumaPesos += pesoConsulta;
        }

        return sumaPesos / (pesosConsulta.size() + 1);
    }


 
    public DefaultTableModel obtenerTratamientosDeMascota(int idMascota) {
        String[] columnas = {"Fecha", "Tratamiento", "Detalles", "Inicio", "Fin", "Importe"};
        DefaultTableModel model = new DefaultTableModel(columnas, 0);
        String sql = "SELECT v.fechaVisita, t.tipo, t.descripcion, t.fechaInicio, t.fechaFin, t.importe " +
                     "FROM visita v " +
                     "JOIN tratamiento t ON v.idTratamiento = t.idTratamiento " +
                     "WHERE v.idMascota = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String fecha = rs.getDate("fechaVisita").toString();
                String tratamiento = rs.getString("tipo");
                String detalles = rs.getString("descripcion");
                String inicio = rs.getDate("fechaInicio").toString();
                String fin = rs.getDate("fechaFin").toString();
                String importe = rs.getString("importe");

                model.addRow(new String[]{fecha, tratamiento, detalles, inicio, fin, importe});
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return model;
    }

    //CONSULTA TODAS LAS MASCOTAS Y DEVUELVE EL DNI DEL CLIENTE EN VEZ DEL ID
    public List<Mascota> obtenerTodasLasMascotas() {
        String sql = "SELECT m.*, c.documento AS dniCliente " +
                     "FROM mascota m " +
                     "INNER JOIN cliente c ON m.idCliente = c.idCliente";
        List<Mascota> mascotas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota(
                    rs.getInt("idMascota"),
                    rs.getInt("idCliente"),
                    rs.getString("alias"),
                    rs.getString("sexo"),
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getString("color"),
                    rs.getObject("nacimiento", LocalDate.class),
                    rs.getBoolean("estadoMascota")
                    );
                    mascota.setDocumento(rs.getInt("dniCliente"));
                    mascotas.add(mascota);
                }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mascotas;
    }

    public List<Mascota> obtenerMascotasInactivas() {
    String sql = "SELECT m.*, c.documento AS dniCliente " +
                 "FROM mascota m " +
                 "INNER JOIN cliente c ON m.idCliente = c.idCliente " +
                 "WHERE m.estadoMascota = 0";
    
    List<Mascota> mascotasInactivas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota(
                    rs.getInt("idMascota"),
                    rs.getInt("idCliente"),
                    rs.getString("alias"),
                    rs.getString("sexo"),
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getString("color"),
                    rs.getObject("nacimiento", LocalDate.class),
                    rs.getBoolean("estadoMascota")
                );
                mascota.setDocumento(rs.getInt("dniCliente"));
                mascotasInactivas.add(mascota);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mascotasInactivas;
    }

    public int obtenerEstadoMascotaPorId(int idMascota) {
    String sql = "SELECT estadoMascota FROM mascota WHERE idMascota = ?";
    int estadoMascota = -1;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMascota);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                estadoMascota = rs.getInt("estadoMascota");
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estadoMascota;
    }


    public void activarMascota(int idMascota) {
    String sql = "UPDATE mascota SET estadoMascota = 1 WHERE idMascota = ?";
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idMascota);

        int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("Mascota activada con éxito.");
            } else {
                System.out.println("No se pudo activar la mascota.");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Mascota> obtenerMascotasActivas() {
    String sql = "SELECT m.*, c.documento AS dniCliente " +
                 "FROM mascota m " +
                 "INNER JOIN cliente c ON m.idCliente = c.idCliente " +
                 "WHERE m.estadoMascota = 1";
    List<Mascota> mascotas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mascota mascota = new Mascota(
                    rs.getInt("idMascota"),
                    rs.getInt("idCliente"),
                    rs.getString("alias"),
                    rs.getString("sexo"),
                    rs.getString("especie"),
                    rs.getString("raza"),
                    rs.getString("color"),
                    rs.getObject("nacimiento", LocalDate.class),
                    rs.getBoolean("estadoMascota")
                );
                mascota.setDocumento(rs.getInt("dniCliente"));
                mascotas.add(mascota);
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return mascotas;
    }


}
