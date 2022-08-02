package in.ac.charusat.studentmgmtsystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    private Integer id;
    private String title;
    private String discription;

    public Course(Integer id, String title, String discription) {
        this.id = id;
        this.title = title;
        this.discription = discription;
    }

    public Course() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDiscription() {
        return discription;
    }


}