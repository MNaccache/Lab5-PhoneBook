package Lab5;
//import java.util.*;

public class ListNode { //M NACCACHE
    private String fName; //stores all the class-level variables
    private String lName;
    private String address;
    private int phoneNum;
    protected ListNode next;
    
    protected ListNode (String fName, String lName, String address, int phoneNum) { //To make a ListNode object
        this.fName = fName; //sets each class-level variable to the one just given to the class
        this.lName = lName;
        this.address = address;
        this.phoneNum = phoneNum;
        this.next = null;
    }

    protected String getFirstName () { //to access the person's first name
        return fName;
    }

    protected String getLastName () { //to access the person's last name
        return lName;
    }

    protected String getAddress () { //to access the person's address
        return address;
    }

    protected int getPhoneNumber () { //to access the person's phone number
        return phoneNum;
    }

    protected ListNode next () {
        return next;
    }

    @Override
    public String toString () { //this makes all the information in the file into a string to give to the manager class for printing reasons
        return String.format("%d -- %s %s: %s", 
                            getPhoneNumber(), getFirstName(), 
                            getLastName(), getAddress());
    }
}
