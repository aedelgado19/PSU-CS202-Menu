/* Author: Allison Delgado
 * CS 202 Summer 2021
 * This class contains the RBT (red black tree) class in which each
 * node contains a LLL of an order. The classes are nested so that 
 * they are only able to be accessed by the classes that need to access them.
 * 
 * Last updated: aug 27, 2021
 */

//RBT class: contains B_Node, LLL, L_Node
class RBT {
	final int RED = 1;
	final int BLACK = 2;
	B_Node root;

	//B_Node class: contains LLL, L_Node
	class B_Node {
		B_Node parent;
		B_Node left;
		B_Node right;
		int color;
		LLL order;
	
		public B_Node() {
			parent = null;
			left = null;
			right = null;
			color = RED;
			order = new LLL(); 
		}
		
		// LLL  class: contains L_Node
		class LLL{
			L_Node head;
			
			public LLL() {
				head = null;
			}
			
			public void insert(String food) {
				head = insert(food, head);
			}
			
			private L_Node insert(String food, L_Node cur) {
				if(cur == null) {
					L_Node node = new L_Node(food);
					return node;
				} 
				cur.next = insert(food, cur.next);
				return cur;
			}
			
			public char key() {
				return head.data.charAt(0);
			}
			
			//wrapper display
			public void display() {
				display(head);
			}
			
			//recursive display
			private void display(L_Node cur) {
				if(cur == null) {
					return;
				}
				System.out.println(cur.data);
				display(cur.next);
			}
			
			
			//delete the whole LLL
			public L_Node delete() {
				head = null;
				return head;
			}
			
			//class for the L_Node
			class L_Node {
				String data;
				L_Node next;
				
				L_Node(String d){
					this.data = d;
				}
			}
		}
		
	}
	
	//deletes the whole tree
	public void delete() {
		root = null;
	}
	
	//wrapper insert
	public void insert(String food) {
		root = insert(food, this.root);
	}
	
	//insert a new node
	private B_Node insert(String food, B_Node cur) {
		//new root
		if(cur == null) {
			cur = new B_Node();
			cur.order.insert(food);
			return cur;
		}
		
		//right side
		if(cur.order.key() < food.charAt(0)) {
			cur.right = insert(food, cur.right);
		}
		
		//left
		else if(cur.order.key() > food.charAt(0)){
			cur.left = insert(food, cur.left);
		} 
		
		else {
			cur.order.insert(food);
		}
		
		return cur;
	}
	
	//display the tree
	public void display() {
		display(root);
	}
	
	//recursive display for the tree
	private void display(B_Node cur) {
		if(cur == null) {
			return;
		}
		
		display(cur.left);
		cur.order.display();
		display(cur.right);
	}
	
	//tree fixup for insertion to maintain RBT structure
	public RBT tree_fixup(B_Node node, RBT tree) {
		while(node.parent != null && node.parent.color == RED) {
			if(node.parent.parent.left == node.parent) { //left child
				B_Node right_uncle = node.parent.parent.right;
				if(right_uncle != null && right_uncle.color == RED) {
					//recolor
					node.parent.color = BLACK;
					right_uncle.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				} else {
					if(node.parent.right == node) {
						node = node.parent;
						left_rotate(node, tree);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					right_rotate(node.parent.parent, tree);
				}
			} else { //right
				B_Node left_uncle = node.parent.parent.left;
				if(left_uncle != null && left_uncle.color == RED) {
					left_uncle.color = BLACK;
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					node = node.parent.parent;
				} else {
					if(node.parent.left == node) {
						node.parent.color = BLACK;
						node.parent.parent.color = RED;
						left_rotate(node.parent.parent, tree);
					}
				}
				tree.root.color = BLACK;
			}
			tree.root.color = RED;
		}
		
		return tree;
		
	}
	
	//left rotate tree for fix up
	public RBT left_rotate(B_Node node, RBT tree) {
		B_Node hold = node.right;
		if(hold.left != null) {
			hold.left.parent = node;
		}
		hold.parent = node.parent;
		if(node.parent == null) { //root
			tree.root = hold;
		}
		else if(node == node.parent.left) { //left child
			node.parent.left = hold;
		} else { //right child
			node.parent.right = hold;
		}
		hold.left = node;
		node.parent = hold;
		return tree;
	}
	
	//right rotate tree for fix up
	public RBT right_rotate(B_Node node, RBT tree) {
		B_Node hold = node.left;
		if(hold.right != null) {
			hold.right.parent = node;
		}
		hold.parent = node.parent;
		if(node.parent == null) { //root
			tree.root = hold;
		}
		else if(node == node.parent.right) { //left child
			node.parent.right = hold;
		} else { //right child
			node.parent.left = hold;
		}
		hold.right = node;
		node.parent = hold;
		return tree;
		
	}
}
