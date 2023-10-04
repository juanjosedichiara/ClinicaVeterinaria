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
public class TratamientoData {
    private Connection con = null;
    
    public TratamientoData(){
         con = Conexion.getConexion();
    }
}
