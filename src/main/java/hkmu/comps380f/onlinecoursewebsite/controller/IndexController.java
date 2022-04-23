package hkmu.comps380f.onlinecoursewebsite.controller;

import hkmu.comps380f.onlinecoursewebsite.dao.WebUserRepository;
import hkmu.comps380f.onlinecoursewebsite.model.WebUser;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class IndexController {

    @Resource
    WebUserRepository WebUserRepo;

    @GetMapping
    public String index() {
        return "redirect:/course";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    public static class Form {

        private String username;
        private String password;
        private String phone;
        private String fullname;
        private String address;
        private String roles;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }

    @GetMapping("/createUser")
    public ModelAndView toCeateUser() {
        return new ModelAndView("createUser", "WebUser", new Form());
    }

    @PostMapping("/createUser")
    public View createUser(Form form) throws IOException {
        WebUser user = new WebUser(form.getUsername(),
                form.getPassword(), form.getPhone(), form.getFullname(), form.getAddress(), form.getRoles());
        WebUserRepo.save(user);
        return new RedirectView("/course", true);
    }

}
