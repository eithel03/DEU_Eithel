/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.laboratorio_1_2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Eithel
 */
public class Maquina_de_tiquetes {
    
     private int numeroClienteActual = 1;

    public Cliente generarTiquete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        int numero = numeroClienteActual++;
        char letra = determinarLetra();
        int tiempoTramite = generarTiempo();
        return new Cliente(numero, letra, tiempoTramite, nombre, numero);
    }


    private int generarNumeroAleatorio() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(15) + 1;
    }

    private char determinarLetra() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la categoría del cliente:");
        System.out.println("1. Adulto mayor");
        System.out.println("2. Embarazada o con un niño");
        System.out.println("3. Dos o más asuntos a tratar");
        System.out.println("4. Otro caso");
        int opcion = scanner.nextInt();
        char letra;
        switch (opcion) {
            case 1:
                letra = 'A';
                break;
            case 2:
                letra = 'B';
                break;
            case 3:
                letra = 'C';
                break;
            default:
                letra = 'D';
                break;
        }
        return letra;
    }

    private int generarTiempo() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(24) + 2;
    }
}