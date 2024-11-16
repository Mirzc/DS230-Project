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