package pl.itacademy.testsportal.model;

import javax.persistence.*;
import java.util.List;

@Entity(name="TASK")
@Table(name="TASK")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private String type;
    private int difficulty;

    @Transient
    private String studentName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task")
    private List<Parameter> parameters;

    public Task(String description, String type, int difficulty, Student student) {
        this.description = description;
        this.difficulty = difficulty;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
