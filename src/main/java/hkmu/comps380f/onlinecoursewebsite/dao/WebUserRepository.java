package hkmu.comps380f.onlinecoursewebsite.dao;

import hkmu.comps380f.onlinecoursewebsite.model.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserRepository extends JpaRepository<WebUser, String> {
}
