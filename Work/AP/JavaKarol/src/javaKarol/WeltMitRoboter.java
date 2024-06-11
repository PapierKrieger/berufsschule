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

	public void roboterVorWandGehen() {
		if (roboter.IstWand()) {
			do {
				roboterLinksDrehen();
			}
			while (roboter.IstWand());
		}
		else {
			return;
		}
	}

	public void roboterBisWandGehen() {
		while (!roboter.IstWand()) {
			roboterSchrittVorwärts();
		}
	}

	public boolean roboterInStartPosition() {
		if (roboter.IstBlickNorden()) {
			roboterBisWandGehen();
			roboterLinksDrehen();
			roboterBisWandGehen();
		}
		else {
			do {
				roboterLinksDrehen();
			}
			while (!roboter.IstBlickWesten());
			roboterBisWandGehen();
			roboterRechtsDrehen();
			roboterBisWandGehen();
		}
		return false;
	}

	public void roboterReiheZiegelsteineLegen() {
		roboterBisWandGehen();
		roboterRechtsDrehen();
		roboterRechtsDrehen();
		legeZiegelsteinUnterRoboter();
		while (!roboter.IstWand()) {
			roboterZiegelHinlegen();
			roboterSchrittVorwärts();
		}
	}

	public void roboterBautBunker() {
		int weltHöhe = welt.getWeltHoehe() - 1;
		int counter = 0;
		while (counter < weltHöhe) {
		roboterBautMauerAußen();
		counter++;
		}
	}

	public void roboterIstFuckingFast(int speed) {
		roboter.VerzoegerungSetzen(speed);
		while (true) {
			roboterBisWandGehen();
			roboterLinksDrehen();
		}
	}

	private void legeZiegelsteinUnterRoboter(){
		if (!roboter.IstWand()) {
			roboterSchrittVorwärts();
		}
		else {
			roboterRechtsDrehen();
			roboterRechtsDrehen();
		}
		roboterRechtsDrehen();
		roboterRechtsDrehen();
		roboterZiegelHinlegen();
		roboterSchrittVorwärts();
		roboterRechtsDrehen();
		roboterRechtsDrehen();
	}

	private void roboterBautMauerAußen() {
		for (int counter = 0; counter < 4; counter++) {
			while (!roboter.IstWand()) {
				roboterZiegelHinlegen();
				roboterSchrittVorwärts();
			}
			roboterLinksDrehen();
		}
	}
}
