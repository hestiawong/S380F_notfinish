package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pollrespone")
public class PollRespone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int respone_id;
    
    private int question_id;
    
    private int answer_id;
    
    private String username;
    
    public PollRespone(){};
    
     public PollRespone(int question_id,int answer_id,String username){
     this.question_id = question_id;
     this.answer_id = answer_id;
     this.username = username;
     };

    public int getRespone_id() {
        return respone_id;
    }

    public void setRespone_id(int respone_id) {
        this.respone_id = respone_id;
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
