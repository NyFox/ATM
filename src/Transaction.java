import java.util.Date;

/**
 * Created by Stas on 30.05.2016.
 */
public class Transaction {

    private double amount;
    private Date timestap;
    private String memo;
    private Account inAccount;

    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestap = new Date();
        this.memo = "";

    }

    public Transaction(double amount, String memo, Account inAccount){

        // call the two-arg constructor first
        this(amount, inAccount);

        // set the memo
        this.memo = memo;

    }

}
