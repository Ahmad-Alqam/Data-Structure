package final_;
// Feature 2
public class RoomRequests {
	String studentName;
	int studentYear;
	int room;
	
	public RoomRequests(String name, int year, int room) {
		this.studentName = name;
		this.studentYear = year;
		this.room = room;
	}
	
	// Override
	public String toString() {
        return studentName + " (Year " + studentYear + ") - Room: " + room;
    }
}
