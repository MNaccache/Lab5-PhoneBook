package Lab5;

import java.util.NoSuchElementException;

public class PhoneBookManager { //M NACCACHE
    private String city; //class-level variable for printing reasons
    private ListNode guys; //will be replaced by a linked list of guys instead of just one once I set all that up

    public PhoneBookManager (String city) { //sets what city this phonebook is for 
        this.city = city; //sets the city class variable
    }

    public void makeGuy (String fName, String lName, String address, int phoneNum, ListNode next) { //Makes a new ListNode object with someone's info in it
        if (guys == null) {
            guys = new ListNode(fName, lName, address, phoneNum, next); //making new ListNode guy
        } else {
            ListNode current = guys;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(fName, lName, address, phoneNum, next); //making new ListNode guy
        }
        
    }

    public void insertGuy (int index, String fName, String lName, String address, int phoneNum) { //Makes a new ListNode object with someone's info in it
        if (guys == null) {
            guys = new ListNode(fName, lName, address, phoneNum, null); //making new ListNode guy
        } else {
            ListNode current = guys;
            index--;
            for (int i = 0; i < index; i++) { //counts through the linked list
                current = current.next;
            }
            current.next = new ListNode(fName, lName, address, phoneNum, current.next); //making new ListNode guy
        }
    }

    public void removeGuy (int index) {
        if (guys == null) { //if the list has nothing, then you can't remove anything
            throw new NoSuchElementException();
        } else if (index == 0) { //if it's at the start, then you can just skip the first one
            guys = guys.next;
        } else {
            ListNode current = guys;
            for (int i = 0; i < (index - 1); i++) { //counts through the linked list
                current = current.next;
            }
            current.next = current.next.next; //skips one of them in the middle
        }
    }

    public void changeGuy (int index, int choose, String given) {
        ListNode current = guys;
        for (int i = 0; i < index; i++) { //counts through to get to the right node
            current = current.next;
        }
        
        switch (choose) { //which one do you want to change then changes that one
            case 1:
                current.setFName(given);
                break;
            case 2:
                current.setLName(given);
                break;
            case 3:
                current.setAddress(given);
                break;
            case 4:
                int number = Integer.parseInt(given); //needs to be an int for phoneNum but it's a String
                current.setPhoneNum(number);
            default:
                System.out.println("That doesn't work, sorry!");
                break;
        }
    }

    public void printList () { //Goes through the LL and prints out each one on their own lines all nice and orderly
        System.out.println("_ " + city.toUpperCase() + " PHONE BOOK _"); //Prints out a title that will look like: _ PARIS PHONE BOOK _
        
        ListNode counter = guys;

        while (counter != null) {
            System.out.println(counter.toString()); // Prints out a guy that looks like: 123456 -- Hue Man: House, City
            counter = counter.next();
        } //You have no one left to call/Calling for help won't save you now/You must be desperate if you're looking here for your number
    }
}
