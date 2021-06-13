import java.util.Random;

public class BankAccount{
    private String accountNumber;
    private double checkingBalance;
    private double savingBalance;
    private static int numAccounts = 0;
    private static double totalAmount = 0;
// Constructor
    public BankAccount(){
        BankAccount.numAccounts++;
        this.checkingBalance = 0;
        this.savingBalance = 0;
        BankAccount.totalAmount = savingBalance + checkingBalance;
        this.accountNumber = generateAccountNum();
    }

    private String generateAccountNum(){
        Random r = new Random();
        String accountNum = "";
        for (int i=0 ; i<10 ; i++){
            accountNum += r.nextInt(9);
        }
        return accountNum;
    }

// getter
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingBalance(){
        return this.savingBalance;
    }

    public String getAccountNum(){
        return this.accountNumber;
    }

    public static int getNumAccounts(){
        return BankAccount.numAccounts;
    }

    public static double getTotalAmount(){
        return BankAccount.totalAmount;
    }

// setter
    public void deposite(String accountName , int depositAmoumt){
        if(accountName == "CheckingBalance"){
            this.checkingBalance += depositAmoumt;
            BankAccount.totalAmount += this.checkingBalance;
        }
        if(accountName == "SavingBalance"){
            this.savingBalance += depositAmoumt;
            BankAccount.totalAmount += this.savingBalance;
        }
    }

    public void withDraw(String accountName , int withdrawAmoumt){
        if(accountName == "CheckingBalance"){
            if(withdrawAmoumt > this.checkingBalance){
                System.out.println("\n" + "Mahmoud try to withdraw from Saving Balance : " + withdrawAmoumt);
                System.out.println("Insufficient funds");
            }
            else{
                System.out.println("\n" +"Mahmoud try to withdraw from Checking Balanece : " + withdrawAmoumt);
                this.checkingBalance -= withdrawAmoumt;
                BankAccount.totalAmount -= this.checkingBalance;
            }
        }
            
        
        if(accountName == "SavingBalance"){
            if(withdrawAmoumt > this.savingBalance){
                System.out.println("\n" + "Mahmoud try to withdraw from Saving Balance : " + withdrawAmoumt);
                 System.out.println("Insufficient funds");
            }
            else{
                System.out.println("\n" + "Mahmoud try to withdraw from Saving Balance : " + withdrawAmoumt);
                this.savingBalance -= withdrawAmoumt;
                BankAccount.totalAmount -= this.savingBalance;
            }
        }
    }
    
    public void totalMoney(){
        System.out.println("Total Money Amounts: " +BankAccount.totalAmount);
    }
}
