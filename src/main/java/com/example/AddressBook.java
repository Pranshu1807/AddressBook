package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    public String name;

    AddressBook(String name) {
        this.name = name;
    }

    public Map<String, Contact> ContactsList = new HashMap<>();
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public void addContact() {
        Contact contact = Contact.createContact();
        String name = contact.firstName + " " + contact.lastName;
        if (ContactsList.containsKey(name)) {
            System.out.println("This person already exists");
            return;
        }
        ContactsList.put(name, contact);
    }

    public void getContacts() {
        if (ContactsList.size() == 0) {
            System.out.println("There are no contacts in the Address Book");
            return;
        }
        int i = 1;
        for (Map.Entry<String, Contact> contact : ContactsList.entrySet()) {
            System.out.println("Details of Person " + (i));
            showContact(contact.getValue());
            i++;
        }
    }

    public void showContact(Contact contact) {

        System.out.println("First Name: " + contact.firstName);
        System.out.println("Last Name: " + contact.lastName);
        System.out.println("City: " + contact.city);
        System.out.println("State: " + contact.state);
        System.out.println("Phone Number: " + contact.phoneNumber);
        System.out.println("Zip Code: " + contact.zip);
        System.out.println("Email: " + contact.email);
        System.out.println("");
    }

    public void updateContact() {
        System.out.println("Enter the First Name of the person to be searched");
        String FirstName = sc.nextLine();
        System.out.println("Enter the Last Name of the person to be searched");
        String LastName = sc.nextLine();

        String name = FirstName + " " + LastName;

        if (!ContactsList.containsKey(name)) {
            System.out.println("There is no person with this name in the address book");
            return;
        }

        System.out.println("Enter the New City ");
        ContactsList.get(name).city = sc.nextLine();
        System.out.println("Enter the New State ");
        ContactsList.get(name).state = sc.nextLine();
        System.out.println("Enter the New Phone Number ");
        ContactsList.get(name).phoneNumber = sc.nextLine();
        System.out.println("Enter the New Zip Code ");
        ContactsList.get(name).zip = sc.nextLine();
        System.out.println("Enter the New Email ");
        ContactsList.get(name).email = sc.nextLine();
        System.out.println("The updated details are:-");
        showContact(ContactsList.get(name));
    }

    public void deleteContact() {
        System.out.println("Enter the First Name of the person to be deleted");
        String FirstName = sc.nextLine();
        System.out.println("Enter the Last Name of the person to be deleted");
        String LastName = sc.nextLine();
        String name = FirstName + " " + LastName;
        if (!ContactsList.containsKey(name)) {
            System.out.println("There is no person with this name in the address book");
            return;
        }
        ContactsList.remove(name);
        System.out.println("Contact deleted Successfully");
    }

    public static AddressBook createAddressBook(String name) {
        AddressBook AddressBook1 = new AddressBook(name);
        return AddressBook1;

    }
}