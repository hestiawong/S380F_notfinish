
package hkmu.comps380f.onlinecoursewebsite.dao;

import hkmu.comps380f.onlinecoursewebsite.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String>{
    
}
