import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    private JFrame frame;
    private Supervisor supervisor;
    private JTextArea displayArea;

    public UI(Supervisor supervisor) {
        this.supervisor = supervisor;
        frame = new JFrame("Course Management System");

        // Setting up the frame
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create buttons for each option
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1)); // 6 buttons

        // Button for Add Course
        JButton addCourseButton = new JButton("Add Course");
        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show input fields for course information
                String title = JOptionPane.showInputDialog(frame, "Enter course title:");
                String instructor = JOptionPane.showInputDialog(frame, "Enter instructor name:");
                String area = JOptionPane.showInputDialog(frame, "Enter course area:");
                supervisor.addCourse(new Course(title, instructor, area));
                displayArea.append("Course added: " + title + "\n");
            }
        });

        // Button for Display Courses
        JButton displayCoursesButton = new JButton("Display Courses");
        displayCoursesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder courseList = new StringBuilder();
                for (Course course : supervisor.getCourses()) {
                    courseList.append("Title: ").append(course.getTitle())
                            .append(", Instructor: ").append(course.getInstructor())
                            .append(", Area: ").append(course.getArea()).append("\n");
                }
                displayArea.setText(courseList.toString());
            }
        });

        // Button for Search by Title
        JButton searchByTitleButton = new JButton("Search by Title");
        searchByTitleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog(frame, "Enter title to search:");
                displaySearchResults(supervisor.searchByTitle(title));
            }
        });

        // Button for Search by Instructor
        JButton searchByInstructorButton = new JButton("Search by Instructor");
        searchByInstructorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String instructor = JOptionPane.showInputDialog(frame, "Enter instructor name to search:");
                displaySearchResults(supervisor.searchByInstructor(instructor));
            }
        });

        // Button for Search by Area
        JButton searchByAreaButton = new JButton("Search by Area");
        searchByAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String area = JOptionPane.showInputDialog(frame, "Enter area to search:");
                displaySearchResults(supervisor.searchByArea(area));
            }
        });

        // Button for Exit
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the application window
            }
        });

        // Add all buttons to the panel
        buttonPanel.add(addCourseButton);
        buttonPanel.add(displayCoursesButton);
        buttonPanel.add(searchByTitleButton);
        buttonPanel.add(searchByInstructorButton);
        buttonPanel.add(searchByAreaButton);
        buttonPanel.add(exitButton);

        // Add the button panel to the frame
        frame.add(buttonPanel, BorderLayout.WEST);

        // Create a display area for showing courses or search results
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    // Method to display search results
    private void displaySearchResults(java.util.List<Course> courses) {
        StringBuilder result = new StringBuilder();
        if (courses.isEmpty()) {
            result.append("No courses found.");
        } else {
            for (Course course : courses) {
                result.append("Found: ").append(course.getTitle())
                        .append(", Instructor: ").append(course.getInstructor())
                        .append(", Area: ").append(course.getArea()).append("\n");
            }
        }
        displayArea.setText(result.toString());
    }

    public void show() {
        frame.setVisible(true);
    }
}
