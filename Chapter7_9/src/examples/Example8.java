package examples;

class TwoDShape {
	double width;
	double height;
	
	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
	
}

class Triangle extends TwoDShape {
	String style;
	
	double area() {
		return width * height / 2;		
	}
	
	void showStyle() {
		System.out.println("Triangle is " + style);
	}
}
class Rectangle extends TwoDShape {
	boolean isSquare() {
		if(width == height) {
			return true;
		}else {
			return false;
		}
	}
	double area() {
		return width * height;
	}
}
	

public class Example8 {
	public static void main(String[] args) {
		Triangle t1 = new Triangle();
		Triangle t2 = new Triangle();
		
		t1.width = 4.0;
		t1.height = 4.0;
		t1.style = "filled";
		
		t2.width = 8.0;
		t2.height = 12.0;
		t2.style = "outlined";	

		System.out.println("info for t1: ");
		t1.showStyle();
		t1.showDim();
		System.out.println("area is " + t1.area());
		
		System.out.println();
		
		System.out.println("info for t2: ");
		t2.showStyle();
		t2.showDim();
		System.out.println("area is " + t2.area());

	}
}
