import java.util.ArrayList;
import java.util.Scanner;

/*
 * Main class for ske-restaurant application
 * It displays a menu and accept item to order,
 * When done,it prints a receipt include the 
 * order total and ask  how many you will pay 
 * and print your change 
 *  
 * @ author Hayato Kawai
 */
public class mainRestaurant {
	public static Scanner scan = new Scanner(System.in);

	private static ArrayList<Integer> order = new ArrayList<Integer>();
	static double sum = 0, sums = 0;

	/*
	 * show the menu and tell what the input does
	 */
	public static void menuList(String[] menu, double[] price) {
		System.out.println("--------- Welcome to SKE Restaurant ---------");
		for (int i = 0; i < menu.length; i++) {
			System.out.printf("%d.) %s", i + 1, menu[i]);
			System.out.printf("\t\t\t   %7.2f Baht.\n", price[i]);
		}
		System.out.println("[m] to see Menu");
		System.out.println("[p] to payment");
		System.out.println("[T] to see order");
		System.out.println("[e] to exit");
	}

	public static void setOrder(String[] menu) {
		for (int z = 0; z < menu.length; z++) {
			order.add(0);
		}
	}

	/*
	 * print the order if total >=1000 get 10% discount
	 */
	public static double order(double sum, String choice, String[] menu, double[] price) {
		double total = 0.0;
		if (choice.equalsIgnoreCase("t")) {
			System.out.println("\t\tSKE Restaurant");
			System.out.println("+------ Menu --------------+-- Qty --+-- Price --+");
			for (int i = 0; i < price.length; i++) {
				if (price[i] * order.get(i) != 0) {
					System.out.printf("|%-8s\t\t   |\t%d    |\t%7.2f  |\n", menu[i], order.get(i),
							price[i] * order.get(i));
				}
			}

			if (sum >= 1000) {
				sums = sum;
				System.out.println("+------------------------------------+-----------+");
				System.out.println("|Price over 1000 Baht.\t\t\t\t |");
				System.out.println("|You got 10% discount.\t\t\t\t |");
				sum = sum * 90 / 100;
			}
			for (int j = 0; j < menu.length; j++) {
				total = total + order.get(j);
			}
			System.out.println("+--------------------------+---------+-----------+");
			System.out.printf("|Total\t\t\t   |\t%.0f    |\t%7.2f  |\n", total, sum);
			System.out.println("+--------------------------+---------+-----------+");
			RestaurantManager.recordOrder(price, total, sum, menu, order, sums);
		}
		return sum;
	}

	/*
	 * ask how many you will pay and print your change
	 */
	public static void payMent(double lastPrice) {
		double pay;
		do {
			if (lastPrice >= 1000)
				lastPrice = lastPrice * 90 / 100;
			System.out.print("Pay(Baht): ");
			pay = scan.nextDouble();
			if (pay < lastPrice) {
				System.out.println("Not enough money.Please try again.");
			}
		} while (pay < lastPrice);
		System.out.printf("Change(Baht): %.2f\n", pay - lastPrice);
	}

	public static double price0(String choice, int quantity, double[] price) {
		double pricez = 0;
		int orders, all;
		double[] calprice = price;
		ArrayList<Integer> lastQty = new ArrayList<Integer>();
		for (int i = 0; i < calprice.length; i++) {
			lastQty.add(0);
		}
		int choicess = Integer.parseInt(choice);
		for (int j = 0; j < calprice.length; j++) {
			if (choicess == j + 1) {
				orders = order.get(j) + quantity;
				order.add(j, orders);
				order.remove(j + 1);
				all = quantity - lastQty.get(j);
				lastQty.add(j, all);
				lastQty.remove(j + 1);
				pricez = all * calprice[j];
				break;
			}
		}
		return pricez;
	}

	/*
	 * receive the order
	 */
	public static void enterOrder(String[] menu, double[] price) {
		double prices = 0;
		int quantity = 0;
		String choice;
		do {
			System.out.print("Enter your Choice: ");
			choice = scan.next();
			prices = order(sum, choice, menu, price);
			if ((!choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("t") && !choice.equalsIgnoreCase("p")
					&& !choice.equalsIgnoreCase("m")) && !choice.equalsIgnoreCase(checkInt(choice, price))) {
				System.out.println("What is that menu?!\nPlease try again.");
				continue;
			}
			if (choice.equalsIgnoreCase("m")) {
				System.out.println();
				menuList(menu, price);
				continue;

			} else if (choice.equalsIgnoreCase("e")) {
				end();
			} else if (choice.equalsIgnoreCase("p")) {
				payMent(prices);
				end();
			} else if (!choice.equalsIgnoreCase("m") && !choice.equalsIgnoreCase("p") && !choice.equalsIgnoreCase("t")
					&& !choice.equalsIgnoreCase("e")) {
				System.out.print("Enter Quantity: ");
				quantity = scan.nextInt();
			} else {
				continue;
			}
			sum = sum + price0(choice, quantity, price);
		} while (!choice.equalsIgnoreCase("E"));
	}

	public static String checkInt(String choice, double[] price) {
		String str;
		for (int ch = 1; ch <= price.length; ch++) {
			str = Integer.toString(ch);
			if (choice.equals(str)) {
				return str;
			}
		}
		return " ";
	}

	/*
	 * print before the application end
	 */
	public static void end() {
		System.out.println("========= Thank you =========================");
		System.out.println("                                             ");
		System.out.println("          /\\                    /\\         ");
		System.out.println("         /  \\                  /  \\        ");
		System.out.println("                                             ");
		System.out.println("                                             ");
		System.out.println("                                             ");
		System.out.println("  \\                                     /   ");
		System.out.println("   \\                                   /    ");
		System.out.println("    \\_________________________________/     ");
		System.exit(0);
	}

	public static void console() {
		RestaurantManager.init();
		String[] menu = RestaurantManager.getMenuItem();
		double[] price = RestaurantManager.getPrices();
		menuList(menu, price);
		setOrder(menu);
		enterOrder(menu, price);
	}

	public static void main(String[] args) {
		console();
	}

}
