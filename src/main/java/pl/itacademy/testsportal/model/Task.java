package pl.itacademy.testsportal.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="TASK")
@Table(name="TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String subject;
    private int difficulty;
    private String formula;

    @Transient
    private String studentName;

    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    private List<Parameter> parameters;

    public Task(String description,  String subject, int difficulty, Student student) {
        this.description = description;
        this.difficulty = difficulty;
        this.subject = subject;
        this.student = student;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
