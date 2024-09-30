package perlenkette;

import ack.shapes.Leinwand;

public class Main {

	public static void main(String[] args) {
		Perlenkette p = new Perlenkette();
		Leinwand l = new Leinwand();
		p.zeichne(l);
		l.warte(1000);

		p.farbeSetzen("rot", "orange", "blau");
		p.zeichne(l);
		l.warte(1000);

		p.spiegeln();
		p.zeichne(l);
		l.warte(1000);
	}

}
