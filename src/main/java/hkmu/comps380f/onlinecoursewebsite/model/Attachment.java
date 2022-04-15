//package hkmu.comps380f.onlinecoursewebsite.model;
//
//import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.Lob;
//import javax.persistence.ManyToOne;
//
//
//@Entity
//public class Attachment implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "filename")
//    private String name;
//
//    @Column(name = "content_type")
//    private String mimeContentType;
//
//    @Column(name = "content")
//    @Basic(fetch = FetchType.LAZY)
//    @Lob
//    private byte[] contents;
//
//    @Column(name = "lecture_id", insertable = false, updatable = false)
//    private long lecture_id;
//
//    @ManyToOne
//    @JoinColumn(name = "lecture_id")
//    private Lecture lecture;
//
//    // getters and setters of all properties
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMimeContentType() {
//        return mimeContentType;
//    }
//
//    public void setMimeContentType(String mimeContentType) {
//        this.mimeContentType = mimeContentType;
//    }
//
//    public byte[] getContents() {
//        return contents;
//    }
//
//    public void setContents(byte[] contents) {
//        this.contents = contents;
//    }
//
//    public long getLecture_id() {
//        return lecture_id;
//    }
//
//    public void setLecture_id(long lecture_id) {
//        this.lecture_id = lecture_id;
//    }
//
//    public Lecture getLecture() {
//        return lecture;
//    }
//
//    public void setLecture(Lecture lecture) {
//        this.lecture = lecture;
//    }
//
//    
//}
