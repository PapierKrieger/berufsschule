package figuren;

public class Kreis {
    private int positionX, positionY, radius;
    private String farbe;

    public Kreis(int positionX, int positionY, int radius, String farbe) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.radius = radius;
        this.farbe = farbe;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getRadius() {
        return radius;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public Kreis() {
        this.positionX = 100;
        this.positionY = 100;
        this.radius = 50;
        this.farbe = "red";
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }
    public void verschieben(int xRichtung, int yRichtung) {
        positionX = positionX + xRichtung;
        positionY = positionY + yRichtung;
    }
    public void  randomFarbe(){
        String [] farben = {"gruen", "rot", "gelb", "schwarz", "blau"};
        int zufall = (int)(Math.random()*farben.length);
        farbe = farben[zufall];
    }
    public void setRadius(int radius){
        if (radius <= 0){
            radius = Math.abs(radius);
        }
        this.radius = radius;
    }
}
