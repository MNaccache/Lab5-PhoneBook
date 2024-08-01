package Lab5;
import java.util.Scanner;

public class TestClass { //M NACCACHE
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Do you want predefined phonebook entries (0) or input your own (1)? ");
        int choice = input.nextInt();

        if (choice == 0) {
            predefined();
        } else if (choice == 1) {
            userInputed();
        }
        
        input.close();
    }

    public static void predefined () { //predefined mode
        PhoneBookManager Paris = new PhoneBookManager("Paris"); //Makes a phonebook for Paris
        Paris.makeGuy("Noe", "Archiviste", "The Shapeless One's Manor", 18871901, null); //Makes a guy in the Paris phonebook
        Paris.makeGuy("Vanitas", "of the Blue Moon", "Hotel Chou Chou", 21221522, null);
        Paris.makeGuy("Lucius", "Oriflame", "The Palace", 42111522, null);
        Paris.insertGuy(2, "Dominique", "de Sade", "The de Sade Manor", 83929820); //Inserts into the middle of the list
        Paris.insertGuy(3, "Louis", "de Sade", "The Shapeless One's Manor", 82734834);
        Paris.changeGuy(0, 3, "Hotel Chou Chou"); //Changes Noe's address to Hotel Chou Chou
        Paris.removeGuy(3); //deletes Louis

        PhoneBookManager Gevaudan = new PhoneBookManager("Gevaudan"); //making another phone book for a different city
        Gevaudan.makeGuy("Chloe", "d'Apchier", "Chateau d'Apchier", 16291916, null);
        Gevaudan.makeGuy("Jean-Jacques", "Chastel", "Chateau d'Apchier", 25011920, null);

        Paris.printList(); //prints out all the people currently in the phone book
        System.out.println(); //Just for the aesthetics
        Gevaudan.printList();
    }

    public static void userInputed () { //user inputted mode
        Scanner input = new Scanner(System.in);

        System.out.print("What city is your phone book for? "); //name the phone book (you can only have 1 in ui mode)
        String cityName = input.nextLine();

        PhoneBookManager city = new PhoneBookManager(cityName); //makes a phonebook object

        boolean loop = true;
        while (loop) { //loops through the menu until you quit
            loop = uiMenu(city, input);
        }
    }

    public static boolean uiMenu (PhoneBookManager city, Scanner input) { //menu
        String fName = ""; //just establishing all these variables so the computer doesn't get mad at me later
        String lName = "";
        String address = "";
        int phoneNum = 0;
        int index = 0;
        String eats = "";
        
        System.out.println("What do you want to do?"); //first menu bit
        System.out.println("(0) Exit");
        System.out.println("(1) Add person");
        System.out.println("(2) Insert person");
        System.out.println("(3) Change person");
        System.out.println("(4) Delete person");
        System.out.println("(5) Print out book");
        int choice = input.nextInt();

        switch (choice) {
            case 1://make guy
                eats = input.nextLine(); //just to eat the first thing, so it doesn't mess other things up like it enjoys doing
                System.out.print("First Name: ");
                fName = input.nextLine();
                System.out.print("Last Name: ");
                lName = input.nextLine();
                System.out.print("Address: ");
                address = input.nextLine();
                System.out.print("Phone Number: ");
                phoneNum = input.nextInt();
                city.makeGuy(fName, lName, address, phoneNum, null); //creates the guy
                System.out.println("Person created!"); //just to give some feedback to the user so they know that something happened
                return true; //keeps looping through the menu
            case 2://insert guy
                eats = input.nextLine();
                System.out.print("Index number: ");
                index = input.nextInt();
                System.out.print("First Name: ");
                fName = input.nextLine();
                System.out.print("Last Name: ");
                lName = input.nextLine();
                System.out.print("Address: ");
                address = input.nextLine();
                System.out.print("Phone Number: ");
                phoneNum = input.nextInt();
                city.insertGuy(index, fName, lName, address, phoneNum); //inserts the guy
                System.out.println("Person inserted!"); //user feedback
                return true; //keeps looping through the menu
            case 3://change guy
                eats = input.nextLine();
                System.out.print("Person's index number: ");
                index = input.nextInt();
                System.out.println("What do you want to change?");
                System.out.println("(1) First Name");
                System.out.println("(2) Last Name");
                System.out.println("(3) Address");
                System.out.println("(4) Phone Number");
                int choose = input.nextInt();
                System.out.print("What do you want to change it to? ");
                String change = input.nextLine();
                city.changeGuy(index, choose, change); //changes the guy
                System.out.println("Person changed!"); //feedback
                return true; //keep looping
            case 4://delete guy
                eats = input.nextLine();
                System.out.print("Person's index number: ");
                index = input.nextInt();
                city.removeGuy(index); //removes the guy
                System.out.println("Person removed!"); //feedback
                return true; //keep looping
            case 5://print out book
                city.printList(); //prints it out
                return true; //keep looping
            case 0://exit
                return false; //stop looping
            default:
                return true; //keep looping
        }
    } //Started making a menu, then I got too tired and decided to give up
}
