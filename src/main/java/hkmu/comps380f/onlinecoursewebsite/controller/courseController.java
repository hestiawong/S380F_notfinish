package hkmu.comps380f.onlinecoursewebsite.controller;

import hkmu.comps380f.onlinecoursewebsite.dao.CommentRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.CourseRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.LectureRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.PollAnswerRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.PollQuestionRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.PollResponeRepository;
import hkmu.comps380f.onlinecoursewebsite.exception.AttachmentNotFound;
import hkmu.comps380f.onlinecoursewebsite.exception.LectureNotFound;
import hkmu.comps380f.onlinecoursewebsite.model.Attachment;
import hkmu.comps380f.onlinecoursewebsite.model.Comment;
import hkmu.comps380f.onlinecoursewebsite.model.Course;
import hkmu.comps380f.onlinecoursewebsite.model.Lecture;
import hkmu.comps380f.onlinecoursewebsite.model.PollQuestion;
import hkmu.comps380f.onlinecoursewebsite.model.PollRespone;
import hkmu.comps380f.onlinecoursewebsite.service.AttachmentService;
import hkmu.comps380f.onlinecoursewebsite.service.CommentService;
import hkmu.comps380f.onlinecoursewebsite.service.LectureService;
import hkmu.comps380f.onlinecoursewebsite.view.DownloadingView;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/course")
public class courseController {

    @Autowired
    private LectureService lectureService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private CommentService commentService;

    @Resource
    CourseRepository courseRepo;

    @Resource
    LectureRepository lectureRepo;

    @Resource
    CommentRepository commentRepository;
    
    @Resource
    PollAnswerRepository pollAnswerRepo;
    
    @Resource
    PollQuestionRepository pollquestionRepo;
    
    @Resource
    PollResponeRepository pollResponeRepo;

    @GetMapping({"", "/list"})
    public String list(ModelMap model) {
        model.addAttribute("course", courseRepo.findAll());
        model.addAttribute("poll",pollquestionRepo.findAll());
        Poll poll = new Poll();
        model.addAttribute("p", poll);
        return "list";
    }
    
    
    @PostMapping("/vote")
    public String vote(Poll form,Principal principal) throws IOException {
        PollRespone pollRespone = new PollRespone(form.getQuestion_id(),form.getAnswer(),principal.getName()); 
        pollResponeRepo.save(pollRespone);
        return "redirect:/course";
    }
    
    
    
    public static class Poll{
        private int answer;
        private int question_id;

        public int getAnswer() {
            return answer;
        }

        public void setAnswer(int answer) {
            this.answer = answer;
        }

        public int getQuestion_id() {
            return question_id;
        }

        public void setQuestion_id(int question_id) {
            this.question_id = question_id;
        }

        
    };

    @GetMapping("/visitor")
    public String visitorlist(ModelMap model) {
        model.addAttribute("course", courseRepo.findAll());
        return "visitorlist";
    }

    @GetMapping("/deletecourse/{coursename}")
    public View deleteCourse(@PathVariable("coursename") String coursename) {
        courseRepo.delete(courseRepo.findById(coursename).orElse(null));
        return new RedirectView("/course", true);
    }

    @GetMapping("/deletelecture/{id}")
    public View deleteLecture(@PathVariable("id") Long id) {
        Lecture lecture = lectureRepo.findById(id).orElse(null);
        lectureRepo.delete(lecture);
        return new RedirectView("/course", true);
    }

    @GetMapping("/createcourse")
    public ModelAndView createCourse() {
        return new ModelAndView("createCourse", "course", new Form());
    }

    @PostMapping("/createcourse")
    public String createCourse(Form form) throws IOException {
        Course course = courseRepo.findById(form.getCoursename()).orElse(null);
        if (course == null) {
            Course newcourse = new Course(form.getCoursename());
            courseRepo.save(newcourse);
            long lectureId = lectureService.createLecture(newcourse, form.getLecturetitle(), form.getAttachments());
            return "redirect:/course/" + lectureId;
        } else {
            long lectureId = lectureService.createLecture(course, form.getLecturetitle(), form.getAttachments());
            return "redirect:/course/" + lectureId;
        }

    }

    @GetMapping("/{id}")
    public ModelAndView toLecturePage(ModelMap model, @PathVariable("id") Long id) {
        Lecture lecture = lectureRepo.findById(id).orElse(null);
        ModelAndView modelAndView = new ModelAndView("lecturePage");
        modelAndView.addObject("lecture", lecture);

        Form form = new Form();
        modelAndView.addObject("AttachmentForm", form);
        return modelAndView;
    }

    @PostMapping("/{id}")
    public String addAttachment(@PathVariable("id") long id, Form form)
            throws IOException, LectureNotFound {
        lectureService.updateLecture(id, form.getAttachments());
        return "redirect:/course/" + id;
    }

    @GetMapping("/{id}/delete/attachment/{attachment:.+}")
    public String deleteAttachment(@PathVariable("id") long id,
            @PathVariable("attachment") String name) throws AttachmentNotFound {
        lectureService.deleteAttachment(id, name);
        return "redirect:/course/" + id;
    }

    @GetMapping("/{id}/attachment/{attachment:.+}")
    public View download(@PathVariable("id") long id,
            @PathVariable("attachment") String name) {

        Attachment attachment = attachmentService.getAttachment(id, name);
        if (attachment != null) {
            return new DownloadingView(attachment.getName(),
                    attachment.getMimeContentType(), attachment.getContents());
        }
        return new RedirectView("/{id}", true);
    }

    @PostMapping("/comment/{id}")
    public String comment(@PathVariable("id") long id, Form form, Principal principal)
            throws IOException, LectureNotFound {
        lectureService.addComment(id, form.getComment(), principal.getName());
        return "redirect:/course/" + id;
    }

    @GetMapping("/{id}/delete/comment/{commentId}")
    public String deleteComment(@PathVariable("id") long id,
            @PathVariable("commentId") long commentId) {
        lectureService.deleteComment(id, commentId);
        return "redirect:/course/" + id;
    }

    @GetMapping("/comment/history")
    public ModelAndView toCommentHistory(Principal principal) {

        List<Comment> comments = commentService.findUserComment(principal.getName());
        Set<Long> set = new HashSet<>();
        for (Comment comment : comments) {
            set.add(comment.getLecture_id());
        }
        List<Lecture> lectures = new ArrayList<>();
        for (Long id : set) {
            lectures.add(lectureRepo.findById(id).orElse(null));
        }
        List<Course> courses = courseRepo.findAll();
        ModelAndView modelAndView = new ModelAndView("commentHistory");
        modelAndView.addObject("lectures", lectures);
        modelAndView.addObject("comments", comments);
        modelAndView.addObject("courses", courses);
        return modelAndView;
    }

    @GetMapping("/addPoll")
    public ModelAndView toPollPage(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("addPoll");
        PollForm pollForm = new PollForm();
        modelAndView.addObject("addPoll", pollForm);
        return modelAndView;
    };
    
    @PostMapping("/addPoll")
    public String addPoll(PollForm pollForm)
            throws IOException, LectureNotFound {
        
        String[] pollAnswer = new String[4];
        pollAnswer[0] = pollForm.getAnswer0();
        pollAnswer[1] = pollForm.getAnswer1();
        pollAnswer[2] = pollForm.getAnswer2();
        pollAnswer[3] = pollForm.getAnswer3();
        
        PollQuestion pollQuestion = new PollQuestion(pollForm.getQuestion(), pollAnswer);
        pollquestionRepo.save(pollQuestion);
       
        return "redirect:/course/";
    }
    
    
    


    public static class PollForm {

        private String question;
        private String answer0;
        private String answer1;
        private String answer2;
        private String answer3;

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getAnswer0() {
            return answer0;
        }

        public void setAnswer0(String answer0) {
            this.answer0 = answer0;
        }

        public String getAnswer1() {
            return answer1;
        }

        public void setAnswer1(String answer1) {
            this.answer1 = answer1;
        }

        public String getAnswer2() {
            return answer2;
        }

        public void setAnswer2(String answer2) {
            this.answer2 = answer2;
        }

        public String getAnswer3() {
            return answer3;
        }

        public void setAnswer3(String answer3) {
            this.answer3 = answer3;
        }

    }

    public static class Form {

        private String coursename;
        private String lecturetitle;
        private List<MultipartFile> attachments;
        private String comment;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCoursename() {
            return coursename;
        }

        public void setCoursename(String coursename) {
            this.coursename = coursename;
        }

        public String getLecturetitle() {
            return lecturetitle;
        }

        public void setLecturetitle(String lecturetitle) {
            this.lecturetitle = lecturetitle;
        }

        public List<MultipartFile> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
        }

    }
}
