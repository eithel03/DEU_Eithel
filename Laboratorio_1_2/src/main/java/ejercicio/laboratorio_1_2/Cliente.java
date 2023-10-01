/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.laboratorio_1_2;
import java.util.Random;

/**
 *
 * @author Eithel
 */
public class Cliente {
    private int numero;
    private char letra;
    private int tiempoTramite;
    private String nombre;
    private int numeroCliente;
    private int numeroTurno;

  
   public Cliente(int numero, char letra, int tiempoTramite, String nombre, int numeroCliente) {
    this.numero = numero;
    this.letra = letra;
    this.tiempoTramite = tiempoTramite;
    this.nombre = nombre;
    this.numeroCliente = numeroCliente;
}

    private int generarTiempoAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }


    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the letra
     */
    public char getLetra() {
        return letra;
    }

    /**
     * @param letra the letra to set
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }

    /**
     * @return the tiempoTramite
     */
    public int getTiempoTramite() {
        return tiempoTramite;
    }

    /**
     * @param tiempoTramite the tiempoTramite to set
     */
    public void setTiempoTramite(int tiempoTramite) {
        this.tiempoTramite = tiempoTramite;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }
    public void setNumeroTurno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }
}

