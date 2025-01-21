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
                //salir = ejecutarOpciones(opcion, sc, productos);
            } catch (RuntimeException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            finally {
                System.out.println();
            }
        }
    }
    private static int mostrarMenu(Scanner sc){
        System.out.println("""
                Menu:
                1. Comprar snack
                2. Mostrar ticket
                3. Agregar Nuevo Snack
                4. Salir
                Elige una opcion:\s""");
        return Integer.parseInt(sc.nextLine());
    }
}