/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio.laboratorio_1_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Eithel
 */
public class Laboratorio_1_2 {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        do {
            System.out.print("Ingrese el número de clientes deseados (no puede ser mayor a 15): ");
            int numClientes = scanner.nextInt();

            if (numClientes > 15) {
                System.out.println("El número de clientes no puede ser mayor a 15.");
                System.out.println("¿Desea continuar? (si/no)");
                scanner.nextLine(); // Limpiar el buffer del teclado
                if (!scanner.nextLine().equalsIgnoreCase("si")) {
                    continuar = false;
                }
            } else {
                Maquina_de_tiquetes maquina = new Maquina_de_tiquetes();
                List<Cliente> clientes = generarClientes(maquina, numClientes);

                //Se llama al metodo:
                asignarNumerosDeTurno(clientes);

                // Se llama al metodo: atender clientes en cajas
                atenderClientesEnCajas(clientes);

                System.out.println("¿Deseas volver a registrar? (si/no)");
                scanner.nextLine(); // Limpiar el buffer del teclado
                if (!scanner.nextLine().equalsIgnoreCase("si")) {
                    continuar = false;
                }
            }
        } while (continuar);
    }

    public static List<Cliente> generarClientes(Maquina_de_tiquetes maquina, int numClientes) {
        List<Cliente> clientes = new ArrayList<>();

        for (int i = 1; i <= numClientes; i++) {
            Cliente tiquete = maquina.generarTiquete();
            clientes.add(tiquete);
        }

        return clientes;
    }

    public static void asignarNumerosDeTurno(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            clientes.get(i).setNumeroTurno(i + 1);
        }
    }

    public static void atenderClientesEnCajas(List<Cliente> clientes) {
        // Crear cajas
        Caja[] cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1);
        }

        // Se atiende los clientes en las cajas
        for (Cliente cliente : clientes) {
            Caja cajaDisponible = buscarCajaDisponible(cajas);
            if (cajaDisponible != null) {
                cajaDisponible.atenderCliente(cliente);
                cajaDisponible.ocuparCaja(); // Se ocupa la caja después de que se atiende un cliente
            }
        }
    }

    public static Caja buscarCajaDisponible(Caja[] cajas) {
        for (Caja caja : cajas) {
            if (caja.estaDisponible()) {
                return caja;
            }
        }
        return null;
    }
}