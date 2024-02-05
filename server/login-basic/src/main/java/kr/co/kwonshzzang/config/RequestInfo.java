package kr.co.kwonshzzang.config;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Builder;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RequestInfo {
    private String remoteIp;
    private String sessionId;
    private LocalDateTime loginTime;
}
