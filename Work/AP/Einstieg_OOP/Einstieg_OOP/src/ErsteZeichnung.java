import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class ErsteZeichnung {
    public static void main(String[] args) {
        Leinwand leinwand = new Leinwand();
        Rechteck baumstamm = new Rechteck(200, 400, "braun", 100, 400);
        Kreis baumkrone = new Kreis(250, 300, 100, "gruen");
        Kreis sonne = new Kreis(500, 100, 25, "gelb");

        leinwand.zeichne(baumkrone);
        leinwand.zeichne(baumstamm);
        leinwand.zeichne(sonne);
    }
}
