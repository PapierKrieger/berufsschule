package perlenkette;

import ack.shapes.Leinwand;

public class Perlenkette {

    private Kreis[] kette;

    public Perlenkette() {
        this(10, "blau");
    }

    public Perlenkette(int laenge, String farbe) {
        if (laenge < 0) {
            laenge = 1;
        }
        kette = new Kreis[laenge];
        final int radius = 20;
        final int posY = 50;
        for (int i = 0; i < laenge; i++) {
            kette[i] = new Kreis(radius + 2 * i * radius, posY, radius, farbe);

        }
    }

    public void farbeSetzen(String farbe) {
        for (Kreis kreis : kette) {
            kreis.setFarbe(farbe);
        }
    }

    public void farbeSetzen(int index, String farbe) {
        if (index < 0 || index >= kette.length) {
            System.out.println("Ungültiger index");
        }
		else {
			kette[index].setFarbe(farbe);
		}
    }

    public void zeichne(Leinwand l) {
        for (Kreis kreis : kette) {
            l.zeichne(kreis);
        }
    }

    public int laengePerlenkette() {
        int laenge = 0;
        for (Kreis kreis : kette) {
            laenge += kreis.getRadius() * 2;
        }
        return laenge;
    }

    public int groessterPerlenRadius() {
        int maxRadius = 0;
        for (Kreis kreis : kette) {
            if (kreis.getRadius() > maxRadius) {
                maxRadius = kreis.getRadius();
            }
        }
        return maxRadius;
    }

	public void positionSetzen(int xPos, int yPos) {
		kette[0].setPositionY(yPos);
        kette[0].setPositionX(xPos);
        for (int i = 1; i <= kette.length; i++) {
            kette[i].setPositionY(yPos);
            
        }
	}
}
