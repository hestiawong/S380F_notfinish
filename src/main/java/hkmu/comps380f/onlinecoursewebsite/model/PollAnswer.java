/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pollanswer")
public class PollAnswer implements Serializable {

    private int answerId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private PollQuestion pollQuestion;

    private String pollAnswer;

    public PollAnswer() {
    }

    ;
    
    public PollAnswer(PollQuestion pollQuestion, int answerId, String pollAnswer) {
        this.pollQuestion = pollQuestion;
        this.answerId = answerId;
        this.pollAnswer = pollAnswer;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public PollQuestion getPollQuestion() {
        return pollQuestion;
    }

    public void setPollQuestion(PollQuestion pollQuestion) {
        this.pollQuestion = pollQuestion;
    }

    public String getPollAnswer() {
        return pollAnswer;
    }

    public void setPollAnswer(String pollAnswer) {
        this.pollAnswer = pollAnswer;
    }

}
