package com.example;

import java.util.ArrayList;

public class AddressBook {
    public static ArrayList<Contact> ContactsList = new ArrayList<Contact>();

    public static void addContact() {
        Contact contact = Contact.createContact();
        ContactsList.add(contact);
        System.out.println("");
    }

    public static void getContacts() {
        for (int i = 0; i < ContactsList.size(); i++) {
            Contact contact = ContactsList.get(i);
            System.out.println("Details of Person " + (i + 1));
            System.out.println("First Name: " + contact.firstName);
            System.out.println("Last Name: " + contact.lastName);
            System.out.println("City: " + contact.city);
            System.out.println("State: " + contact.state);
            System.out.println("Phone Number: " + contact.phoneNumber);
            System.out.println("Zip Code: " + contact.zip);
            System.out.println("Email: " + contact.email);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        addContact();
        getContacts();
        addContact();
        getContacts();
    }
}
