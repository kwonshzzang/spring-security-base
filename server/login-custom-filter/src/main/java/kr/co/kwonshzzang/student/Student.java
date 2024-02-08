package kr.co.kwonshzzang.student;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    private String id;
    private String userName;
    private Set<GrantedAuthority> roles;
}
