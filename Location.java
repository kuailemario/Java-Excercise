package b;
import java.util.Scanner;

public class Location {
	int row, column;
	double maxValue;
	Location(){row=0;column=0;maxValue=0;}
	
	public static Location locateLargest(double[][] a)
	{
		Location loc1 = new Location();
		for(int i = 0; i < a.length; i++)
			for(int j = 0; j < a[0].length; j++)
				if(a[i][j] >= loc1.maxValue)
				{
					loc1.maxValue = a[i][j];
					loc1.row = i;
					loc1.column = j;
				}
		return loc1;
	}
	
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the number of rows and columns of the array:");
	int row1 = input.nextInt();
	int column1 = input.nextInt();
	double[][] rect1 = new double[row1][column1];
	System.out.println("Enter the array:");
	for(int i = 0; i < row1; i++)
		for(int j = 0; j < column1; j++)
			rect1[i][j] = input.nextDouble();
	Location loc1 = new Location();
	loc1 = locateLargest(rect1);
	System.out.println("The location of the largest element is "
	+ loc1.maxValue + " at (" + loc1.row + ", " + loc1.column +")");
	}
}
