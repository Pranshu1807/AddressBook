package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MultipleAdressBook {
    static HashMap<String, AddressBook> AddressBookMap = new HashMap<String, AddressBook>();

    public static List<Contact> getContactsByCity(String city) {

        List<Contact> matchedContacts = new ArrayList<>();

        for (Map.Entry<String, AddressBook> entry : AddressBookMap.entrySet()) {
            List<Contact> matchingPersons = entry.getValue().ContactsList.stream()
                    .filter(person -> (person.city).equals(city))
                    .collect(Collectors.toList());
            matchedContacts.addAll(matchingPersons);
        }
        return matchedContacts;
    }

    public static List<Contact> getContactsByState(String state) {

        List<Contact> matchedContacts = new ArrayList<>();

        for (Map.Entry<String, AddressBook> entry : AddressBookMap.entrySet()) {
            List<Contact> matchingPersons = entry.getValue().ContactsList.stream()
                    .filter(person -> (person.state).equals(state))
                    .collect(Collectors.toList());
            matchedContacts.addAll(matchingPersons);
        }
        return matchedContacts;
    }

    public static void sortByName(String Name) {
        if (!AddressBookMap.containsKey(Name)) {
            System.out.println("No address Book exists by this name");
        } else {
            Collections.sort(AddressBookMap.get(Name).ContactsList,
                    (Contact1, Contact2) -> Contact1.firstName.compareTo(Contact2.firstName));
            System.out.println("Address Book after sorting\n");
            AddressBookMap.get(Name).getContacts();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (true) {

            System.out.println("\nWhat do you want to do");
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to create a new Address Book");
            System.out.println("Enter 2 to get the names of all Address Books");
            System.out.println("Enter 3 to use an existing Address Book using the name of it");
            System.out.println("Enter 4 to search contacts using city");
            System.out.println("Enter 5 to search contacts using state");
            System.out.println("Enter 6 to number of contacts of a city");
            System.out.println("Enter 7 to number of contacts of a state");
            System.out.println("Enter 8 to sort an address book by its name");

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
                case 4: {
                    System.out.println("Enter the name of the city");
                    String city = sc.nextLine();

                    List<Contact> matchedContacts = getContactsByCity(city);
                    if (matchedContacts.size() == 0) {
                        System.out.println("No matching contacts");
                    } else {
                        int i = 1;
                        for (Contact contact : matchedContacts) {
                            System.out.println("Details of contact " + (i));
                            i++;
                            AddressBook.showContact(contact);
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter the name of the state");
                    String state = sc.nextLine();

                    List<Contact> matchedContacts = getContactsByState(state);
                    if (matchedContacts.size() == 0) {
                        System.out.println("No matching contacts");
                    } else {
                        int i = 1;
                        for (Contact contact : matchedContacts) {
                            System.out.println("Details of contact " + (i));
                            i++;
                            AddressBook.showContact(contact);
                        }
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enter the name of the city");
                    String city = sc.nextLine();

                    List<Contact> matchedContacts = getContactsByCity(city);
                    System.out.println("Number of contacts in city " + city + " is " + matchedContacts.size());
                    break;
                }
                case 7: {
                    System.out.println("Enter the name of the state");
                    String state = sc.nextLine();

                    List<Contact> matchedContacts = getContactsByState(state);
                    System.out.println("Number of contacts in state " + state + " is " + matchedContacts.size());
                    break;
                }
                case 8: {
                    System.out.println("Enter the name of the book");
                    String name = sc.nextLine();
                    sortByName(name);

                }
                default: {
                    System.out.println("Enter a value between 0-8");
                    break;
                }
            }
            if (exit)
                break;
        }
    }
}
