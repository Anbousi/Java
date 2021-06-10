public class Fibonacci {
    int n1 = 0 , n2 = 1 , n3 = 0;
    public int Fibo(int num) {
        if (num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }

        if(num>1){
            n3 = n1 + n2;
            // System.out.println(n1+" " + n2 + " " +n3);
            n1 = n2;
            n2 = n3;
            num = num-1;
            Fibo(num);
        }
        return n3;
    }
}