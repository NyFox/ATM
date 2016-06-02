import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Stas on 30.05.2016.
 */
public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     * Create a new Bank object with empty lists of users and accounts
     * @param name the name of the bank
     */
    public Bank(String name){

        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();

    }

    /** Generate a new, universal unique ID for the user
     * return uuid
     */
    public String getNewUserUUID(){

        //inits
        String uuid;
        Random rand = new Random();
        int len = 6;
        boolean noUnique;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for(int i = 0; i < len; i++){
                uuid += ((Integer)rand.nextInt(10)).toString();
            }

            // Check to make sure it's unique
            noUnique = false;
            for (User u : this.users) {
                if(uuid.compareTo(u.getUUID()) == 0){
                    noUnique = true;
                    break;
                }

            }

        } while (noUnique);

        return uuid;

    }

    /** Generate a new, universal unique ID for an account
     * return uuid
     */
    public String getNewAccountUUID(){

        //inits
        String uuid;
        Random rand = new Random();
        int len = 10;
        boolean noUnique;

        // continue looping until we get a unique ID
        do {

            // generate the number
            uuid = "";
            for(int i = 0; i < len; i++){
                uuid += ((Integer)rand.nextInt(10)).toString();
            }

            // Check to make sure it's unique
            noUnique = false;
            for (Account a : this.accounts) {
                if(uuid.compareTo(a.getUUID()) == 0){
                    noUnique = true;
                    break;
                }

            }

        } while (noUnique);

        return uuid;

    }

    // add an account
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }

    /**
     * Create a new user of the bank
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param pin the user's pin
     * @return the new User object
     */
    public User addUser(String firstName, String lastName, String pin){

        // create a new User object and add it to out list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        // create a savings account for the user
        Account newAccount = new Account("Savings", newUser, this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);

        return newUser;

    }

    /**
     * Get the User object associated with a particular userID and pin, if they are valid
     * @param userID the UUID of user to log in
     * @param pin the pin of the user
     * @return the User object, if the login is successful, or null, if it is not
     */
    public User userLogin(String userID, String pin){

        // search through list of users
        for(User u : this.users){

            // check user ID is correct
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(pin)){
                return u;
            }
        }

        // if we haven't found the user or have an incorrect pin
        return null;
    }

    /**
     * Get the name of the bank
     * @return the name of the bank
     */
    public String getName(){
        return this.name;
    }


}
