class Supervisor {
    public List<Classes> subjects;

    public Supervisor() {
        subjects = new ArrayList<>();
        subjects.add(new Classes("Intro to Data Science", "Dr. Mohammed", "Dammam"));
        subjects.add(new Classes("Islam 101", "Dr. Ahmed", "Dammam"));
        subjects.add(new Classes("Mathamatcis: Algebra", "Dr. Khalid", "Riyadh"));
        subjects.add(new Classes("Ethics for Data Science", "Dr. Ali", "Jeddah"));
    }

    public void displayAllSubjects() {
        System.out.println("Available Subjects:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
                        }
            }

    public void searchSubjects(String phrase)   
    {
        System.out.println("Search Results:");
        boolean notFound = false;
        for (Classes subject : subjects) {
            if (subject.subjectTitle.equalsIgnoreCase(phrase) || subject.subjectInstructor.equalsIgnoreCase(phrase))
            {                   System.out.println(subject);
                                        notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No matches notFound for: " + phrase);
        }
    }

    public void displaySubjectsByarea(String area) {
        System.out.println("Subjects in " + area + ":");
        boolean notFound = false;
        for (Classes subject : subjects) {
            if (subject.area.equalsIgnoreCase(area)) {
                System.out.println(subject);
                notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No subjects notFound in: " + area);
        }
    }

   public void displaySubjectsBySubjectInstructor(String subjectInstructor) {
        System.out.println("Subjects in " + subjectInstructor + ":");
        boolean notFound = false;
        for (Classes subject : subjects) {
            if (subject.area.equalsIgnoreCase(subjectInstructor)) {
                System.out.println(subject);
                notFound = true;
            }
        }
        if (!notFound) {
            System.out.println("No subjects notFound in: " + subjectInstructor);
        }
    }
}