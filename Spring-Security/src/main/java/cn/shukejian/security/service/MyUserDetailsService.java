package cn.shukejian.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author chaseshu
 * @date 2022/4/3 18:51
 * @apiNote
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
        // 登录逻辑
        // 连接数据库MySQL
        // TODO
        
        // String pw = BCrypt.hashpw("123456", BCrypt.gensalt());
        // UserDetails userDetails = new User("chaseshu", "{bcrypt}" + pw,
        //         AuthorityUtils.commaSeparatedStringToAuthorityList("admin, user"));
    
        UserDetails userDetails = new User("chaseshu", passwordEncoder.encode("123456"),
                        AuthorityUtils.commaSeparatedStringToAuthorityList("admin, user"));
                
        return userDetails;
    }
}
