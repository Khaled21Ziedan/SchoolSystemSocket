package model;
import javax.persistence.*;
@Entity
@Table(name="grades")

public class SubjectGradeBean {
    @Id
    private int id;

    @Column(name = "username")
    private String userName;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "subjectname")
    private String subjectName;
    @Column(name = "grade")
    private double grade;

    public SubjectGradeBean(String userName, String firstName, String lastName, String subjectName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subjectName = subjectName;
        this.grade = grade;
        this.userName = userName;
    }

    public SubjectGradeBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}


