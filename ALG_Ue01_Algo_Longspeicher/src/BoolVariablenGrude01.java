public class BoolVariablenGrude01 {

	public static void main(String[] args) {
		int[] r03 = { 100, 200, 300 };
		int[] r04 = { 100, 200, 300 };
		int[] r05 = r04;

		boolean b01 = r03 == r04; // das Ergebnis des Referenz-Vergleichs wird
									// der boolschen Var zugewiesen
		System.out.println(b01);
		boolean b02 = r03.equals(r04);
		System.out.println(b02);
		boolean b03 = r04 == r05;
		System.out.println(b03);
		boolean b04 = r04.equals(r05);
		System.out.println(b04);

	}

}
