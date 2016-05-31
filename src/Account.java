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
        holder.addAccount(this);
        thebank.addAccount(this);

    }

}
