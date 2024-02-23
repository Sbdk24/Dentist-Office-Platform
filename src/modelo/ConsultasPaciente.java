package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasPaciente extends Conexion {
    
    public boolean registrar(PacienteModel p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO pacientes (nombre, apellido, edad, sexo, numero_telefonico, correo_electronico) VALUES(?,?,?,?,?,?)";
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getEdad());
            ps.setString(4, p.getSexo());
            ps.setInt(5, p.getNumero_telefonico());
            ps.setString(6, p.getCorreo_electronico());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
    
    public boolean modificar(PacienteModel p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE pacientes SET nombre=?, apellido=?, edad=?, sexo=?, numero_telefonico=?, correo_electronico=? WHERE id=? ";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getEdad());
            ps.setString(4, p.getSexo());
            ps.setInt(5, p.getNumero_telefonico());
            ps.setString(6, p.getCorreo_electronico());
            ps.setInt(7, p.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
    
    public boolean eliminar(PacienteModel p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM pacientes WHERE id=? ";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
    public boolean buscar(PacienteModel p)
    {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM pacientes WHERE nombre=? ";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                p.setId(Integer.parseInt(rs.getString("id")));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setEdad(Integer.parseInt(rs.getString("edad")));
                p.setSexo(rs.getString("sexo"));
                p.setNumero_telefonico(Integer.parseInt(rs.getString("numero_telefonico")));
                p.setCorreo_electronico(rs.getString("correo_electronico"));
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
    public boolean checkHistorialExists(int idPaciente) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
    
        String sql = "SELECT count(1) FROM historial WHERE id_paciente = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            rs = ps.executeQuery();
    
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Historial exists
            }
            return false; // No historial found
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean loadHistorialData(PacienteModel p) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
    
        String sql = "SELECT * FROM historial WHERE id_paciente = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            rs = ps.executeQuery();
    
            if (rs.next()) {
                // Assuming these methods exist in PacienteModel
                p.setEnfermedades(rs.getString("enfermedades"));
                p.setMedicamentos(rs.getString("medicamentos"));
                p.setAlergias(rs.getString("alergias"));
                p.setIntervenciones(rs.getString("intervenciones_quirurgicas"));
                return true; // Data loaded successfully
            }
            return false; // No data found
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean registrarH(PacienteModel p) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO historial (id_paciente, enfermedades, medicamentos, alergias, intervenciones_quirurgicas) VALUES(?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId()); // Make sure this is the patient's ID
            ps.setString(2, p.getEnfermedades());
            ps.setString(3, p.getMedicamentos());
            ps.setString(4, p.getAlergias());
            ps.setString(5, p.getIntervenciones());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean modificarH(PacienteModel p)
    {
        PreparedStatement ps = null;
        Connection con = getConexion();
        //historial (enfermedades, medicamentos, alergias, intervenciones_quirurgicas)
        String sql = "UPDATE historial SET enfermedades=?, medicamentos=?, alergias=?, intervenciones_quirurgicas=? WHERE id_paciente=? ";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getEnfermedades());
            ps.setString(2, p.getMedicamentos());
            ps.setString(3, p.getAlergias());
            ps.setString(4, p.getIntervenciones());
            ps.setInt(5, p.getId());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally{
            try{
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        
    }
}