import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class Ampel {
    private Rechteck gehaeuse;
    private Kreis gruenerKreis, gelberKreis, roterKreis;

    Ampel (int positionX, int positionY, int breite) {
        int radius = breite / 2;

        this.gehaeuse = new Rechteck(positionX, positionY, "schwarz", breite, breite * 3);

        this.gelberKreis = new Kreis(breite + (breite / 2), positionY + radius * 3, radius, "gelb");

        this.roterKreis = new Kreis(breite + (breite / 2), positionY + radius, radius, "rot");

        this.gruenerKreis = new Kreis(breite + (breite / 2), positionY + radius * 5, radius, "gruen");
    }

    public void zeichne(Leinwand leinwand) {
        leinwand.zeichne(this.gehaeuse);
        leinwand.zeichne(this.gelberKreis);
        leinwand.zeichne(this.roterKreis);
        leinwand.zeichne(this.gruenerKreis);
    }
}