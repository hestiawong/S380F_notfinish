
package hkmu.comps380f.onlinecoursewebsite.service;

import hkmu.comps380f.onlinecoursewebsite.dao.CommentRepository;
import hkmu.comps380f.onlinecoursewebsite.model.Comment;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Resource
    CommentRepository commentRepository;
    
    @Transactional
    public List<Comment> findUserComment(String username) {
        return commentRepository.findByUsername(username);
    }
}
