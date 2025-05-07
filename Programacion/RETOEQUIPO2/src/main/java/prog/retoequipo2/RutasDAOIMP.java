/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.sql.Connection;

/**
 *
 * @author Rubéns
 */
public class RutasDAOIMP {
private Connection conn=ConexionBD.getInstance().getConn();

public boolean insertarRuta(Ruta ruta){
    boolean insertada=false;
    String sql="INSERT INTO rutas VALUES()";
    return insertada;
}

}
