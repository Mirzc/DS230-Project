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

    public void searchtitle(String phrase) {
        System.out.println("Search Results:");
        boolean notFound = false;
        for (Course course : title) {
            if (course.title.equalsIgnoreCase(phrase) || course.instructor.equalsIgnoreCase(phrase)) {
                System.out.println(course);
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

    public void addCourse(String title, String instructor, String area) {
        Course newCourse = new Course(title, instructor, area);
        this.title.add(newCourse);
        System.out.println("The Course has been " + newCourse.title + " added: ");
    }

}
