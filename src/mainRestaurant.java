import java.util.ArrayList;
import java.util.Scanner;

public class mainRestaurant {
	public static Scanner scan = new Scanner(System.in);

	public static ArrayList<Integer> order = new ArrayList<Integer>();
	static double sum = 0;

	public static void menuList() {
		String[] menu = RestaurantManager.getMenuItem();
		double[] price = RestaurantManager.getPrices();
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

	public static void setOrder() {
		for (int z = 0; z < RestaurantManager.getMenuItem().length; z++) {
			order.add(0);
		}
	}

	public static double Order(double sum, String choice) {
		String[] menu = RestaurantManager.getMenuItem();
		double[] price = RestaurantManager.getPrices();
		Double total = 0.0;
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
		}
		return sum;
	}

	public static void payMent(double lastPrice) {
		double getMoney;
		do {
			if (lastPrice >= 1000)
				lastPrice = lastPrice * 90 / 100;
			System.out.print("Pay(Baht): ");
			getMoney = scan.nextDouble();
			if (getMoney < lastPrice) {
				System.out.println("Not enough money.Please try again.");
			}
		} while (getMoney < lastPrice);
		System.out.printf("Change(Baht): %.2f\n", getMoney - lastPrice);
	}

	public static double price(String choice, int quantity) {
		double price = 0;
		int orders, all;
		double[] calprice = RestaurantManager.getPrices();
		ArrayList<Integer> lastQty = new ArrayList<Integer>();
		for (int i = 0; i < calprice.length; i++) {
			lastQty.add(0);
		}
		int choice2 = Integer.parseInt(choice);
		for (int j = 0; j < calprice.length; j++) {
			if (choice2 == j + 1) {
				orders = order.get(j) + quantity;
				order.add(j, orders);
				order.remove(j + 1);
				all = quantity - lastQty.get(j);
				lastQty.add(j, all);
				lastQty.remove(j + 1);
				price = all * calprice[j];
				break;
			}
		}
		return price;
	}

	public static String checkInt(String choice) {
		String str;
		for (int ch = 1; ch <= RestaurantManager.getPrices().length; ch++) {
			str = Integer.toString(ch);
			if (choice.equals(str)) {
				return str;
			}
		}
		return " ";
	}

	public static void Order() {
		double realPrice = 0;
		int quantity = 0;
		String choice;
		do {
			System.out.print("Enter your Choice: ");
			choice = scan.next();
			realPrice = Order(sum, choice);
			if ((!choice.equalsIgnoreCase("e") && !choice.equalsIgnoreCase("t") && !choice.equalsIgnoreCase("p")
					&& !choice.equalsIgnoreCase("m")) && !choice.equals(checkInt(choice))) {
				System.out.println("What is that menu?!\nPlease try again.");
				continue;
			}
			if (choice.equalsIgnoreCase("m")) {
				System.out.println();
				menuList();

			} else if (choice.equalsIgnoreCase("e")) {
				end();
			} else if (choice.equalsIgnoreCase("p")) {
				payMent(realPrice);
				end();
			} else if (!choice.equalsIgnoreCase("E") && !choice.equalsIgnoreCase("T") && !choice.equalsIgnoreCase("P")
					&& !choice.equalsIgnoreCase("M")) {
				System.out.print("Enter Quantity: ");
				quantity = scan.nextInt();
			} else {
				continue;
			}
			sum = sum + price(choice, quantity);
		} while (!choice.equalsIgnoreCase("E"));
	}

	public static void console() {
		RestaurantManager.init();
		menuList();
		setOrder();
		Order();
	}

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

	public static void main(String[] args) {
		console();
	}

}
