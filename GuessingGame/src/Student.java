public class Student {
    private String name;
    private String surName;
    private String studentID;
    private String courseOfStudy;

    public Student(String name,String surName,String studentID,String courseOfStudy){
        this.name = name;
        this.surName = surName;
        this.studentID = studentID;
        this.courseOfStudy = courseOfStudy;
    }

    public String ToString(){
        return "Name: " + name + "\nSurname: " + surName + "\nStudent ID: " + studentID + "\nCourse of Study: " + courseOfStudy;
    }
}
