import java.util.Scanner;

/**
 * Created by Stas on 30.05.2016.
 */
public class ATM {
    public static void main(String[]args){

        // init Scanner
        Scanner sc = new Scanner(System.in);

        // init Bank
        Bank theBank = new Bank("Сбербанк");

        // add a user, which also creates a savings account
        User aUser = theBank.addUser("Stas", "Lis", "7776");

        // add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

    }
}
