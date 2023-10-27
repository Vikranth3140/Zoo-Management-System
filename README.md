## Assumptions

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

### HOME_FOLDER = src

All the commands should be run on the terminal in the HOME_FOLDER unless otherwise specified.

0) Download the src code folder from Classroom and unzip.
1) mvn clean 
2) mvn compile
3) mvn package
4) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args>
5) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args> 
6) For <name of the functionality>: java jar <assignment1.jar> <class-name> <args>