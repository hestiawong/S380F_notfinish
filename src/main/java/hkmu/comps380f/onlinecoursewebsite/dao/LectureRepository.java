
package hkmu.comps380f.onlinecoursewebsite.dao;

import hkmu.comps380f.onlinecoursewebsite.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long>{
    
}
