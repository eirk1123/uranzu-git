package RETO;
import java.util.Scanner;

public class casodeuso2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

        System.out.println("=== Registrar paquetes en un viaje ===");

        System.out.print("Ingrese ID o nombre del viaje: ");
        String viaje = sc.nextLine();

        String continuar;
        int contador = 1;

        do {
            System.out.println("\n--- Paquete " + contador + " ---");

            System.out.print("Ingrese peso del paquete (kg): ");
            String peso = sc.nextLine();

            System.out.print("Ingrese dimensiones del paquete (LxAnxAl): ");
            String dimensiones = sc.nextLine();

            System.out.print("Ingrese nombre del remitente: ");
            String remitente = sc.nextLine();

            System.out.print("Ingrese nombre del destinatario: ");
            String destinatario = sc.nextLine();

            System.out.println("\nPaquete registrado en el viaje " + viaje + ":");
            System.out.println("Peso: " + peso + " kg");
            System.out.println("Dimensiones: " + dimensiones);
            System.out.println("Remitente: " + remitente);
            System.out.println("Destinatario: " + destinatario);

            System.out.print("\n¿Desea registrar otro paquete? (sí/no): ");
            continuar = sc.nextLine().toLowerCase();
            contador++;

        } while (continuar.equals("sí") || continuar.equals("si"));

        System.out.println("\nRegistro de paquetes finalizado.");
        sc.close();
    }

	}