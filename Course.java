import java.util.ArrayList;
import java.util.List;

// Course Class
public class Course {
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
}

// Supervisor Class
class Supervisor {
    public List<Course> title;

    public Supervisor() {
        title = new ArrayList<>();
        title.add(new Course("Intro to Data Science", "Dr. Mohammed", "Dammam"));
        title.add(new Course("Islam 101", "Dr. Ahmed", "Dammam"));
        title.add(new Course("Mathamatcis: Algebra", "Dr. Khalid", "Riyadh"));
        title.add(new Course("Ethics for Data Science", "Dr. Ali", "Jeddah"));
    }

    public void displayAlltitle() {
        System.out.println("Available title:");
        for (int i = 0; i < title.size(); i++) {
            System.out.println((i + 1) + ". " + title.get(i));
                        }
            }

    public void searchtitle(String phrase)   
    {
        System.out.println("Search Results:");
        boolean notFound = false;
        for (Course course : title) {
            if (course.title.equalsIgnoreCase(phrase) || course.instructor.equalsIgnoreCase(phrase))
            {                   System.out.println(course);
                                        notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No matches notFound for: " + phrase);
        }
    }

    public void displaytitleByarea(String area) {
        System.out.println("title in " + area + ":");
        boolean notFound = false;
        for (Course subject : title) {
            if (subject.area.equalsIgnoreCase(area)) {
                System.out.println(subject);
                notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No title notFound in: " + area);
        }
    }

   public void displaytitleBySubjectInstructor(String subjectInstructor) {
        System.out.println("title in " + subjectInstructor + ":");
        boolean notFound = false;
        for (Course subject : title) {
            if (subject.area.equalsIgnoreCase(subjectInstructor)) {
                System.out.println(subject);
                notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No title notFound in: " + subjectInstructor);
        }
    }
}