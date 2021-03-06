package pl.itacademy.testsportal.model;

import pl.itacademy.testsportal.validate.FieldMatch;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity(name = "Student")
@Table(name = "STUDENT")
//@FieldMatch(first = "password", second = "repeatPassword", message = "Hasła muszą być takie same")
public class Student {
    @Id
    private long index;
    @Size(min = 2, message = "Imię jest za krótkie")
    @Size(max = 30, message = "Imię jest za długie")
    private String name;
    private String surname;
    @Email
    private String email;
    @Size(min = 7, message = "za krótkie hasło")
    private String password;

    @Transient
    private String repeatPassword;
    private Date lastLogin;

    @OneToMany
    private List<Task> tasks;


    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;


    public Student() {
    }

    public Student(long index, String name, String surname, String email, String password) {
        this.index = index;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
