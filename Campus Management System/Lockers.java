package final_;
// Feature 6
public class Lockers {
	private int locker_number;
	private String status;
	
	public Lockers(int locker_number, String status) {
		this.locker_number = locker_number;
		this.status = status;
	}

	public int getLocker_number() {
		return locker_number;
	}

	public String getStatus() {
		return status;
	}
	
	//Override
	public String toString() {
		return "[Locker: " + locker_number + ", Status: " + status + "]";
	}
}
