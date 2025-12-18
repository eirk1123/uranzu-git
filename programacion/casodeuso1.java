//probar crecendiales
import java.util.ArrayList;
import java.util.Scanner;

public class casodeuso1 {

    // CLASE VIAJE
    public static class Viaje {
        private String camion;
        private String camionero;
        private String origen;
        private String destino;
        private String fechaHora;

        public Viaje() {}

        public Viaje(String camion, String camionero, String origen, String destino, String fechaHora) {
            this.camion = camion;
            this.camionero = camionero;
            this.origen = origen;
            this.destino = destino;
            this.fechaHora = fechaHora;
        }

        // Getters y setters
        public String getCamion() { return camion; }
        public void setCamion(String camion) { this.camion = camion; }

        public String getCamionero() { return camionero; }
        public void setCamionero(String camionero) { this.camionero = camionero; }

        public String getOrigen() { return origen; }
        public void setOrigen(String origen) { this.origen = origen; }

        public String getDestino() { return destino; }
        public void setDestino(String destino) { this.destino = destino; }

        public String getFechaHora() { return fechaHora; }
        public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

        // Métodos
        public void mostrarInfo() {
            System.out.println("Camión: " + camion);
            System.out.println("Camionero: " + camionero);
            System.out.println("Ciudad origen: " + origen);
            System.out.println("Ciudad destino: " + destino);
            System.out.println("Fecha y hora de salida: " + fechaHora);
        }
    }

    // CLASE GESTOR
    public static class GestorViajes {
        private ArrayList<Viaje> listaViajes = new ArrayList<>();

        public void agregarViaje(Viaje viaje) {
            listaViajes.add(viaje);
        }

        public void listarViajes() {
            if (listaViajes.isEmpty()) {
                System.out.println("No hay viajes registrados.");
            } else {
                System.out.println("=== Lista de viajes ===");
                for (Viaje v : listaViajes) {
                    v.mostrarInfo();
                    System.out.println("--------------------");
                }
            }
        }

        public void buscarViajePorCamion(String camion) {
            boolean encontrado = false;
            for (Viaje v : listaViajes) {
                if (v.getCamion().equalsIgnoreCase(camion)) {
                    System.out.println("Viaje encontrado:");
                    v.mostrarInfo();
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún viaje con ese camión.");
            }
        }
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorViajes gestor = new GestorViajes();

        System.out.println("=== Registrar un nuevo viaje ===");

        System.out.print("Ingrese el ID del camión: ");
        String camion = sc.nextLine();

        System.out.print("Ingrese el nombre del camionero: ");
        String camionero = sc.nextLine();

        System.out.print("Ingrese ciudad de origen: ");
        String origen = sc.nextLine();

        System.out.print("Ingrese ciudad de destino: ");
        String destino = sc.nextLine();

        System.out.print("Ingrese fecha y hora de salida: ");
        String fechaHora = sc.nextLine();

        Viaje viaje = new Viaje(camion, camionero, origen, destino, fechaHora);
        gestor.agregarViaje(viaje);

        System.out.println("\nViaje registrado correctamente:");
        viaje.mostrarInfo();

        // Ejemplo de listar y buscar viajes
        System.out.println("\nListando todos los viajes:");
        gestor.listarViajes();

        System.out.print("\nIngrese un ID de camión para buscar un viaje: ");
        String busquedaCamion = sc.nextLine();
        gestor.buscarViajePorCamion(busquedaCamion);

        sc.close();
    }
}
