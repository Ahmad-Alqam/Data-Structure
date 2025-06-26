package final_;
// Feature 6
class BST_Nodes {
	int studentID;
	Lockers locker;
	BST_Nodes left, right;
	
	public BST_Nodes(int ID, Lockers locker) {
		this.studentID = ID;
		this.locker = locker;
		this.left = this.right = null;
	}
}

public class BST_Lockers {
	private BST_Nodes Root;
	private boolean found = false;
	
	public void register(int studentID, Lockers locker) { // O(tree's height)
	    if (lockerExists(Root, locker.getLocker_number())) {
	        System.out.println("Locker " + locker.getLocker_number() + " is already assigned to another student!");
	        return;
	    }

	    BST_Nodes new_node = new BST_Nodes(studentID, locker);

	    if (Root == null) {
	        Root = new_node;
	        return;
	    }

	    BST_Nodes parent = null;
	    BST_Nodes current = Root;

	    while (current != null) {
	        parent = current;
	        if (studentID < current.studentID) {
	            current = current.left;
	        } else if (studentID > current.studentID) {
	            current = current.right;
	        } else {
	            System.out.println("Student already exists!!!");
	            return;
	        }
	    }

	    if (studentID < parent.studentID) {
	        parent.left = new_node;
	    } else {
	        parent.right = new_node;
	    }
	}

	
	public Lockers search(int studentID) { // O(tree's height)
		BST_Nodes current = Root;
		
		while(current != null) {
			if(studentID == current.studentID) {
				found = true;
				return current.locker;
			} else if(studentID < current.studentID) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}
	
	public boolean remove(int studentID) { // O(tree's height)
		BST_Nodes parent = null, current = Root;
		
		while(current != null && current.studentID != studentID) {
			parent = current;
			if(studentID < current.studentID) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if(current == null) {
			return false;
		}
		
		// Target node has one or no child
		if(current.left == null || current.right == null) {
			BST_Nodes child;
			if(current.left == null) {
				child = current.right;
			} else {
				child = current.left;
			}
			
			if(parent == null) {
				Root = child;
			} else if(current == parent.left) {
				parent.left = child;
			} else {
				parent.right = child;
			}
			current.locker = new Lockers(current.locker.getLocker_number(), "Withdrawn");
		} else { // Target node with 2 children
			BST_Nodes successor_parent = current, successor = current.right;
			
			while(successor.left != null) {
				successor_parent = successor;
				successor = successor.left;
			}
			
			current.studentID = successor.studentID;
			current.locker = successor.locker;
			
			if(successor_parent.left == successor) {
				successor_parent.left = successor.right;
			} else {
				successor_parent.right = successor.right;
			}
		}
		return true;
	}
	
	private boolean lockerExists(BST_Nodes node, int lockerNumber) {
	    if (node == null) return false;

	    if (node.locker.getLocker_number() == lockerNumber &&
	        node.locker.getStatus().equalsIgnoreCase("In use")) {
	        return true;
	    }

	    return lockerExists(node.left, lockerNumber) || lockerExists(node.right, lockerNumber);
	}
	
	// Display only "In-use" lockers with recursions
	public void displayInOrder() { // O(tree's nodes)
        System.out.println("Lockers Used:");
        inOrder(Root);
    }

    private void inOrder(BST_Nodes root) { // O(tree's height)
    	if (root != null) {
            inOrder(root.left);
            if (root.locker.getStatus().equalsIgnoreCase("In Use")) {
                System.out.println("ID: " + root.studentID + " -> " + root.locker);
            }
            inOrder(root.right);
        }
    }
}
