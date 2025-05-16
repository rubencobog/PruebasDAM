/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author DAM110
 */
public class ImportCSV {

    public static void importar(File archivoCSV,JTextField txtNomRuta,JTextField txtLatInicio,
                                JTextField txtLonInicio,JTextField txtLatFinal,JTextField txtLonFinal,
                                JTextField txtDistancia,JTextField txtDuracion,JTextField txtDesnivel,
                                JTextField txtLatMax,JTextField txtLonMax,JComboBox<String> cmbTipoRuta) {
        try {
            if (archivoCSV == null || !archivoCSV.exists()) {
                throw new IllegalArgumentException("El archivo no existe.");
            }

            BufferedReader reader = new BufferedReader(new FileReader(archivoCSV));
            String linea;

            String[] general = reader.readLine().split(",", -1);
            txtNomRuta.setText(general[0].trim());

            double latPrimera = 0, lonPrimera = 0;
            double latUltima = 0, lonUltima = 0;
            double latMax = -Double.MAX_VALUE, lonMax = -Double.MAX_VALUE;
            double eleAnterior = 0;
            double desnivelPos = 0, desnivelNeg = 0;
            double distanciaTotal = 0;

            LocalDateTime tiempoInicio = null, tiempoFin = null;

            double latAnterior = 0, lonAnterior = 0;
            boolean primerPunto = true;

            DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

            while ((linea = reader.readLine()) != null) {
                if (linea.startsWith("TRK")) {
                    String[] campos = linea.split(",", -1);
                    double lat = Double.parseDouble(campos[2]);
                    double lon = Double.parseDouble(campos[3]);
                    double ele = Double.parseDouble(campos[4]);
                    LocalDateTime tiempo = LocalDateTime.parse(campos[5], formatter);

                    if (primerPunto) {
                        latPrimera = lat;
                        lonPrimera = lon;
                        tiempoInicio = tiempo;
                        eleAnterior = ele;
                        primerPunto = false;
                    } else {
                        distanciaTotal += calcularDistancia(latAnterior, lonAnterior, lat, lon);
                        double deltaAlt = ele - eleAnterior;
                        if (deltaAlt > 0) desnivelPos += deltaAlt;
                        else desnivelNeg += Math.abs(deltaAlt);
                        eleAnterior = ele;
                    }

                    latUltima = lat;
                    lonUltima = lon;
                    tiempoFin = tiempo;

                    if (lat > latMax) latMax = lat;
                    if (lon > lonMax) lonMax = lon;

                    latAnterior = lat;
                    lonAnterior = lon;
                }
            }

            reader.close();

            long duracionMinutos = Duration.between(tiempoInicio, tiempoFin).toMinutes();

            txtLatInicio.setText(String.format("%.5f", latPrimera));
            txtLonInicio.setText(String.format("%.5f", lonPrimera));
            txtLatFinal.setText(String.format("%.5f", latUltima));
            txtLonFinal.setText(String.format("%.5f", lonUltima));
            txtDistancia.setText(String.format("%.2f", distanciaTotal));
            txtDuracion.setText(Long.toString(duracionMinutos));
            txtDesnivel.setText(String.format("+%.0f / -%.0f", desnivelPos, desnivelNeg));
            txtLatMax.setText(String.format("%.5f", latMax));
            txtLonMax.setText(String.format("%.5f", lonMax));

            boolean esCircular = calcularDistancia(latPrimera, lonPrimera, latUltima, lonUltima) < 0.05;
            cmbTipoRuta.setSelectedItem(esCircular ? "Circular" : "Lineal");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al importar CSV: " + e.getMessage());
        }
    }

    private static double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Radio Tierra en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c;
    }
}
/*public static void importar(File archivoGPX, JTextField txtNomRuta){
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
    } */
