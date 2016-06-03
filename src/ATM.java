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
        theUser.printAccountsSummary();

        // init
        int choice;

        // user menu
        do {
            System.out.printf("Welcome %s, what would you like to do?",
                    theUser.getFirstName());
            System.out.println(" 1) Show account transaction history");
            System.out.println(" 2) Withdrawl");
            System.out.println(" 3) Deposit");
            System.out.println(" 4) Transfer");
            System.out.println(" 5) Quit");
            System.out.println();
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice. Please choose 1-5");
            }
        } while (choice < 1 || choice >  5);


        // process the choice
        switch (choice){

            case 1:
                ATM.showTransHistory(theUser, sc);
                break;

            case 2:
                ATM.withdrawlFunds(theUser, sc);
                break;

            case 3:
                ATM.depositFunds(theUser, sc);
                break;

            case 4:
                ATM.transferFunds(theUser, sc);
                break;
        }

        // redisplay this menu unless the user wants to quit
        if(choice != 5){
            ATM.printUserMenu(theUser, sc);
        }
    }

    /**
     * Show the transaction history for a account
     * @param theUser the logged in User object
     * @param sc the Scanner object used for user input
     */
    public static void showTransHistory(User theUser, Scanner sc){

        int theAcct;

        // get account whose transaction history to look at
        do {
            System.out.printf("Enter the number (1-%d) of the account" +
                    " whose transactions you want to see: ",
                    theUser.numAccounts());
            theAcct = sc.nextInt() - 1;
            if(theAcct < 0 || theAcct >= theUser.numAccounts()){
                System.out.println("Invalid account. Please try again.");
            }
        } while (theAcct < 0 || theAcct >= theUser.numAccounts());

        // print transaction history
        theUser.printAcctTransHistory(theAcct);

    }

    public static void transferFunds(User theUser, Scanner sc){

    }


}
