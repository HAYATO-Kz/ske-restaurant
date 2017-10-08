package XD;

//		   String menu1; String menu2;
//		   
//		    do{System.out.println("Hi, This is my first game");
//		    System.out.print("|(S)tart|   |(O)ption|   |(Q)uit|  -> ");
//		    menu1 = scan.next();
//		    	if(menu1.equalsIgnoreCase("S"))
//		    	   {do{System.out.print("|(C)ontinue|   |(N)ew game|   |(B)ack|  -> ");
//		    	        menu2 = scan.next();}while(!menu2.equals("B"));}
//		    	if(menu1.equalsIgnoreCase("O"))
//		    	   {do{System.out.print("|(A)udio|   |(B)ack|");menu2 = scan.next();}while(!menu2.equals("B"));}
//		   }while(!menu1.equalsIgnoreCase("Q"));
//				
//		    	   
//		    	   
//		    	   }
//				}

//elab-source:LabCom1.java
import java.util.Scanner;

public class DD {
	static Scanner scan = new Scanner(System.in);
	static int howM = 0, piz = 0, ham = 0, chic = 0, fren = 0, cola = 0, spiz = 0, sham = 0, schic = 0, sfren = 0,
			scola = 0, total = 0, user = 1, i;
	static int[] qty = new int[6];
	static int[] price = new int[6];
	static String[] menus = new String[6];
	static String menu, who;

	public static void firstMenulist() {
		menus[1] = "Pizza";		price[1] = 250;
		menus[2] = "Hamburger";	price[2] = 50;
		menus[3] = "Chicken";	price[3] = 45;
		menus[4] = "Salad";		price[4] = 45;
		menus[5] = "Cola";		price[5] = 20;
	}

	public static void menu() {
		do {
			System.out.print("Enter your Choice: ");
			menu = scan.next();

			if (menu.equals("1")) {
				System.out.print("How many?: ");
				howM = scan.nextInt();
				qty[1] = howM;
				piz = howM * price[1];
				total = total + piz;
			}
			if (menu.equals("2")) {
				System.out.print("How many?: ");
				howM = scan.nextInt();
				qty[2] = howM;
				ham = howM * price[2];
				total = total + ham;
			}
			if (menu.equals("3")) {
				System.out.print("How many?: ");
				howM = scan.nextInt();
				qty[3] = howM;
				chic = howM * price[3];
				total = total + chic;
			}
			if (menu.equals("4")) {
				System.out.print("How many?: ");
				howM = scan.nextInt();
				qty[4] = howM;
				fren = howM * price[4];
				total = total + fren;
			}
			if (menu.equals("5")) {
				System.out.print("How many?: ");
				howM = scan.nextInt();
				qty[5] = howM;
				cola = howM * price[5];
				total = total + cola;
			}
			if (menu.equalsIgnoreCase("T")) {
				Total();
			}
		} while (!menu.equalsIgnoreCase("E"));
		System.out.println("");
		System.out.println("Thank you. :) ");
	}

	public static void Total() {
		int i = 1;
		System.out.printf("+-----------------------+-------+-------+\n");
		System.out.printf("|         Menu   \t|  Qty  | Price |\n");
		System.out.printf("+-----------------------+-------+-------+\n");
		if (piz > 0) {
			System.out.printf("|%d.) %s	\t| %5d | %5d |\n", i, menus[1], qty[1], piz);
			i++;
		}
		if (ham > 0) {
			System.out.printf("|%d.) %s	\t| %5d | %5d |\n", i, menus[2], qty[2], ham);
			i++;
		}
		if (chic > 0) {
			System.out.printf("|%d.) %s	\t| %5d | %5d |\n", i, menus[3], qty[3], chic);
			i++;
		}
		if (fren > 0) {
			System.out.printf("|%d.) %s	\t| %5d | %5d |\n", i, menus[4], qty[4], fren);
			i++;
		}
		if (cola > 0) {
			System.out.printf("|%d.) %s	\t| %5d | %5d |\n", i, menus[5], qty[5], cola);
			i++;
		}
		System.out.printf("+-------------------------------+-------+\n");
		System.out.printf("| Total                         | %5d |\n", total);
		System.out.printf("+-------------------------------+-------+\n");
	}

	public static void menuList() {

		System.out.printf("Welcome to SKE retaurant\n");
		System.out.printf("\n");
		System.out.printf("+-------------- MENU -----------------+\n");
		System.out.printf("|\t\t\t\t      |\n");
		System.out.printf("| 1.) %s\t\t  %5d Baht. |\n", menus[1], price[1]);
		System.out.printf("| 2.) %s\t\t  %5d Baht. |\n", menus[2], price[2]);
		System.out.printf("| 3.) %s\t\t  %5d Baht. |\n", menus[3], price[3]);
		System.out.printf("| 4.) %s\t\t  %5d Baht. |\n", menus[4], price[4]);
		System.out.printf("| 5.) %s\t\t  %5d Baht. |\n", menus[5], price[5]);
		System.out.printf("| 6.) Total\t\t              |\n");
		System.out.printf("| 7.) Exit\t\t\t      |\n");
		System.out.printf("|\t\t\t\t      |\n");
		System.out.printf("+-------------------------------------+\n");
		System.out.printf("\n");
		System.out.printf("What would you like to have?\n");
		System.out.printf("\n");
		menu();
	}

	public static void WHO() {
		System.out.println("Welcome to SKE restaurant");
		System.out.println("Plesae [c] to enter the order menu:"); // Seller can enput [imsel] to change the menulist
		who = scan.next();
		if (who.equalsIgnoreCase("c")) {
			menuList();
		} else if (who.equalsIgnoreCase("imsel")) {
			user++;
			userConect();
		}
	}

	public static Boolean user() {
		int i = 1;
		String username;
		int password;
		do {
			System.out.println("Username: "); // seller
			username = scan.next();
			System.out.println("Password: ");// 1234
			password = scan.nextInt();
			if (username.equalsIgnoreCase("Seller") && password == 1234) {
				break;
			}
			i++;
		} while (i < 3);
		if (i >= 3) {
			return false;
		} else {
			return true;
		}

	}

	public static void userConect() {
		String connect;

		if (user() == true) {
			do {
				System.out.println(" [c] to create menulist");
				System.out.println(" [p] to craet price");
				System.out.println(" [e] to exit");
				System.out.print("What do you want to do?: ");
				connect = scan.next();
				if (connect.equalsIgnoreCase("c")) {
					createMenu(menus);
				}
				if (connect.equalsIgnoreCase("p")) {
					createPrice(price);
				}
			} while (!connect.equalsIgnoreCase("e"));
		} else {
			user--;
		}
		WHO();
	}

	public static String[] createMenu(String[] menus) {
		int cre;
		do {
			System.out.print("which menu do you want to change?[1-5 or 6 to exit]: ");
			cre = scan.nextInt();
			if (cre != 6) {
				System.out.print("Enter menu:");
				String enter = scan.next();
				menus[cre] = enter;
			}
		} while (cre != 6);
		return menus;
	}

	public static int[] createPrice(int[] price) {
		int cre;
		do {
			System.out.print("which menu price do you want to change?[1-5 or 6 to exit]: ");
			cre = scan.nextInt();
			if (cre != 6) {
				System.out.print("Enter price:");
				int enter = scan.nextInt();
				price[cre] = enter;
			}
		} while (cre != 6);
		return price;
	}

	public static void main(String[] args) {
		firstMenulist();
		WHO();

	}
}