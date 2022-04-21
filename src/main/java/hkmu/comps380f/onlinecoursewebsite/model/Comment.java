
package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    
    private String username;

    
    private String comment;

    @Column(name = "lecture_id", insertable = false, updatable = false)
    private long lecture_id;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(long lecture_id) {
        this.lecture_id = lecture_id;
    }

    

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    
    
}
