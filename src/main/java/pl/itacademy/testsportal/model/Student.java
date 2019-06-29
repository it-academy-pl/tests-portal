package pl.itacademy.testsportal.model;

import pl.itacademy.testsportal.validate.FieldMatch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity(name = "Student")
@Table(name = "STUDENT")
@FieldMatch(first = "password", second = "repeatPassword", message = "Hasła muszą być takie same")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    @OneToMany(mappedBy = "student")
    private List<Task> tasks;

    public Student() {
    }

    public Student(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

}