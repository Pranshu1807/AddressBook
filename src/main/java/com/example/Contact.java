package com.example;

import java.util.Scanner;

public class Contact {
    public String firstName, lastName, city, state, zip, phoneNumber, email;

    public Contact(String firstName, String lastName, String city, String state, String zip, String phoneNumber,
            String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter the Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter the City");
        String city = sc.nextLine();
        System.out.println("Enter the State");
        String state = sc.nextLine();
        System.out.println("Enter the zip code");
        String zip = sc.nextLine();
        System.out.println("Enter the Phone Number");
        String phoneNumber = sc.nextLine();
        System.out.println("Enter the Email");
        String email = sc.nextLine();

        Contact contact = new Contact(firstName, lastName, city, state, zip, phoneNumber, email);

        System.out.println("Address Book");
        System.out.println("First Name: " + contact.firstName);
        System.out.println("Last Name: " + contact.lastName);
        System.out.println("City: " + contact.city);
        System.out.println("State: " + contact.state);
        System.out.println("Phone Number: " + contact.phoneNumber);
        System.out.println("Zip Code: " + contact.zip);
        System.out.println("Email: " + contact.email);
    }
}
