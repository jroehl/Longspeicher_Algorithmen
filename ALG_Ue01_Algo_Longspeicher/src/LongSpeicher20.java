import java.util.Arrays; // Fuer Testausgaben

class LongSpeicher20 implements LongSpeicher {
	// ---------------------------------------------------------------------
	// Zum Ein-/Ausschalten von Testbefehlen:
	static final boolean TST1 = true;
	// ---------------------------------------------------------------------
	private long[] speicher;
	private int nfi = 0; // naechster freier Index

	// private int von;

	public LongSpeicher20(int groesse) {
		speicher = new long[groesse];
	}

	// ---------------------------------------------------------------------
	private int index(long n) {
		// Liefert den Index i, an dem n steht oder eingefuegt werden sollte.

		// Binaer gesucht wird jeweils
		// in der Teilreihung speicher[von..bis]:
		int von = 0;
		int bis = nfi - 1;
		// was ist mit der Null???????????????????????????
		while (von <= bis) {
			int mitte = von + (bis - von) / 2;
			if (n > speicher[mitte]) {
				von = mitte + 1; // rechts weitersuchen
			} else if (n < speicher[mitte]) {
				bis = mitte - 1; // links weitersuchen
			} else {
				return mitte;// n == speicher[mitte]
			}
		}
		return von; // n steht nicht im speicher
	}

	// ---------------------------------------------------------------------
	public boolean fuegeEin(long n) {
		// Fuegt n in diesen Speicher ein und liefert true.
		// Liefert false, wenn n nicht eingefuegt werden konnte.

		if (nfi == speicher.length) {
			return false;
		}

		int ind = index(n);
		// n!= 0 --> 0 darf sich selbst überschreiben...
		// if (speicher[ind] == n && n != 0) {
		// // nfi++;
		// return true;
		// }
		if (ind < nfi && speicher[ind] == n)
			return false;

		for (int i = nfi - 1; i >= ind; i--) {

			speicher[i + 1] = speicher[i];
		}
		speicher[ind] = n;
		nfi++;
		return true;
	}

	// ---------------------------------------------------------------------
	public boolean loesche(long n) {
		// Loescht ein Vorkommen von n in diesem Speicher, und liefert true.
		// Liefert false falls n nicht in diesem Speicher vorkommt.

		int ind = index(n);
		if (ind >= nfi || speicher[ind] != n) {
			return false;
		}
		for (int i = ind; i <= nfi - 1; i++) {
			if (i < nfi - 1) {
				speicher[i] = speicher[i + 1];
				speicher[i + 1] = 0;
			}
		}
		nfi--; // nach fünf mal löschen muss der nfi = 0 sein!!!

		return true;

	}

	// ---------------------------------------------------------------------
	public boolean istDrin(long n) {
		// Liefert true genau dann wenn n in diesem Speicher vorkommt.
		int index = index(n);
		if (index < nfi && speicher[index] == n) {
			return true;
		}
		return false;
	}

	// ---------------------------------------------------------------------
	// Zum Testen:
	private void print() {
		// Gibt diesen Speicher in lesbarer Form zur Standardausgabe aus:
		printf("nfi: %d, speicher: %s%n", nfi, Arrays.toString(speicher));
	}

	// ---------------------------------------------------------------------
	static public void main(String[] args) {
		printf("LongSpeicher10: Jetzt geht es los!%n");
		printf("----------------------------------%n");

		LongSpeicher20 lsa = new LongSpeicher20(5);

		lsa.print();
		System.out.println("lsa.fuegeEin(0): " + lsa.fuegeEin(0));

		lsa.print();

		System.out.println("lsa.fuegeEin(30)" + lsa.fuegeEin(30));
		lsa.print();

		System.out.println("lsa.fuegeEin(50)" + lsa.fuegeEin(50));
		lsa.print();

		System.out.println("lsa.fuegeEin(20)" + lsa.fuegeEin(20));
		lsa.print();

		System.out.println("lsa.fuegeEin(20)" + lsa.fuegeEin(20));
		lsa.print();

		System.out.println("lsa.fuegeEin(40)" + lsa.fuegeEin(40));
		lsa.print();

		System.out.println("lsa.loesche(30)" + lsa.loesche(30));
		lsa.print();

		System.out.println("lsa.loesche(10)" + lsa.loesche(10));
		lsa.print();

		System.out.println("lsa.loesche(50)" + lsa.loesche(50));
		lsa.print();

		System.out.println("lsa.loesche(50)" + lsa.loesche(50));
		lsa.print();
		System.out.println("lsa.loesche(13)" + lsa.loesche(13));
		lsa.print();

		printf("----------------------------------%n");
		printf("LongSpeicher10: Das war's erstmal!%n");
	} // main

	// ---------------------------------------------------------------------
	// Eine Methode mit einem kurzen Namen:

	static void printf(String f, Object... v) {
		System.out.printf(f, v);
	}
	// ---------------------------------------------------------------------
} // class LongSpeicher10

