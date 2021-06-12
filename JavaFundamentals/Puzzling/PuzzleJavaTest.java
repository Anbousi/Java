import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;


public class PuzzleJavaTest{
    public static void main(String[] args) {
        PuzzleJava Arr = new PuzzleJava();
        int[] X = {1,2,7,11,13};
        System.out.println("Original Array = " + Arrays.toString(X)+"\n");

        // Print the sum of all numbers in the array.
        int Y = Arr.getSum(X);
        System.out.println("Sum of array elements = " + Y);
        ArrayList<Integer> K = new ArrayList<Integer>();
        K = Arr.getGreater10(X);
        System.out.println("Elements greater than 10 = " + K+"\n");

        String[] names = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        System.out.println("Original names = " +Arrays.toString(names)+"\n");

        //  Shuffle names
        String[] newNames = Arr.shuffleArray(names);
        System.out.println("Shuffled names = " +Arrays.toString(newNames)+"\n");
        // names longer than 5 Chars
        ArrayList<String> longNames = new ArrayList<String>();
        longNames = Arr.getLongNames(names);
        System.out.println("Names longer than 5 chars = " +longNames+"\n");

        String[] letter = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        List<String> letters = Arrays.asList(letter);
        Collections.shuffle(letters);
        System.out.println("letters = " + letters+"\n");
        String lastChar = Arr.getLastChar(letters);
        System.out.println("Last Charachter is: " + lastChar+"\n");
        String firstChar = Arr.getFirstChar(letters);
        if(firstChar == "a" || firstChar == "e" || firstChar == "o" || firstChar == "u" || firstChar == "i"){
            System.out.println("First Charachter is: " +"\"" + firstChar +"\" " +"Vowel Charachter"+"\n");
        }
        else{
            System.out.println("First Charachter is: " + firstChar+"\n");
        }

        int[] RanNum = Arr.getRanNum55to100();
        System.out.println("Random numbers between 55 to 100: " + Arrays.toString(RanNum)+"\n");
        Arrays.sort(RanNum);
        System.out.println("Sorted numbers: " + Arrays.toString(RanNum)+"\n");
        System.out.println("Min value: " + RanNum[0]+"\n");
        System.out.println("Max value: " + RanNum[RanNum.length-1]+"\n");

        String Char = Arr.getRanChar();
        System.out.println("Random Chars: " + Char+"\n");

        String[] Char1 = Arr.get10RanNum();
        System.out.println("Ten sets of Random Chars: " + Arrays.toString(Char1)+"\n");

	}

    }
