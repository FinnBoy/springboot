package net.awaken.springboot;

import net.awaken.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //this.userService.saveRole("test_role");
        this.userService.getRole(1l);
        //this.userService.saveUser("Finn", "email@unknown.com");
    }
}
