package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleAdressBook {
    static HashMap<String, AddressBook> AddressBookMap = new HashMap<String, AddressBook>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (true) {

            System.out.println("\nWhat do you want to do");
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to create a new Address Book");
            System.out.println("Enter 2 to get the names of all Address Books");
            System.out.println("Enter 3 to use an existing Address Book using the name of it");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0: {
                    exit = true;
                    break;
                }
                case 1: {
                    System.out.println("Enter the name of the Address Book to be created");
                    String name = sc.nextLine();
                    AddressBook AddressBook1 = AddressBook.createAddressBook(name);
                    AddressBookMap.put(name, AddressBook1);
                    System.out.println("Address Book created Succesfull \n");
                    break;
                }
                case 2: {
                    if (AddressBookMap.size() == 0) {
                        System.out.println("There are no Address Books currently");
                    }
                    for (Map.Entry<String, AddressBook> e : AddressBookMap.entrySet()) {
                        System.out.println(e.getKey());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter the name of the Address Book you want to use");
                    String name = sc.nextLine();

                    AddressBook AddressBook1 = AddressBookMap.get(name);
                    if (AddressBook1 == null) {
                        System.out.println("No Address Book exists with name :" + name);
                        break;
                    }
                    boolean end = false;
                    while (true) {
                        System.out.println("\nWhat do you want to do in Address Book: " + name);
                        System.out.println("Enter 0 to end ");
                        System.out.println("Enter 1 to add a contact ");
                        System.out.println("Enter 2 to get all the contacts ");
                        System.out.println("Enter 3 to update an existing contact");
                        System.out.println("Enter 4 to delete an existing contact");
                        int choice1 = sc.nextInt();
                        sc.nextLine();
                        switch (choice1) {
                            case 0: {
                                end = true;
                                break;
                            }
                            case 1: {
                                AddressBook1.addContact();
                                break;
                            }
                            case 2: {
                                AddressBook1.getContacts();
                                break;
                            }
                            case 3: {
                                AddressBook1.updateContact();
                                break;
                            }
                            case 4: {
                                AddressBook1.deleteContact();
                                break;
                            }
                            default: {
                                System.out.println("Enter a value between 0-4 ");
                                break;
                            }
                        }
                        if (end)
                            break;
                    }
                    break;
                }
                default: {
                    System.out.println("Enter a value between 0-3");
                    break;
                }
            }
            if (exit)
                break;
        }
    }
}
