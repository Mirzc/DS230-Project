import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course Class
class Course {
    // Attributes
    public String title;
    public String instructor;
    public String area;

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

    @Override
    public String toString() {
        return "Title: " + title + ", Instructor: " + instructor + ", Area: " + area;
    }

}

// Supervisor Class
class Supervisor {
    public List<Course> course;

    // Sample Data
    public Supervisor() {
        course = new ArrayList<>();
        course.add(new Course("Intro to Data Science", "Dr. Mohammed", "Dammam"));
        course.add(new Course("Islam 101", "Dr. Ahmed", "Dammam"));
        course.add(new Course("Mathamatcis: Algebra", "Dr. Khalid", "Riyadh"));
        course.add(new Course("Ethics for Data Science", "Dr. Ali", "Jeddah"));
    }

    // display all courses
    public void displayAllCourses() {
        System.out.println("Available Courses:");
        for (int i = 0; i < course.size(); i++) {
            System.out.println((i + 1) + ". " + course.get(i));
        }
    }

    public List<Course> searchcourse(String phrase) {
        List<Course> results = new ArrayList<>();
        System.out.println("Search Results:");
        boolean notFound = false;
        for (Course search : course) {
            if (search.getTitle().equalsIgnoreCase(phrase)) {
                results.add(search);
                notFound = true;
            }
        }
        if (!notFound) { // Error handling
            System.out.println("No matches Found for: " + phrase);
        }
        return results;
    }

    // display by area
    public void displayCourseByarea(String area) {
        System.out.println("title in " + area + ":");
        boolean notFound = false;
        for (Course subject : course) {
            if (subject.area.equalsIgnoreCase(area)) {
                System.out.println(subject);
                notFound = true;
            }
        }
        if (!notFound) { // Error handling
            System.out.println("No title notFound in: " + area);
        }
    }

    // display by instructor
    public void displaytitleByInstructor(String Instructor) {
        System.out.println("title in " + Instructor + ":");
        boolean notFound = false;
        for (Course course : course) {
            if (course.getInstructor().equalsIgnoreCase(Instructor)) {
                System.out.println(course);
                notFound = true;
            }
        }
        if (!notFound) { // Error handling
            System.out.println("No title notFound in: " + Instructor);
        }
    }

    // add course
    public void addCourse(String title, String instructor, String area) {
        Course newCourse = new Course(title, instructor, area);
        this.course.add(newCourse);
        System.out.println("The Course has been " + newCourse.getTitle() + " added: ");
    }

    public List<Course> searchByInstructor(String instructor) {
        List<Course> results = new ArrayList<>();
        for (Course course : course) {
            if (course.getInstructor().equalsIgnoreCase(instructor)) {
                results.add(course);
            }
        }
        return results;
    }

    public List<Course> searchByArea(String area) {
        List<Course> results = new ArrayList<>();
        for (Course course : course) {
            if (course.getArea().equalsIgnoreCase(area)) {
                results.add(course);
            }
        }
        return results;
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Supervisor supervisor = new Supervisor();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        int choice = -1;
        while (isRunning) { // loop to prevent crashes and allow the user to exit gracefully and options to
                            // be displayed
            System.out.println("\n <3 Course Management System <3 ");
            System.out.println("1. Add Course");
            System.out.println("2. Display All Courses");
            System.out.println("3. Search Courses by Title");
            System.out.println("4. Search Courses by Instructor");
            System.out.println("5. Display Courses by Area");
            System.out.println("6. Exit");

            try { // Error handling
                System.out.print("Insert your input: ");
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error, input is wrong. Try again using 1-6");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("insert course title: ");
                    String title = scanner.nextLine();
                    System.out.print("insert instructor name: ");
                    String instructor = scanner.nextLine();
                    System.out.print("insert course area: ");
                    String area = scanner.nextLine();
                    supervisor.addCourse(title, instructor, area);
                    System.out.println("Course is added");
                    break;
                case 2:
                    System.out.println("\n Below are all the courses");
                    supervisor.displayAllCourses();
                    break;
                case 3:
                    System.out.print("insert title to search: ");
                    String searchTitle = scanner.nextLine();
                    List<Course> coursesByTitle = supervisor.searchcourse(searchTitle);
                    if (coursesByTitle.isEmpty()) {
                        System.out.println("There is no course with this title: " + searchTitle);
                    } else {
                        for (Course results : coursesByTitle) {
                            System.out.println(results);

                        }
                    }
                    break;
                case 4:
                    System.out.print("insert instructor name to search: ");
                    String searchInstructor = scanner.nextLine();
                    List<Course> coursesByInstructor = supervisor.searchByInstructor(searchInstructor);
                    if (coursesByInstructor.isEmpty()) {
                        System.out.println("there is no course with this instructor: " + searchInstructor);
                    } else {
                        for (Course course : coursesByInstructor) {
                            System.out.println("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor()
                                    + ", Area: " + course.getArea());
                        }
                    }
                    break;
                case 5:
                    System.out.print("insert area to display courses: ");
                    String searchArea = scanner.nextLine();
                    List<Course> coursesByArea = supervisor.searchByArea(searchArea);
                    if (coursesByArea.isEmpty()) {
                        System.out.println("there is no course with this Area: " + searchArea);
                    } else {
                        System.out.println(" These are all the courses in this area: " + searchArea);
                        for (Course course : coursesByArea) {
                            System.out.println(course);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting system. Hope You Enjoyed :)  <3   ");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 6.");
                    break;
            }

        }
        scanner.close();
    }
}