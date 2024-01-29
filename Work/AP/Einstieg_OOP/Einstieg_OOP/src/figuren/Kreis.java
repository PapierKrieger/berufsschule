package figuren;

public class Kreis {
    int positionX, positionY, radius;
    String farbe;

    public Kreis(int positionX, int positionY, int radius, String farbe) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;
        this.farbe = farbe;
    }

    public Kreis() {
        this.positionX = 100;
        this.positionY = 100;
        this.radius = 50;
        this.farbe = "red";
    }
    public void verschieben(int xRichtung, int yRichtung){
        positionX += xRichtung;
        positionY += yRichtung;
    }
    public void vergroessern(int zusaetzlicherRadius){
        radius += zusaetzlicherRadius;
    }
    public double flaecheninhaltBerechnen(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double umfangBerechnen(){
        return 2 * Math.PI * radius;
    }
}
