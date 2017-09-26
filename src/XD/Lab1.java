package XD;

import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Input a: ");
		double a = scan.nextDouble();
		System.out.print("Input b: ");
		double b = scan.nextDouble();
		System.out.print("Input c: ");
		double c = scan.nextDouble();
		double d = Math.sqrt((a * a) + (b * b) + (c * c));
		double f = a / d;
		double g = b / d;
		double h = c / d;
		System.out.printf("Unit vector of (%3.2fi, %3.2fj, %3.2fk) = (%3.2fi, %3.2fj, %3.2fk)", a, b, c, f, g, h);
		//
		// System.out.println(d);
		//
	}
}

// Scanner scan = new Scanner(System.in);
// char mn = scan.next