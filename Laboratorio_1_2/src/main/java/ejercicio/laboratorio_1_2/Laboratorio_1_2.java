/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ejercicio.laboratorio_1_2;

import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Eithel
 */
public class Laboratorio_1_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Cliente> clientesAtendidos = new HashSet<>();

        boolean continuar = true;
        do {
            System.out.print("Ingrese el número de clientes deseados (no puede ser mayor a 15): ");
            int numClientes = scanner.nextInt();

            if (numClientes <= 0 || numClientes > (15 - clientesAtendidos.size())) {
                System.out.println("Número de clientes no válido.");
                System.out.println("¿Desea continuar? (si/no)");
                scanner.nextLine(); // Limpiar el buffer del teclado
                if (!scanner.nextLine().equalsIgnoreCase("si")) {
                    continuar = false;
                }
            } else {
                Maquina_de_tiquetes maquina = new Maquina_de_tiquetes();
                List<Cliente> clientes = generarClientes(maquina, numClientes);

                asignarNumerosDeTurno(clientes);

                atenderClientesEnCajas(clientes, clientesAtendidos);

                clientesAtendidos.addAll(clientes);

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

    public static void atenderClientesEnCajas(List<Cliente> clientes, Set<Cliente> clientesAtendidos) {
        Caja[] cajas = new Caja[4];
        for (int i = 0; i < cajas.length; i++) {
            cajas[i] = new Caja(i + 1);
        }

        int clienteAtendido = 0;
        Queue<Cliente> filaClientes = new PriorityQueue<>(Comparator.comparing(Cliente::getLetra));

        for (Cliente cliente : clientes) {
            filaClientes.add(cliente);
        }

        while (clienteAtendido < clientes.size()) {
            for (Caja caja : cajas) {
                if (clienteAtendido >= clientes.size()) {
                    break;
                }

                if (caja.estaDisponible()) {
                    Cliente cliente = filaClientes.poll();
                    if (cliente != null) {
                        caja.atenderCliente(cliente);
                        caja.ocuparCaja();

                        Timer temporizador = new Timer(cliente.getTiempoTramite() * 1000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                caja.liberarCaja();
                                Cliente siguienteCliente = filaClientes.poll();
                                if (siguienteCliente != null) {
                                    caja.atenderCliente(siguienteCliente);
                                }
                            }
                        });
                        temporizador.setRepeats(false);
                        temporizador.start();

                        clienteAtendido++;
                    }
                }
            }
        }
    }
}
