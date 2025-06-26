package final_;
// Feature 1
class Nodes {
	Track_Lost_Found_Records data; 
	Nodes next;
	
	public Nodes(Track_Lost_Found_Records element) {
		this.data = element;
		this.next = null;
	}
}

public class Linked_List {
	private Nodes head;
	private Nodes tail;
	private int size;
	
	public Linked_List() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void insertEnd(Track_Lost_Found_Records element) { //O(1)
		Nodes new_node = new Nodes(element);
		if(head == null) { //Validation
			head = tail = new_node;
		} else {
			tail.next = new_node;
			tail = new_node;
		}
		size++;
	}
	
	public void deleteEnd() { //O(n)
		if(head == null) { //Validation
			return;
		}
		if(head == tail) {
			head = tail = null;
		} else {
			Nodes temp = head;
			while(temp.next != tail) {
				temp = temp.next;
			}
			temp.next = null;
			tail = temp;
		}
		size--;
	}
	
	public void searchByDescription(String description) { //O(n)
		Nodes temp = head;
		boolean found = false;
		
		while(temp != null) {
			if (temp.data.getDescription().toLowerCase().contains(description.toLowerCase())) {
				System.out.println(temp.data);
				found = true;
			}
			temp = temp.next;
		}
		
		if(!found) {
			System.out.println("No results for your keyword: " + description);
		}
	}
	
	public void searchByDate(String part_of_date) { //O(n)
		Nodes temp = head;
		boolean found = false;
		
		while(temp != null) {
			if(temp.data.getDate().contains(part_of_date)) {
				System.out.println(temp.data);
				found = true;
			}
			temp = temp.next;
		}
		
		if(!found) {
			System.out.println("No results for your keyword: " + part_of_date);
		}
	}
	
	public void searchByLocation(String location) { //O(n)
		Nodes temp = head;
		boolean found = false;
		
		while(temp != null) {
			if(temp.data.getLocation().equalsIgnoreCase(location)) {
				System.out.println(temp.data);
				found = true;
			}
			temp = temp.next;
		}
		
		if(!found) {
			System.out.println("No results for your keyword: " + location);
		}
	}
	
	public int size() { //O(1)
		return size;
	}
	
	public void display() { //O(n)
		Nodes temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
