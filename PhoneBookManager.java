package Lab5;
public class PhoneBookManager { //M NACCACHE
    private String city; //class-level variable for printing reasons
    private ListNode guy; //will be replaced by a linked list of guys instead of just one once I set all that up

    public PhoneBookManager (String city) { //sets what city this phonebook is for 
        this.city = city; //sets the city class variable
    }

    public void makeGuy (String fName, String lName, String address, int phoneNum) { //Makes a new ListNode object with someone's info in it
        guy = new ListNode(fName, lName, address, phoneNum); //making new ListNode guy
    }

    //Make methods that make linked lists and add to them and remove from them and change them?????

    public void printList () { //Goes through the LL and prints out each one on their own lines all nice and orderly
        System.out.println("_ " + city.toUpperCase() + " PHONE BOOK _"); //Prints out a title that will look like: _ PARIS PHONE BOOK _
        
        ListNode counter = guy;

        while (counter != null) {
            System.out.println(counter.toString()); // Prints out a guy that looks like: 123456 -- Hue Man: House, City
            counter = counter.next();
        }
        System.out.println("Sorry -- this isn't done yet :)"); //You have no one left to call/Calling for help won't save you now/You must be desperate if you're looking here for your number
    }
}
