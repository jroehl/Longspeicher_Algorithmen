public class arrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] r02 = new int[500];
		int[] zahlen = { 1, 2, 3 };

		for (int i = 0; i < r02.length; i++) {
			for (int a = 0; a < zahlen.length; a++) {
				r02[i] = zahlen[a];
				System.out.println(r02[i]);
			}
		}
		// System.out.println(r02[49]);
	}

}
