import java.util.Scanner;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double tempC;
		double tempF;

		Scanner in = new Scanner(System.in);

		System.out.println("Temperatura u Celzijusu je: ");
		tempC = in.nextInt();

		tempF = tempC * 1.8 + 32;

		System.out.println("Temperatura u Farenhajt je: " + tempF);

		Scanner in2 = new Scanner(System.in);

		System.out.println("Temperatura u Farenhajt je: ");
		tempF = in2.nextInt();

		tempC = (tempF - 32) / 1.8;

		System.out.println("Temperatura u Celzijusu je: " + tempC);
	}

}
