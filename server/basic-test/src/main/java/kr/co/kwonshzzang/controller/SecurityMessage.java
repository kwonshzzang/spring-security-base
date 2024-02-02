package kr.co.kwonshzzang.controller;

import org.springframework.security.core.Authentication;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SecurityMessage {
    private Authentication auth;
    private String messsage;
}
