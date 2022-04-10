import java.util.Scanner;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    private static int tid = 1;
    private static int aid = 1;
    private static int gid = 1;
    private static int nid = 1;
    private static Users loggedInUser = new Users("test uid", "test name", 
                                        "test street", "test zip", "test phone", 
                                        "test.com", true, getCurrentTime());

    public static void main (String[] args){
        while(on){
            if(loggedIn){
                printMenu();
            }
            else{
                logIn();
            }
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
        String opener = "\nWelcome, what would you like to do? \n(Log out) \n(View Posts) \n(Make a new post) \n(Offer thanks) \n(Generate a report) \n(Exit program)";
        System.out.println(opener);
        String operation = scnr.nextLine();
        String logOut = "log out";
        String viewPosts = "viewPosts";
        String makePost = "make a new post";
        String offerThanks = "offer thanks";
        String report = "generate a report";
        String exit = "exit program";
        if(operation.equalsIgnoreCase(logOut)){
            logOut();
        }
        else if(operation.equalsIgnoreCase(viewPosts)){
            viewPosts();
        }
        else if(operation.equalsIgnoreCase(makePost)){
            makePost();
        }
        else if(operation.equalsIgnoreCase(offerThanks)){
            offerThanks();
        }
        else if(operation.equalsIgnoreCase(report)){
            generateReport();
        }
        else if(operation.equalsIgnoreCase(exit))
        {
            on = false;
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

        Users newUser = new Users(uid, name, street, zip, phone, photo, true, getCurrentTime());
        //TODO pass the user to the other class to add a new account to the API

        return newUser.toString();
    }

    private static String logInAccount(){
        System.out.println("\nPlease enter the user ID for the account you would like to log in to");
        String newUID = scnr.nextLine();
        //TODO Pass the uid to the other class to make an API request to get that users account
        return "";
    }

    private static String logOut(){
        String loggedOut = "\nYou have succesfully logged out";
        System.out.println(loggedOut);
        loggedIn = false;
        return loggedOut;
    }

    private static String viewPosts(){
        return "";
    }

    private static String makePost(){
        System.out.println("What type of post would you like to make? \n(give) \n(ask)");
        String type = scnr.nextLine();
        String give = "give";
        String ask = "ask";
        if(type.equalsIgnoreCase(give)){
            newGive();
        }
        else if(type.equalsIgnoreCase(ask)){
            newAsk();
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
        return type.toLowerCase();
    }

    private static String offerThanks(){
        String tempUID = "200";

        System.out.println("What is the user ID of the person you would like to thank?");
        String thanksTo = scnr.nextLine();
        System.out.println("What would you like your message to say?");
        String body = scnr.nextLine();

        String currentTID = Integer.toString(tid);
        tid++;

        Thanks newThanks = new Thanks(tempUID, currentTID, thanksTo, body, getCurrentTime());
        //TODO pass the new thanks to the other class to do the API call
        return newThanks.toString();
    }

    private static String generateReport(){
        return "";
    }

    private static String newAsk(){
        ArrayList<String> zipCodes = new ArrayList<>();
        System.out.println("What is the description of the ask?");
        String description = scnr.nextLine();
        System.out.println("What is the start date for availability (Leave blank for immediately)");
        String start = scnr.nextLine();
        System.out.println("What is the end date for availability (Leave blank for no time)");
        String end = scnr.nextLine();
        System.out.println("Would you like to enter different zip codes to show the ask?");
        String yesNo = scnr.nextLine();
        if(start.equals(""))
        {
            start = getCurrentTime();
        }
        if(yesNo.equalsIgnoreCase("yes"))
        {
            System.out.println("How many zip codes would you like to offer?");
            String zipCount = scnr.nextLine();
            int intZipCount = Integer.parseInt(zipCount);
            for(int i = 0; i < intZipCount; i++)
            {
                System.out.println("Please enter one of the zip codes");
                String tempZip = scnr.nextLine();
                zipCodes.add(tempZip);
            }
        }
        else if(yesNo.equalsIgnoreCase("no"))
        {
            zipCodes.add(loggedInUser.getZip());
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
        String[] tempZipList = new String[zipCodes.size()];
        for(int i = 0; i < zipCodes.size(); i ++)
        {
            tempZipList[i] = zipCodes.get(i);
        }
        Ask newAsk = new Ask(loggedInUser.getUid(), Integer.toString(aid), description, start, end, tempZipList, true, getCurrentTime());
        return newAsk.toString();
    }

    private static String newGive(){
        ArrayList<String> zipCodes = new ArrayList<>();
        System.out.println("What is the description of the give?");
        String description = scnr.nextLine();
        System.out.println("What is the start date for availability (Leave blank for immediately)");
        String start = scnr.nextLine();
        System.out.println("What is the end date for availability (Leave blank for no time)");
        String end = scnr.nextLine();
        System.out.println("Would you like to enter different zip codes to show the give?");
        String yesNo = scnr.nextLine();
        if(start.equals(""))
        {
            start = getCurrentTime();
        }
        if(yesNo.equalsIgnoreCase("yes"))
        {
            System.out.println("How many zip codes would you like to offer?");
            String zipCount = scnr.nextLine();
            int intZipCount = Integer.parseInt(zipCount);
            for(int i = 0; i < intZipCount; i++)
            {
                System.out.println("Please enter one of the zip codes");
                String tempZip = scnr.nextLine();
                zipCodes.add(tempZip);
            }
        }
        else if(yesNo.equalsIgnoreCase("no"))
        {
            zipCodes.add(loggedInUser.getZip());
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
        String[] tempZipList = new String[zipCodes.size()];
        for(int i = 0; i < zipCodes.size(); i ++)
        {
            tempZipList[i] = zipCodes.get(i);
        }
        Give newGive = new Give(loggedInUser.getUid(), Integer.toString(aid), description, start, end, tempZipList, true, getCurrentTime());
        return newGive.toString();
    }

    private static String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime current = LocalDateTime.now();
        String dateCreated = dtf.format(current);
        return dateCreated;
    }
}