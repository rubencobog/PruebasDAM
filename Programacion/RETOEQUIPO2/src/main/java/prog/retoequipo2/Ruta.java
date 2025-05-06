/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.retoequipo2;

import java.time.LocalDate;
import java.util.LinkedList;

public class Ruta {
private int id_ruta;
private String nombre;
private LocalDate fecha;
private double longitud_ini;
private double latitud_ini;
private double longitud_fin;
private double latitud_fin;
private int distancia_total;
private int duracion;
private double latitud_max;
private double longitud_max;
private CLASIFICACION clasificacion;
private int nivel_riesgo;
private int nivel_esfuerzo;
private int desnivel_acumulado;
private int tipo_terreno;
private int indicaciones;
private Actividad actividad;
private Periodo periodo;
private boolean accesible_inclusivo;
private boolean familiar;
private String url_gpx;
private boolean validada;
private String recomendaciones;
private String zona_geografica;
private double valoracion_media;
private LinkedList <Punto_interes>puntos_interes;
private LinkedList<Punto_peligro>puntos_peligro;
private LinkedList<Resena>resenas;
private LinkedList<Valoracion>valoraciones;

    public Ruta(int id_ruta, String nombre, LocalDate fecha, double longitud_ini, double latitud_ini, double longitud_fin, double latitud_fin, int distancia_total, int duracion, double latitud_max, double longitud_max, CLASIFICACION clasificacion, int nivel_riesgo, int nivel_esfuerzo, int desnivel_acumulado, int tipo_terreno, int indicaciones, Actividad actividad, Periodo periodo, boolean accesible_inclusivo, boolean familiar, String url_gpx, boolean validada, String recomendaciones, String zona_geografica, double valoracion_media, LinkedList<Punto_interes> puntos_interes, LinkedList<Punto_peligro> puntos_peligro, LinkedList<Resena> resenas, LinkedList<Valoracion> valoraciones) {
        this.id_ruta = id_ruta;
        this.nombre = nombre;
        this.fecha = fecha;
        this.longitud_ini = longitud_ini;
        this.latitud_ini = latitud_ini;
        this.longitud_fin = longitud_fin;
        this.latitud_fin = latitud_fin;
        this.distancia_total = distancia_total;
        this.duracion = duracion;
        this.latitud_max = latitud_max;
        this.longitud_max = longitud_max;
        this.clasificacion = clasificacion;
        this.nivel_riesgo = nivel_riesgo;
        this.nivel_esfuerzo = nivel_esfuerzo;
        this.desnivel_acumulado = desnivel_acumulado;
        this.tipo_terreno = tipo_terreno;
        this.indicaciones = indicaciones;
        this.actividad = actividad;
        this.periodo = periodo;
        this.accesible_inclusivo = accesible_inclusivo;
        this.familiar = familiar;
        this.url_gpx = url_gpx;
        this.validada = validada;
        this.recomendaciones = recomendaciones;
        this.zona_geografica = zona_geografica;
        this.valoracion_media = valoracion_media;
        this.puntos_interes = puntos_interes;
        this.puntos_peligro = puntos_peligro;
        this.resenas = resenas;
        this.valoraciones = valoraciones;
    }

    public Ruta(String nombre, LocalDate fecha, double longitud_ini, double latitud_ini, double longitud_fin, double latitud_fin, int distancia_total, int duracion, double latitud_max, double longitud_max, CLASIFICACION clasificacion, int nivel_riesgo, int nivel_esfuerzo, int desnivel_acumulado, int tipo_terreno, int indicaciones, Actividad actividad, Periodo periodo, boolean accesible_inclusivo, boolean familiar, String url_gpx, boolean validada, String recomendaciones, String zona_geografica, double valoracion_media, LinkedList<Punto_interes> puntos_interes, LinkedList<Punto_peligro> puntos_peligro, LinkedList<Resena> resenas, LinkedList<Valoracion> valoraciones) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.longitud_ini = longitud_ini;
        this.latitud_ini = latitud_ini;
        this.longitud_fin = longitud_fin;
        this.latitud_fin = latitud_fin;
        this.distancia_total = distancia_total;
        this.duracion = duracion;
        this.latitud_max = latitud_max;
        this.longitud_max = longitud_max;
        this.clasificacion = clasificacion;
        this.nivel_riesgo = nivel_riesgo;
        this.nivel_esfuerzo = nivel_esfuerzo;
        this.desnivel_acumulado = desnivel_acumulado;
        this.tipo_terreno = tipo_terreno;
        this.indicaciones = indicaciones;
        this.actividad = actividad;
        this.periodo = periodo;
        this.accesible_inclusivo = accesible_inclusivo;
        this.familiar = familiar;
        this.url_gpx = url_gpx;
        this.validada = validada;
        this.recomendaciones = recomendaciones;
        this.zona_geografica = zona_geografica;
        this.valoracion_media = valoracion_media;
        this.puntos_interes = puntos_interes;
        this.puntos_peligro = puntos_peligro;
        this.resenas = resenas;
        this.valoraciones = valoraciones;
    }

    
    

    public int getId_ruta() {
        return id_ruta;
    }

    public void setId_ruta(int id_ruta) {
        this.id_ruta = id_ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getLongitud_ini() {
        return longitud_ini;
    }

    public void setLongitud_ini(double longitud_ini) {
        this.longitud_ini = longitud_ini;
    }

    public double getLatitud_ini() {
        return latitud_ini;
    }

    public void setLatitud_ini(double latitud_ini) {
        this.latitud_ini = latitud_ini;
    }

    public double getLongitud_fin() {
        return longitud_fin;
    }

    public void setLongitud_fin(double longitud_fin) {
        this.longitud_fin = longitud_fin;
    }

    public double getLatitud_fin() {
        return latitud_fin;
    }

    public void setLatitud_fin(double latitud_fin) {
        this.latitud_fin = latitud_fin;
    }

    public int getDistancia_total() {
        return distancia_total;
    }

    public void setDistancia_total(int distancia_total) {
        this.distancia_total = distancia_total;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public CLASIFICACION getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(CLASIFICACION clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getNivel_riesgo() {
        return nivel_riesgo;
    }

    public void setNivel_riesgo(int nivel_riesgo) {
        this.nivel_riesgo = nivel_riesgo;
    }

    public int getNivel_esfuerzo() {
        return nivel_esfuerzo;
    }

    public void setNivel_esfuerzo(int nivel_esfuerzo) {
        this.nivel_esfuerzo = nivel_esfuerzo;
    }

    public int getDesnivel_acumulado() {
        return desnivel_acumulado;
    }

    public void setDesnivel_acumulado(int desnivel_acumulado) {
        this.desnivel_acumulado = desnivel_acumulado;
    }

    public int getTipo_terreno() {
        return tipo_terreno;
    }

    public void setTipo_terreno(int tipo_terreno) {
        this.tipo_terreno = tipo_terreno;
    }

    public int getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(int indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public boolean isAccesible_inclusivo() {
        return accesible_inclusivo;
    }

    public void setAccesible_inclusivo(boolean accesible_inclusivo) {
        this.accesible_inclusivo = accesible_inclusivo;
    }

    public boolean isFamiliar() {
        return familiar;
    }

    public void setFamiliar(boolean familiar) {
        this.familiar = familiar;
    }

    public String getUrl_gpx() {
        return url_gpx;
    }

    public void setUrl_gpx(String url_gpx) {
        this.url_gpx = url_gpx;
    }

    public boolean isValidada() {
        return validada;
    }

    public void setValidada(boolean validada) {
        this.validada = validada;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getZona_geografica() {
        return zona_geografica;
    }

    public void setZona_geografica(String zona_geografica) {
        this.zona_geografica = zona_geografica;
    }

    public LinkedList<Punto_interes> getPuntos_interes() {
        return puntos_interes;
    }

    public void setPuntos_interes(LinkedList<Punto_interes> puntos_interes) {
        this.puntos_interes = puntos_interes;
    }

    public LinkedList<Punto_peligro> getPuntos_peligro() {
        return puntos_peligro;
    }

    public void setPuntos_peligro(LinkedList<Punto_peligro> puntos_peligro) {
        this.puntos_peligro = puntos_peligro;
    }

    public LinkedList<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(LinkedList<Resena> resenas) {
        this.resenas = resenas;
    }

    public LinkedList<Valoracion> getValoraciones() {
        return valoraciones;
    }

    public void setValoraciones(LinkedList<Valoracion> valoraciones) {
        this.valoraciones = valoraciones;
    }

    public double getLatitud_max() {
        return latitud_max;
    }

    public void setLatitud_max(double latitud_max) {
        this.latitud_max = latitud_max;
    }

    public double getLongitud_max() {
        return longitud_max;
    }

    public void setLongitud_max(double longitud_max) {
        this.longitud_max = longitud_max;
    }

    public double getValoracion_media() {
        return valoracion_media;
    }

    public void setValoracion_media(double valoracion_media) {
        this.valoracion_media = valoracion_media;
    }

}
