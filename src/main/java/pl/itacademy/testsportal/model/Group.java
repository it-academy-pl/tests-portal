package pl.itacademy.testsportal.model;


import com.sun.tools.javac.util.List;

import javax.persistence.*;

@Entity(name = "Group")
@Table(name = "GROUP")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groupId;
    private int yearStarted;
    private String name;

    @OneToMany
    private List<Student> studentList;

    public Group(long groupId, int yearStarted, String name) {
        this.groupId = groupId;
        this.yearStarted = yearStarted;
        this.name = name;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public int getYearStarted() {
        return yearStarted;
    }

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
