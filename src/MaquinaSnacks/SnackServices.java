package MaquinaSnacks;

import java.util.ArrayList;
import java.util.List;

public class SnackServices {
    private static final List<Snack> snacks;

    static{
        snacks = new ArrayList<>();
        snacks.add(new Snack("Papa", 70.0));
        snacks.add(new Snack("Refresco", 50.0));
        snacks.add(new Snack("Sandwich", 120.0));
    }

    public static void agregarSnack(Snack snack){
        snacks.add(snack);
    }

    public static void mostrarSnacks(){
        String inventarioSnack = "";
        for (Snack snack:snacks){
            inventarioSnack += snack.toString() + "\n";
        }
        System.out.println("--- Snacks en el Inventario ---");
        System.out.println(inventarioSnack);
    }

    public static List<Snack> getSnacks(){
        return snacks;
    }
}