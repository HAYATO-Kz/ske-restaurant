package XD;



		
			

import java.util.Random;

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
	    
		static Scanner scan = new Scanner (System.in);	
		public static void main (String[] args){ 
		Random rand = new Random(); String bb;
	do{	int n = rand.nextInt(100)+100;
		 System.out.println(n); 
		  bb = scan.next();
	  }
	while (!bb.equals("b"));
	  
		}
}