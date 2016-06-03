import java.util.Date;

/**
 * Created by Stas on 30.05.2016.
 */
public class Transaction {

    private double amount;
    private Date timestap;
    private String memo;
    private Account inAccount;


    /**
     * Create new transaction
     * amount  the amount transacted
     * inAccount the account the transaction belongs to
     */
    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestap = new Date();
        this.memo = "";

    }

    /**
     * Create new transaction
     * amount  the amount transacted
     * memo the memo for transaction
     * inAccount the account the transaction belongs to
     */
    public Transaction(double amount, String memo, Account inAccount){

        // call the two-arg constructor first
        this(amount, inAccount);

        // set the memo
        this.memo = memo;

    }

    /**
     * Get the amount of the transaction
     * @return the amount
     */
    public double getAmount(){
        return this.amount;
    }


    /**
     * Get a string summarizing the transaction
     * @return the summary string
     */
    public String getSummaryLine(){

        if(this.amount >= 0){
            return String.format("%s : $%.02f : %s", this.timestap.toString(),
                    this.amount, this.memo);
        } else {
            return String.format("%s : $(%.02f) : %s", this.amount, this.memo);
        }

    }


}
