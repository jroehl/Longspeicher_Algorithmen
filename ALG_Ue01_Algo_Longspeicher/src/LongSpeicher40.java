class LongSpeicher40 implements LongSpeicher {
	// ---------------------------------------------------------------------
	// Zum Ein-/Ausschalten von Testbefehlen:
	static final boolean TST1 = true;

	// ---------------------------------------------------------------------
	// Eine (statische) geschachtelte Klasse (nested static class).
	// Jedes Objekt dieser Klasse kann als Knoten einer einfach
	// verketteten Liste verwendet werden:
	static protected class Knoten {
		Knoten next;
		long data;

		Knoten(Knoten next, long data) { // Konstruktor
			this.next = next;
			this.data = data;
		}
	}

	// ---------------------------------------------------------------------
	// Eine leere Liste besteht aus 2 Dummy-Knoten:
	// einem End-Dummy-Knoten EDK und einem Anfangs-Dummy-Knoten ADK. Die
	// "richtigen Knoten" werden spaeter zwischen die 2 Dummies gehaengt.
	final Knoten EDK = new Knoten(null, 0); // End-Dummy-Knoten
	final Knoten ADK = new Knoten(EDK, 0); // Anfangs-Dummy-Knoten

	// ---------------------------------------------------------------------
	private Knoten vorgaenger(long n) {
		EDK.data = n;
		Knoten hier = ADK;

		while (hier.next.data != n && n > hier.next.data) { // n muss kleiner
															// sein als data im
															// nächsten feld
			hier = hier.next;
		}
		return hier;
		// Liefert den Vorgaenger eines Knotens, der n enthaelt, oder
		// den Vorgaenger des EDK (falls n in dieser Liste nicht vorkommt).
		// ...
	}

	@Override
	public boolean fuegeEin(long n) { // statt am Anfang bei EDK (edeka HAHAHA)
		Knoten vorg = vorgaenger(n);
		vorg.next = new Knoten(vorg.next, n);
		return true;
	}

	@Override
	public boolean loesche(long n) {
		Knoten start = vorgaenger(n);
		if (start.next != EDK) {
			start.next = start.next.next;
			return true;
		}
		return false;
	}

	@Override
	public boolean istDrin(long n) {
		// return (vorgaenger(n).next != EDK);
		while (vorgaenger(n).next != EDK) {

			if (vorgaenger(n).next.data == n) {
				return true;
			}
			vorgaenger(n).next = vorgaenger(n).next.next;
		}
		return false;
	}

	// ist das selbe wie:
	// if (vorgaenger(n).next != EDK){
	// return true;
	// }
	// return false;.. jedoch ohne if-Anweisung!!!!

	static public void main(String[] args) {
		// Main Methode fügt versch Werte
		// ein und lässt sich dann Vorgaenger von Werten ausgeben

		LongSpeicher40 lo40 = new LongSpeicher40();
		lo40.fuegeEin(12);
		lo40.fuegeEin(55);
		lo40.fuegeEin(8);
		lo40.fuegeEin(123);
		lo40.fuegeEin(0);
		System.out
				.println("lo40.vorgaenger(200): " + lo40.vorgaenger(200).data);
		System.out
				.println("lo40.vorgaenger(123): " + lo40.vorgaenger(123).data);
		System.out.println("lo40.vorgaenger(55): " + lo40.vorgaenger(55).data);
		System.out.println("lo40.vorgaenger(12): " + lo40.vorgaenger(12).data);
		System.out.println("lo40.vorgaenger(8): " + lo40.vorgaenger(8).data);
		System.out.println("lo40.vorgaenger(0): " + lo40.vorgaenger(0).data);
		System.out.println(" ");
		System.out.println("lo40.istDrin(30)" + lo40.istDrin(30));
		System.out.println("lo40.fuegeEin(30)" + lo40.fuegeEin(30));
		System.out.println("lo40.istDrin(30)" + lo40.istDrin(30));
		System.out.println("lo40.loesche(30)" + lo40.loesche(30));
		System.out.println("lo40.istDrin(30)" + lo40.istDrin(30));
		System.out.println(" ");
		System.out.println("lo40.istDrin(50)" + lo40.istDrin(50));
		System.out.println("lo40.fuegeEin(50)" + lo40.fuegeEin(50));
		System.out.println("lo40.istDrin(50)" + lo40.istDrin(50));
		System.out.println("lo40.loesche(50)" + lo40.loesche(50));
		System.out.println("lo40.loesche(50)" + lo40.loesche(50));
		System.out.println("lo40.istDrin(50)" + lo40.istDrin(50));

	}

}