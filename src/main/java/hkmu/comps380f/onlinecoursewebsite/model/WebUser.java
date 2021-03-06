package hkmu.comps380f.onlinecoursewebsite.model;

import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "users")
public class WebUser implements Serializable {

    @Id
    private String username;

    private String password;

    private String phone;

    private String fullname;

    private String address;

    private String roles;

    public WebUser() {
    }

    public WebUser(String username, String password, String phone, String fullname, String address, String roles) {
        this.username = username;
        this.password = "{noop}" + password;

        this.roles = roles;

        this.phone = phone;
        this.fullname = fullname;
        this.address = address;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

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
