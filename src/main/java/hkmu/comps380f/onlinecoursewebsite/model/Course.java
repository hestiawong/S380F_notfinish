package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    private String coursename;

    public Course() {
    }

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Lecture> lecture = new ArrayList<>();

    public Course(String coursename, String lecturetitle) {
        this.coursename = coursename;
        this.lecture.add(new Lecture(this, lecturetitle));

    }

    public Course(String coursename) {
        this.coursename = coursename;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public List<Lecture> getLecture() {
        return lecture;
    }

    public void setLecture(List<Lecture> lecture) {
        this.lecture = lecture;
    }

}
