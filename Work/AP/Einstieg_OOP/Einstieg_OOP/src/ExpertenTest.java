import ack.shapes.Leinwand;
import figuren.Rechteck;

public class ExpertenTest {
    public static void main(String[] args) {
        Leinwand leinwand = new Leinwand();
        Rechteck rechteck = new Rechteck(100, 100, "rot", 200, 50);

        leinwand.zeichne(rechteck);
    }
}