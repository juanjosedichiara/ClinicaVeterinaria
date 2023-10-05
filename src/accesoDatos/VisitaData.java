
package accesoDatos;

import java.sql.Connection;

public class VisitaData {
    private Connection con = null;
    
    public VisitaData(){
        con = Conexion.getConexion();
    }
    
    
    
        public void registrarVisita() {
            
            
    }
}
