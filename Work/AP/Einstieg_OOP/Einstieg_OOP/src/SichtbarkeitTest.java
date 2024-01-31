import ack.shapes.Leinwand;
import figuren.Kreis;

public class SichtbarkeitTest {
    public static void main(String[] args) {
        Kreis k = new Kreis();
        Leinwand leinwand = new Leinwand();

        leinwand.zeichne(k);
    }
}
