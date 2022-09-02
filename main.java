/* Author: Allison Delgado
 * CS 202 Summer 2021
 * This is a menu program to allow users to order different types of food.
 * This file acts as a testing site for the data structures and external data files
 * 
 * Last updated: aug 27, 2021
 */

import java.util.Scanner;
import java.io.*;

public class main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Sushi Central!");
		System.out.println("You can order sushi, ramen, and drinks.");
		System.out.println("What is the name for the order?");
		System.out.print("> ");
		
		String name = scanner.nextLine();
		System.out.println("Thank you, " + name + ". Beginning ordering process now.");
		System.out.println();
		Menu[] m = new Menu[3];
		m[0] = new Ramen("ramen.txt", name);
		m[1] = new Drinks("drinks.txt", name);
		m[2] = new Sushi("sushi.txt", name);
		System.out.println();
		RBT t = new RBT();
		choices(name, m, t);
		System.out.println("");
	}
	
	
	//print choices for ordering
	public static void choices(String name, Menu[] m, RBT t) {
		final int START = 10;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Select an option: ");
		System.out.println("1 - order ramen");
		System.out.println("2 - order drinks");
		System.out.println("3 - order sushi");
		System.out.println("4 - show all orders");
		System.out.println("5 - delete all orders");
		System.out.println("6 - see total price and amount of items purchased");
		System.out.println("q - quit");
		System.out.print("> ");
		String choice = scanner.nextLine();
		
		//ramen
		if(choice.equals("1")) {
			int c = START;
			int i = 0;
			while(c != 0) {
				System.out.println("");
				System.out.println("FOOD: " + m[0].dll.display_at_index(i));
				System.out.println("");
				System.out.println("Price: $8");
				System.out.println("Select an option: ");
				System.out.println("1 - order this item");
				System.out.println("2 - move on to next item");
				System.out.println("3 - see previous item");
				System.out.println("0 - quit ordering this");
				System.out.print("> ");
				c = scanner.nextInt();
				scanner.nextLine();
				if(c == 1) {
					System.out.println("Enter the quantity: ");
					int q = scanner.nextInt();
					m[0].add_to_cost(q*8); //ramen costs 8 dollars
					m[0].add_item(q);
					System.out.println("added!");
					t.insert(m[0].dll.display_at_index(i));
					scanner.nextLine();
				}
				if(c == 2) {
					if(m[0].dll.display_at_index(i+1) != null) {
						i++;
					} else {
						System.out.println("no more items in the menu!");
					}
				}
				if(c == 3) {
					if(i == 0) {
						System.out.println("no previous item :(");
						System.out.println(" ");
					} else {
						i -= 1;
					}
				} 
			}
			
			System.out.println("Would you like to continue? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m, t);
				System.out.println("");
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else if(choice.equals("2")) { //sushi
			int c = START;
			int i = 0;
			while(c != 0) {
				System.out.println("");
				System.out.println("DRINK: " + m[1].dll.display_at_index(i));
				System.out.println("");
				System.out.println("Price: $3");
				System.out.println("Select an option: ");
				System.out.println("1 - order this item");
				System.out.println("2 - move on to next item");
				System.out.println("3 - see previous item");
				System.out.println("0 - quit ordering this");
				System.out.print("> ");
				c = scanner.nextInt();
				scanner.nextLine();
				if(c == 1) {
					System.out.println("Enter the quantity: ");
					int q = scanner.nextInt();
					m[1].add_to_cost(q*3); //sushi costs 3 dollars
					m[1].add_item(q);
					System.out.println("added!");
					t.insert(m[1].dll.display_at_index(i));
					scanner.nextLine();
				}
				if(c == 2) {
					if(m[1].dll.display_at_index(i+1) != null) {
						i++;
					} else {
						System.out.println("no more items in the menu!");
					}
				}
				if(c == 3) {
					if(i == 0) {
						System.out.println("no previous item :(");
						System.out.println(" ");
					} else {
						i -= 1;
					}
				} 
			}
			System.out.println("Would you like to continue? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m, t);
				System.out.println("");
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else if(choice.equals("3")) { //sushi
			System.out.println("At any time, press 0 to quit ordering.");
			int c = START;
			int i = 0;
			while(c != 0) {
				System.out.println("");
				System.out.println("FOOD: " + m[2].dll.display_at_index(i));
				System.out.println("");
				System.out.println("Price: $2");
				System.out.println("Select an option: ");
				System.out.println("1 - order this item");
				System.out.println("2 - move on to next item");
				System.out.println("3 - see previous item");
				System.out.println("0 - quit ordering this");
				System.out.print("> ");
				c = scanner.nextInt();
				scanner.nextLine();
				if(c == 1) {
					System.out.println("Enter the quantity: ");
					int q = scanner.nextInt();
					m[2].add_to_cost(q*2); //drinks cost 2 dollars
					m[2].add_item(q);
					System.out.println("added!");
					t.insert(m[2].dll.display_at_index(i));
					scanner.nextLine();
				}
				if(c == 2) {
					if(m[2].dll.display_at_index(i+1) != null) {
						i++;
					} else {
						System.out.println("no more items in the menu!");
					}
				}
				if(c == 3) {
					if(i == 0) {
						System.out.println("no previous item :(");
						System.out.println(" ");
					} else {
						i -= 1;
					}
				} 
			}
			System.out.println("Would you like to continue? (y/n)");
			String yn = scanner.nextLine();
			if(yn.equals("y")) {
				choices(name, m, t);
				System.out.println("");
			} else {
				System.out.println("Thank you for ordering!");
			}
		} else if(choice.equals("4")) { //view
			t.display();
			choices(name, m, t);
			System.out.println("");
		} else if(choice.equals("5")) { //delete all
			t.delete();
			choices(name, m, t);
			System.out.println("");
		} else if(choice.equals("6")) { //total price
			System.out.println("Ramen price: $" + m[0].total_cost);
			System.out.println("  amount purchased: " + m[0].amount_of_items);
			System.out.println("Drinks price: $" + m[1].total_cost);
			System.out.println("  amount purchased: " + m[1].amount_of_items);
			System.out.println("Sushi price: $" + m[2].total_cost);
			System.out.println("  amount purchased: " + m[2].amount_of_items);
			System.out.println("");
			choices(name, m, t);
		} else if(choice.equals("q")){
			System.out.println("Thank you for ordering!");
		} else {
			System.out.println("That was not one of the options!");
		}
	}
}

// ------------------------- MENU CLASS ------------------------
abstract class Menu {
	int total_cost;
	String customer; //customer's name
	int amount_of_items;
	DLL dll;
	
	//constructor
	public Menu(String file_name, String name) {
		this.customer = name;
		dll = new DLL();
		File f = new File(file_name);
		Scanner s;
		try {
			s = new Scanner(f);
			int i = s.nextInt(); //amount of lines to read
			s.nextLine();
			for(int j = 0; j < i; j++) {
				dll.insert(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	//called by derived classes to add to the total cost
	//when a customer adds an item
	public void add_to_cost(int to_add) {
		total_cost += to_add;
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		total_cost -= to_remove;
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		amount_of_items += to_add;
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		amount_of_items -= to_remove;
	}
	
	public void display() {
		System.out.println("Thank you for ordering.");
	}
}

// ------------------ SUSHI CLASS ---------------------------
class Sushi extends Menu {
	public Sushi(String file_name, String customer) {
		super(file_name, customer);
	}
	
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

// -------------------- DRINKS CLASS --------------------------
class Drinks extends Menu {
	public Drinks(String file_name, String customer) {
		super(file_name, customer);
	}
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

// -------------------- RAMEN CLASS ----------------------------
class Ramen extends Menu {
	public Ramen(String file_name, String customer) {
		super(file_name, customer);
	}
	
	public void add_to_cost(int to_add) {
		super.add_to_cost(to_add);
	}
	
	//remove from cost if a user deletes a selected item
	public void remove_from_cost(int to_remove) {
		super.remove_from_cost(to_remove);
	}
	
	//add to the count of total items purchased
	public void add_item(int to_add) {
		super.add_item(to_add);
	}
	
	//remove items from the total count
	public void remove_item(int to_remove) {
		super.remove_item(to_remove);
	}
	
}

