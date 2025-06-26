package final_;
// Feature 2
class Nodes_3{
	RoomRequests request;
	Nodes_3 next;
	
	public Nodes_3(RoomRequests request) {
		this.request = request;
		this.next = null;
	}
}

public class LinkedListQueue_Booking {
	private Nodes_3 front;
	private Nodes_3 rear;
	private int size;
	
	public LinkedListQueue_Booking() {
		front = rear = null;
	}
	
	public void enqueue(RoomRequests request) { // O(n)
		Nodes_3 new_node = new Nodes_3(request);
		if(front == null) {
			front = rear = new_node;
		} else if(request.studentYear > front.request.studentYear) {
			new_node.next = front;
			front = new_node;
		} else {
			Nodes_3 current = front;
			Nodes_3 previous = null;
			while(current != null && request.studentYear <= current.request.studentYear) {
				previous = current;
				current = current.next;
			}
			new_node.next = current;
			if(previous != null) {
				previous.next = new_node;
			}
			if(new_node.next == null) {
				rear = new_node;
			}
		}
		size++;
		System.out.println("Request: " + request + " added successfully!");
	}
	
	public RoomRequests dequeue() { // O(1)
		if(front == null) {
			System.out.println("Queue is empty!!!");
			return null;
		}
		RoomRequests dequeued_request = front.request;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		size--;
		return dequeued_request;
	}
	
	public void displayQueue() { // O(n)
		if(front == null) {
			System.out.println("Queue is empty!!!");
			return;
		}
		Nodes_3 current = front;
		System.out.println("Current room booking queue: ");
		while(current != null) {
			System.out.println("* " + current.request);
			current = current.next;
		}
	}
	
	public boolean isEmpty() { //O(1)
		return size == 0;
	}
}
