/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hkmu.comps380f.onlinecoursewebsite.dao;

import hkmu.comps380f.onlinecoursewebsite.model.PollAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PollAnswerRepository extends JpaRepository<PollAnswer, Integer>{
    
}
