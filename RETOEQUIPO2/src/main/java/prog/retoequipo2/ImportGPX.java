/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.io.File;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


/**
 *
 * @author DAM110
 */
public class ImportGPX {
   
    public static void importar(File archivoGPX, JTextField txtNomRuta){
        try {
            if (archivoGPX == null || !archivoGPX.exists()) {
                throw new IllegalArgumentException("El archivo no existe.");
            }
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = (Document) builder.parse(archivoGPX);
            doc.getDocumentElement().normalize();
            NodeList nameList = doc.getElementsByTagName("name");
            if (nameList.getLength() > 0) {
                String nombre = nameList.item(0).getTextContent();
                txtNomRuta.setText(nombre);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null, "Error al importar el archivo GPX: " + e.getMessage());
        }
    }
}
