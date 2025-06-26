package final_;
// Feature 5
class Nodes_2 {
	Student data; 
	Nodes_2 next;
	
	public Nodes_2(Student data) {
		this.data = data;
		this.next = null;
	}
}	
public class LinkedList_Queue {
	private Nodes_2 front; //head
	private Nodes_2 rear; //tail
	private int size;
	
	public LinkedList_Queue() {
		front = rear = null;
		size = 0;
	}
	
	public void enqueue(Student student) { //O(1)
		Nodes_2 new_node = new Nodes_2(student);
		if(!isEmpty()) {
			rear.next = new_node;
			rear = new_node;
		} else {
			front = rear = new_node;
		}
		size++;
	}
	
	public Student dequeue() { //O(1)
		if(isEmpty()) {
			System.out.println("Queue is empty!!!");
			return null;
		}
		Student dequeued = front.data;
		front = front.next;
		if(front == null) { //Queue become empty 
			rear = null;
		}
		size--;
		return dequeued;
	}
	
	public Student peek() { //O(1)
		if(isEmpty()) {
			System.out.println("Queue is empty!!!");
			return null;
		}
		return front.data;
	}
	
	public boolean isEmpty() { //O(1)
		return size == 0;
	}
	
	public int size() { //O(1)
		return size;
	}
	
	public void display() { //O(n)
        if (isEmpty()) {
            System.out.println("No registrations.");
            return;
        }
        Nodes_2 temp = front;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}

