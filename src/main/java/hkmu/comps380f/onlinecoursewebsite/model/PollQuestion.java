/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pollquestion")
public class PollQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_id;

    private String question;

    @OneToMany(mappedBy = "pollQuestion", fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<PollAnswer> pollAnswer = new ArrayList<>();
    
    public PollQuestion(){};
    public PollQuestion(String question, String[] pollAnswer) {
        this.question = question;
        int x = 0;
        for (String answer : pollAnswer) {
            this.pollAnswer.add(new PollAnswer(this, x, answer));
            x++;
        }
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<PollAnswer> getPollAnswer() {
        return pollAnswer;
    }

    public void setPollAnswer(List<PollAnswer> pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

}
