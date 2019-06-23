package pl.itacademy.testsportal.model;

import javax.persistence.*;

@Entity{name="TABLE"}
@Table{name="TABLE"}
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private int difficulty;
    private Subject subject;

    public Task(String description, int difficulty) {
        this.description = description;
        this.difficulty = difficulty;
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
}
