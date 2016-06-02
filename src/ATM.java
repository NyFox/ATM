import java.util.Scanner;

/**
 * Created by Stas on 30.05.2016.
 */
public class ATM {
    public static void main(String[]args){

        // init Scanner
        Scanner sc = new Scanner(System.in);

        // init Bank
        Bank theBank = new Bank("Сбербанк"); // very cool russian bank :DD

        // add a user, which also creates a savings account
        User aUser = theBank.addUser("Stas", "Lis", "7776");

        // add a checking account for our user
        Account newAccount = new Account("Checking", aUser, theBank);
        aUser.addAccount(newAccount);
        theBank.addAccount(newAccount);

        User curUser;
        while (true){

            // stay in the login prompt until successful login
            curUser = ATM.mainMenuPrompt(theBank, sc);

            // stay in main menu until user quits
            ATM.printUserMenu(curUser, sc);

        }

    }

    /**
     * Print the ATM's login menu
     * @param theBank the Bank object whose accounts to use
     * @param sc the Scanner object to use for user input
     * @return
     */
    public static User mainMenuPrompt(Bank theBank, Scanner sc){

        // units
        String userID;
        String pin;
        User authUser;

        // prompt the user for user ID/pin combo until a correct one is reached
        do {

            System.out.printf("\n\nWelcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID: ");
            userID = sc.nextLine();
            System.out.print("Enter pin: ");
            pin = sc.nextLine();

            // try to get the user object corresponding to the ID and pin combo
            authUser = theBank.userLogin(userID, pin);
            if(authUser == null){
                System.out.println("Incorrect user ID/pin combination. " +
                "Please try again.");
            }

        } while (authUser == null); // continue looping until successful login

        return authUser;
    }

    public static void printUserMenu(User theUser, Scanner sc){

        // print a summary of the user's accounts


    }
}
