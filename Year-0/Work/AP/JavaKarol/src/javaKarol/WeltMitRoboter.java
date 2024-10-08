package javaKarol;

import javakarol.Roboter;
import javakarol.Welt;

public class WeltMitRoboter {
	
	private Welt welt;
	private Roboter roboter;
	
	public WeltMitRoboter(int breite, int laenge, int hoehe) {
		welt = new Welt(breite, laenge, hoehe);
		roboter = new Roboter(welt);
		//roboter.VerzoegerungSetzen(0);
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

	public void roboterDurchSumpfLaufen() {
		while (true) {
			if (roboter.IstZiegel()) {
				roboterSchrittVorwärts();
			}
			else if (roboter.IstZiegelRechts()) {
				roboterRechtsDrehen();
			}
			else if (roboter.IstZiegelLinks()) {
				roboterLinksDrehen();
			}
			else {
				roboterLinksDrehen();
			}
		}
	}

	public void roboterZiegelReiheLegen() {
		roboterBisWandGehen();
		roboterRechtsDrehen();
		roboterRechtsDrehen();
		legeZiegelsteinUnterRoboter();
		while (!roboter.IstWand()) {
			roboterZiegelHinlegen();
			roboterSchrittVorwärts();
		}
	}

	public void roboterZiegelReiheLegen(int anzahl) {

	}

	public void roboterBautBunker() {
		int weltHöhe = welt.getWeltHoehe() - 1;
		int counter = 0;
		while (counter < weltHöhe) {
		roboterBautMauerAußen();
		counter++;
		}
	}

	public void roboterBautBunkerAb() {
		int weltHöhe = welt.getWeltHoehe() - 1;
		int counter = weltHöhe;
		while (counter >= 1) {
			roboterBautMauerAußenAb();
			counter--;
		}
	}

	public void roboterIstFuckingFast(int speed) {
		roboter.VerzoegerungSetzen(speed);
		while (true) {
			roboterBisWandGehen();
			roboterLinksDrehen();
		}
	}

	public void roboterHoltZeitung() {
		while (!roboter.IstBlickSueden()) {
			roboterLinksDrehen();
		}
		while (!roboter.IstMarke() && !roboter.IstZiegel()) {
			roboterSchrittVorwärts();
		}
		if (roboter.IstZiegel()){
			roboterLinksDrehen();
		}
		while (roboter.IstZiegelRechts()) {
			if (roboter.IstZiegel()){
				roboterLinksDrehen();
			}
			roboterSchrittVorwärts();
		}
		if (!roboter.IstZiegelRechts()){
			roboterRechtsDrehen();
		}
		while (!roboter.IstMarke()){
			roboterSchrittVorwärts();
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

	public void roboterBautMauerAußen() {
		for (int counter = 0; counter < 4; counter++) {
			while (!roboter.IstWand()) {
				roboterZiegelHinlegen();
				roboterSchrittVorwärts();
			}
			roboterLinksDrehen();
		}
	}

	public void roboterBautMauerAußenAb() {
		for (int counter = 0; counter < 4; counter++) {
			while (!roboter.IstWand()) {
				roboterZiegelAufheben();
				roboterSchrittVorwärts();
			}
			roboterLinksDrehen();
		}
	}

	public void roboterPflastertBoden() {
		// todo: increase efficiency: switch-case IstZiegel() and within the other conditions
		while (true){
			if (roboter.IstWand()) {
				roboterLinksDrehen();
			}
			else if (!roboter.IstZiegel() && !roboter.IstWand()) {
				roboterZiegelHinlegen();
				roboter.Schritt();
			}
			else if (roboter.IstZiegelRechts() && roboter.IstZiegelLinks() && roboter.IstZiegel()) {
				roboter.Schritt();
			}
			else if (roboter.IstZiegel()) {
				if (roboter.IstZiegel() && roboter.IstZiegelLinks() || roboter.IstZiegelLinks()) {
					roboterLinksDrehen();
					roboter.Schritt();
				}
				else {
					roboterLinksDrehen();
				}
			}
		}
	}

	public void schatzsuche(){
		while (true) {
			if (roboter.IstMarke()) {
				while (true){
					roboterLinksDrehen();
				}
			}
				if (!roboter.IstZiegelRechts()) {
					roboterRechtsDrehen();
					roboter.Schritt();
			} else if (!roboter.IstZiegel()) {
				roboter.Schritt();
			} else {
				roboterLinksDrehen();
			}
		}
	}
}
