package perlenkette;

public class Kreis {
	private int positionX, positionY, radius;
	private String farbe;

	Kreis() {
		this(100, 100, 50, "gruen");
	}

	public Kreis(int positionX, int positionY, int radius, String farbe) {
		this.positionX = positionX;
		this.positionY = positionY;
//		this.radius = radius;
		setRadius(radius);
		this.farbe = farbe;
	}

	public void verschieben(int xRichtung, int yRichtung) {
		positionX += xRichtung;
		positionY += yRichtung;
	}

	public double umfangBerechnen() {
		return Math.PI * 2 * radius;
	}

	public double flaecheninhaltBerechnen() {
		return radius * radius * Math.PI;
	}

	public void vergroessern(int zusaetzlicherRadius) {
		radius += zusaetzlicherRadius;
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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}
}
