package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "pollrespone")
public class PollRespone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int question_id;
    
    private int answer_id;
    
    private String username;
    

    public PollRespone(){};
    
     public PollRespone(int question_id,int answer_id,String username){
     this.question_id = question_id;
     this.answer_id = answer_id;
     this.username = username;
     };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
