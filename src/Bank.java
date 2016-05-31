import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Stas on 30.05.2016.
 */
public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;


    // Generate a new, universal unique ID for the user
    // return uuid

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

    // Generate a new, universal unique ID for an account
    // return uuid

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

}
