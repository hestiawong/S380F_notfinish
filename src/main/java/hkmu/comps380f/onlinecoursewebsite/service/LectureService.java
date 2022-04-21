package hkmu.comps380f.onlinecoursewebsite.service;

import hkmu.comps380f.onlinecoursewebsite.dao.AttachmentRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.CommentRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.LectureRepository;
import hkmu.comps380f.onlinecoursewebsite.exception.AttachmentNotFound;
import hkmu.comps380f.onlinecoursewebsite.exception.LectureNotFound;
import hkmu.comps380f.onlinecoursewebsite.model.Attachment;
import hkmu.comps380f.onlinecoursewebsite.model.Comment;
import hkmu.comps380f.onlinecoursewebsite.model.Course;
import hkmu.comps380f.onlinecoursewebsite.model.Lecture;
import java.io.IOException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LectureService {

    @Resource
    private LectureRepository lectureRepo;

    @Resource
    private AttachmentRepository attachmentRepo;

    @Resource
    private CommentRepository commentRepo;

    @Transactional
    public long createLecture(Course course, String lecturetitle,
            List<MultipartFile> attachments) throws IOException {
        Lecture lecture = new Lecture();
        lecture.setCourse(course);
        lecture.setLecturetitle(lecturetitle);

        for (MultipartFile filePart : attachments) {
            Attachment attachment = new Attachment();
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            attachment.setLecture(lecture);
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null
                    && attachment.getContents().length > 0) {
                lecture.getAttachments().add(attachment);
            }
        }
        Lecture savedLecture = lectureRepo.save(lecture);
        return savedLecture.getId();
    }

    @Transactional(rollbackFor = AttachmentNotFound.class)
    public void deleteAttachment(long id, String name) throws AttachmentNotFound {
        Lecture lecture = lectureRepo.findById(id).orElse(null);
        for (Attachment attachment : lecture.getAttachments()) {
            if (attachment.getName().equals(name)) {
                lecture.deleteAttachment(attachment);
                lectureRepo.save(lecture);
                return;
            }
        }
        throw new AttachmentNotFound();
    }

    @Transactional(rollbackFor = LectureNotFound.class)
    public void updateLecture(long id, List<MultipartFile> attachments)
            throws IOException, LectureNotFound {
        Lecture updatedLecture = lectureRepo.findById(id).orElse(null);
        if (updatedLecture == null) {
            throw new LectureNotFound();
        }

        for (MultipartFile filePart : attachments) {
            Attachment attachment = new Attachment();
            attachment.setName(filePart.getOriginalFilename());
            attachment.setMimeContentType(filePart.getContentType());
            attachment.setContents(filePart.getBytes());
            attachment.setLecture(updatedLecture);
            if (attachment.getName() != null && attachment.getName().length() > 0
                    && attachment.getContents() != null
                    && attachment.getContents().length > 0) {
                updatedLecture.getAttachments().add(attachment);
            }
        }
        lectureRepo.save(updatedLecture);
    }

    @Transactional(rollbackFor = LectureNotFound.class)
    public void addComment(long id, String comment, String username)
            throws IOException, LectureNotFound {
        Lecture updatedLecture = lectureRepo.findById(id).orElse(null);
        if (updatedLecture == null) {
            throw new LectureNotFound();
        }

        Comment acomment = new Comment();
        acomment.setUsername(username);
        acomment.setComment(comment);
        acomment.setLecture(updatedLecture);

        updatedLecture.getComments().add(acomment);

        lectureRepo.save(updatedLecture);
    }

    @Transactional(rollbackFor = AttachmentNotFound.class)
    public void deleteComment(long id, long commentId) {
        Lecture lecture = lectureRepo.findById(id).orElse(null);
        for (Comment comment : lecture.getComments()) {
            if (comment.getId()==commentId) {
                lecture.deleteComment(comment);
                lectureRepo.save(lecture);
                return;

            }
        }

    }
}
