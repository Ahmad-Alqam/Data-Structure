package final_;
// Feature 5
public class Student {
	    private int id;
	    private String name;
	    private String event;

	    public Student(int id, String name, String event) {
	        if(id <= 0) {
	        	System.out.println("Invalid ID.");
	        	return;
	        }
	    	this.id = id;
	        this.name = name;
	        this.event = event;
	    }

	    //Override
	    public String toString() {
	        return "[ID: " + id + ", Name: " + name + ", Event: " + event + "]";
	    }
}
