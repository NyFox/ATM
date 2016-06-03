import java.util.ArrayList;

/**
 * Created by Stas on 30.05.2016.
 */
public class Account {

    private String name;
    private double balance;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    public Account(String name, User holder, Bank thebank){

        // set the account name and holder
        this.name = name;
        this.holder = holder;

        // get new account UUID
        this.uuid = thebank.getNewAccountUUID();

        //init transaction
        this.transactions = new ArrayList<Transaction>();

        // add to holder and bank lists

        //holder.addAccount(this);
        //thebank.addAccount(this);

    }

    // Get the account ID
    // return uuid
    public String getUUID(){
        return this.uuid;
    }


    /**
     * Get summary line for the account
     * @return the string summary
     */
    public String getSummaryLine(){

        // get the account's balance
        double balance = this.getBalance();

        // format the summary line, depending on the whether the balance is negative
        if(balance >= 0){
            return String.format("%s : $%.02f : %s", this.uuid, balance, this.name);
        } else {
            return String.format("%s : $(%.02f) : %s", this.uuid, balance, this.name);
        }

    }

    /**
     * Get the balance of this accounts by adding the amounts of the transactions
     * @return the balance value
     */
    public double getBalance(){

        double balance = 0;
        for (Transaction t : this.transactions){
            balance += t.getAmount();
        }

        return balance;
    }


    /**
     * Print the transaction history of the account
     */
    public void printTransHistory(){

        System.out.printf("\nTransaction history for account %s\n", this.uuid);
        for (int t = this.transactions.size()-1; t >= 0; t--){
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }

}
