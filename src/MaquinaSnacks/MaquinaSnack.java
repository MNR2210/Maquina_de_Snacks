package MaquinaSnacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaquinaSnack {
    public static void main(String[] args) {
        maquinaSnacks();
    }

    public static void maquinaSnacks(){
        boolean salir = false;
        Scanner sc = new Scanner(System.in);
        //Creando lista de productos de tipo snack
        List<Snack> productos = new ArrayList<>();
        System.out.println("*** Maquina de Snacks ***");
        SnackServices.mostrarSnacks();//Mostrando el inventario
        while (!salir){
            try{
                int opcion = mostrarMenu(sc);
                salir = ejecutarOpciones(opcion, sc, productos);
            } catch (RuntimeException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }
    private static int mostrarMenu(Scanner sc){
        System.out.print("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar Nuevo Snack
                4. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(sc.nextLine());
    }

    private static boolean ejecutarOpciones (int opcion, Scanner sc, List<Snack> productos){
        boolean salir = false;
        switch (opcion){
            case 1 -> comprarSnack(sc, productos);
            case 2 -> mostrarTicket(productos);
        }
        return salir;
    }

    private static void comprarSnack(Scanner sc, List <Snack> productos){
        System.out.println("Qué querés comprar? Inserte el ID del producto: ");
        int idSnack = Integer.parseInt(sc.nextLine());
        boolean snackEncontrado = false;
        for (Snack Snack : SnackServices.getSnacks()){
            if (idSnack == Snack.getIdSnack()){
                productos.add(Snack);
                System.out.println("Producto Agregado con éxito. Producto: " + Snack);
                snackEncontrado = true;
                break;
            }
            if (snackEncontrado){
                System.out.println("Id de Snack no encontrado: " + idSnack);
            }
        }
    }

    private static void mostrarTicket(List<Snack> productos){
        String ticket = "*** Ticket de Venta ***";
        double total = 0.0;
        for (var producto: productos){
            ticket += "\n\t-" + producto.getSnackName() + " - $" + producto.getPrice();
            total += producto.getPrice();
        }
        ticket += "\n\tTotal -> $" + total;
        System.out.println(ticket);
    }
}