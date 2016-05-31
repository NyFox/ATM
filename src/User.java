import com.sun.org.apache.bcel.internal.generic.RET;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 * Created by Stas on 30.05.2016.
 */
public class User {
    private String firstName;
    private String lastName;
    private String uuid;
    private byte pinHash[];
    private ArrayList<Account> accounts;

    public User(String firstName, String lastName, String pin, Bank thebank){

        // sets user's name
        this.firstName = firstName;
        this.lastName = lastName;

        // store the pin's MD5 hash, rather that the original value, for
        // security reasons
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash = md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
        }

        // get a new, unique universal ID for the user
        this.uuid = thebank.getNewUserUUID();

        // create empty list of accounts
        this.accounts = new ArrayList<Account>();

        // print log message
        System.out.printf("New user %s, %s with ID %s created.\n", lastName, firstName, this.uuid);
    }


    // add account for user
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    // return user's UUID
    public String getUUID(){
        return this.uuid;
    }
}
