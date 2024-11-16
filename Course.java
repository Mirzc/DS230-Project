import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Course Class
public class Course {
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
        courses.add(new Course("Math 101", "Dr. Ahmed", "Dammam"));
        courses.add(new Course("Islm 101", "Dr. Hamed", "Dammam"));
        courses.add(new Course("Eng 101", "Dr. Khalid", "Jeddah"));
        courses.add(new Course("Physics 101", "Dr. Fahad", "Riyadh"));
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
