package kr.co.kwonshzzang.student;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentAuthenticationToken implements Authentication {
    private Student principal;
    private String credentials;
    private String details;
    private boolean authenticated;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return principal == null? new HashSet<>(): principal.getRoles();
    }

    @Override
    public String getName() {
        return principal == null? "" : principal.getUserName();
    }
}
