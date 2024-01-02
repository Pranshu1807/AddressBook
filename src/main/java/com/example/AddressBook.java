package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {
    public String name;

    AddressBook(String name) {
        this.name = name;
    }

    public ArrayList<Contact> ContactsList = new ArrayList<Contact>();
    static Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public void addContact() {
        Contact contact = Contact.createContact();
        String name = contact.firstName + " " + contact.lastName;
        List<Contact> matchingPersons = ContactsList.stream()
                .filter(person -> (person.firstName + " " + person.lastName).equals(name))
                .collect(Collectors.toList());
        if (matchingPersons.size() != 0) {
            System.out.println("Contact with this name already exists");
            return;
        }
        ContactsList.add(contact);
        System.out.println("\nContact added Succesfully\n");
    }

    public void getContacts() {
        if (ContactsList.size() == 0) {
            System.out.println("There are no contacts in the Address Book");
            return;
        }
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

    public void updateContact() {
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

    public void deleteContact() {
        System.out.println("Enter the First Name of the person to be deleted");
        String FirstName = sc.nextLine();
        System.out.println("Enter the Last Name of the person to be deleted");
        String LastName = sc.nextLine();
        String targetName = FirstName + " " + LastName;
        boolean flag = ContactsList.removeIf(person -> (person.firstName + " " + person.lastName).equals(targetName));

        if (!flag)
            System.out.println("There is no person with this name in the address book");
        else
            System.out.println("Contact Deleted Succesfully");
    }

    public static AddressBook createAddressBook(String name) {
        AddressBook AddressBook1 = new AddressBook(name);
        return AddressBook1;

    }
}