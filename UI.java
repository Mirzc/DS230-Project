import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class UI {

    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("Course Management System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the Supervisor to handle courses
        Supervisor supervisor = new Supervisor();

        // Layout Manager
        frame.setLayout(new FlowLayout());

        // Create GUI components
        JLabel labelTitle = new JLabel("Course Title:");
        JTextField titleField = new JTextField(20);
        JLabel labelInstructor = new JLabel("Instructor:");
        JTextField instructorField = new JTextField(20);
        JLabel labelArea = new JLabel("Course Area:");
        JTextField areaField = new JTextField(20);

        JButton addCourseButton = new JButton("Add Course");
        JButton displayCoursesButton = new JButton("Display Courses");
        JTextArea displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);

        // Add components to the frame
        frame.add(labelTitle);
        frame.add(titleField);
        frame.add(labelInstructor);
        frame.add(instructorField);
        frame.add(labelArea);
        frame.add(areaField);
        frame.add(addCourseButton);
        frame.add(displayCoursesButton);
        frame.add(new JScrollPane(displayArea));

        // Action Listener for Add Course button
        addCourseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the values from the text fields
                String title = titleField.getText();
                String instructor = instructorField.getText();
                String area = areaField.getText();

                // Add the course to the Supervisor
                supervisor.addCourse(new Course(title, instructor, area));

                // Clear the text fields
                titleField.setText("");
                instructorField.setText("");
                areaField.setText("");

                // Notify the user
                JOptionPane.showMessageDialog(frame, "Course Added Successfully!");
            }
        });

        // Action Listener for Display Courses button
        displayCoursesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Display all courses in the JTextArea
                List<Course> courses = supervisor.getCourses();
                displayArea.setText(""); // Clear existing text
                for (Course course : courses) {
                    displayArea.append("Title: " + course.getTitle() + ", Instructor: " + course.getInstructor()
                            + ", Area: " + course.getArea() + "\n");
                }
            }
        });

        // Display the frame
        frame.setVisible(true);
    }
}
