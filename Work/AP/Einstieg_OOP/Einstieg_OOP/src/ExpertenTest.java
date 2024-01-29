import ack.shapes.Leinwand;
import figuren.Rechteck;

public class ExpertenTest {
    public static void main(String[] args) {
        Leinwand leinwand = new Leinwand();
        Rechteck rechteck = new Rechteck(100, 100, "rot", 200, 50);

        while (true) {
            leinwand.zeichne(rechteck);
            leinwand.warte(500);
            rechteck.um90GradDrehen();
            leinwand.zeichne(rechteck);
        }
    }
}
