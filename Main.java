import java.util.Scanner;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main{
    //TODO Differentiate between a user and csr by making csr's negative
    //TODO look to the view posts method in order to make another sub menu that will allow the user to make more choices with posts
    //TODO make the next class that can do the JSON/API handling
    //TODO do the API handling
    //TODO link the API class back to this one to complete functionallity
    //TODO make README
    //TODO make memo
    //TODO unit testing
    //TODO all options with accounts
    //TODO all report options 

    private static final String searchAsk = null;
    private static Scanner scnr = new Scanner(System.in);
    private static boolean on = true;
    private static boolean loggedIn = false;
    private static int uid = 1;
    private static int tid = 1;
    private static int pid = 1;
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

//Menus-----------------------------------------------------------------------------------------------------------------------------------------------
    private static String logIn(){
        String logInPrompt = "\nWould you like to (log in) or (create a new account) \nPlease enter one of the options surrounded by '()' into the command line. \nDo not include '()' in your command";
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
        String opener = "\nWelcome, what would you like to do? \n(Log out) \n(View Posts) \n(Make a new post) \n(Thanks) \n(Notes) \n(Generate a report) \n(Exit program)";
        System.out.println(opener);
        String operation = scnr.nextLine();
        String logOut = "log out";
        String viewPosts = "viewPosts";
        String makePost = "make a new post";
        String thanks = "thanks";
        String report = "generate a report";
        String notes = "notes";
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
        else if(operation.equalsIgnoreCase(thanks)){
            thanks();
        }
        else if(operation.equalsIgnoreCase(report)){
            generateReport();
        }
        else if(operation.equalsIgnoreCase(notes)){
            notes();
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

    private static String viewPosts(){
        System.out.println("What do you want to do with posts? \n(Asks) \n(Gives)");
        String askOrGive = scnr.nextLine();
        if(! (askOrGive.equalsIgnoreCase("asks") || askOrGive.equalsIgnoreCase("gives")))
        {
            System.out.println("ERROR: Please enter a valid command");
        }
        System.out.println("What would you like to do? \n(Deactivate " + askOrGive + ") \n(Update " + askOrGive + ") \n(Delete " + askOrGive + ") \n(View your " + askOrGive + ") \n(View all " + askOrGive + ") \n(View a " + askOrGive + ") \n(Search " + askOrGive + ")");
        String request = scnr.nextLine();
        String deactivate = "deactivate ";
        String update = "update ";
        String delete = "delete ";
        String viewYourRequest =  "view your ";
        String viewAllRequest = "view all ";
        String viewRequest = "view ";
        String searchRequest = "search ";
        String ask = "ask";
        String give = "give";
        if(request.equalsIgnoreCase(deactivate + ask)){
            deactivateAsk();
        }
        else if(request.equalsIgnoreCase(update + ask)){
            updateAsk();
        }
        else if(request.equalsIgnoreCase(delete + ask)){
            deleteAsk();
        }
        else if(request.equalsIgnoreCase(viewYourRequest + ask)){
            viewYourAsk();
        }
        else if(request.equalsIgnoreCase(viewAllRequest + ask)){
            viewAllAsk();
        }
        else if(request.equalsIgnoreCase(viewRequest + ask)){
            viewAsk();
        }
        else if(request.equalsIgnoreCase(searchRequest + ask)){
            searchAsk();
        }
        else if(request.equalsIgnoreCase(deactivate + give)){
            deactivateGive();
        }
        else if(request.equalsIgnoreCase(update + give)){
            updateGive();
        }
        else if(request.equalsIgnoreCase(delete + give)){
            deleteGive();
        }
        else if(request.equalsIgnoreCase(viewYourRequest + give)){
            viewYourGive();
        }
        else if(request.equalsIgnoreCase(viewAllRequest + give)){
            viewAllGive();
        }
        else if(request.equalsIgnoreCase(viewRequest + give)){
            viewGive();
        }
        else if(request.equalsIgnoreCase(searchRequest + give)){
            searchGive();
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
        return "";
    }

    private static void notes() {
        System.out.println("What would you like to do with notes \n(Create note) \n(Update note) \n(Delete note) \n(View notes) \n(View note) \n(Search note)");
        String operation = scnr.nextLine();
        String createNote = "create note";
        String updateNote = "update note";
        String deleteNote = "delete note";
        String viewNotes = "view notes";
        String viewNote = "view note";
        String searchNote = "search note";
        if(operation.equalsIgnoreCase(createNote)){
            createNote();
        }
        else if(operation.equalsIgnoreCase(updateNote)){

        }
        else if(operation.equalsIgnoreCase(deleteNote)){
            updateNote();
        }
        else if(operation.equalsIgnoreCase(viewNotes)){
            viewNotes();
        }
        else if(operation.equalsIgnoreCase(viewNote)){
            viewNote();
        }
        else if(operation.equalsIgnoreCase(searchNote)){
            searchNote();
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
    }

    private static void thanks(){
        System.out.println("What would you like to do with thanks? \n(Create thanks) \n(Update thanks) \n(View thanks) \n(View thank) \n(Search thanks)");
        String operation = scnr.nextLine();
        String createThanks = "create thanks";
        String updateThanks = "update thanks";
        String viewThanks = "view thanks";
        String viewThank = "view thank";
        String searchThanks = "search thanks";
        if(operation.equalsIgnoreCase(createThanks)){
            createThanks();
        }
        else if(operation.equalsIgnoreCase(updateThanks)){
            updateThanks();
        }
        else if(operation.equalsIgnoreCase(viewThanks)){
            viewThanks();
        }
        else if(operation.equalsIgnoreCase(viewThank)){
            viewThank();
        }
        else if(operation.equalsIgnoreCase(searchThanks)){
            searchThanks();
        }
        else{
            System.out.println("ERROR: Please enter a valid command");
        }
    }

//Log in/out-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

//Account options-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

        String tempUID = Integer.toString(uid);

        Users newUser = new Users(tempUID, name, street, zip, phone, photo, true, getCurrentTime());
        uid++;
        //TODO pass the user to the other class to add a new account to the API

        return newUser.toString();
    }

//Post options--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static String createThanks(){
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

    private static void updateThanks() {
        System.out.println("What is the tid of the thanks you want to update?");
        String tempTid = scnr.nextLine();
    }

    private static void viewThanks() {
    }

    private static void viewThank() {
        System.out.println("What is the tid of the thanks you want to view?");
        String tempTid = scnr.nextLine();
    }

    private static void searchThanks() {
        System.out.println("What is the start date you would like to search?");
        String start = scnr.nextLine();
        System.out.println("What is the end date you would like to search?");
        String end = scnr.nextLine();
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
        Ask newAsk = new Ask(loggedInUser.getUid(), Integer.toString(pid), description, start, end, tempZipList, true, getCurrentTime());
        pid++;
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
        Give newGive = new Give(loggedInUser.getUid(), Integer.toString(pid), description, start, end, tempZipList, true, getCurrentTime());
        pid++;
        return newGive.toString();
    }

    private static void searchGive() {
        System.out.println("What is the start date you would like to search?");
        String start = scnr.nextLine();
        System.out.println("What is the end date you would like to search?");
        String end = scnr.nextLine();
    }

    private static void viewGive() {
        System.out.println("What is the pid of the give you want to view?");
        String tempGid = scnr.nextLine();
    }

    private static void viewAllGive() {
    }

    private static void viewYourGive() {
    }

    private static void deleteGive() {
        System.out.println("What is the pid of the give you want to delete?");
        String tempGid = scnr.nextLine();
    }

    private static void updateGive() {
        System.out.println("What is the pid of the give you want to update?");
        String tempGid = scnr.nextLine();
    }

    private static void deactivateGive() {
        System.out.println("What is the pid of the give you want to deactivate?");
        String tempGid = scnr.nextLine();
    }

    private static void searchAsk() {
        System.out.println("What is the start date you would like to search?");
        String start = scnr.nextLine();
        System.out.println("What is the end date you would like to search?");
        String end = scnr.nextLine();
    }

    private static void viewAsk() {
        System.out.println("What is the pid of the ask you want to view?");
        String tempAid = scnr.nextLine();
    }

    private static void viewAllAsk() {
    }

    private static void viewYourAsk() {
    }

    private static void deleteAsk() {
        System.out.println("What is the pid of the ask you want to delete?");
        String tempAid = scnr.nextLine();
    }

    private static void updateAsk(){
        System.out.println("What is the pid of the ask you want to update?");
        String tempAid = scnr.nextLine();
    }

    private static void deactivateAsk() {
        System.out.println("What is the pid of the ask you want to deactivate?");
        String temAid = scnr.nextLine();
    }

    private static void searchNote() {
        System.out.println("What is the start date you would like to search?");
        String start = scnr.nextLine();
        System.out.println("What is the end date you would like to search?");
        String end = scnr.nextLine();
    }

    private static void viewNote() {
        System.out.println("What is the nid of the note that you would like to view?");
        String tempNid = scnr.nextLine();
    }

    private static void viewNotes() {
        System.out.println("What is the pid of the post that you would like to see the notes for?");
        String tempPid = scnr.nextLine();
    }

    private static void updateNote() {
        System.out.println("What is the nid of the note that you would like to update?");
        String tempNid = scnr.nextLine();
    }

    private static void createNote() {
        System.out.println("What is the pid of the post that the note will be going to?");
        String toId = scnr.nextLine();
        System.out.println("What is the description of the note?");
        String description = scnr.nextLine();
        String tempNid = Integer.toString(nid);
        nid++;
        //TODO use the toID to get the post to populate most of the data
    }

//Utility----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    private static String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime current = LocalDateTime.now();
        String dateCreated = dtf.format(current);
        return dateCreated;
    }
}