package RETO;

import java.util.Scanner;

public class casodeuso3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
   
        System.out.println("Bienvenido al sistema de optimización de rutas de threecode.");
        System.out.print("Cuántas ciudades de destino tienes para entregar los paquetes? ");
        int numDestinos = sc.nextInt();
        sc.nextLine();  

        String[] ciudades = new String[numDestinos];
        for (int i = 0; i < numDestinos; i++) {
            System.out.print("Ingrese la ciudad de destino #" + (i + 1) + ": ");
            ciudades[i] = sc.nextLine();
        }
        
        System.out.println("Calculando las rutas para optimizarlas");

        String[] rutasOptimizadas = new String[numDestinos];
        for (int i = 0; i < numDestinos; i++) {
            double trafico = Math.random();
            if (trafico < 0.3) {
                rutasOptimizadas[i] = "Ruta sin tráfico para " + ciudades[i];
            } else if (trafico < 0.7) {
                rutasOptimizadas[i] = "Ruta con poco tráfico para " + ciudades[i];
            } else {
                rutasOptimizadas[i] = "Ruta con mucho tráfico para " + ciudades[i];
            }
        }
       
        System.out.println("Las rutas optimizadas son:");
        for (int i = 0; i < numDestinos; i++) {
            System.out.println("Para " + ciudades[i] + ": " + rutasOptimizadas[i]);
        }
       
        System.out.println("Comienza la entrega de paquetes...");

        int i = 0;
        do {
            System.out.println("Entregando paquete a " + ciudades[i]);
            System.out.println("Ruta seleccionada: " + rutasOptimizadas[i]);
            
            double retraso = Math.random();
            if (retraso > 0.8) {
                System.out.println("Hay un retraso en la entrega, pero esta en ello.");
            } else {
                System.out.println("Entrega completada con exito en " + ciudades[i]);
            }
            
            i++;
        } while (i < numDestinos);
       
        System.out.println("Todas las entregas han sido realizadas con exito");
        sc.close();
    }
}