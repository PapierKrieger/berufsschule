package test;

import geldautomat.Geldautomat;
import geldautomat.GeldautomatZustand;
import geldautomat.Menuepunkt;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.MethodName.class)
class GeldautomatTest {
	
	private Geldautomat automat;
	private static final String PIN = "1234";
	private static int kontostand = 500;
	
	private final PrintStream originalOut = System.out;
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUp() {
		System.setOut(new PrintStream(outContent));
		automat = new Geldautomat(PIN, kontostand);
	}

	@Test
	@DisplayName(value = "Aufgabe i: Startzustand")
	void test_Aufgabe_1() {
		assertTrue(outContent.toString().contains(Geldautomat.WILLKOMENSFESNTER_ANEZIGEN));
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, automat.getZustand());
	}
	
	@Test
	@DisplayName(value = "Aufgabe ii: Zustandswechsel bei Karteneingabe")
	void test_Aufgabe_2_1() {
		automat.karteEinstecken();
		GeldautomatZustand aktuell = automat.getZustand();
		assertEquals(GeldautomatZustand.AUF_MENUEAUSWAHL_WARTEN, aktuell);
		assertTrue(outContent.toString().contains(Geldautomat.MENUEAUSWAHL_ANZEIGEN));
	}
	
	@Test
	@DisplayName(value = "Aufgabe ii: Zustandswechsel nach Abbruch")
	void test_Aufgabe_2_2() {
		automat.karteEinstecken();
		automat.abbruch();
		GeldautomatZustand aktuell = automat.getZustand();
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, aktuell);
		assertTrue(outContent.toString().contains(Geldautomat.KARTE_AUSGEBEN));
	}
	
	@Test
	@DisplayName(value = "Abbruch im Startzustand ungültig")
	void test_Aufgabe_2_3() {
		automat.abbruch();
		assertTrue(outContent.toString().contains(Geldautomat.UNGUELTIGE_AKTION));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iii: Zustandswechsel nach Auswahl eines Menüpunktes")
	void test_Aufgabe_3_1() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		assertEquals(GeldautomatZustand.AUF_PIN_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.PIN_ABFRAGE));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iii: Ungültige Aktion falls keine Karte eingesteckt wurde")
	void test_Aufgabe_3_2() {
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOAUSZUG_DRUCKEN);
		assertTrue(outContent.toString().contains(Geldautomat.UNGUELTIGE_AKTION));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iii: Ungültiger Menüpunkt führt zu ungültiger Aktion")
	void test_Aufgabe_3_3() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(null);
		assertTrue(outContent.toString().contains(Geldautomat.UNGUELTIGE_AKTION));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iv: Ungültige PIN führt zum Zustand wieder auf PIN warten")
	void test_Aufgabe_4_1() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe("");
		assertEquals(GeldautomatZustand.WIEDER_AUF_PIN_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.FALSCHE_PIN_ANZEIGE));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iv: Gültige PIN führt zum ausgewählten Menüpunkt Abheben")
	void test_Aufgabe_4_2() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe(PIN);
		assertEquals(GeldautomatZustand.AUF_BETRAG_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.BETRAGEINGABE_ANZEIGEN));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iv: Gültige PIN führt zum ausgewählten Menüpunkt Kontostandanzeige")
	void test_Aufgabe_4_3() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOSTAND_ANEZIGEN);
		automat.pinEingabe(PIN);
		assertEquals(GeldautomatZustand.AUF_AKTION_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.KONTOSTAND_ANZEIGEN));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iv: Nach Kontostandanzeige kann Kontoauszug drucken gewählt werden")
	void test_Aufgabe_4_4() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOSTAND_ANEZIGEN);
		automat.pinEingabe(PIN);
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOAUSZUG_DRUCKEN);
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.KARTE_AUSGEBEN));
		assertTrue(outContent.toString().contains(Geldautomat.KONTOAUSZUG_DRUCKEN));
	}
	
	@Test
	@DisplayName(value = "Aufgabe iv: Nach erfolgreicher PIN Eingabe kann der Kontoauszug gedruckt werden")
	void test_Aufgabe_4_5() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOAUSZUG_DRUCKEN);
		automat.pinEingabe(PIN);
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.KONTOAUSZUG_DRUCKEN));
		assertTrue(outContent.toString().contains(Geldautomat.KARTE_AUSGEBEN));
	}
	
	@Test
	@DisplayName(value = "Aufgabe v: Nach Bestätigung einer gültigen Betrageingabe wird das Geld und die Karte ausgegeben")
	void test_Aufgabe_5_1() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe(PIN);
		automat.betragEingabe(200);
		automat.betragBestaetigen();
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.AUF_BESTAETIGUNG_WARTEN));
		assertTrue(outContent.toString().contains(Geldautomat.GELD_AUSGEBEN));
		assertTrue(outContent.toString().contains(Geldautomat.KARTE_AUSGEBEN));
	}

	@Test
	@DisplayName(value = "Aufgabe v: Nach einer ungültigen Betragseingabe wird dies angezeigt")
	void test_Aufgabe_5_2() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe(PIN);
		automat.betragEingabe(Geldautomat.ABHEBELIMIT + 1);
		assertEquals(GeldautomatZustand.AUF_BETRAG_WARTEN, automat.getZustand());
		assertTrue(outContent.toString().contains(Geldautomat.UNGUELTIGER_BETRAG_ANZEIGE));
	}
	
	@Test
	@DisplayName(value = "Anfangszustand nach zu häufiger falscher Pineingabe")
	void test_4() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe("12");
		assertTrue(outContent.toString().contains(Geldautomat.FALSCHE_PIN_ANZEIGE));
		automat.pinEingabe("34");
		GeldautomatZustand aktuell = automat.getZustand();
		assertEquals(GeldautomatZustand.AUF_KARTE_WARTEN, aktuell);
		assertTrue(outContent.toString().contains(Geldautomat.KARTE_EINZIEHEN));
	}
	
	@Test
	@DisplayName(value = "Nach erfolgreichem Abheben ist der Kontostand aktualisiert")
	void test_Aufgabe_5_3() {
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.ABHEBEN);
		automat.pinEingabe(PIN);
		final int betrag = 100;
		automat.betragEingabe(betrag);
		automat.betragBestaetigen();
		
		automat.karteEinstecken();
		automat.menuePunktAuswaehlen(Menuepunkt.KONTOSTAND_ANEZIGEN);
		automat.pinEingabe(PIN);
		final int neuerKontostand = kontostand - betrag;
		assertTrue(outContent.toString().contains(neuerKontostand + ""));
	}
	
	
	@AfterEach
	public void cleanUp() {
		System.setOut(originalOut);
		automat = null;
	}

}
