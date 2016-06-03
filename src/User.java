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
            System.exit(1);
        }

        // get a new, unique universal ID for the user
        this.uuid = thebank.getNewUserUUID();

        // create empty list of accounts
        this.accounts = new ArrayList<Account>();

        // print log message
        System.out.printf("New user %s, %s with ID %s created.\n", firstName, lastName, this.uuid);
    }


    // add account for user
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    // return user's UUID
    public String getUUID(){
        return this.uuid;
    }


    /**
     * Check whether a given pin matches the true User pin
     * @param aPin the pin to check
     * @return whether the ping is valid or not
     */
    public boolean validatePin(String aPin){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()), this.pinHash);
        } catch (NoSuchAlgorithmException e) {
            System.out.println("error, caught NoSuchAlgorithmException");
            e.printStackTrace();
            System.exit(1);
        }

        return false;
    }

    /**
     * Return the user's first name.
     * @return the first name
     */
    public String getFirstName(){
       return this.firstName;
    }

    /**
     * Print summaries for the accounts of this user.
     */
    public void printAccountsSummary(){

        System.out.printf("\n\n%s's accounts summary", this.firstName);
        for(int a = 0; a < this.accounts.size(); a++){
            System.out.printf("%d) %s\n", a + 1,
                    this.accounts.get(a).getSummaryLine());
        }
        System.out.println();

    }

    /**
     * Get the number of accounts of the user
     * @return the number of accounts
     */
    public int numAccounts(){
        return this.accounts.size();
    }


    /**
     * Print transaction history for a particular account.
     * @param acctIdx the index of the account to use
     */
    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTransHistory();
    }

}
