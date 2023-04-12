package az.orient.com.auth;



import az.orient.com.model.User;
import az.orient.com.repository.UserRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    UserRepostory userRepostory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

     User userByName = userRepostory.findUserByName(username);

        return new CustomUserDetail(userByName);
    }
}
