import ack.shapes.Leinwand;
import figuren.Kreis;
import figuren.Rechteck;

public class Schwanz {
    private Rechteck shaft;
    private Kreis leftBall, rightBall;
    private Kreis  tip;

    // custom Constructor
    Schwanz (int positionX, int positionY, int girth, int length, String color) {
        this.shaft = new Rechteck(positionX, positionY, color, girth, length);
        this.tip = new Kreis(positionX + girth / 2, positionY + length, girth / 2, color);
        this.leftBall = new Kreis(positionX, positionY, girth / 2, color);
        this.rightBall = new Kreis(positionX + girth, positionY, girth / 2, color);
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

    public int getLength() {
        return shaft.getHoehe();
    }

    public void extendRetract(Schwanz schwanz, Leinwand leinwand) {
        int step = 5;
        int newShaftY, newShaftLength;
        boolean isErecting = true;
        while (true)
        {
            // set new length depending on extension or retraction
            if (isErecting && shaft.getHoehe() < 300) {
                shaft.setHoehe(shaft.getHoehe() + step);
            }
            else if (!isErecting && shaft.getHoehe() > 100) {
                shaft.setHoehe(shaft.getHoehe() - step);
            }

            // set flag to indicate if it should continue extending
            if (shaft.getHoehe() >= 300) {
                isErecting = false;
            }
            else if (shaft.getHoehe() <= 100) {
                isErecting = true;
            }

            // update new position of the tip
            newShaftY = shaft.getPositionY();
            newShaftLength = shaft.getHoehe();
            tip.setPositionY(newShaftY + newShaftLength);

            drawDick(leinwand);
            leinwand.warte(20);
        }
    }
}
