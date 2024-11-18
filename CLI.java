import java.util.List;
import java.util.Scanner;

public class CLI {Supervisor supervisor = new Supervisor();
Scanner scanner = new Scanner(System.in);
int choice;{
    System.out.println("\n <3 Course Management System <3 ");
    System.out.println("1. Add Course");
    System.out.println("2. Display All Courses");
    System.out.println("3. Search Courses by Title");
    System.out.println("4. Search Courses by Instructor");
    System.out.println("5. Display Courses by Area");
    System.out.println("6. Exit");
    System.out.print("insert your input: ");
    choice = scanner.nextInt();
    scanner.nextLine();
    }
{
    switch (choice) {
    case 1:
    System.out.print("insert course title: ");
    String title = scanner.nextLine();
    System.out.print("insert instructor name: ");
    String instructor = scanner.nextLine();
    System.out.print("insert course area: ");
    String area = scanner.nextLine();
    supervisor.addCourse(new Course(title, instructor, area));
    System.out.println("Course is added");
        break;
    case 2:
    System.out.println("\n Below are all the courses");
supervisor.displayCourses();
        break;
    case 3:
    System.out.print("insert title to search: ");
String searchTitle = scanner.nextLine();
List<Course> coursesByTitle = supervisor.searchByTitle(searchTitle);
if (coursesByTitle.isEmpty()) {
    System.out.println("There is no course with this title: " + searchTitle);
} else {
    for (Course course : coursesByTitle) {
        System.out.println("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor() + ", Area: " + course.getArea());
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
        System.out.println("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor() + ", Area: " + course.getArea());
    }
}
        break;
    case 5:
    System.out.print("insert area to display courses: ");
String searchArea = scanner.nextLine();
supervisor.displayCoursesByArea(searchArea);
List<Course> displayCoursesByArea = supervisor.searchByArea(searchArea);
if (displayCoursesByArea.isEmpty()){
    System.out.println("there is no course with this Area: " + searchArea);
} else {
    for (Course course : displayCoursesByArea);
}
        break;
    case 6:
    System.out.println("Exiting system. Hope You Enjoyed :)  <3   ");
    break;
        
    default:
        System.out.println("Error, input is wrong, try again");

        scanner.close();
        }
    }
}
