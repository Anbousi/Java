import java.util.ArrayList;

// Print numbers from 1 to 255
public class BasicJava {
    public ArrayList<Integer> print1To255() {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i = 0 ; i<256 ; i++){
            myArray.add(i);
        }
        return myArray;
}

// Print Odd numbers from 1 to 255
public ArrayList<Integer> printOdd() {
    ArrayList<Integer> myArray = new ArrayList<Integer>();
    for (int i = 0 ; i<256 ; i++){
        if (i%2 == 1){
            myArray.add(i);
        }
    }
    return myArray;
}

}