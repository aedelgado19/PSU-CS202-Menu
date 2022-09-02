/* Author: Allison Delgado
 * CS 202 Summer 2021
 * This is the DLL class in which each node is an item ordered. This
 * also contains the Node class (holds a specific food or drink).
 * 
 * Last updated: aug 27, 2021
 */

//DLL class contains Node
public class DLL {
	Node head;
	
	public DLL() {
		head = null;
	}
	
	class Node {
		String food;
		Node next;
		Node previous;
		
		//constructor
		Node(String f){
			food = f;
		}
	}
	
	//insert method wrapper
	public DLL insert(String to_add) {
		insert(head, to_add);
		return this;
	}
	
	//insert method recursive
	private DLL insert(Node current, String to_add) {
		//System.out.println("inserting" + to_add);
		Node n = new Node(to_add);
		n.next = null;
		n.previous = null;
		
		//check if list is empty
		if(current == null) {
			head = n;
		} else {
			if(current.next != null) {
				insert(current.next, to_add);
			} else {
				current.next = n;
				n.previous = current;
			}
		}
		return this;
	}
	
	//remove all nodes in the DLL
	public void delete_all() {
		head = null;
	}
	
	//wrapper display
	public void display() {
		display(head);
	}
	
	//recursive display
	private void display(Node cur) {
		if(cur == null) {
			return;
		}
		System.out.println(cur.food);
		display(cur.next);
	}
	
	//returns the string at a certain index in the DLL (used for printing out options)
	public String display_at_index(int index) {
		Node cur = head;
		for(int i = 0; i < index; i++) {
			cur = cur.next;
			if(cur == null) {
				return null;
			}
		}
		return cur.food;
	}
}