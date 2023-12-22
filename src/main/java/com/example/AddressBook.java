package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    public static ArrayList<Contact> ContactsList = new ArrayList<Contact>();
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public static void addContact() {
        Contact contact = Contact.createContact();
        ContactsList.add(contact);
        System.out.println("");
    }

    public static void getContacts() {
        for (int i = 0; i < ContactsList.size(); i++) {
            Contact contact = ContactsList.get(i);
            System.out.println("Details of Person " + (i + 1));
            showContact(contact);

        }
    }

    public static void showContact(Contact contact) {

        System.out.println("First Name: " + contact.firstName);
        System.out.println("Last Name: " + contact.lastName);
        System.out.println("City: " + contact.city);
        System.out.println("State: " + contact.state);
        System.out.println("Phone Number: " + contact.phoneNumber);
        System.out.println("Zip Code: " + contact.zip);
        System.out.println("Email: " + contact.email);
        System.out.println("");
    }

    public static void updateContact() {
        System.out.println("Enter the First Name of the person to be searched");
        String FirstName = sc.nextLine();
        System.out.println("Enter the Last Name of the person to be searched");
        String LastName = sc.nextLine();

        boolean found = false;
        for (Contact obj : ContactsList) {
            if (obj.firstName.equals(FirstName) && obj.lastName.equals(LastName)) {
                System.out.println("Enter the New First Name ");
                obj.firstName = sc.nextLine();
                System.out.println("Enter the New Last Name ");
                obj.lastName = sc.nextLine();
                System.out.println("Enter the New City ");
                obj.city = sc.nextLine();
                System.out.println("Enter the New State ");
                obj.state = sc.nextLine();
                System.out.println("Enter the New Phone Number ");
                obj.phoneNumber = sc.nextLine();
                System.out.println("Enter the New Zip Code ");
                obj.zip = sc.nextLine();
                System.out.println("Enter the New Email ");
                obj.email = sc.nextLine();
                found = true;
                System.out.println("The updated details are:-");
                showContact(obj);
                break;
            }
        }
        if (!found) {
            System.out.println("There is no person with this name in the address book");
        }
    }

    public static void main(String[] args) {

        addContact();
        getContacts();
        // addContact();
        // addContact();
        // getContacts();
        updateContact();
    }
}