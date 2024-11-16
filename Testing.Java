import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course Class
public class Testing {
    // Attributes
    private String title;
    private String instructor;
    private String area;

    // Getters
    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getArea() {
        return area;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setArea(String area) {
        this.area = area;
    }

    // (Optional) Constructor - initializes attributes during object creation
    public Course(String title, String instructor, String area) {
        this.title = title;
        this.instructor = instructor;
        this.area = area;
    }
}

// Supervisor Class
class Supervisor {
    private List<Course> courses;

    public Supervisor() {
        courses = new ArrayList<>();
        // Initialize with sample courses
        initializeSampleCourses();
    }

    private void initializeSampleCourses() {
        courses.add(new Course("Math 101", "Dr. Ahmed", "Mathematics"));
        courses.add(new Course("Islm 101", "Dr. Hamed", "Islam"));
        courses.add(new Course("Eng 101", "Dr. Khalid", "English"));
        courses.add(new Course("Physics 101", "Dr. Fahad", "Science"));
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> searchByTitle(String title) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().equalsIgnoreCase(title)) {
                result.add(course);
            }
        }
        return result;
    }

    public List<Course> searchByInstructor(String instructor) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getInstructor().equalsIgnoreCase(instructor)) {
                result.add(course);
            }
        }
        return result;
    }

    public List<Course> searchByArea(String area) {
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getArea().equalsIgnoreCase(area)) {
                result.add(course);
            }
        }
        return result;
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor() + ", Area: "
                    + course.getArea());
        }
    }

    public void displayCoursesByArea(String area) {
        for (Course course : courses) {
            if (course.getArea().equalsIgnoreCase(area)) {
                System.out.println("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor());
            }
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Supervisor supervisor = new Supervisor();
        boolean running = true;

        while (running) {
            System.out.println("1. Add Course");
            System.out.println("2. Display Courses");
            System.out.println("3. Search Course by Title");
            System.out.println("4. Search Course by Instructor");
            System.out.println("5. Search Course by Area");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int option = -1;

            // Error handling for invalid input
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
                continue; // Skip to the next iteration of the loop
            }

            switch (option) {
                case 1:
                    // Logic to add a course
                    System.out.print("Enter course title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter instructor name: ");
                    String instructor = scanner.nextLine();
                    System.out.print("Enter course area: ");
                    String area = scanner.nextLine();
                    supervisor.addCourse(new Course(title, instructor, area));
                    System.out.println("Course added successfully.");
                    break;
                case 2:
                    supervisor.displayCourses();
                    break;
                case 3:
                    System.out.print("Enter course title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Course> titleResults = supervisor.searchByTitle(searchTitle);
                    if (titleResults.isEmpty()) {
                        System.out.println("No courses found with that title.");
                    } else {
                        for (Course course : titleResults) {
                            System.out
                                    .println("Found: " + course.getTitle() + ", Instructor: " + course.getInstructor());
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter instructor name to search: ");
                    String searchInstructor = scanner.nextLine();
                    List<Course> instructorResults = supervisor.searchByInstructor(searchInstructor);
                    if (instructorResults.isEmpty()) {
                        System.out.println("No courses found for that instructor.");
                    } else {
                        for (Course course : instructorResults) {
                            System.out.println("Found: " + course.getTitle() + ", Area: " + course.getArea());
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter course area to search: ");
                    String searchArea = scanner.nextLine();
                    List<Course> areaResults = supervisor.searchByArea(searchArea);
                    if (areaResults.isEmpty()) {
                        System.out.println("No courses found in that area.");
                    } else {
                        for (Course course : areaResults) {
                            System.out
                                    .println("Found: " + course.getTitle() + ", Instructor: " + course.getInstructor());
                        }
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}