package final_;

public class Campus_Management {
	public Linked_List Found_Lost_Items; // Feature 1
	private LinkedListQueue_Booking Rooms_Booking; // Feature 2
	private Shortest_Path Student_Orientation; // Feature 3
	private ArrayStack undoStack, redoStack; // Feature 4
	private LinkedList_Queue Event_Registration; // Feature 5
	private BST_Lockers lockerSystem; // Feature 6
	
	public Campus_Management(int vertex, int edges) {
		Found_Lost_Items = new Linked_List();
		Rooms_Booking = new LinkedListQueue_Booking();
		undoStack = new ArrayStack(100);
		redoStack = new ArrayStack(100);
		Event_Registration = new LinkedList_Queue();
		lockerSystem = new BST_Lockers();
	}
	
	public Campus_Management(Shortest_Path orientationGraph) {
	    this.Found_Lost_Items = new Linked_List();
	    this.Rooms_Booking = new LinkedListQueue_Booking();
	    this.undoStack = new ArrayStack(100);
	    this.redoStack = new ArrayStack(100);
	    this.Student_Orientation = orientationGraph;
	    this.Event_Registration = new LinkedList_Queue();
	    this.lockerSystem = new BST_Lockers();
	}
	
	// Feature 1 - Track lost/found record
	public void reportLost(Track_Lost_Found_Records record) {
	    Found_Lost_Items.insertEnd(record);
	    undoStack.push("LostItem: " + record);
	    redoStack = new ArrayStack(100);  
	    System.out.println("Recorded item: " + record);
	}

	
	public void searchLostItem(String keyword) {
		System.out.println("Search by description:");
		Found_Lost_Items.searchByDescription(keyword);
		System.out.println("Search by date:");
		Found_Lost_Items.searchByDate(keyword);
		System.out.println("Search by location:");
		Found_Lost_Items.searchByLocation(keyword);
	}
	
	public void displayLostItems() {
		Found_Lost_Items.display();
	}
	
	// Feature 2 - Room Booking
	public void roomBook(RoomRequests request) {
		Rooms_Booking.enqueue(request);
		undoStack.push("Room booked: " + request);
		redoStack = new ArrayStack(100);
		System.out.println("Room booked: " + request);
	}
	
	public void bookingProcess() {
		RoomRequests processed = Rooms_Booking.dequeue();
		if(processed != null) {
	        undoStack.push("RoomProcessed: " + processed);
	        redoStack = new ArrayStack(100);
			System.out.println("Processed room: " + processed);
		}
	}
	public void displayRoomBookings() {
	    if (Rooms_Booking.isEmpty()) {
	        System.out.println("No room bookings in the queue.");
	        return;
	    }

	    System.out.println("Current Room Booking Queue:");
	    Rooms_Booking.displayQueue();
	}

	
	// Feature 3 - Student Orientation Help
	public void guideStudent(int from) {
		Student_Orientation.autoSelect_Algorithm(from);
	}
	
	// Feature 4 - Undo/Redo
	public void undo() {
		if(!undoStack.isEmpty()) {
			String lastAction = undoStack.pop();
			redoStack.push(lastAction);
			System.out.println("Undo: " + lastAction);
		} else {
			System.out.println("Nothing to undo.");
		}
	}
	
	public void redo() {
		if(!redoStack.isEmpty()) {
			String restored = redoStack.pop();
			undoStack.push(restored);
			System.out.println("Redo: " + restored);
		} else {
			System.out.println("Nothing to redo.");
		}
	}
	
	public void lastAction() {
		if(!undoStack.isEmpty()) {
			System.out.println("Last action: " + undoStack.peek());
		} else {
			System.out.println("No actions recorded.");
		}
	}
	
	// Feature 5 - Event Participation Registration
	public void registerStudent(Student student) {
		Event_Registration.enqueue(student);
	    undoStack.push("Event Registered: " + student);
	    redoStack = new ArrayStack(100);
		System.out.println("Registered: " + student);
	}
	
	public void registeringProcess() {
		Student next = Event_Registration.dequeue();
		if(next != null) {
			System.out.println("Registering: " + next);
		}
	}
	
	// Feature 6 - Student Locker Allocation
	public void assignLocker(int ID, int lockerNumber) {
	    Lockers locker = new Lockers(lockerNumber, "In use");
	    lockerSystem.register(ID, locker);
	    Lockers result = lockerSystem.search(ID);
	    if (result != null && result.getLocker_number() == lockerNumber &&
	        result.getStatus().equalsIgnoreCase("In use")) {
	    	undoStack.push("LockerRemoved: StudentID=" + ID);
	        redoStack = new ArrayStack(100);
	        System.out.println("Assigned locker to student: " + ID + " => Locker: " + locker);
	    }
	}
	
	public void removeLockers(int ID) {
		 boolean removed = lockerSystem.remove(ID);
		    if (removed) {
		        undoStack.push("LockerRemoved: StudentID=" + ID);
		        redoStack = new ArrayStack(100);
		        System.out.println("Locker for student ID " + ID + " has been marked as Withdrawn.");
		    } else {
		        System.out.println("Student ID not found. No locker removed.");
		    }
	}
	
	public void searchLocker(int ID) {
		Lockers locker = lockerSystem.search(ID);
		if(locker != null) {
			System.out.println("Locker: " + locker);
		} else {
			System.out.println("No locker assigned.");
		}
	}
	
	public void displayLockers() {
		lockerSystem.displayInOrder();
	}

}