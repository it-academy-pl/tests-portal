package pl.itacademy.testsportal.model;


import javax.persistence.*;
import java.util.List;

@Entity(name = "Group")
@Table(name="GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String subject;

    @OneToMany
    private List<Student> students;

    public Group() {
    }

    public Group(String name, String subject, List<Student> students) {
        this.name = name;
        this.subject = subject;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
