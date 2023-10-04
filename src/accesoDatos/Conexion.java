/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="clinicaveterinaria";
    private static final String USUARIO="root";
    private static final String PASSWORD=" ";
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
        if(connection==null){
            try{
                Class.forName("org.mariadb.jdbc.Driver");
                connection=DriverManager.getConnection(URL+DB,USUARIO,PASSWORD);
                
            }catch(ClassNotFoundException ex){
                JOptionPane.showConfirmDialog(null,"No se pueden cargar los drivers");
            }catch(SQLException ex){
                JOptionPane.showConfirmDialog(null, "No se puede conectar a la base de datos");
            }
        }
    return connection;
    }    
        
    }
    
