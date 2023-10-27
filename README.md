# Zoo Management System

## Introduction:

The Zoo Management System is a Java-based application designed to manage zoos, animals, and interactions. It provides functionalities for administrators and visitors. Below, you'll find a comprehensive overview of the project, its structure, and key components.

### Welcome to the Zoo Management System:

When you run the application, you will be presented with a menu:

- Enter 1 for the Admin section (to manage animals, attractions, deals, special deals, and to view visitor statistics).
- Enter 2 for the Visitor section (to interact with animals and attractions).
- Enter 3 to view Special Deals for visitors.
- Enter 4 to exit the application.

### Administrator Section:

1. **Manage Animals:** Administrators can add, edit, or remove animals, specifying their unique identifiers, names, types, sounds, and historical information.

2. **Manage Attractions:** Administrators can add, edit, or remove attractions, including names, descriptions, ticket prices, and visitor counts.

3. **Schedule Attractions:** Administrators can schedule an attraction to be open or closed, set the price, and view the total number of visitors.

4. **Manage Discounts:** Administrators can add, view, remove or modify category and discount rate.

5. **Manage Special Deals:** Administrators can add, view, remove or modify the minimum number of attractions to visit and special deal applicable.

6. **View Visitor Stats:** Administrators can view visitor statistics, like the total number of visitors, most popular attraction, and zoo revenue.

7. **View Visitor Feedback:** Administrators can view visitor feeback.

### Visitor Section:

1. **Explore the Zoo:** Visitors can choose from a list of animals and attractions to interact with, including feeding animals and reading about their history.

2. **Purchase Membership:** Visitors can purchase zoo memberships, which is mandatory to visit animals or attractions.

3. **Purchase Tickets:** Basic Visitors can purchase tickets to the attraction after applying their coupon code and special deals.

4. **View Discounts:** Visitors can view the various discount coupons available and decide which one they can use.

5. **View Special Deals:** Visitors can view the various special deals available to them if they buy a minimum number of attraction tickets.

6. **Visit Animals:** Visitors can visit animals and choose to either feed them or read about them.

7. **Visit Attractions:** Basic Visitors can use the tickets bought to visit the attraction, whereas premium visitors can visit infinite times.

8. **Leave Feedback:** Visitors can provide feedback about their experiences, which will be recorded and can be viewed by administrators.

## Class Structures:

### Abstract Animal Class:

- Represents animals in the zoo.
- Contains attributes such as unique identifiers, names, types, sounds, and historical information.
- Provides methods to access and manipulate animal data.

#### Attributes:
- animalID: A unique identifier for each animal.
- name: The name of the animal.
- type: The type of the animal (Mammal, Reptile, Amphibian).
- sound: The sound made by the animal.
- history: Historical information about the animal.

#### Methods:
- getAnimalID(): Returns the unique identifier of the animal.
- getName(): Returns the name of the animal.
- getType(): Returns the type of the animal.
- getSound(): Returns the sound made by the animal.
- getHistory(): Returns historical information about the animal.

### Mammal Class:

- Extends the Animal class to represent mammals in the zoo.
- Inherits sound and historical information methods.

### Reptile Class:

- Extends the Animal class to represent reptiles in the zoo.
- Inherits sound and historical information methods.

### Amphibian Class:

- Extends the Animal class to represent amphibians in the zoo.
- Inherits sound and historical information methods.

### Abstract Attraction Class:

- Represents different attractions within the zoo.
- Includes information like names, descriptions, ticket prices, and visitor counts.
- Supports various methods to interact with attractions.

#### Attributes:
- attractionID: A unique identifier for each attraction.
- name: The name of the attraction.
- description: A brief description of the attraction.
- ticketPrice: The price of the attraction ticket.
- visitorCount: The total number of visitors to the attraction.

#### Methods:
- getAttractionID(): Returns the unique identifier of the attraction.
- getName(): Returns the name of the attraction.
- getDescription(): Returns the description of the attraction.
- getTicketPrice(): Returns the ticket price for the attraction.
- getVisitorCount(): Returns the total number of visitors to the attraction.

### AttractionAvailability Class:

- Implements the Availability interface to manage the availability status of attractions.
- Contains a boolean attribute, isOpen, to track whether the attraction is open or closed.
- Provides methods to check and set the attraction's availability status.

#### Attributes:
- isOpen: A boolean indicating whether the attraction is open.

#### Methods:
- isOpen(): Returns true if the attraction is open, false otherwise.
- setOpen(boolean open): Sets the availability status of the attraction.

### Visitor Class:

- Represents visitors to the zoo.
- Manages visitor information, memberships, and feedback.
- Handles functionalities like purchasing memberships, leaving feedback, and interacting with animals.

#### Attributes:
- visitorID: A unique identifier for each visitor.
- name: The name of the visitor.
- membership: The type of membership (Basic, Premium).
- feedbackList: A list of feedback provided by the visitor.

#### Methods:
- getVisitorID(): Returns the unique identifier of the visitor.
- getName(): Returns the name of the visitor.
- getMembership(): Returns the type of membership.
- getFeedbackList(): Returns a list of feedback provided by the visitor.

### Basic Membership Class:

- An implementation of Membership Interface.
- Sets the Basic Membership Cost and Basic Type of a visitor.

#### Attributes:
- cost: The cost of the basic membership.
- type: The type of membership (Basic).

#### Methods:
- getCost(): Returns the cost of the membership.
- getType(): Returns the type of membership.

### Premium Membership Class:

- An implementation of Membership Interface.
- Sets the Premium Membership Cost and Premium Type of a visitor.

#### Attributes:
- cost: The cost of the premium membership.
- type: The type of membership (Premium).

#### Methods:
- getCost(): Returns the cost of the membership.
- getType(): Returns the type of membership.

### Feedback Class:

- Stores visitor feedback, including names and feedback messages.
- Allows for the collection and retrieval of visitor feedback.

#### Attributes:
- visitorName: The name of the visitor providing feedback.
- feedback: The feedback message provided by the visitor.

#### Methods:
- getVisitorName(): Returns the name of the visitor.
- getFeedback(): Returns the feedback message.

### Zoo Class:

- Central class managing the entire zoo system.
- Contains lists of attractions, animals, visitors, memberships, and feedback.
- Provides methods for administrators to manage zoo components, visitors, and statistics.

#### Attributes:
- attractions: A list of Attraction objects representing attractions in the zoo.
- animals: A list of Animal objects representing animals in the zoo.
- visitors: A list of Visitor objects representing visitors to the zoo.
- memberships: A list of Membership objects representing visitor memberships.
- feedbackList: A list of Feedback objects representing visitor feedback.

#### Methods:
- Various methods for administrators to manage attractions, animals, and visitors.
- Methods for tracking visitor statistics and visitor interactions.

## Interfaces:

### Membership Interface:

- An interface representing different membership types.
- Concrete implementations include `BasicMembership` and `PremiumMembership`, each offering specific benefits and costs.

#### Methods:
- getCost(): Returns the cost of the membership.
- getType(): Returns the type of membership.

### Availability Interface:

- Defines methods for managing the availability of zoo attractions.
- Includes methods to check whether an attraction is open and to set its availability status.

#### Methods:
- isOpen(): Returns true if the attraction is open, false otherwise.
- setOpen(boolean open): Sets the availability status of the attraction.

## Data Structures:

The Zoo Management System uses various data structures to efficiently manage data.

1. **Lists (ArrayLists):**
    - Used to store collections of members, books, and member-fine information.
    - Members, books, and their details are stored in separate ArrayLists for easy access and management.

2. **HashSet:**
    - Used to store unique phone numbers of members to ensure uniqueness during member registration.

3. **Map (HashMap):**
    - Used to map attraction identifiers to their respective availability status for efficient management.
    - Used to map discounts with their category and special deals with their minimum number of attractions required.

## Exception Handling:

The Zoo Management System includes comprehensive exception handling to ensure smooth operation and data integrity.

- **Input Validation:** The system validates inputs for visitor characteristics, membership purchases, and attraction interactions. This validation prevents incorrect data entry and guides users to provide valid inputs.

- **Invalid Choices:** The system handles invalid menu choices with informative messages and prompts users to enter a valid option.

- **Error Handling:** In the case of unexpected errors, the system gracefully handles exceptions and provides detailed error messages to assist in issue resolution. Log files may be generated to track and diagnose errors for maintenance purposes.

## Functionality Summary:

- Visitors can interact with animals and attractions, buy memberships, and provide feedback.
- Administrators can manage animals, attractions, and view visitor statistics.
- Feedback from visitors is stored and can be viewed by administrators.

## Important Notes:

- Visitors must log in to access certain features, including purchasing memberships and providing feedback.
- Visitors must have a non-negative age and balance.
- More than 1 visitor cannot have the same email id and phone number.
- Visitors must first buy a membership.
- The coupon codes, special deals, names, attraction names and animals, all are case-sensitive.
- Admin login and password are "admin" & "admin123" (case sensitive).
- I have already hardcoded 3 Attractions and 6 Animals, 2 each of Mammal, Reptile and Amphibian.
- Admin cannot remove an animal if there are only 2 types of that animal available.
- I have also hardcoded MINOR10 and SENIOR CITIZEN20 Coupon codes to give 10% and 20% discount of membership and tickets to attractions and the visitor who applies these coupons will undergo through age validation with the age entered at the time of registration.
- Minor and Senior Citizen discount can be modified by the admin but the maximum age to avail Minor discount will always be 17 and minimum age to avail Senior Citizen discount will always be 61.
- Only Minor and Senior Citizen Category's coupon codes will go through age verification, other coupon codes will not be subjected to any verification and will directly be provided.
- I have also hardcoded Special Deals for 1 and 2 attractions to give 15% and 20% discount of tickets to attractions and the visitor will automatically have these Special Deals applied on him when he buys Tickets.
- Visitors can buy a basic membership to visit animals and also need to buy tickets to visit the attraction after buying their basic membership.
- Visitors can buy a premium membership to any attractions infinite number of times without buying tickets.
- When an admin schedules an attraction, he sees the people who have purchased tickets to the attraction and not visited it, so premium people are not included because they do not contribute to the ticket revenue of the attraction.
- Every time an attraction is rescheduled to be open, it will come again in the available attractions, so that the visitors know that it is rescheduled open.
- Membership and Ticket discounts are applied based on coupon code entered by the visitor.
- Ticket special deals are applied based on the number of tickets bought by the visitor.
- The revenue and most popular attraction will not show up in visitor stats until there is really revenue and atleast 1 attraction visited.

The Zoo Management System provides an efficient and user-friendly solution for managing zoo operations, enhancing visitor experiences, and collecting valuable feedback. Enjoy using the system for your zoo management needs!