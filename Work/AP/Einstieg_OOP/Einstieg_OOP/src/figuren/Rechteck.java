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


    public void verschieben(int xRichtung, int yRichtung) {
        positionX = positionX + xRichtung;
        positionY = positionY + yRichtung;
    }

    public double flaecheninhaltBerechnen() {
        return breite * hoehe;
    }
    public void hoeheBreiteVertauschen(){
        int temp = breite;
        breite = hoehe;
        hoehe = temp;
    }
    public void um90GradDrehen(){
        verschieben(breite/2 - hoehe/2, -breite/2 + hoehe/2);
        hoeheBreiteVertauschen();
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        if (breite <= 0){
            breite = Math.abs(breite);
        }
        this.breite = breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        if (hoehe <= 0){
            hoehe = Math.abs(hoehe);
        }
        this.hoehe = hoehe;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double umfangBerechnen() {
        return hoehe*2 + breite*2;
    }

    public boolean istQuadrat() {
        return hoehe == breite;
    }

    public void vergroessern(int faktor) {
        breite *= faktor;
        hoehe *= faktor;
    }
}