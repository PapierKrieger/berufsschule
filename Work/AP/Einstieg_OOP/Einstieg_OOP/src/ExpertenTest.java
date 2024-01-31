import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class ExpertenTest {
    public static void main(String[] args) {
        Leinwand leinwand = new Leinwand();
        Kreis kreis = new Kreis(100, 100, 50, "blau");
        int velocityX = 10;
        int velocityY = 15;

        while (true){
            if (leinwand.getLeinwandBreite() <= kreis.getPositionX()+kreis.getRadius() || kreis.getPositionX() - kreis.getRadius() <= 0){
                velocityX *= -1;
                kreis.randomFarbe();
            }
            if (leinwand.getLeinwandHoehe() <= kreis.getPositionY()+kreis.getRadius() || kreis.getPositionY() - kreis.getRadius() <= 0){
                velocityY *= -1;
                kreis.randomFarbe();
            }
            kreis.verschieben(velocityX, velocityY);
            leinwand.zeichne(kreis);
            leinwand.warte(30);
        }
    }
}
