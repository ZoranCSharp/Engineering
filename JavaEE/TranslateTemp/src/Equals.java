import java.util.Scanner;

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String proizvod;

		System.out.println("Unesite proizvod: ");

		Scanner s = new Scanner(System.in);
		proizvod = s.nextLine();
		proizvod = proizvod.toUpperCase();

		proizvod = proizvod.trim();

		if (proizvod.equals("KAFA") || proizvod.equals("JAFA") || proizvod.equals("PESAK")) {

			System.out.println("Imamo taj proizvod");

		} else {
			System.out.println("Nemamo taj proizvod");
		}

	}

}
