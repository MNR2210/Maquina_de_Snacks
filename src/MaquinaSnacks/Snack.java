package MaquinaSnacks;

public class Snack {
    private static int contadorSnacks;
    private final int idSnack;
    private String snackName;
    private double price;

    public Snack(String snackName, double price) {
        this.idSnack = ++Snack.contadorSnacks;
        this.snackName = snackName;
        this.price = price;
    }

    public int getIdSnack() {
        return idSnack;
    }

    public String getSnackName() {
        return snackName;
    }

    public void setSnackName(String snackName) {
        this.snackName = snackName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    Puto el que lee

    @Override
    public String toString(){
        return "Producto{" + "idProducto=" + this.idSnack + ", nombre=" + this.snackName + ", precio=" + this.price + "}";
    }
}