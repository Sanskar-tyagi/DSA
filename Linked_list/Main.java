package Linked_list;

public class Main {

    public static class Person {

        // Data Members
        String name;
        int age;
        double height;
        long contactNum;
        String address;
    }

    public static void main(String[] args) {
        // A person here is an object class or is said to be an instance of the
        // class
        // Class allow us to create a type of variable /object with different premitive
        // data types
        Person p1 = new Person();

        // Setting the data members
        p1.name = "Sanskar";
        p1.height = 2;
        p1.age = 69;
        p1.contactNum = 69696969;
        p1.address = "DELHI";
    }
}
// Program Stack
// | |
// | |
// | |
// | |
// | |
// | |
// |_________|
// |_________| p1 (instance) -->pointing to 4k adress

// HEAP
// 4k{ name: null, height:0;etc..}