/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author DAM126
 */
public class UsuarioDAO {
    private Connection conn = ConexionBD.getInstance().getConn();

public Usuario obtenerUsuarioPorId(int id){
    Usuario usu=null;
    String sql="SELECT * FROM usuarios WHERE cod_usu=?";
    try(PreparedStatement ps=conn.prepareStatement(sql);){
        ps.setInt(1, id);
        try(ResultSet rs=ps.executeQuery();){
            if(rs!=null && rs.next()){
                usu.setId(id);
                usu.setEmail(rs.getString("email"));
                usu.setNombre(rs.getString("nombre"));
                usu.setApellidos(rs.getString("apellidos"));
                usu.setPassword(rs.getString("password"));
                usu.setFecha_nac(rs.getDate("fecha_nac").toLocalDate());
                usu.setRol(ROL.valueOf(rs.getString("rol")));
                usu.setValidado(rs.getBoolean("validado"));
            }
        }
    }catch(SQLException ex){
        System.out.println(ex.getMessage());
    }
    return usu;
}
}
