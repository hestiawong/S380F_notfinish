
package hkmu.comps380f.onlinecoursewebsite.controller;

import hkmu.comps380f.onlinecoursewebsite.dao.CourseRepository;
import hkmu.comps380f.onlinecoursewebsite.dao.LectureRepository;
import hkmu.comps380f.onlinecoursewebsite.model.Course;
import hkmu.comps380f.onlinecoursewebsite.model.Lecture;
import java.util.List;
import javax.annotation.Resource;
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
    
    @Resource
    CourseRepository courseRepo;
    
    @Resource
    LectureRepository lectureRepo;
            
    
    @GetMapping({"","/list"})
    public String list(ModelMap model) {
        model.addAttribute("course", courseRepo.findAll());
        return "list";
    }
    
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
    public View createCourse(Form form) {
       Course course = courseRepo.findById(form.getCoursename()).orElse(null);
       if(course == null){
       Course newcourse = new Course(form.getCoursename(), form.getLecturetitle());
       courseRepo.save(newcourse);
       }else{
       Lecture lecture = new Lecture(course,form.getLecturetitle());
       lectureRepo.save(lecture);}
       return new RedirectView("/course/list", true);
    }
    
//    @GetMapping("/{id}")
//    public ModelAndView createCourse(ModelMap model, @PathVariable("id") Long id) {
//       model.addAttribute("lecture", lectureRepo.findById(id));
//       return new ModelAndView("lecturePage", "AttachmentForm", new Form());
//    }
//    
//    @PostMapping("/create")
//    public String createAttachment(Form form, Principal principal) throws IOException {
//        long ticketId = ticketService.createTicket(principal.getName(),
//                form.getSubject(), form.getBody(), form.getAttachments());
//        return "redirect:/ticket/view/" + ticketId;
//    }
    
    
    public static class Form {
        private String coursename;
        private String lecturetitle;
        private List<MultipartFile> attachments;

        public List<MultipartFile> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<MultipartFile> attachments) {
            this.attachments = attachments;
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
        
        
    }
}
