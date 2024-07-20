package Lab5;

public class TestClass {
    public static void main (String[] args) {
        PhoneBookManager Paris = new PhoneBookManager("Paris"); //Makes a phonebook for Paris
        Paris.makeGuy("Noe", "Archiviste", "Hotel Chou Chou", 18871901); //Makes a guy in the Paris phonebook
        Paris.printList(); //prints out all the people currently in the phone book

        System.out.println(); //seperating the printing out for nicely formatted output reasons

        PhoneBookManager Gevaudan = new PhoneBookManager("Gevaudan"); //making another phone book for a different city
        Gevaudan.makeGuy("Chloe", "d'Apchier", "Chateau d'Apchier", 16291916);
        Gevaudan.printList();
    }
}
