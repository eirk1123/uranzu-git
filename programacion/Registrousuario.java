package RETO;

import java.util.ArrayList;
import java.util.Scanner;

public class Registrousuario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<String> contrasenas = new ArrayList<>();

        System.out.println("===== REGISTRO DE USUARIOS =====");

        while (true) {
            System.out.print("\nIngrese nombre de usuario (o 'salir' para terminar): ");
            String usuario = sc.nextLine();
            if (usuario.equalsIgnoreCase("salir")) {
                break;
            }

            // Verificar si el usuario ya existe
            if (usuarios.contains(usuario)) {
                System.out.println("❌ Este usuario ya está registrado.");
                continue;
            }

            System.out.print("Ingrese contraseña: ");
            String contrasena = sc.nextLine();

            usuarios.add(usuario);
            contrasenas.add(contrasena);

            System.out.println("✅ Usuario registrado correctamente.");
        }

        // Mostrar todos los usuarios registrados
        System.out.println("\n===== LISTA DE USUARIOS REGISTRADOS =====");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Usuario: " + usuarios.get(i) + " | Contraseña: " + contrasenas.get(i));
        }

        sc.close();
    }
}