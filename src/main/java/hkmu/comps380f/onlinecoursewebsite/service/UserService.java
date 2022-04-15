package hkmu.comps380f.onlinecoursewebsite.service;

import hkmu.comps380f.onlinecoursewebsite.model.WebUser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import hkmu.comps380f.onlinecoursewebsite.dao.WebUserRepository;

@Service
public class UserService implements UserDetailsService {

    @Resource
    WebUserRepository UserRepo;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        WebUser user = UserRepo.findById(username).orElse(null);
        if (user == null) {
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoles()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
