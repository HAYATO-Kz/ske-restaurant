package XD;

//elab-source:LabCom1.java

import java.util.Scanner;
public class LabCom1 { 
	
	 
	static boolean isPalindrome( long number){  long tenns=0;
		 if(tenns==number){return true;}
		  else{return false;}	
	}
	 public static void main(String[] args) { 
		 Scanner scan = new Scanner(System.in);
		 long ten,i=0; long tenns =0,number;
		 System.out.print("Input a number : ");  String number1 = scan.nextLine();
		  number = Integer.parseInt(number1);    int lennum = number1.length(); 
		 do{   ten= number%10; 
		        tenns= tenns*10+ten; 
		        number = number/10;   
		 			
		 }while(ten>0);    number = Integer.parseInt(number1);  number = number*10;
		 isPalindrome(number);
		  if(tenns==number){System.out.printf("%s is palindrome number.",number1);}
		  else{System.out.printf("%s is not palindrome number.",number1);}	
	 }
}
//	static int n=0,e=0,w=0,s=0,nn=0,ee=0,ww=0,ss=0,x=0,y=0;
//	static String moving1,moving2=moving1;
//	public static void main (String[] args){   
//		System.out.print("Input String command for robot: ");    String move = scan.nextLine(); 
//		int length = move.length();      
//		for(int i = 0;(length-1)>=i;i++){
//			char moving = move.charAt(i);       moving1 = Character.toString(moving);  if (i==0){moving2=moving1;}
//			if(moving1.equals(moving2)){} else{continue;} 
//			 if (moving1.equals("n")){n++;}  else if (moving1.equals("N")){nn++;}
//			else if (moving1.equals("s")){s++;}  else if (moving1.equals("S")){ss++;}
//			else if (moving1.equals("w")){w++;}  else if (moving1.equals("W")){ww++;}
//			else if (moving1.equals("e")){e++;}  else if (moving1.equals("E")){ee++;}
//			 moving2 = moving1;
//		
//		if(i==0){System.out.printf("Robot will\n");} }
//		if(n>0){System.out.printf("Move North %d unit(s),\n",n);  }
//		 if (e>0){System.out.printf("Move East %d unit(s),\n",e); }
//		 if (w>0){System.out.printf("Move West %d unit(s),\n",w); }
//		 if (s>0){System.out.printf("Move South %d unit(s),\n",s); } 
//		 if (nn>0){System.out.printf("move North %d unit(s),\n",nn);  }
//		 if (ee>0){System.out.printf("move East %d unit(s),\n",ee); }
//		 if (ww>0){System.out.printf("move West %d unit(s),\n",ww); }
//		 if (ss>0){System.out.printf("move South %d unit(s),\n",ss);
//		 }  
//		 System.out.printf("Final robot location: x = %d, y = %d.",(x=x+(w-e)),(y=y+(n-s)));	
//	}
//}