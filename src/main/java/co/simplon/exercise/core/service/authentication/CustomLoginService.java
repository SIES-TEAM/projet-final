package co.simplon.exercise.core.service.authentication;

import java.util.ArrayList;
import java.util.List;

import co.simplon.exercise.core.model.User;
import co.simplon.exercise.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomLoginService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findOne(email);
        if(user==null) {
            throw new UsernameNotFoundException("User name not found");
        }
//        System.out.println("User : " + user.getEmail());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        String role = user.getRole().toString();
//        System.out.println("Role : " + role);
        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }

}
