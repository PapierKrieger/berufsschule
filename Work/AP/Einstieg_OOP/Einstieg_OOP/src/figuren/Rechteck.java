package figuren;

public class Rechteck {
    int positionX, positionY, breite, hoehe;
    String farbe;

    public Rechteck() {
        positionX = 200;
        positionY = 150;
        farbe = "rot";
        breite = 300;
        hoehe = 100;
    }

    public Rechteck(int positionX, int positionY, String farbe, int breite, int hoehe) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.farbe = farbe;
        this.breite = breite;
        this.hoehe = hoehe;
    }
    public void verschieben(int xRichtung, int yRichtung){
        positionX += xRichtung;
        positionY += yRichtung;
    }
    public double flaecheninhaltBerechnen(){
        return breite * hoehe;
    }
    public void vergroessern(int faktor){
        hoehe = hoehe * faktor;
        breite = breite * faktor;
    }
    public double umfangBerechnen(){
        return breite * 2 + hoehe * 2;
    }
    public boolean istQuadrat(){
        return hoehe == breite;    //möglich, da "breite == hoehe" einen bool zurückgibt
    }
    public void hoeheBreiteVertauschen(){
        int tempHoehe = hoehe;
        hoehe = breite; breite = tempHoehe;
    }
}
