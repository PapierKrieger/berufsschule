package perlenkette;

import ack.shapes.Leinwand;

public class Main {

	public static void main(String[] args) {
		Perlenkette p = new Perlenkette();
		Leinwand l = new Leinwand();
		p.zeichne(l);
		p.farbeSetzen("gelb");
		p.zeichne(l);
	}

}
