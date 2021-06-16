
public class Rectangle extends Shape {
	private int length;
	private int width;
	private double area;
	
	public Rectangle() {
		this.length = 0;
		this.width = 0;
	}
	
	public Rectangle(int length , int width) {
		this.length = length;
		this.width = width;
	}
	
	
	
	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		this.area = this.length * this.width;
		return this.area;
	}

	@Override
	public String toString() {
		this.getArea();
		return "Rectangle [length=" + length + ", width=" + width + ", area=" + area + "]";
	}
	
	

	
	
	
	
}
	