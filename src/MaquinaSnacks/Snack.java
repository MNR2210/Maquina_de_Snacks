package MaquinaSnacks;
import java.io.Serializable;
import java.util.Objects;

public class Snack implements Serializable {
    private static int contadorSnacks;
    private final int idSnack;
    private String snackName;
    private double price;

    public Snack(){
        this.idSnack = ++Snack.contadorSnacks;
    }

    public Snack(String snackName, double price) {
        this();
        this.snackName = snackName;
        this.price = price;
    }

    public static int getContadorSnacks() {
        return contadorSnacks;
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

    @Override
    public String toString() {
        return "Snack{" +
                "idSnack=" + idSnack +
                ", snackName='" + snackName + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snack snack = (Snack) o;
        return idSnack == snack.idSnack && Double.compare(price, snack.price) == 0 && Objects.equals(snackName, snack.snackName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSnack, snackName, price);
    }
}