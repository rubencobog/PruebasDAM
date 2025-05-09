
     /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package prog.retoequipo2;

import java.time.LocalDate;

/**
 *
 * @author DAM126
 */
public class RETOEQUIPO2 {

    public static void main(String[] args) {
        //hola ruben
        ConexionBD conexion=ConexionBD.getInstance();
        RutasDAO rutasss=new RutasDAO();
        Usuario usu1=new Usuario(1,"rubencio@gmail.com","ruben","cobo","pass",LocalDate.parse("1994-02-24"),ROL.ADMINISTRADOR,true);
        Ruta ruta=new Ruta("El toral",LocalDate.parse("1998-12-12"),22.22,44.44,44.44,22.22,345,456,55.65,65.87,CLASIFICACION.circular,300,4,3,true,true,"suputamadre.com",false,
                "lleva una rebequita por si refresca","Sri lanka",usu1);
        if(rutasss.insertarRuta(ruta)){
            System.out.println("Ruta insertada");
        }
    }
}
