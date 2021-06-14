public class CalculatorTest{
    public static void main(String[] args){
        Calculator C = new Calculator();
        C.setOperandOne(5);
        C.setOperandTwo(5);
        C.setOperation("+");
        C.performOperation();
        System.out.println(C.getResult());
        C.setOperation("*");
        C.performOperation();
        System.out.println(C.getResult());
        C.setOperation("-");
        C.performOperation();
        System.out.println(C.getResult());
        C.setOperation("/");
        C.performOperation();
        System.out.println(C.getResult());

    }
}