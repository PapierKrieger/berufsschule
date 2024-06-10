package javaKarol;

import javakarol.Roboter;
import javakarol.Welt;

public class WeltMitRoboter {
	
	private Welt welt;
	private Roboter roboter;
	
	public WeltMitRoboter(int breite, int laenge, int hoehe) {
		welt = new Welt(breite, laenge, hoehe);
		roboter = new Roboter(welt);
//		roboter.VerzoegerungSetzen(10);
	}
	                
	public WeltMitRoboter(String absoluterDateipfad) {
		welt = new Welt(absoluterDateipfad);
		roboter = new Roboter(welt);
	}
	
	public void roboterSchrittVorwärts() {
		roboter.Schritt();
	}
	
	public void roboterMarkeSetzen() {
		roboter.MarkeSetzen();
	}
	
	public void roboterZiegelAufheben() {
		roboter.Aufheben();
	}
	
	public void roboterZiegelHinlegen() {
		roboter.Hinlegen();
	}
	
	public void roboterLinksDrehen() {
		roboter.LinksDrehen();
	}
	
	public void roboterRechtsDrehen() {
		roboter.RechtsDrehen();
	}
	
	public void weltReset() {
		welt.ZurueckSetzen();
	}
	
	public void weltSpeichern(String dateiname) {
		welt.Speichern(dateiname);
	}

}
