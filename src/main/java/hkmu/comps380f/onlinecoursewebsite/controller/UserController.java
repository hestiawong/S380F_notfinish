package hkmu.comps380f.onlinecoursewebsite.controller;

import hkmu.comps380f.onlinecoursewebsite.dao.WebUserRepository;
import hkmu.comps380f.onlinecoursewebsite.model.WebUser;
import java.io.IOException;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/userlist")
public class UserController {

    @Resource
    WebUserRepository WebUserRepo;

    @GetMapping
    public String userList(ModelMap model) {
        model.addAttribute("WebUsers", WebUserRepo.findAll());
        return "userList";
    }

    @GetMapping("/delete/{username}")
    public View deleteUser(@PathVariable("username") String username) {
        WebUserRepo.delete(WebUserRepo.findById(username).orElse(null));
        return new RedirectView("/userlist", true);
    }

    @GetMapping("/edit/{username}")
    public ModelAndView editUser(@PathVariable("username") String username) {
        WebUser user = WebUserRepo.findById(username).orElse(null);

        ModelAndView modelAndView = new ModelAndView("editUser");
        modelAndView.addObject("WebUser", user);

        Form userForm = new Form();
        userForm.setAddress(user.getAddress());
        userForm.setFullname(user.getFullname());
        userForm.setRoles(user.getRoles());
        userForm.setPhone(user.getPhone());
        modelAndView.addObject("UserForm", userForm);

        return modelAndView;
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

        public String getPhone() {
            return phone;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
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

    @PostMapping("/edit/{username}")
    public View editUser(@PathVariable("username") String username, Form form) throws IOException {
        WebUser updatedUser = WebUserRepo.findById(username).orElse(null);
        updatedUser.setRoles(form.getRoles());
        updatedUser.setPhone(form.getPhone());
        updatedUser.setFullname(form.getFullname());
        updatedUser.setAddress(form.getAddress());
        WebUserRepo.save(updatedUser);
        return new RedirectView("/userlist", true);
    }

}

