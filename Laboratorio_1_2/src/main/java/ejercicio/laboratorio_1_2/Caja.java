/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.laboratorio_1_2;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Eithel
 */
public class Caja {
    private int numero;
    private boolean disponible;

    public Caja(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public void atenderCliente(Cliente cliente) {
       System.out.println("Caja " + this.numero + " atiende al Cliente: "
                + cliente.getNombre() + ", código de tiquete: " + cliente.getLetra() + cliente.getNumero() 
                + ", Tiempo Trámite: " + cliente.getTiempoTramite());
        this.disponible = true;
    }

    public boolean estaDisponible() {
        return this.disponible;
    }

    public void ocuparCaja() {
        this.disponible = false;
    }

    public int getNumero() {
        return this.numero;
    }
    
}