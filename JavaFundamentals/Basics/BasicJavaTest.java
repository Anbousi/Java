import java.util.Arrays;
public class BasicJavaTest{
    public static void main(String[] args){
        // Print numbers from 1 to 255
        // BasicJava Ex1 = new BasicJava();
        // for (int i = 0; i<Ex1.print1To255().size();i++){
        // System.out.println(Ex1.print1To255().get(i));
                // OR-----OR-----OR-----OR-----OR
                // for (int i = 0 ; i<256 ; i++){
                //     System.out.println(i);
                // }
                // }

//--------------------------------------------------------------

        // Print Odd numbers from 1 to 255
        // BasicJava Ex2 = new BasicJava();
        // for (int j = 0; j<Ex2.printOdd().size();j++){
        // System.out.println(Ex2.printOdd().get(j));
        // }
                // OR-----OR-----OR-----OR-----OR
                // for (int i = 0 ; i<256 ; i++){
                // if(i%2 ==1){
                //     System.out.println(i);
                // }

//--------------------------------------------------------------

        // Print Sum
        // int sum = 0;
        // for(int k = 0 ; k<256 ; k++){
        //     sum += k;
        //     System.out.println("New number: "+ k + " Sum: " + sum);
        // }

//--------------------------------------------------------------

        // Iterating through an array
        // int[] X = {1,3,5,7,9,13};
        // for(int m=0 ; m<X.length ; m++){
        //     System.out.println(X[m]);
        // }

//--------------------------------------------------------------

        // Find Max
        // int[] Y = {-3, -5, -7, 0, 5};
        // int max = Y[0];
        // for(int n=1 ; n<Y.length ; n++){
        //     if(Y[n]>max){
        //         max = Y[n];
        //     }
        // }
        // System.out.println("Maximum number is: " + max);

//--------------------------------------------------------------

        //Get Average
        // int[] K = {2, 10, 3};
        // float sum =0;
        // float avg;
        // for(int h=0; h<K.length ;h++){
        //     sum += K[h];
        // }
        // avg = sum/K.length;

        // System.out.println("sum is: " + sum + " Elements = " + K.length );
        // System.out.println("Average is: " + avg);
        
//--------------------------------------------------------------

        // Array with Odd Numbers
        // BasicJava Ex3 = new BasicJava();
        // System.out.println(Ex3.printOdd());

//--------------------------------------------------------------

        // Greater Than Y
        // int Y = 3;
        // int[] L = {1, 3, 5, 7};
        // int sum1 = 0;
        // for (int a=0 ; a<L.length ; a++ ){
        //     if(L[a]>Y){
        //         sum1++;
        //     }
        // }
        // System.out.println("Num of elements greater than Y: " + sum1);

//--------------------------------------------------------------

        // Square the values
        // int[] M = {1, 5, 10, -2};
        // for (int a=0 ; a<M.length ; a++ ){
        //     M[a] = M[a]*M[a];
        //     System.out.println(M[a]);
        // }
        // System.out.println(Arrays.toString(M));

//--------------------------------------------------------------
        // Eliminate Negative Numbers
//         int[] X = {1, 5, 10, -2};
//         for (int i=0 ; i<X.length ; i++ ){
//             if(X[i]<0){
//                 X[i] = 0;
//             }
// }
//         System.out.println(Arrays.toString(X));

//--------------------------------------------------------------


        // Max, Min, and Average
//         int[] K = {1, 5, 10, -2};
//         float sum =0;
//         float avg;
//         int min = K[0];
//         int max = K[0];
        
//         for(int h=0; h<K.length ;h++){
//             sum += K[h];
//             if(K[h]>max){
//                 max = K[h];
//             }
//             if(K[h]<min){
//                 min = K[h];
//             }
//         }
//         avg = sum/K.length;
//         float[] arr = {max, min, avg};
//         System.out.println("sum is: " + sum + " Elements = " + K.length );
//         System.out.println("Average is: " + avg);
//         System.out.println("Max value is: " + max);
//         System.out.println("Min value is: " + min);
//         System.out.println(Arrays.toString(arr));

//--------------------------------------------------------------

        // Shifting the Values in the Array
        int[] X = {1, 5, 10, 7, -2};
        for (int i=1; i<X.length; i++){
            X[i-1] = X[i];
        }
        X[X.length-1] = 0;
        System.out.println(Arrays.toString(X));

}
}