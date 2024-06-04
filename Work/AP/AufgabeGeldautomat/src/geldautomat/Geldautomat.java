package geldautomat;
public class Geldautomat {

	private Menuepunkt menuepunkt;
	private GeldautomatZustand zustand;
	private final String pin;
	private final double kontostand;
	public static final int ABHEBELIMIT = 2000;
	
	public static final String WILLKOMENSFESNTER_ANEZIGEN = "Willkommen, bitte Karte einstecken";
	public static final String MENUEAUSWAHL_ANZEIGEN = "Wählen Sie die gewünschte Funktion";
	public static final String KARTE_AUSGEBEN = "Karte wird ausgegeben";
	public static final String GELD_AUSGEBEN = "Geld wird ausgegeben";
	public static final String KARTE_EINZIEHEN = "Karte wird eingezogen";
	public static final String BETRAGEINGABE_ANZEIGEN = "Bitte Betrag eingeben";
	public static final String KONTOAUSZUG_DRUCKEN = "Kontoauszug wird gedruckt";
	public static final String FALSCHE_PIN_ANZEIGE = "Falsche PIN eingegeben";
	public static final String UNGUELTIGER_BETRAG_ANZEIGE= "Ungültiger Betrag eingegeben";
	public static final String KONTOSTAND_ANZEIGEN = "Ihr Kontostand beträgt ";
	public static final String PIN_ABFRAGE= "Bitte PIN eingeben";
	public static final String AUF_BESTAETIGUNG_WARTEN = "Bitte Betrag bestätigen";
	public static final String UNGUELTIGE_AKTION = "Ungültige Aktion in diesem Zustand";
	
	private final int auszuzahlenderBetrag;
	
	
	public Geldautomat(String pin, double kontostand) {
		this.pin = pin;
		this.kontostand = kontostand;
		auszuzahlenderBetrag = 0;
		//ToDo Teilaufgabe i)
		willkommensfensterAnzeigen();
		zustand = GeldautomatZustand.AUF_KARTE_WARTEN;
	}

	//ToDo Teilaufgabe ii)
	public void karteEinstecken() {
		if (zustand == GeldautomatZustand.AUF_KARTE_WARTEN) {
		zustand = GeldautomatZustand.AUF_MENUEAUSWAHL_WARTEN;
		menueauswahlAnzeigen();
	}
		else {
			ungueltigeAktion();
		}
	}

	//ToDo Teilaufgabe ii)
	public void abbruch() {
		if (zustand != GeldautomatZustand.AUF_KARTE_WARTEN) {
			karteAusgeben();
			zustand = GeldautomatZustand.AUF_KARTE_WARTEN;
			willkommensfensterAnzeigen();
		}
		else {
			ungueltigeAktion();
		}
	}
	
	//ToDo Teilaufgabe iii)
	public void menuePunktAuswaehlen(Menuepunkt m) {
		pinAbfrageAnzeigen();
		switch (m) {
			case ABHEBEN -> geldAusgeben();
			case KONTOAUSZUG_DRUCKEN -> kontoauszugDrucken();
			case KONTOSTAND_ANEZIGEN -> kontostandfensterAnzeigen();
		}
	}

	//ToDo Teilaufgabe iv)
	private boolean pinPruefen(String pin) {
		return false;
	}

	//ToDo Teilafugabe iv)
	public void pinEingabe(String pin) {
		
	}
	
	private void kontostandfensterAnzeigen() {
		System.out.println(KONTOSTAND_ANZEIGEN + kontostand);
	}

	private void kontoauszugDrucken() {
		if (zustand == GeldautomatZustand.AUF_KARTE_WARTEN) {
			ungueltigeAktion();
			return;
		}
		else {
			System.out.println(KONTOAUSZUG_DRUCKEN);
			karteAusgeben();
			zustand = GeldautomatZustand.AUF_KARTE_WARTEN;
			willkommensfensterAnzeigen();
		}
	}

	//ToDo Teilaufgabe v)
	public void betragEingabe(int betrag) {
	
	}
	
	private boolean betragPruefen(int betrag) {
		return betrag <= ABHEBELIMIT;
	}
	
	private void betragBestaetigenAnzeigen() {
		System.out.println(AUF_BESTAETIGUNG_WARTEN);
	}
	
	private void ungueltigeBetragEingabeAnzeigen() {
		System.out.println(UNGUELTIGER_BETRAG_ANZEIGE);
	}
	
	//ToDo Teilaufgabe v)
	public void betragBestaetigen() {
		
	}
	
	private void willkommensfensterAnzeigen() {
		System.out.println(WILLKOMENSFESNTER_ANEZIGEN);
	}
	
	private void menueauswahlAnzeigen() {
		System.out.println(MENUEAUSWAHL_ANZEIGEN);
	}
	
	private void ungueltigeAktion() {
		System.out.println(UNGUELTIGE_AKTION);
	}
	
	private void pinAbfrageAnzeigen() {
		System.out.println(PIN_ABFRAGE);
		zustand = GeldautomatZustand.AUF_PIN_WARTEN;
	}
	
	private void karteAusgeben() {
		System.out.println(KARTE_AUSGEBEN);
	}
	
	private void betrageingabefensterAnzeigen() {
		System.out.println(BETRAGEINGABE_ANZEIGEN);
	}
	
	private void eingabeFalschePIN() {
		System.out.println(FALSCHE_PIN_ANZEIGE);
	}
	
	private void geldAusgeben() {
		System.out.println(GELD_AUSGEBEN);
		System.out.println("Ausgezahlter Betrag: " + auszuzahlenderBetrag);
	}
	
	private void karteEinziehen() {
		System.out.println(KARTE_EINZIEHEN);
	}
	
	public GeldautomatZustand getZustand() {
		return zustand;
	}

}