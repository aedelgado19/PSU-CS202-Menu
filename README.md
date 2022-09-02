# PSU-CS202-Menu
The goal of this assignment was to create a food ordering service for a restaurant (I chose a sushi/ramen restaurant).
I implemented an abstract base class called Menu, with derived classes of Ramen, Drinks, and Sushi. The Menu base class
has dynamically bound functions to read external data files and a doubly linked list to store items. This allows the 
customer to move forward or backwards to see the ordering options.

Each individual order was required to be stored in a balanced tree, so I chose to implement a Red-Black Tree. Each node
in the RBT contains a linear linked list of what was stored in a customer's order.
