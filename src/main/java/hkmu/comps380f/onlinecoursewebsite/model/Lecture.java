package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "lecture")
public class Lecture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(insertable = false, updatable = false)
    private String coursename;
    private String lecturetitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coursename")
    private Course course;
    
//    @OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL, orphanRemoval = true)
//    @Fetch(FetchMode.SUBSELECT)
//    private List<Attachment> attachments = new ArrayList<>();

    public long getId() {
        return id;
    }

    public Lecture() {
    }

    public Lecture(Course course, String lecturetitle) {
        this.course = course;
        this.lecturetitle = lecturetitle;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getLecturetitle() {
        return lecturetitle;
    }

    public void setLecturetitle(String lecturetitle) {
        this.lecturetitle = lecturetitle;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    
//    public List<Attachment> getAttachments() {
//        return attachments;
//    }
//
//    public void setAttachments(List<Attachment> attachments) {
//        this.attachments = attachments;
//    }

//    public void deleteAttachment(Attachment attachment) {
//        attachment.setTicket(null);
//        this.attachments.remove(attachment);
//    }

}
