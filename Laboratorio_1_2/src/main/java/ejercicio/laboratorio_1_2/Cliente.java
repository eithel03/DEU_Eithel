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
        this.tiempoTramite = generarTiempoAleatorio(2, 24); 
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
    }
    public Cliente(int numeroCliente) {
        this.numero = numero;
        this.letra = letra;
        this.tiempoTramite = generarTiempoAleatorio(2, 24); 
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
    }

    private int generarTiempoAleatorio(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void actualizarTiempoRestante() {
        tiempoTramite--; // Decrementa el tiempo restante
    }
    public void asignarNuevoTiempoTramite() {
    this.tiempoTramite = generarTiempoAleatorio(2, 24);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getTiempoTramite() {
        return tiempoTramite;
    }

    public void setTiempoTramite(int tiempoTramite) {
        this.tiempoTramite = tiempoTramite;
    }

    public int getTiempoRestanteTramite() {
        return tiempoTramite;
    }

    public String getNombre() {
        return nombre;
    }

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