/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoDatos;

import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class VisitaData {
    private Connection con = null;
    
    public VisitaData(){
        con = Conexion.getConexion();
    }
}
