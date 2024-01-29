import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class main {

    public static void main(String[] args) {
        Rechteck rechteck1 = new Rechteck();
        Kreis kreis1 = new Kreis();
        Leinwand leinwand = new Leinwand();
        leinwand.zeichne(rechteck1);
        leinwand.zeichne(kreis1);
    }
}
