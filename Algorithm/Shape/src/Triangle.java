
public class Triangle extends Shape {
private int base=0;
private int height=0;
private double area=0;



public Triangle() {
	
}

public Triangle(int base, int height) {
	this.base = base;
	this.height = height;
}



public int getBase() {
	return base;
}

public void setBase(int base) {
	this.base = base;
}

public int getHeight() {
	return height;
}

public void setHeight(int height) {
	this.height = height;
}

@Override
public double getArea() {
	// TODO Auto-generated method stub
	this.area=0.5*this.base*this.height;
	return this.area;
}
@Override
public String toString() {
	this.getArea();
	return "Triangle [base=" + base + ", height=" + height + ", area=" + area + "]";
}


}
