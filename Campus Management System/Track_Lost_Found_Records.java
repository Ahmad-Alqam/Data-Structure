package final_;
// Feature 1

public class Track_Lost_Found_Records {
	private String description;
	private String date;
	private String location;
	
	public Track_Lost_Found_Records(String description, String date, String location) {
		this.description = description;
		this.date = date;
		this.location = location;
	}
	
	//Getters
	public String getDescription() {
		return description;
	}

	public String getDate() {
		return date;
	}

	public String getLocation() {
		return location;
	}

	//Override
	public String toString() {
		return "[Description: " + description + ", Date: " + date + ", Location: " + location + "]";
	}
}