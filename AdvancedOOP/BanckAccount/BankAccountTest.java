public class BankAccountTest{
    public static void main(String[] args){
        BankAccount Mahmoud = new BankAccount();
        BankAccount Saed = new BankAccount();

        System.out.println("Mahmoud's Account Number: " + Mahmoud.getAccountNum());
        System.out.println("Mahmoud's Checking Balance: " + Mahmoud.getCheckingBalance());
        System.out.println("Mahmoud's Saving Balance: " + Mahmoud.getSavingBalance());
        System.out.println("Bank Total Amount of Money: " + BankAccount.getTotalAmount());
        System.out.println("Number of Account/s in Bank: " + BankAccount.getNumAccounts());
        Mahmoud.deposite("SavingBalance" , 1000);
        Mahmoud.deposite("CheckingBalance" , 1500);
        System.out.println("Mahmoud's Checking Balance: " + Mahmoud.getCheckingBalance());
        System.out.println("Mahmoud's Saving Balance: " + Mahmoud.getSavingBalance());
        System.out.println("Bank Total Amount of Money: " +BankAccount.getTotalAmount());
        
        Mahmoud.withDraw("SavingBalance" , 2000);
        
        Mahmoud.withDraw("SavingBalance" , 500);
        System.out.println("Mahmoud's Checking Balance: " + Mahmoud.getCheckingBalance());
        System.out.println("Mahmoud's Saving Balance: " + Mahmoud.getSavingBalance());
        

    }
}