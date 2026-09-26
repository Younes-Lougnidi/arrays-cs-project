package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    Double[] transactions = new Double[1000];
    int transactions_count = 0;

    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if(amount >= 0 ){
            currentBalance += amount;
            transactions[transactions_count] = amount;
            transactions_count += 1;
            System.out.println("The client " + name + " has deposited " + amount + ". The new balance is : "+currentBalance);
        }
        else{
            System.out.println("The deposit amount can't be negative");
        }

    }

    public void withdraw(double amount){
        if(amount >= 0 && currentBalance >= amount){
            currentBalance -= amount;
            transactions[transactions_count] = - amount;
            transactions_count += 1;
            System.out.println("The client " + name + " has withdrawn " + amount + ". The new balance is : "+currentBalance);
        }
        else if (amount <= 0){
            System.out.println("The withdrawn amount can't be negative");
        }
        else{
            System.out.println("The withdrawn amount exceeds the account's balance.");
        }
    }

    public void displayTransactions(){
        System.out.print("The transactions made on " + name + "'s bank account are : ");
        for(int i = 0; i < transactions_count; i++){
            if(i == transactions_count-1) {
                System.out.println(transactions[i]);
            }
            else{
                System.out.print(transactions[i]+ ", ");
            }

        }

    }

    public void displayBalance(){
        System.out.println("The balance of "+name+"'s bank account is : "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}
