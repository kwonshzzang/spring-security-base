package kr.co.kwonshzzang.student;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

@Component
public class StudentManager implements AuthenticationProvider, InitializingBean {
    private Map<String, Student> studentDB = new HashMap<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        if(studentDB.containsKey(token.getName())) {
            Student student = studentDB.get(token.getName());
            return StudentAuthenticationToken.builder()
                    .principal(student)
                    .details(student.getUserName())
                    .authenticated(true)
                    .build();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == UsernamePasswordAuthenticationToken.class;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        Set.of(
                Student.builder().id("hong").userName("홍길동").roles(Set.of(new SimpleGrantedAuthority("ROLE_USER"))).build(),
                Student.builder().id("kang").userName("강아지").roles(Set.of(new SimpleGrantedAuthority("ROLE_USER"))).build(),
                Student.builder().id("rang").userName("호랑이").roles(Set.of(new SimpleGrantedAuthority("ROLE_USER"))).build()
        ).forEach(s -> studentDB.put(s.getId(), s));
    }
}
