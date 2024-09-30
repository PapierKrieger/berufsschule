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

    public void farbeSetzen(String farbe){
        for (Kreis kreis : kette) {
            kreis.setFarbe(farbe);
        }
    }

    public void farbeSetzen(String... muster){
        int counter = 0;

        for (int i = 0; counter < kette.length; i++) {
            //kette[i].setFarbe(muster[i % muster.length]);
           if (i >= muster.length){
               i = 0;
           }
           kette[counter].setFarbe(muster[i]);
           counter++;
        }
    }

    public void farbeSetzen(int index, String farbe){
        if (index < 0 || index >= kette.length) {
            System.out.println("Ungültiger index");
        }
		else {
			kette[index].setFarbe(farbe);
		}
    }

    public void zeichne(Leinwand l){
        for (Kreis kreis : kette) {
            l.zeichne(kreis);
        }
    }

    public int laengePerlenkette(){
        int laenge = 0;
        for (Kreis kreis : kette) {
            laenge += kreis.getRadius() * 2;
        }
        return laenge;
    }

    public int groessterPerlenRadius(){
        int maxRadius = 0;
        for (Kreis kreis : kette) {
            if (kreis.getRadius() > maxRadius) {
                maxRadius = kreis.getRadius();
            }
        }
        return maxRadius;
    }

    public void positionSetzen(int xPos, int yPos){
        kette[0].setPositionX(xPos);
        kette[0].setPositionY(yPos);
        for (int i = 1; i < kette.length; i++) {
            int prevXPos = kette[i - 1].getPositionX();
            int prevRadius = kette[i - 1].getRadius();
            int currRadius = kette[i].getRadius();
            kette[i].setPositionX(prevXPos + prevRadius + currRadius);
            kette[i].setPositionY(yPos);
        }
    }

    public void radiusSetzen(int index, int neuerRadius){
        if (index < 0 || index >= kette.length || neuerRadius <= 0) {
            System.out.println("Falscher Wert!");
            return;
        }

        kette[index].setRadius(neuerRadius);

        if (index == 0) {
            positionSetzen(kette[0].getPositionX(), kette[0].getPositionY());
        } else {
            int prevXPos = kette[index - 1].getPositionX();
            int prevRadius = kette[index - 1].getRadius();
            kette[index].setPositionX(prevXPos + prevRadius + neuerRadius);
            for (int i = index + 1; i < kette.length; i++) {
                prevXPos = kette[i - 1].getPositionX();
                prevRadius = kette[i - 1].getRadius();
                int currRadius = kette[i].getRadius();
                kette[i].setPositionX(prevXPos + prevRadius + currRadius);
            }
        }
    }

    public void perlenTauschen(int index1, int index2){
        Kreis temp = kette[index1];
        kette[index1] = kette[index2];
        kette[index2] = temp;
        positionSetzen(kette[0].getPositionX(), kette[0].getPositionY());
    }

    public void spiegeln(){
        int j = kette.length - 1;
        for (int i = 0; i <= kette.length; i++){
            perlenTauschen(i, j);
            j = j - 1;
            if (kette.length / 2 == j){
                return;
            }
        }
    }
}
