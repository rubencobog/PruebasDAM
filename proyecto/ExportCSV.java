/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *Clase que se encarga de exportar los datos de una ruta a un fichero
 * 
 * @author Guille
 */
public class ExportCSV {
/**
 *El método se encarga de exportar los datos de una ruta a un archivo formato CSV
 * 
 * @author Guille
 * @param ruta objeto de tipo {@link Ruta} que representa la ruta que se va a exportar
 * @param archivoExport que se corresponde con la URL donde se aloja el archivo
 */
public static void exportarRuta(Ruta ruta, String archivoExport) {
        File archivo = new File(archivoExport);
        MetodosDAO metodos = new MetodosDAO();
        try {
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoExport))){
                writer.write("TipoRegistro,NombreRuta,Autor,EnlaceWikiloc,FechaCreacion\n");
                writer.write("InfoGeneral," + ruta.getNombre() + "," + ruta.getCreador() + "," + ruta.getUrl_gpx() + "," + ruta.getFecha() + "\n");
 
                writer.write("\nTipoRegistro,Latitud,Longitud,Timestamp\n");
                for (Punto_interes interes : metodos.listarPuntosInteresRuta(ruta.getId_ruta())) {
                    writer.write("PuntoInteres," + interes.getLatitud() + "," + interes.getLongitud() + "," + interes.getTimestamp()
                            + "," + interes.getTipo() + "," + interes.getCaract_especiales() + "\n");
                }
                for (Punto_peligro peligro : metodos.listarPuntosPeligroRuta(ruta.getId_ruta())) {
                    writer.write("PuntoPeligro," + peligro.getLatitud() + "," + peligro.getLongitud() + "," + peligro.getTimestamp()
                            + "," + peligro.getKm() + "," + peligro.getNivel_gravedad() + "," + peligro.getDescripcion_gravedad() + "\n");
                }
                }
 
            
            } catch (IOException e) {
                System.out.println("Error al exportar el archivo");
            }
         }
}
