package b;

public class Rectangle {
	public static void main(String[] args)
	{
		Rectangle rect1 = new Rectangle(4,40);
		System.out.println("Rectangle1:");
		System.out.println("Width:" + rect1.width);
		System.out.println("Height:" + rect1.height);
		System.out.println("Area:" + rect1.getArea());
		System.out.println("Perimeter:" + rect1.getPerimeter());
		Rectangle rect2 = new Rectangle(3.5,35.9);
		System.out.println("Rectangle2:");
		System.out.println("Width:" + rect2.width);
		System.out.println("Height:" + rect2.height);
		System.out.print("Area:");
		System.out.printf("%.3f", rect2.getArea());
		System.out.println("");
		System.out.println("Perimeter:" + rect2.getPerimeter());
	}
	
	double width, height;
	
	Rectangle()
	{  //default constructor
		width = 1;
		height = 1;
	}
	
	Rectangle(double width1, double height1)
	{ //specified width and height constructor
		width = width1;
		height = height1;
	}
	
	double getArea()
	{ //that returns the area of this rectangle
		return width * height;
	}
	
	double getPerimeter()
	{ //that returns the circumference
		return width*2 + height*2;
	}
}
