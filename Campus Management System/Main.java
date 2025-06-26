package final_;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Configure Shortest Path Graph (Feature 3)
        int vertices = 5;
        int edges = 11;
        Shortest_Path orientationGraph = new Shortest_Path(vertices, edges);
        orientationGraph.addEdge(0, 0, 1, 4);
        orientationGraph.addEdge(1, 0, 2, 2);
        orientationGraph.addEdge(2, 1, 2, -3);  
        orientationGraph.addEdge(3, 1, 3, 2);
        orientationGraph.addEdge(4, 2, 3, 3);
        orientationGraph.addEdge(5, 3, 4, 2);
        orientationGraph.addEdge(6, 4, 0, 5); 
        orientationGraph.addEdge(7, 2, 4, 6); 
        orientationGraph.addEdge(8, 3, 0, 7); 
        orientationGraph.addEdge(9, 4, 2, 4); 
        orientationGraph.addEdge(10, 1, 4, 1); 
        Campus_Management system = new Campus_Management(orientationGraph);

        int choice;
        do {
            System.out.println("\n===== Campus Management System =====");
            System.out.println("1. Report Lost/Found Item");
            System.out.println("2. Search Lost/Found Item");
            System.out.println("3. Display All Lost/Found Items");
            System.out.println("4. Book Study Room");
            System.out.println("5. Process Room Booking");
            System.out.println("6. Display Room Bookings");
            System.out.println("7. Guide Student (Shortest Path)");
            System.out.println("8. Undo Last Action");
            System.out.println("9. Redo Last Action");
            System.out.println("10. View Last Action");
            System.out.println("11. Register for Event");
            System.out.println("12. Process Event Registration");
            System.out.println("13. Assign Locker to Student");
            System.out.println("14. Remove Locker");
            System.out.println("15. Search Locker");
            System.out.println("16. Display Lockers");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();
                    System.out.print("Enter location: ");
                    String location = scanner.nextLine();
                    system.reportLost(new Track_Lost_Found_Records(description, date, location));
                    break;
                    
                case 2:
                    System.out.println("Search Lost/Found Item By:");
                    System.out.println("1. Description");
                    System.out.println("2. Date");
                    System.out.println("3. Location");
                    System.out.print("Choose an option: ");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Enter your keyword: ");
                    String keyword = scanner.nextLine();

                    switch (searchOption) {
                        case 1:
                            system.Found_Lost_Items.searchByDescription(keyword);
                            break;
                            
                        case 2:
                            system.Found_Lost_Items.searchByDate(keyword);
                            break;
                            
                        case 3:
                            system.Found_Lost_Items.searchByLocation(keyword);
                            break;
                            
                        default:
                            System.out.println("Invalid search option!");
                    }
                    break;

                case 3:
                    system.displayLostItems();
                    break;
                    
                case 4:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your academic year: ");
                    int year = scanner.nextInt();
                    if(year <= 0) {
                    	System.out.println("Invalid year.");
                    	break;
                    }
                    System.out.print("Enter room number: ");
                    int room = scanner.nextInt();
                    if(room <= 0) {
                    	System.out.println("Invalid room number.");
                    	break;
                    }
                    system.roomBook(new RoomRequests(name, year, room));
                    break;
                    
                case 5:
                    system.bookingProcess();
                    break;
                    
                case 6:
                    system.displayRoomBookings();
                    break;
                    
                case 7:
                    System.out.print("Enter your building ID (0–" + (vertices - 1) + "): ");
                    int from = scanner.nextInt();
                    if (from < 0 || from >= vertices) {
                        System.out.println("Invalid building ID. Please enter a value between 0 and " + (vertices - 1) + ".");
                    } else {
                        system.guideStudent(from);
                    }
                    break;
                    
                case 8:
                    system.undo();
                    break;
                    
                case 9:
                    system.redo();
                    break;
                    
                case 10:
                    system.lastAction();
                    break;
                    
                case 11:
                    System.out.print("Enter student name: ");
                    String name_ = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id_ = scanner.nextInt();
                    if(id_ <= 0) {
                    	System.out.println("Invalid ID.");
                    	break;
                    }
                    scanner.nextLine(); 
                    System.out.print("Enter event: ");
                    String event = scanner.nextLine();
                    system.registerStudent(new Student(id_, name_, event));
                    break;
                    
                case 12:
                    system.registeringProcess();
                    break;
                    
                case 13:
                    System.out.print("Enter student ID: ");
                    int student_ID = scanner.nextInt();
                    if(student_ID <= 0) {
                    	System.out.println("Invalid ID.");
                    	break;
                    }
                    System.out.print("Enter locker number: ");
                    int lockerNum = scanner.nextInt();
                    system.assignLocker(student_ID, lockerNum);
                    break;
                    
                case 14:
                    System.out.print("Enter student ID to remove locker: ");
                    int removeID = scanner.nextInt();
                    if(removeID <= 0) {
                    	System.out.println("Invalid ID.");
                    	break;
                    }
                    system.removeLockers(removeID);
                    break;
                    
                case 15:
                    System.out.print("Enter student ID to search locker: ");
                    int searchID = scanner.nextInt();
                    if(searchID <= 0) {
                    	System.out.println("Invalid ID");
                    	break;
                    }
                    system.searchLocker(searchID);
                    break;
                    
                case 16:
                    system.displayLockers();
                    break;
                    
                case 0:
                    System.out.println("Exiting Campus Management System...");
                    break;
                    
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 0);
    }
}
