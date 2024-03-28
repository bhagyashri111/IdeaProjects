package model;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
@Entity
@Table
public class Teacher implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy=GenerationType.IDENTITY )
    private int teacherId;
    private String salary;
    private String TeacherName;
    @ManyToOne
    private Department department;
    public Teacher(int teacherId, String salary, String teacherName) {
        super();
        this.teacherId = teacherId;
        this.salary = salary;
        TeacherName = teacherName; }
    public Teacher() {}
    public Teacher(String salary, String tName, Department dept1) {
        this.salary=salary;
        this.TeacherName=tName;
        this.department=dept1;
    }

    public Teacher(String teacherName) {
    }

    public Department getDep() {
        return department; }
    public void setDep(Department department) {
        this.department = department;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getTeacherName() {
        return TeacherName;
    }
    public void setTeacherName(String teacherName) {
        TeacherName = teacherName; }
}