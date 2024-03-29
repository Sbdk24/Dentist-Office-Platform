package modelo;

import java.sql.Connection;  // Corrected import for SQL Connection
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
 
    private final String base = "consultorio";
    private final String user = "root";
    private final String password = "rHQKUcA3XE";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConexion()
    {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //Controlador para realizar conexion
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
        
        } catch(SQLException e){
            System.err.println(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    
    }
}