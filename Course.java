public class Course {
    //Attributes
    private String title;
    private String instructor;
    private String area;
    //Getters
    public String getTitle {
      return title;
    }
    public String grtInstructor {
      return instructor;
    }
    public String getArea {
      return area;
    }
    //Setters
    public void setTitle {
      this.title = title;
     }
    public void setInstructor {
      this.instructor = instructor; 
    }
    public void 
    setArea(String area) {
       this.area = area;
    //(Opional) Constructor - initializes attributes during object creation
    public Course(String title, String instructor , String area) {
        this.title = title;
        this.instructor = instructor;
        this.area = area; 
       }
    }
    