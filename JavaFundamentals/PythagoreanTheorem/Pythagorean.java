import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
	double A = legA*legA;
     double B = legB*legB;
     double sum = A+B;
	double squareRoot = Math.sqrt(sum);
        
       return squareRoot;
}
}