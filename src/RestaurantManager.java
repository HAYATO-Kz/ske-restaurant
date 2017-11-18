
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
/*
 * 	This class is class for
 * 
 * 
 */
public class RestaurantManager {
private static	ArrayList<String> names = new ArrayList<>();
private	static ArrayList<Double> prices = new ArrayList<>();

	 static void setMenu(String filename) {
		ClassLoader loader = RestaurantManager.class.getClassLoader();
		InputStream in = loader.getResourceAsStream(filename);
		if (in == null) {
			System.out.println("Error reading file: " + filename);
			return;
		}
		Scanner sc = new Scanner(in);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			if (line.startsWith("#")) {
				continue;
			}
			String[] array = line.split(";");
			names.add(array[0]);
			prices.add(Double.parseDouble(array[1]));
		}
		sc.close();
	
	 }
	 
	public static String[] getMenuItem(){
		String[] namemenu =  names.toArray(new String[names.size()]);
		return namemenu;
	}
	
	public static double[] getPrices(){
		double[] pricemenu = new double[prices.size()];
		for (int x = 0; x<pricemenu.length; x++){
			pricemenu[x] = prices.get(x);
		}
		return pricemenu;
	}
	
	static void init(){
		setMenu("data/menu.txt");
	}
	
	static void recordOrder(double[]price,double total,double sum,String[]menu,ArrayList<Integer> order,double sums) {

	 FileWriter fileWriter;
	try {
		fileWriter = new FileWriter("order.txt");
	    PrintWriter w = new PrintWriter(fileWriter);
	    w.println("\t\tSKE Restaurant");
		w.println("+------ Menu --------------+-- Qty --+-- Price --+");
		for (int i = 0; i < price.length; i++) {
			if (price[i] * order.get(i) != 0) {
				w.printf("|%-8s\t\t   |\t%d    |\t%7.2f  |", menu[i], order.get(i),
						price[i] * order.get(i));
				w.println();
			}
		}
		if (sums*(100/90) >= 1000) {
			w.println("+------------------------------------+-----------+");
			w.println("|Price over 1000 Baht.\t\t\t\t |");
			w.println("|You got 10% discount.\t\t\t\t |");
		}
		w.println("+--------------------------+---------+-----------+");
		w.printf("|Total\t\t\t   |\t%.0f    |\t%7.2f  |\n", total, sum);
		w.println();
		w.print("+--------------------------+---------+-----------+");
		w.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}