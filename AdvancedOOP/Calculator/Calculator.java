public class Calculator{
    private double operandOne;
    private double operandTwo;
    private String operation;
    private double result;

    public Calculator(){

    }

    public void setOperandOne(double operandOne){
        this.operandOne = operandOne;
    }
    public void setOperandTwo(double operandTwo){
        this.operandTwo = operandTwo;
    }
    public void setOperation(String operation){
        this.operation = operation;
    }

    public void performOperation(){
        if ( this.operation == "+")
            this.result = operandOne + operandTwo;
        else if (this.operation == "-")
            this.result = operandOne - operandTwo;
        else if (this.operation == "*")
            this.result = operandOne * operandTwo;
        else if (this.operation == "/")
            this.result = operandOne / operandTwo;
    }

    public double getResult(){
        return this.result;
    }
}