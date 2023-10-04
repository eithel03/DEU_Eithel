/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.laboratorio_1_2;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Eithel
 */
public class Caja {
 private int numero;
    private boolean disponible;
    private Cliente clienteActual;
    private Queue<Cliente> filaClientes = new LinkedList<>();

    public Caja(int numero) {
        this.numero = numero;
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

    public void liberarCaja() {
         this.disponible = true;
        Cliente clienteAtendido = this.clienteActual;
        this.clienteActual = null;

        if (clienteAtendido != null) {
            clienteAtendido.asignarNuevoTiempoTramite(); // Asignar nuevo tiempo
        } else {
            System.out.println("Caja " + this.numero + " liberada.");
        }

        if (!filaClientes.isEmpty()) {
            Cliente siguienteCliente = obtenerSiguienteClienteDeLaFila();
            this.clienteActual = siguienteCliente;
            this.disponible = false;
            atenderCliente(this.clienteActual);
        }
        
    }
     public String toString() {
        String estado;
        if (clienteActual == null) {
            estado = "-----------------------------------------------------------" + "\n"
                    + "\n"
                    + "La caja número: " + this.numero + ": se encuentra libre" + "\n";
              
        } else {
            estado = "-----------------------------------------------------------" + "\n"
                    + "\n"
                    + "Caja número: " + this.numero + ": esta atendiendo a el cliente: " + clienteActual.getNombre()
                    + " cuyo codigo de tiquete es: " + clienteActual.getLetra() + clienteActual.getNumero()+ " Tiempo de tramite: " + clienteActual.getTiempoTramite() + "\n";
                  
        }
        return estado;
    }

   public void atenderCliente(Cliente cliente) {
        if (filaClientes.isEmpty()) {
            this.clienteActual = cliente;
             System.out.println(toString());
            this.disponible = true;
        } else {
            Cliente siguienteCliente = obtenerSiguienteClienteDeLaFila();
           
            this.clienteActual = siguienteCliente;
            System.out.println(toString());
            this.disponible = true;
        }
        this.ocuparCaja();
    }

    public Cliente obtenerSiguienteClienteDeLaFila() {
        return filaClientes.poll();
    }
}        