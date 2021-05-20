package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TodosPojo {

    /*
    POJO: Plain Old Java Object
    To create POJO classes; we need to follow 5 steps:
    1.Create private variables
    2.Create constructor without parameter
    3.Create constructor with all parameters
    4.Create all getters and setters
    5.Create toString()
     */

    private int userId;
    private String title;
    private boolean completed;
    public TodosPojo() {
    }
    public TodosPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    @Override
    public String toString() {
        return "TodosPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
