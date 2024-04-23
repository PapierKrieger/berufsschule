import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class Schwanz {
    private Rechteck shaft;
    private Kreis leftBall, rightBall;
    private Kreis  tip;

    // custom Constructor
    Schwanz (int positionX, int positionY, int girth, int length) {
        this.shaft = new Rechteck(positionX, positionY, "rot", girth, length);
        this.tip = new Kreis(positionX + girth / 2, positionY, girth / 2, "rot");
        this.leftBall = new Kreis(positionX, positionY + length, girth / 2, "rot");
        this.rightBall = new Kreis(positionX + girth,positionY +  length , girth / 2, "rot");
    }

    // default Constructor
    Schwanz () {
        this.shaft = new Rechteck(50, 50, "rot", 50, 100);
        this.tip = new Kreis(75, 50, 25, "rot");
        this.leftBall = new Kreis(50, 150, 25, "rot");
        this.rightBall = new Kreis(100, 150, 25, "rot");
    }

    public void drawDick(Leinwand leinwand) {
        leinwand.zeichne(this.shaft);
        leinwand.zeichne(this.tip);
        leinwand.zeichne(this.leftBall);
        leinwand.zeichne(this.rightBall);
    }
}
