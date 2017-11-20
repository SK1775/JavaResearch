package examples;

class TwoDShape2 {
	private double width;
	private double height;
	
	void showDim() {
		System.out.println("Width and height are " + width + " and " + height);
	}
	
	double getWidth(){
		return width;
	}
	
	double getHeight(){
		return height;
	}
	
	void setWidth(double w) {
		this.width = w; //this isn't needed here as the arg name is different
	}
	
	void setHeight(double height) {
		this.height = height; // this should be used here, this references the objects "height" variable
	}
	
}

class Triangle2 extends TwoDShape2 {
	String style;
	Triangle2(String s, double w, double h){
		setWidth(w);
		setHeight(h);
		style = s;
	}
	
	double area() {
		return getWidth() * getHeight() / 2;		
	}
	
	void showStyle() {
		System.out.println("Triangle is " + style);
	}
class Rectangle2 extends TwoDShape2 {
	boolean isSquare() {
		if( getWidth() == getHeight() ) {
			return true;
		}else {
			return false;
		}
	}
	double area() {
		return getWidth() * getHeight();
	}
}
	
}
public class Example9 {
	public static void main(String[] args) {
		Triangle2 t1 = new Triangle2("filled", 4.0, 4.0);
		Triangle2 t2 = new Triangle2("outline", 12.0, 4.0);
		

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
