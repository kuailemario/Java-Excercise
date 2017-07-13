package b;
import java.util.Scanner;
public class StringCheck {
public static void main(String args[])
  {
	  String string1,string2;
	  @SuppressWarnings("resource")
	Scanner string=new Scanner(System.in);
	  System.out.println("input two strings,like\"aaa,sdffa\"");
	  string1=string.next();
	  string2=string.next();
	  checkString( string1,string2);
	  if(checkString( string1,string2))System.out.println("\""+string1+"\""+" is a substring of "+"\""+string2+"\"");
	  else System.out.println("\""+string1+"\""+" isn't a substring of "+"\""+string2+"\"");
	  
  }
 public static boolean checkString(String s1,String s2)
  {
	 int a;
	  a=s2.indexOf(s1,0);
	  if (a!=-1)return true;
	  else return false;
  }
}
 