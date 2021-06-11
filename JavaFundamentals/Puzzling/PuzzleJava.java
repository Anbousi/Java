import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.String;

public class PuzzleJava{
    public int getSum(int[] arr){
        int sum =0;
        for (int i =0; i<arr.length;i++){
            sum = sum + arr[i];
        }
        return sum;
    }

    public int[] getGreater10(int[] arr){
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        for (int i =0; i<arr.length;i++){
            if(arr[i]>10){
                myArray.add(arr[i]);
            }
        }
        int[] arr1 = new int[myArray.size()];
        for (int k =0; k<myArray.size();k++){
            arr1[k] = myArray.get(k);
        }
        return arr1;
    }

    public String[] shuffleArray(String[] array){

        Random rand = new Random();
		for (int i = 0; i < array.length; i++) {
			int randomIndexToSwap = rand.nextInt(array.length);
			String temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
		}

		return array;
    }

    public String[] getLongNames(String[] array){
        ArrayList<String> myArray = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
            if(array[i].length()>5){
                myArray.add(array[i]);
            }
		}

        String[] arr = new String[myArray.size()];
        for (int k =0; k<myArray.size();k++){
            arr[k] = myArray.get(k);
        }
        return arr;
    }

    public String getLastChar(List<String> letters){
        int x = letters.size() - 1;
        String lastChar = letters.get(x);
        return lastChar;
    }

    public String getFirstChar(List<String> letters){
        String firstChar = letters.get(0);
        return firstChar;
    }

    public int[] getRanNum55to100(){
        
        Random r = new Random();
        int[] arr = new int[10];
        int min = 55;
        int max = 100;

        for(int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt(max-min) + min;
        }
        return arr;
    }

    public String getRanChar(){
        Random r = new Random();
        
        int min = 97;
        int max = 122;
        String str1 = "";
        String str = "";
        for(int i = 0; i < 5; i++){
            int charachter = r.nextInt(max-min) + min;
            char ch = (char) charachter;
            str1 = String.valueOf(ch);
            str = str + str1;
        }        
        return str;
    }

    public String[] get10RanNum(){
        String[] str = new String[10];
        for(int i = 0; i<str.length; i++){
            str[i] = getRanChar();
        }
        return str;
    }
}
