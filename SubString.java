package b;

import java.util.Scanner;

public class SubString {
	 public static boolean checkString(String s1,String s2)
	 {
		 int a;
		  a = s2.indexOf(s1,0);
		  if (a!=-1)return true;
		  else return false;
	 }
	 
	 public static void main(String args[])
	 {
		 String string1,string2;
		 Scanner string = new Scanner(System.in);
		 System.out.println("Input two strings (Ex. \"bcd,acbdef\" )");
		 string1=string.next();
		 string2=string.next();
		 if(checkString( string1,string2))
			 System.out.println("True, \""+string1+"\""+" is a substring of "+"\""+string2+"\"");
		 else
			 System.out.println("False, \""+string1+"\""+" isn't a substring of "+"\""+string2+"\"");
	  
	 }
}
 