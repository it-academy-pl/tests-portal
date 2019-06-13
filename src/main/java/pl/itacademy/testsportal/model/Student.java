package pl.itacademy.testsportal.model;
import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "Student.findAll", query = "Select s from STUDENT s"),
        @NamedQuery(name = "Student.findByMail", query = "Select s from STUDENT s where s.email =:email")
})

@Entity(name = "STUDENT")
@Table(name = "STUDENT") // tak widoczna będzie w bazie danych
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @Transient
    private String repeatPassword;
    private Date lastLogin;

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

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

}