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
		if (index > kette.length - 1) {
			System.out.println("Ungültiger index");
		}
		kette[index].setFarbe(farbe);
	}

	public void zeichne(Leinwand l) {
		for (Kreis kreis : kette) {
			l.zeichne(kreis);
		}
	}
}
