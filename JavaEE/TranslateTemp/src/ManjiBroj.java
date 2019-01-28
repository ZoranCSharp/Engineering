import java.util.Scanner;

public class ManjiBroj {

	public static int getMax(int a, int b) {

		return (a > b ? a : b);
	}

	public static int getMaxer(int a, int b, int c) {

		return getMax(getMax(a, b), c);
	}

	public static int getMaxest(int a, int b, int c, int d) {

		return getMax(getMaxer(a, b, c), d);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x, y, z, o;

		System.out.println("Unesite 4 broja");

		Scanner s = new Scanner(System.in);
		x = s.nextInt();
		y = s.nextInt();
		z = s.nextInt();
		o = s.nextInt();

		System.out.println("Najveci broj je: " + getMaxest(x, y, z, o));

	}

}
