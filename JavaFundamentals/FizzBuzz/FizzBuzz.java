public class FizzBuzz {
    public String FB(int x) {
	
if (x%3 == 0 && x%5 == 0){
return "Fizz Buzz";
}
else if( x%3 == 0){
return "Fizz";
}
else if (x%5 == 0){
return "Buzz";
}
else{
    return Integer.toString(x);
}
}
}