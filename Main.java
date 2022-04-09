import java.util.Scanner;

import org.junit.platform.console.shadow.picocli.CommandLine.Command;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class Main{
    //User can ask, give, share, or lend
    //Give indicates what it is for, a description, and how to get it
    //User may offer thanks to another user
    //User must put a distance limit on their ask or give
    //User might be able to list a zip code where the offer can be visible which will default to the user's location
    //User can see all of the asks and gives within their account's zip code or if the other user specified their zip code
    //Users can put notes on a post and the op can put notes on the post as well
    //OP can make a post inactive occurs by defualt after a transaction is complete
    //Users can search by keyword or filter posts based on being active or inactive
    //CSR's need to be able to make reports that show the number of asks/ gives between a start date and end date. They will include zip and status\
    //CSR's can generate a list of all previous asks/ gives with the associated communications between a start and end date for a user
    private static Scanner scnr = new Scanner(System.in);
    private static boolean on = true;
    private static boolean loggedIn = false;
    private static String uid;
    private static int counter = 1;

    public static void main (String[] args){
        if(loggedIn){
            printMenu();
        }
        else{
            logIn();
        }
    }

    private static String logIn(){
        String logInPrompt = "\nWould you like to (log in) or (create a new account)? \nPlease enter one of the options surrounded by '()' into the command line. \nDo not include '()' in your command";
        System.out.println(logInPrompt);
        String loginOrCreate = scnr.nextLine();
        String action = "";
        String logInSelect = "log in";
        String createSelect = "create a new account";
        if(loginOrCreate.equalsIgnoreCase(createSelect))
        {
            action = logInSelect;
            createNewAccount();
        }
        else if(loginOrCreate.equalsIgnoreCase(logInSelect)){
            action = createSelect;
            logInAccount();
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
        return action;
    }

    private static String printMenu(){
        String opener = "\nWelcome, what would you like to do? \n(Log out) \n(View Posts) \n(Make a new post) \n(Offer thanks) \n(Generate a report)";
        System.out.println(opener);
        String operation = scnr.nextLine();
        String logOut = "log out";
        String viewPosts = "viewPosts";
        String makePost = "make a new post";
        String offerThanks = "offer thanks";
        String report = "generate a report";
        if(operation.equalsIgnoreCase(logOut)){

        }
        else if(operation.equalsIgnoreCase(viewPosts)){
            
        }
        else if(operation.equalsIgnoreCase(makePost)){

        }
        else if(operation.equalsIgnoreCase(offerThanks)){

        }
        else if(operation.equalsIgnoreCase(report)){

        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }

        return operation.toLowerCase();
    }

    private static String createNewAccount(){
        System.out.println("\nPlease provide the name of the new account");
        String name = scnr.nextLine();
        System.out.println("Please provide street address of the new account");
        String street = scnr.nextLine();
        System.out.println("Please provide the zip code of the new account");
        String zip = scnr.nextLine();
        System.out.println("Please provide the phone number of the new account");
        String phone = scnr.nextLine();
        System.out.println("Please provide the url of a photo for the new account");
        String photo = scnr.nextLine();

        String uid = Integer.toString(counter);
        counter++;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime current = LocalDateTime.now();
        String dateCreated = dtf.format(current);

        Users newUser = new Users(uid, name, street, zip, phone, photo, true, dateCreated);
        //TODO pass the user to the other class to add a new account to the API

        return newUser.toString();
    }

    public static String logInAccount(){
        System.out.println("\nPlease enter the user ID for the account you would like to log in to");
        String newUID = scnr.nextLine();
        //TODO Pass the uid to the other class to make an API request to get that users account
        return "";
    } 
}