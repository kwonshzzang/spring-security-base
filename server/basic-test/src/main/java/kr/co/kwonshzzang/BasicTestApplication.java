package kr.co.kwonshzzang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicTestApplication {
    public static void main(String[] args) {
        Person person = Person.builder().name("kwonshzzang").build();
        SpringApplication.run(BasicTestApplication.class, args);
    }
}
