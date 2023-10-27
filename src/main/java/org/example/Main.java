package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //make a zoo object of Zoo class
        Zoo zoo = new Zoo();

        //make an attraction object of Attraction class
        Attraction attraction1 = new Attraction() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public void setOpen(boolean open) {

            }

            @Override
            public void welcomeMessage() {
            }
        };
        //set the attraction details
        attraction1.setAttractionID(1);
        attraction1.setName("Jungle Safari");
        attraction1.setDescription("ZOOtopia offers an adventure ride that allows you to explore unexplored trails. Buy your ticket now!");
        attraction1.setTicketPrice(10);
        attraction1.setAvailable(false);
        attraction1.setVisitorCount(0);
        zoo.addAttraction(attraction1);

        //make an attraction object of Attraction class
        Attraction attraction2 = new Attraction() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public void setOpen(boolean open) {

            }

            @Override
            public void welcomeMessage() {
            }
        };
        //set the attraction details
        attraction2.setAttractionID(2);
        attraction2.setName("Botanical Garden");
        attraction2.setDescription("ZOOtopia offers a beutiful garden that allows you to be with nature. Buy your ticket now!");
        attraction2.setTicketPrice(15);
        attraction2.setAvailable(false);
        attraction2.setVisitorCount(0);
        zoo.addAttraction(attraction2);

        //make an attraction object of Attraction class
        Attraction attraction3 = new Attraction() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public void setOpen(boolean open) {

            }

            @Override
            public void welcomeMessage() {
            }
        };
        //set the attraction details
        attraction3.setAttractionID(3);
        attraction3.setName("Dinosaur Show");
        attraction3.setDescription("ZOOtopia offers dinosaur show which is unique of its kind. Buy your ticket now!");
        attraction3.setTicketPrice(12);
        attraction3.setAvailable(false);
        attraction3.setVisitorCount(0);
        zoo.addAttraction(attraction3);

        //make an object of declared type Animal and actual type Mammal
        Animal cat = new Mammal();
        //set the cat details
        cat.setAnimalID(1);
        cat.setName("Cat");
        cat.setType("Mammal");
        cat.setDescription("Description of Cat.");
        cat.setSound("Meow");
        cat.setHistory("History of Cat.");
        zoo.addAnimal(cat);

        //make an object of declared type Animal and actual type Mammal
        Animal lion = new Mammal();
        //set the lion details
        lion.setAnimalID(2);
        lion.setName("Lion");
        lion.setType("Mammal");
        lion.setDescription("Description of Lion.");
        lion.setSound("Roar");
        lion.setHistory("History of Lion.");
        zoo.addAnimal(lion);

        //make an object of declared type Animal and actual type Amphibian
        Animal frog = new Amphibian();
        //set the frog details
        frog.setAnimalID(3);
        frog.setName("Frog");
        frog.setType("Amphibian");
        frog.setDescription("Description of Frog.");
        frog.setSound("Croak");
        frog.setHistory("History of Frog.");
        zoo.addAnimal(frog);

        //make an object of declared type Animal and actual type Amphibian
        Animal salamander = new Amphibian();
        //set the salamander details
        salamander.setAnimalID(4);
        salamander.setName("Salamander");
        salamander.setType("Amphibian");
        salamander.setDescription("Description of Salamander.");
        salamander.setSound("FIshhh");
        salamander.setHistory("History of Salamander.");
        zoo.addAnimal(salamander);

        //make an object of declared type Animal and actual type Reptile
        Animal crocodile = new Reptile();
        //set the crocodile details
        crocodile.setAnimalID(5);
        crocodile.setName("Crocodile");
        crocodile.setType("Reptile");
        crocodile.setDescription("Description of Crocodile.");
        crocodile.setSound("Crock");
        crocodile.setHistory("History of Crocodile.");
        zoo.addAnimal(crocodile);

        //make an object of declared type Animal and actual type Reptile
        Animal tortoise = new Reptile();
        //set the tortoise details
        tortoise.setAnimalID(6);
        tortoise.setName("Tortoise");
        tortoise.setType("Reptile");
        tortoise.setDescription("Description of Tortoise.");
        tortoise.setSound("Tort");
        tortoise.setHistory("History of Tortoise.");
        zoo.addAnimal(tortoise);

        System.out.println();
        System.out.println("Welcome to ZOOtopia!");

        //set MINOR10 and SENIOR CITIZEN20 discount coupons
        zoo.addDiscount("Minor", 10);
        zoo.addDiscount("Senior Citizen", 20);

        //set 15% and 30% special deals for visiting atleast 2 or 3 attractions
        zoo.addSpecialDeal(2, 15);
        zoo.addSpecialDeal(3, 30);

        while (true) {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1. Enter as Admin");
            System.out.println("2. Enter as a Visitor");
            System.out.println("3. View Special Deals");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println();
                        System.out.println("Admin Login Menu:");
                        System.out.print("Enter Admin Username: ");
                        String adminUsername = scanner.nextLine();
                        System.out.print("Enter Admin Password: ");
                        String adminPassword = scanner.nextLine();

                        //authorizing admin details
                        if (adminUsername.equals("admin") && adminPassword.equals("admin123")) {
                            System.out.println("Logged in as Admin.");
                            adminMenu(zoo, scanner);
                        } else {
                            System.out.println("Invalid username or password. Try again.");
                        }
                        break;
                    case 2:
                        visitorMenuLogin(zoo, scanner);
                        break;
                    case 3:
                        zoo.viewSpecialDeals();
                        break;
                    case 4:
                        System.out.println("Thanks for visiting Zootopia!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    private static void adminMenu(Zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Admin Menu:");
            System.out.println("1. Manage Attractions");
            System.out.println("2. Manage Animals");
            System.out.println("3. Schedule Attractions");
            System.out.println("4. Manage Discounts");
            System.out.println("5. Manage Special Deals");
            System.out.println("6. View Visitor Stats");
            System.out.println("7. View Feedback");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        //go to Zoo class method
                        zoo.manageAttractions(scanner);
                        break;
                    case 2:
                        //go to Zoo class method
                        zoo.manageAnimals(scanner);
                        break;
                    case 3:
                        //go to Zoo class method
                        zoo.viewAttractions();
                        System.out.println();
                        System.out.print("Enter attraction ID: ");
                        int attractionID = scanner.nextInt();
                        System.out.print("Enter price to set: ");
                        double price = scanner.nextDouble();
                        //go to Zoo class method
                        zoo.scheduleAttractions(attractionID, price, scanner);
                        break;
                    case 4:
                        //go to Zoo class method
                        zoo.manageDiscounts(zoo, scanner);
                        break;
                    case 5:
                        //go to Zoo class method
                        zoo.manageSpecialDeals(zoo, scanner);
                        break;
                    case 6:
                        //go to Zoo class method
                        zoo.viewVisitorStats();
                        break;
                    case 7:
                        //go to Zoo class method
                        zoo.viewFeedback();
                        break;
                    case 8:
                        System.out.println("Logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    private static void visitorMenuLogin(Zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Visitor Login Menu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        //go to Zoo class method
                        Zoo.registerVisitor(scanner);
                        break;
                    case 2:
                        boolean flag = Zoo.loginVisitor(zoo, scanner);
                        if (flag) {
                            Visitor currentVisitor = zoo.getCurrentVisitor();
                            visitorMenu(zoo, scanner, currentVisitor);
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    private static void visitorMenu(Zoo zoo, Scanner scanner, Visitor currentVisitor) {
        while (true) {
            System.out.println();
            System.out.println("Visitor Menu:");
            System.out.println("1. Explore the Zoo");
            System.out.println("2. Buy Membership");
            System.out.println("3. Buy Tickets");
            System.out.println("4. View Discounts");
            System.out.println("5. View Special Deals");
            System.out.println("6. Visit Animals");
            System.out.println("7. Visit Attractions");
            System.out.println("8. Leave Feedback");
            System.out.println("9. Log Out");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        //go to Zoo class method
                        zoo.exploreZooMenu(scanner);
                        break;
                    case 2:
                        //go to Zoo class method
                        zoo.buyMemberShip(currentVisitor, scanner);
                        break;
                    case 3:
                        //go to Zoo class method
                        zoo.buyTickets(scanner);
                        break;
                    case 4:
                        //go to Zoo class method
                        zoo.viewDiscounts();
                        break;
                    case 5:
                        //go to Zoo class method
                        zoo.viewSpecialDeals();
                        break;
                    case 6:
                        //go to Zoo class method
                        zoo.visitAnimals(currentVisitor, scanner);
                        break;
                    case 7:
                        //go to Zoo class method
                        zoo.visitAvailableAttractions(currentVisitor, scanner);
                        break;
                    case 8:
                        //go to Zoo class method
                        zoo.leaveFeedback(scanner);
                        break;
                    case 9:
                        System.out.println("Logged out.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    static void viewAttractionsMenu(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("View Attractions:");

            ArrayList<Attraction> attractions = Zoo.getAttractions();

            if (attractions.isEmpty()) {
                System.out.println("No attractions found.");
            } else {
                System.out.println();
                System.out.println("Attractions in the Zoo:");
                for (Attraction attraction : attractions) {
                    System.out.println("Attraction ID: " + attraction.getAttractionID());
                    System.out.println("Name: " + attraction.getName());
                    System.out.println("Ticket Price: " + attraction.getTicketPrice());
                    System.out.println();
                }
            }

            try {
                System.out.print("Enter Attraction ID: ");
                int attractionIdChoice = scanner.nextInt();
                scanner.nextLine();

                Attraction foundAttraction = null;
                for (Attraction attraction : attractions) {
                    if (attraction.getAttractionID() == attractionIdChoice) {
                        foundAttraction = attraction;
                        break;
                    }
                }

                if (foundAttraction != null) {
                    String description = foundAttraction.getDescription();
                    System.out.println("Attraction Description: " + description);
                } else {
                    System.out.println("Attraction not found with ID: " + attractionIdChoice);
                }
                return;
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }

    static void viewAnimalsMenu(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("View Animals:");

            ArrayList<Animal> animals = Zoo.getAnimals();
            System.out.print("Enter your choice: ");

            if (animals.isEmpty()) {
                System.out.println("No animals found.");
            } else {
                for (Animal animal : animals) {
                    System.out.println("Animal Name: " + animal.getName());
                    System.out.println("Animal Type: " + animal.getType());
                    System.out.println();
                }
            }

            try {
                System.out.print("Enter Animal Name: ");
                String animalNameChoice = scanner.nextLine();

                Animal foundAnimal = null;
                for (Animal animal : animals) {
                    if (animal.getName().equals(animalNameChoice)) {
                        foundAnimal = animal;
                        break;
                    }
                }

                if (foundAnimal != null) {
                    String description = foundAnimal.getDescription();
                    System.out.println("Animal Description: " + description);
                } else {
                    System.out.println("Animal not found with Name: " + animalNameChoice);
                }
                return;
                //catch for any non integer choice
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine();
            }
        }
    }
}