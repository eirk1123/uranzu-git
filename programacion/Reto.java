package RETO;

import java.util.Scanner;

public class Reto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

   
        String[] usuarios = {"juan", "maria", "carlos"};
        String[] contrasenas = {"1111", "2222", "3333"};

     
        String adminUsuario = "admin";
        String adminContrasena = "12345";

        System.out.println("Seleccione tipo de usuario (normal/admin):");
        String tipoUsuario = sc.nextLine();

        boolean accesoConcedido = false;

        if (tipoUsuario.equalsIgnoreCase("admin")) {
            System.out.print("Usuario: ");
            String usuario = sc.nextLine();
            System.out.print("Contraseña: ");
            String contrasena = sc.nextLine();

            if (usuario.equals(adminUsuario) && contrasena.equals(adminContrasena)) {
                accesoConcedido = true;
                System.out.println("✅ Login correcto. Acceso ADMIN concedido.\n");

              
                String[] clientes = {"Juan", "María", "Carlos", "Ana", "Luis"};
                String[] productos = {"Pizza Congelada", "Pollo Fresco", "Ensalada Precocinada", "Lácteos", "Carne"};
                int[] cantidades = new int[5];
                double[] totales = new double[5];

             
                for (int i = 0; i < 5; i++) {
                    cantidades[i] = (int)(Math.random() * 5) + 1; 
                    double precioUnitario;
                    switch (productos[i]) {
                        case "Pizza Congelada": precioUnitario = 6.0; break;
                        case "Pollo Fresco": precioUnitario = 7.5; break;
                        case "Ensalada Precocinada": precioUnitario = 4.5; break;
                        case "Lácteos": precioUnitario = 2.0; break;
                        case "Carne": precioUnitario = 8.0; break;
                        default: precioUnitario = 5.0; break;
                    }
                    totales[i] = cantidades[i] * precioUnitario;
                }

         
                System.out.println("📋 LISTA DE COMPRAS RANDOM:");
                for (int i = 0; i < 5; i++) {
                    System.out.println("-----------------------------");
                    System.out.println("Cliente: " + clientes[i]);
                    System.out.println("Producto: " + productos[i]);
                    System.out.println("Cantidad: " + cantidades[i]);
                    System.out.println("Total: " + totales[i] + " €");
                }
                System.out.println("-----------------------------");

            } else {
                System.out.println("❌ Usuario o contraseña de ADMIN incorrectos.");
            }

        } else if (tipoUsuario.equalsIgnoreCase("normal")) {
                System.out.print("Usuario: ");
                String usuario = sc.nextLine();
                System.out.print("Contraseña: ");
                String contrasena = sc.nextLine();

                boolean usuarioEncontrado = false;
                boolean contrasenaCorrecta = false;

                for (int i = 0; i < usuarios.length; i++) {
                    if (usuario.equals(usuarios[i])) {
                        usuarioEncontrado = true;
                        if (contrasena.equals(contrasenas[i])) {
                            contrasenaCorrecta = true;
                            accesoConcedido = true;
                            System.out.println("✅ Login correcto. Bienvenido, " + usuario + ".");
                            break;
                        }
                    }
                }

                if (!usuarioEncontrado) {
                    System.out.println("❌ Usuario incorrecto.");
                    sc.close();
                    return;
                } else if (!contrasenaCorrecta) {
                    System.out.println("❌ Contraseña incorrecta.");
                    sc.close();
                    return;
                }

             
                System.out.print("\nIngrese nombre del cliente: ");
                String nombreCliente = sc.nextLine();

                System.out.print("Ingrese el producto que desea pedir: ");
                String producto = sc.nextLine();

                System.out.print("Ingrese la cantidad que desea pedir: ");
                int cantidad = sc.nextInt();
                sc.nextLine();

                if (cantidad <= 0) {
                    System.out.println("Cantidad inválida. Debe ser mayor que cero.");
                    sc.close();
                    return;
                }

                double precioUnitario;
                switch (producto) {
                    case "Pizza Congelada": precioUnitario = 6.0; break;
                    case "Pollo Fresco": precioUnitario = 7.5; break;
                    case "Ensalada Precocinada": precioUnitario = 4.5; break;
                    case "Lácteos": precioUnitario = 2.0; break;
                    case "Carne": precioUnitario = 8.0; break;
                    default: precioUnitario = 5.0; break;
                }

                double total = cantidad * precioUnitario;

                System.out.println("\n----- RESUMEN DEL PEDIDO -----");
                System.out.println("Cliente: " + nombreCliente);
                System.out.println("Producto: " + producto);
                System.out.println("Cantidad: " + cantidad);
                System.out.println("Precio unitario: " + precioUnitario);
                System.out.println("Total a pagar: " + total + " €");
            }
 else {
            System.out.println("⚠️ Tipo de usuario no válido.");
        }

        sc.close();
    }
}


