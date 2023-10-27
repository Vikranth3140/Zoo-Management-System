package org.example;

import java.util.*;
import static org.example.Main.viewAnimalsMenu;
import static org.example.Main.viewAttractionsMenu;

public class Zoo {
    //initiate object visitor of Visitor class
    private static Visitor currentVisitor;
    //ArrayList of visitors
    private static ArrayList<Visitor> visitors = new ArrayList<>();
    //ArrayList of attractions
    private static ArrayList<Attraction> attractions = new ArrayList<>();
    //ArrayList of available attractions
    private static ArrayList<Attraction> availableattractions = new ArrayList<>();
    //HashMap of discounts
    private static HashMap<String, Double> discounts = new HashMap<>();
    //ArrayList of available animals
    private static ArrayList<Animal> animals = new ArrayList<>();
    //HashMap of available special deals
    private static HashMap<Integer, Double> specialDeals = new HashMap<>();
    //ArrayList of feedbacklist
    private static ArrayList<Feedback> feedbackList = new ArrayList<>();

    public static ArrayList<Attraction> getAttractions() {
        return attractions;
    }
    public static void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }
    public static ArrayList<Attraction> getAvailableAttractions() {
        return availableattractions;
    }
    public static void addAvailableAttraction(Attraction attraction) {
        availableattractions.add(attraction);
    }

    public static void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public static ArrayList<Animal> getAnimals() {
        return animals;
    }
    public static void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }
    public static ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }
    public void setCurrentVisitor(Visitor visitor) {
        currentVisitor = visitor;
    }
    public static Visitor getCurrentVisitor() {
        return currentVisitor;
    }
    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }
    public static void registerVisitor(Scanner scanner) {
        System.out.println();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        int age;
        while (true) {
            System.out.print("Enter Age: ");
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine();
                if (age >= 0) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Age which is greater than 0.");
                }
            } else {
                System.out.println("Please Enter a Valid Age.");
                scanner.nextLine();
            }
        }

        String phoneNumber;
        boolean phoneNumberUnique = false;
        do {
            System.out.print("Enter Phone Number: ");
            phoneNumber = scanner.nextLine();
            if (isPhoneNumberUnique(phoneNumber)) {
                phoneNumberUnique = true;
            } else {
                System.out.println("Phone number is already registered. Please choose another.");
            }
        } while (!phoneNumberUnique);

        double balance;
        while (true) {
            System.out.print("Enter Balance: ");
            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
                scanner.nextLine();
                if (balance >= 0) {
                    break;
                } else {
                    System.out.println("Please Enter a Valid Balance which is greater than 0.");
                }
            } else {
                System.out.println("Please Enter a Valid Balance.");
                scanner.nextLine();
            }
        }

        String email;
        boolean emailUnique = false;
        do {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();
            if (isEmailUnique(email)) {
                emailUnique = true;
            } else {
                System.out.println("Email is already registered. Please choose another.");
            }
        } while (!emailUnique);

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        Visitor newVisitor = new Visitor(name, age, phoneNumber, balance, email, password, null);
        visitors.add(newVisitor);

        System.out.println("Registration successful.");
    }
    public static boolean isPhoneNumberUnique(String phoneNumber) {
        for (Visitor visitor : visitors) {
            if (visitor.getPhoneNumber().equals(phoneNumber)) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEmailUnique(String email) {
        for (Visitor visitor : visitors) {
            if (visitor.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }
    public static boolean loginVisitor(Zoo zoo, Scanner scanner) {
        boolean flag = false;
        boolean flag2 = false;
        System.out.println();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        for (Visitor visitor : zoo.getVisitors()) {
            if (visitor.getEmail().equals(email) && visitor.getPassword().equals(password)) {
                System.out.println("Login successful. Welcome, " + visitor.getName() + "!");
                zoo.setCurrentVisitor(visitor);
                flag = true;
                flag2 = true;
                break;
            }
        }

        if (!flag2) {
            System.out.println("Invalid email or password.");
        }

        return flag;
    }

    public static void manageAttractions(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Manage Attractions:");
            System.out.println("1. Add Attraction");
            System.out.println("2. View Attractions");
            System.out.println("3. Modify Attraction");
            System.out.println("4. Remove Attraction");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAttraction(scanner);
                    break;
                case 2:
                    viewAttractions();
                    break;
                case 3:
                    modifyAttraction(scanner);
                    break;
                case 4:
                    removeAttraction(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void addAttraction(Scanner scanner) {
        System.out.println();
        System.out.print("Enter Attraction Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Attraction Description: ");
        String description = scanner.nextLine();

        int attractionID = attractions.isEmpty() ? 1 : attractions.get(attractions.size() - 1).getAttractionID() + 1;

        Attraction newAttraction = new Attraction() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public void setOpen(boolean open) {

            }

            @Override
            public void welcomeMessage() {
                System.out.println("Welcome to " + name + "!");
            }
        };
        newAttraction.setName(name);
        newAttraction.setDescription(description);
        newAttraction.setAttractionID(attractionID);
        newAttraction.setAvailable(false);

        attractions.add(newAttraction);
        System.out.println("Attraction added successfully.");
    }
    public static void viewAttractions() {
        System.out.println();
        System.out.println("Attractions in the Zoo:");
        for (Attraction attraction : attractions) {
            System.out.println(attraction.getAttractionID() + ". " + attraction.getName());
        }
    }
    public static void visitAvailableAttractions(Visitor visitor, Scanner scanner) {
        System.out.println();
        System.out.println("Available Attractions in the Zoo:");

        if (availableattractions.isEmpty()) {
            System.out.println("No attractions found in the zoo.");
            return;
        }

        for (Attraction attraction : availableattractions) {
            System.out.println(attraction.getAttractionID() + ". " + attraction.getName());
        }

        System.out.print("Enter the Attraction ID to visit: ");
        int attractionIDChoice = scanner.nextInt();
        scanner.nextLine();

        Attraction selectedAttraction = null;
        for (Attraction attraction : availableattractions) {
            if (attraction.getAttractionID() == attractionIDChoice) {
                selectedAttraction = attraction;
                break;
            }
        }

        if (visitor.getMembership() == null) {
            System.out.println("You do not even have a membership. Please buy a membership and then a ticket first.");
        } else {
            if (selectedAttraction != null) {
                if (visitor.getMembership().getMembershipType().equals("Basic")) {
                    if (visitor.hasTicketForAttraction(attractionIDChoice)) {
                        visitor.removeVisitorAttractionTicket(attractionIDChoice);
                        System.out.println("You have visited " + selectedAttraction.getName());
                    } else {
                        System.out.println("You don't have a ticket to visit this attraction.");
                    }
                } else if (visitor.getMembership().getMembershipType().equals("Premium")) {
                    System.out.println("You have visited " + selectedAttraction.getName());
                } else {
                    System.out.println("You don't have the required membership to visit this attraction.");
                }
            } else {
                System.out.println("Attraction not found with ID: " + attractionIDChoice);
            }
        }
    }
    public static void modifyAttraction(Scanner scanner) {
        viewAttractions();
        System.out.println();
        System.out.print("Enter the Attraction ID to modify: ");
        int attractionID = scanner.nextInt();
        scanner.nextLine();

        Attraction attractionToModify = null;
        for (Attraction attraction : attractions) {
            if (attraction.getAttractionID() == attractionID) {
                attractionToModify = attraction;
                break;
            }
        }

        if (attractionToModify == null) {
            System.out.println("Attraction with ID " + attractionID + " not found.");
            return;
        }

        System.out.println();
        System.out.print("Enter new Attraction Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Attraction Description: ");
        String newDescription = scanner.nextLine();

        attractionToModify.setName(newName);
        attractionToModify.setDescription(newDescription);

        System.out.println("Attraction modified successfully.");
    }
    public static void removeAttraction(Scanner scanner) {
        viewAttractions();
        System.out.print("Enter the Attraction ID to remove: ");
        int attractionID = scanner.nextInt();
        scanner.nextLine();

        Attraction attractionToRemove = null;
        for (Attraction attraction : attractions) {
            if (attraction.getAttractionID() == attractionID) {
                attractionToRemove = attraction;
                break;
            }
        }

        if (attractionToRemove == null) {
            System.out.println("Attraction with ID " + attractionID + " not found.");
            return;
        }

        attractions.remove(attractionToRemove);
        System.out.println("Attraction removed successfully.");
    }

    public static void manageAnimals(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Manage Animals:");
            System.out.println("1. Add Animal");
            System.out.println("2. View Animals");
            System.out.println("3. Modify Animal");
            System.out.println("4. Remove Animal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addAnimal(scanner);
                    break;
                case 2:
                    viewAnimals();
                    break;
                case 3:
                    modifyAnimal(scanner);
                    break;
                case 4:
                    removeAnimal(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void addAnimal(Scanner scanner) {
        System.out.println();
        System.out.print("Enter Animal Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Animal Type: ");
        String type = scanner.nextLine();
        System.out.print("Enter Animal Description: ");
        String description = scanner.nextLine();
        System.out.print("Enter Animal Sound: ");
        String sound = scanner.nextLine();

        int animalID = animals.isEmpty() ? 1 : animals.get(animals.size() - 1).getAnimalID() + 1;

        Animal newAnimal;

        if (type.equals("Mammal")) {
            newAnimal = new Mammal();
        } else if (type.equals("Amphibian")) {
            newAnimal = new Amphibian();
        } else if (type.equals("Reptile")) {
            newAnimal = new Reptile();
        } else {
            System.out.println("Invalid animal type. Animal not added.");
            return;
        }

        newAnimal.setName(name);
        newAnimal.setType(type);
        newAnimal.setDescription(description);
        newAnimal.setSound(sound);
        newAnimal.setAnimalID(animalID);

        animals.add(newAnimal);
        System.out.println("Animal added successfully.");
    }
    public static void viewAnimals() {
        System.out.println();
        System.out.println("Animals in the Zoo:");
        for (Animal animal : animals) {
            System.out.println(animal.getAnimalID() + ". " + animal.getName() + " - Type: " + animal.getType());
        }
    }
    public static void modifyAnimal(Scanner scanner) {
        viewAnimals();
        System.out.println();
        System.out.print("Enter the Animal ID to modify: ");
        int animalID = scanner.nextInt();
        scanner.nextLine();

        Animal animalToModify = null;
        for (Animal animal : animals) {
            if (animal.getAnimalID() == animalID) {
                animalToModify = animal;
                break;
            }
        }

        if (animalToModify == null) {
            System.out.println("Animal with ID " + animalID + " not found.");
            return;
        }

        System.out.println();
        System.out.print("Enter new Animal Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new Animal Type: ");
        String newType = scanner.nextLine();
        System.out.print("Enter new Animal Description: ");
        String newDescription = scanner.nextLine();
        System.out.print("Enter new Animal Sound: ");
        String newSound = scanner.nextLine();

        if (newType.equals("Mammal") || newType.equals("Reptile") || newType.equals("Amphibian")) {
            animalToModify.setName(newName);
            animalToModify.setType(newType);
            animalToModify.setDescription(newDescription);
            animalToModify.setSound(newSound);
            System.out.println("Animal modified successfully.");
        } else {
            System.out.println("Invalid animal type. Animal type not modified.");
        }
    }
    public static void removeAnimal(Scanner scanner) {
        System.out.println();
        viewAnimals();
        System.out.println();
        System.out.print("Enter the Animal ID to remove: ");
        int animalID = scanner.nextInt();
        scanner.nextLine();

        Animal animalToRemove = null;
        for (Animal animal : animals) {
            if (animal.getAnimalID() == animalID) {
                animalToRemove = animal;
                break;
            }
        }

        if (animalToRemove == null) {
            System.out.println("Animal with ID " + animalID + " not found.");
            return;
        }

        if (animalToRemove instanceof Mammal || animalToRemove instanceof Reptile || animalToRemove instanceof Amphibian) {
            int availableAnimalCount = 0;
            for (Animal animal : animals) {
                if (animalToRemove.getClass().equals(animal.getClass())) {
                    availableAnimalCount++;
                }
            }

            if (availableAnimalCount <= 2) {
                System.out.println("You can't remove " + animalToRemove.getName() + " because there are only 2 " + animalToRemove.getType() + "s available.");
            } else {
                animals.remove(animalToRemove);
                System.out.println(animalToRemove.getName() + " removed successfully.");
            }
        }
    }

    public static void scheduleAttractions(int attractionID, double ticketPrice, Scanner scanner) {
        boolean flag = false;

        for (Attraction existingAttraction : attractions) {
            if (existingAttraction.getAttractionID() == attractionID) {
                flag = true;
                existingAttraction.setTicketPrice(ticketPrice);

                System.out.println();
                System.out.println("Attraction " + existingAttraction.getName() + " has a ticket price of ₹" + ticketPrice);
                System.out.println();

                if (!existingAttraction.getAvailable()) {
                    System.out.println(existingAttraction.getName() + " is Closed.");
                } else {
                    System.out.println(existingAttraction.getName() + " is Open.");
                }

                System.out.print("Set availability for this attraction (1 for Open, 0 for Closed): ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addAvailableAttraction(existingAttraction);
                        existingAttraction.setAvailable(true);
                        System.out.println("Availability: Open");
                        break;
                    case 0:
                        existingAttraction.setAvailable(false);
                        System.out.println("Availability: Closed");
                        break;
                    default:
                        System.out.println("Please Enter 0 or 1");
                }

                int visitorCount = existingAttraction.getVisitorCount();
                System.out.println();
                System.out.println("Number of visitors who purchased tickets for this attraction: " + visitorCount);
                return;
            }
        }

        if (!flag) {
            System.out.println("Please Enter a valid Attraction ID.");
        }
    }

    public static void manageDiscounts(Zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Manage Discounts:");
            System.out.println("1. Add Discount");
            System.out.println("2. View Discount");
            System.out.println("3. Modify Discount");
            System.out.println("4. Remove Discounts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter discount rate: ");
                    double discountRate = scanner.nextDouble();
                    scanner.nextLine();

                    if (zoo.addDiscount(category, discountRate)) {
                        System.out.println("Discount added successfully!");
                    } else {
                        System.out.println("A discount with the same category already exists.");
                    }
                    break;
                case 2:
                    zoo.viewDiscounts();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Modify Discount:");
                    System.out.print("Enter category to modify: ");
                    String categoryToModify = scanner.nextLine();

                    if (zoo.discountExists(categoryToModify)) {
                        System.out.print("Enter the new discount rate: ");
                        double newDiscountRate = scanner.nextDouble();
                        scanner.nextLine();

                        zoo.modifyDiscount(categoryToModify, newDiscountRate);
                        System.out.println("Discount modified successfully!");
                    } else {
                        System.out.println("No such discount category found.");
                    }
                    break;
                case 4:
                    System.out.println("Discount Rates:");
                    for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                        System.out.println("Category: " + entry.getKey());
                        System.out.println("Discount Percentage: " + entry.getValue() + "%");
                    }
                    System.out.print("Enter category to remove: ");
                    String categoryToRemove = scanner.nextLine();
                    zoo.removeDiscount(categoryToRemove);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static boolean addDiscount(String category, double discountRate) {
        if (!discounts.containsKey(category)) {
            discounts.put(category, discountRate);
            return true;
        }
        return false;
    }
    private static String generateCouponCode(String category, double discountRate) {
        String categoryUppercase = category.toUpperCase();
        String couponCode = categoryUppercase + (int) discountRate;
        return couponCode;
    }
    public static void viewDiscounts() {
        System.out.println();
        System.out.println("Available Discounts:");
        for (Map.Entry<String, Double> entry : discounts.entrySet()) {
            String couponCode = generateCouponCode(entry.getKey(), entry.getValue());
            System.out.println(entry.getKey() + " Category" + " can avail " + entry.getValue() + "% discount" + " using Coupon Code: " + couponCode);
        }
    }
    public static void modifyDiscount(String category, double newDiscountRate) {
        discounts.put(category, newDiscountRate);
    }
    public static boolean discountExists(String category) {
        return discounts.containsKey(category);
    }
    public static void removeDiscount(String category) {
        if (discounts.containsKey(category)) {
            discounts.remove(category);
            System.out.println("Discount removed successfully!");
        } else {
            System.out.println("No such discount category found.");
        }
    }

    public static void manageSpecialDeals(Zoo zoo, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Manage Special Deals:");
            System.out.println("1. Add Special Deal");
            System.out.println("2. View Special Deals");
            System.out.println("3. Modify Special Deal");
            System.out.println("4. Remove Special Deal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter the minimum attractions required: ");
                    int minAttractions = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter the discount percentage: ");
                    double dealDiscountRate = scanner.nextDouble();
                    scanner.nextLine();

                    if (zoo.addSpecialDeal(minAttractions, dealDiscountRate)) {
                        System.out.println("Special Deal added successfully!");
                    } else {
                        System.out.println("A special deal with the same minimum attractions already exists.");
                    }
                    break;
                case 2:
                    zoo.viewSpecialDeals();
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Modify Special Deal:");
                    System.out.print("Enter the minimum attractions required to modify: ");
                    int minAttractionsToModify = scanner.nextInt();
                    scanner.nextLine();

                    if (zoo.specialDealExists(minAttractionsToModify)) {
                        System.out.print("Enter the new discount percentage: ");
                        double newDiscountRate = scanner.nextDouble();
                        scanner.nextLine();

                        zoo.modifySpecialDeal(minAttractionsToModify, newDiscountRate);
                        System.out.println("Special Deal modified successfully!");
                    } else {
                        System.out.println("No such special deal found.");
                    }
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Special Deals:");
                    for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
                        System.out.println("Minimum Attractions Required: " + entry.getKey());
                        System.out.println("Discount Percentage: " + entry.getValue() + "%");
                    }
                    System.out.print("Enter the minimum attractions required: ");
                    int minAttractionsRemoval = scanner.nextInt();
                    zoo.removeSpecialDeal(minAttractionsRemoval);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static boolean addSpecialDeal(int minAttractions, double discountRate) {
        if (!specialDeals.containsKey(minAttractions)) {
            specialDeals.put(minAttractions, discountRate);
            return true;
        }
        return false;
    }
    public static void viewSpecialDeals() {
        System.out.println();
        System.out.println("Special Deals:");
        for (Map.Entry<Integer, Double> entry : specialDeals.entrySet()) {
            System.out.println("Buy more than " + entry.getKey() + " attractions and get a " + entry.getValue() + "% discount.");
        }
    }
    public static void modifySpecialDeal(int minAttractions, double newDiscountRate) {
        specialDeals.put(minAttractions, newDiscountRate);
    }
    public static boolean specialDealExists(int minAttractions) {
        return specialDeals.containsKey(minAttractions);
    }
    public static void removeSpecialDeal(int minAttractions) {
        if (specialDeals.containsKey(minAttractions)) {
            specialDeals.remove(minAttractions);
            System.out.println();
            System.out.println("Special Deal removed successfully!");
        } else {
            System.out.println("No such special deal found.");
        }
    }
    public static void exploreZooMenu(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Explore the Zoo:");
            System.out.println("1. View Attractions");
            System.out.println("2. View Animals");
            System.out.println("3. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewAttractionsMenu(scanner);
                    break;
                case 2:
                    viewAnimalsMenu(scanner);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void buyMemberShip(Visitor currentVisitor, Scanner scanner) {
        if (currentVisitor != null) {
            System.out.println();
            System.out.println("Choose a membership type:");
            System.out.println("1. Basic Membership");
            System.out.println("2. Premium Membership");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            Membership membership;

            switch (choice) {
                case 1:
                    if (currentVisitor.getMembership() == null || currentVisitor.getMembership().getMembershipType().equals("Premium")) {
                        membership = new BasicMembership();

                        System.out.println();
                        viewDiscounts();
                        System.out.println();
                        System.out.print("Enter Coupon Code to receive a discount, else type None: ");
                        String couponCode = scanner.nextLine();

                        if (couponCode.equals("None")) {
                            if (currentVisitor.getBalance() >= BasicMembership.getMembershipCost) {
                                currentVisitor.setMembership(membership);
                                currentVisitor.setBalance(currentVisitor.getBalance() - currentVisitor.getMembership().getMembershipCost());
                                currentVisitor.setCost(currentVisitor.getMembership().getMembershipCost());
                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with no discount. Your balance is ₹" + currentVisitor.getBalance());
                            } else {
                                System.out.println("Insufficient balance to purchase basic membership with no discount.");
                            }
                        } else {
                            boolean couponValid = false;
                            for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                                if (couponCode.equals(generateCouponCode(entry.getKey(), entry.getValue()))) {
                                    if (entry.getKey().equals("Minor")) {
                                        if (currentVisitor.getAge() < 18) {
                                            double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                            if (currentVisitor.getBalance() >= discountedCost) {
                                                currentVisitor.setMembership(membership);
                                                currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                                currentVisitor.setCost(discountedCost);
                                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                            } else {
                                                System.out.println("Insufficient balance to purchase basic membership with a " + entry.getKey() + " discount.");
                                            }
                                        } else {
                                            System.out.println("You are not eligible for the coupon code as your age is not less than 18 years.");
                                        }
                                        couponValid = true;
                                        break;
                                    } else if (entry.getKey().equals("Senior Citizen")) {
                                        if (currentVisitor.getAge() > 60) {
                                            double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                            if (currentVisitor.getBalance() >= discountedCost) {
                                                currentVisitor.setMembership(membership);
                                                currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                                currentVisitor.setCost(discountedCost);
                                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                                couponValid = true;
                                                break;
                                            } else {
                                                System.out.println("Insufficient balance to purchase basic membership with a " + entry.getKey() + " discount.");
                                                couponValid = true;
                                                break;
                                            }
                                        } else {
                                            System.out.println("You are not eligible for the coupon code as your age is not more than 60 years.");
                                            couponValid = true;
                                            break;
                                        }
                                    } else {
                                        double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                        if (currentVisitor.getBalance() >= discountedCost) {
                                            currentVisitor.setMembership(membership);
                                            currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                            currentVisitor.setCost(discountedCost);
                                            System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                            couponValid = true;
                                            break;
                                        } else {
                                            System.out.println("Insufficient balance to purchase basic membership with a " + entry.getKey() + " discount.");
                                            couponValid = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!couponValid) {
                                System.out.println("Invalid Coupon. Please enter proper coupon code.");
                            }
                        }
                    } else {
                        System.out.println("You are already a basic member.");
                    }
                    break;
                case 2:
                    if (currentVisitor.getMembership() == null || currentVisitor.getMembership().getMembershipType().equals("Basic")) {
                        membership = new PremiumMembership();

                        System.out.println();
                        viewDiscounts();
                        System.out.println();
                        System.out.print("Enter Coupon Code to receive a discount, else type None: ");
                        String couponCode = scanner.nextLine();

                        if (couponCode.equals("None")) {
                            if (currentVisitor.getBalance() >= PremiumMembership.getMembershipCost) {
                                currentVisitor.setMembership(membership);
                                currentVisitor.setBalance(currentVisitor.getBalance() - currentVisitor.getMembership().getMembershipCost());
                                currentVisitor.setCost(currentVisitor.getMembership().getMembershipCost());
                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with no discount. Your balance is ₹" + currentVisitor.getBalance());
                            } else {
                                System.out.println("Insufficient balance to purchase premium membership with no discount.");
                            }
                        } else {
                            boolean couponValid = false;
                            for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                                if (couponCode.equals(generateCouponCode(entry.getKey(), entry.getValue()))) {
                                    if (entry.getKey().equals("Minor")) {
                                        if (currentVisitor.getAge() < 18) {
                                            double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                            if (currentVisitor.getBalance() >= discountedCost) {
                                                currentVisitor.setMembership(membership);
                                                currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                                currentVisitor.setCost(discountedCost);
                                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                                couponValid = true;
                                                break;
                                            } else {
                                                System.out.println("Insufficient balance to purchase premium membership with a " + entry.getKey() + " discount.");
                                                couponValid = true;
                                                break;
                                            }
                                        } else {
                                            System.out.println("You are not eligible for the coupon code as your age is not less than 18 years.");
                                            couponValid = true;
                                            break;
                                        }
                                    } else if (entry.getKey().equals("Senior Citizen")) {
                                        if (currentVisitor.getAge() > 60) {
                                            double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                            if (currentVisitor.getBalance() >= discountedCost) {
                                                currentVisitor.setMembership(membership);
                                                currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                                currentVisitor.setCost(discountedCost);
                                                System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                                couponValid = true;
                                                break;
                                            } else {
                                                System.out.println("Insufficient balance to purchase premium membership with a " + entry.getKey() + " discount.");
                                                couponValid = true;
                                                break;
                                            }
                                        } else {
                                            System.out.println("You are not eligible for the coupon code as your age is not more than 60 years.");
                                            couponValid = true;
                                            break;
                                        }
                                    } else {
                                        double discountedCost = membership.getMembershipCost() * ((100 - entry.getValue()) / 100);
                                        if (currentVisitor.getBalance() >= discountedCost) {
                                            currentVisitor.setMembership(membership);
                                            currentVisitor.setBalance(currentVisitor.getBalance() - discountedCost);
                                            currentVisitor.setCost(discountedCost);
                                            System.out.println("You have successfully purchased a " + membership.getMembershipType() + " Membership with a " + entry.getKey() + " discount. Your balance is ₹" + currentVisitor.getBalance());
                                            couponValid = true;
                                            break;
                                        } else {
                                            System.out.println("Insufficient balance to purchase premium membership with a " + entry.getKey() + " discount.");
                                            couponValid = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!couponValid) {
                                System.out.println("Invalid Coupon. Please enter proper coupon code.");
                            }
                        }
                    } else {
                        System.out.println("You are already a premium member.");
                    }
                    break;
            }
        } else {
            System.out.println("No visitor logged in. Please log in as a visitor first.");
        }
    }
    public static void buyTickets(Scanner scanner) {
        System.out.println();
        System.out.println("Buy Tickets:");

        Visitor currentVisitor = getCurrentVisitor();

        if (currentVisitor == null) {
            System.out.println("No visitor logged in. Please log in as a visitor first.");
            return;
        }

        if (currentVisitor.getMembership() == null) {
            System.out.println("You do not have a membership. Please buy a Membership first.");
            return;
        }

        if (currentVisitor.getMembership().getMembershipType() != null && currentVisitor.getMembership().getMembershipType().equals("Premium")) {
            System.out.println("You are a premium member and do not need to purchase tickets.");
            return;
        }

        if (currentVisitor.getMembership().getMembershipType() != null && currentVisitor.getMembership().getMembershipType().equals("Basic")) {
            ArrayList<Attraction> availableattractions = getAvailableAttractions();

            if (availableattractions.isEmpty()) {
                System.out.println("No attractions found.");
                return;
            }

            System.out.println("Attractions in the Zoo:");
            for (Attraction availableattraction : availableattractions) {
                System.out.println("Attraction ID: " + availableattraction.getAttractionID());
                System.out.println("Name: " + availableattraction.getName());
                System.out.println("Ticket Price: ₹" + availableattraction.getTicketPrice());
                System.out.println();
            }

            System.out.print("Enter Attraction ID to purchase a ticket: ");
            int attractionIdChoice = scanner.nextInt();
            scanner.nextLine();

            Attraction foundAttraction = null;
            for (Attraction availableattraction : availableattractions) {
                if (availableattraction.getAttractionID() == attractionIdChoice) {
                    foundAttraction = availableattraction;
                    break;
                }
            }

            if (foundAttraction != null) {
                System.out.print("Enter number of tickets to buy: ");
                int numberTickets = scanner.nextInt();
                scanner.nextLine();

                double ticketPrice = foundAttraction.getTicketPrice();

                System.out.println();
                viewDiscounts();
                System.out.println();
                System.out.print("Enter Coupon Code to receive a discount, else type None: ");
                String couponCode = scanner.nextLine();

                double totalCost = 0;
                boolean couponValid = false;

                if (couponCode.equals("None")) {
                    totalCost = numberTickets * ticketPrice;
                } else {
                    for (Map.Entry<String, Double> entry : discounts.entrySet()) {
                        if (couponCode.equals(generateCouponCode(entry.getKey(), entry.getValue()))) {
                            if (entry.getKey().equals("Minor")) {
                                if (currentVisitor.getAge() < 18) {
                                    double discount = entry.getValue();
                                    totalCost = numberTickets * foundAttraction.getTicketPrice() * ((100 - discount) / 100);
                                } else {
                                    System.out.println("You are not eligible for the coupon code as your age is not less than 18 years.");
                                }
                            } else if (entry.getKey().equals("Senior Citizen")) {
                                if (currentVisitor.getAge() > 60) {
                                    double discount = entry.getValue();
                                    totalCost = numberTickets * foundAttraction.getTicketPrice() * ((100 - discount) / 100);
                                } else {
                                    System.out.println("You are not eligible for the coupon code as your age is not more than 60 years.");
                                }
                            } else {
                                double discount = entry.getValue();
                                totalCost = numberTickets * foundAttraction.getTicketPrice() * ((100 - discount) / 100);
                            }
                            couponValid = true;
                            break;
                        }
                    }
                    if (!couponValid) {
                        System.out.println("Invalid Coupon Code. Please enter a proper coupon code.");
                        return;
                    }
                }

                System.out.println();
                viewSpecialDeals();
                System.out.println();
                double totalCostFinal = 0;
                if (specialDeals.containsKey(numberTickets)) {
                    double specialDealDiscount = specialDeals.get(numberTickets);
                    totalCostFinal = totalCost * ((100 - specialDealDiscount) / 100.0);
                }

                if (currentVisitor.getBalance() >= totalCostFinal) {
                    currentVisitor.addVisitorAttractionTicket(attractionIdChoice, numberTickets);
                    currentVisitor.setBalance(currentVisitor.getBalance() - totalCostFinal);
                    currentVisitor.setTickets(currentVisitor.getTickets() + numberTickets);
                    currentVisitor.setCost(currentVisitor.getCost() + totalCost);

                    System.out.println(numberTickets + " tickets purchased for " + foundAttraction.getName() + " at ₹" + ticketPrice + " each. Total cost: ₹" + totalCostFinal + ". Remaining balance: ₹" + currentVisitor.getBalance());

                    foundAttraction.increaseVisitorCount();
                } else {
                    System.out.println("Insufficient balance to purchase the tickets.");
                }
            } else {
                System.out.println("Incorrect Attraction ID Entered. Please try again.");
            }
        }
    }
    public static void visitAnimals(Visitor visitor, Scanner scanner) {
        System.out.println();
        System.out.println("Choose an animal to visit:");
        ArrayList<Animal> animals = getAnimals();

        if (animals.isEmpty()) {
            System.out.println("No animals found in the zoo.");
            return;
        }

        for (Animal animal : animals) {
            System.out.println(animal.getAnimalID() + ". " + animal.getName() + " - Type: " + animal.getType());
        }

        System.out.print("Enter the Animal ID to visit: ");
        int animalIDChoice = scanner.nextInt();
        scanner.nextLine();

        Animal selectedAnimal = null;
        for (Animal animal : animals) {
            if (animal.getAnimalID() == animalIDChoice) {
                selectedAnimal = animal;
                break;
            }
        }

        if (visitor.getMembership() == null) {
            System.out.println("You do not even have a membership. Please buy a membership first.");
            return;
        } else {
            if (selectedAnimal != null) {
                System.out.println("You are visiting " + selectedAnimal.getName());

                System.out.println();
                System.out.println("Visit Animal Menu");
                System.out.println("1. Feed the animal");
                System.out.println("2. Read about the animal");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("You fed the " + selectedAnimal.getName());
                        System.out.println(selectedAnimal.getSound());
                        break;
                    case 2:
                        System.out.println(selectedAnimal.getHistory());
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                System.out.println("Animal not found with ID: " + animalIDChoice);
            }
        }
    }
    public static void viewVisitorStats() {
        int totalVisitors = Zoo.getVisitors().size();
        System.out.println();
        System.out.println("Visitor Statistics:");
        System.out.println("Total Number of Visitors: " + totalVisitors);

        double totalRevenue = 0;
        for (Visitor visitor : Zoo.getVisitors()) {
            if (visitor.getMembership() != null) {
                totalRevenue += visitor.getCost();
            }
        }
        System.out.println("Total Revenue of the Zoo: ₹" + totalRevenue);

        Attraction mostVisitedAttraction = null;
        int maxVisitorCount = 0;
        for (Attraction attraction : Zoo.getAttractions()) {
            if (attraction.getVisitorCount() > maxVisitorCount) {
                maxVisitorCount = attraction.getVisitorCount();
                mostVisitedAttraction = attraction;
            }
        }
        if (mostVisitedAttraction != null) {
            System.out.println("Attraction with the Highest Number of Visitors: " + mostVisitedAttraction.getName());
            System.out.println("Number of Visitors: " + mostVisitedAttraction.getVisitorCount());
        }
    }
    public static void leaveFeedback(Scanner scanner) {
        System.out.println();
        System.out.println("Provide Feedback:");
        System.out.print("Enter your feedback message: ");
        String feedbackMessage = scanner.nextLine();

        Feedback feedback = new Feedback(currentVisitor.getName(), feedbackMessage);
        feedbackList.add(feedback);
        System.out.println("Feedback submitted successfully.");
    }
    public static void viewFeedback() {
        System.out.println("Feedback from Visitors:");
        for (Feedback feedback : feedbackList) {
            System.out.println("Visitor: " + feedback.getVisitorName());
            System.out.println("Feedback: " + feedback.getFeedback());
            System.out.println();
        }
    }
}