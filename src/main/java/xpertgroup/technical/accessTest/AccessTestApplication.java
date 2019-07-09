package xpertgroup.technical.accessTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"xpertgroup.technical"})
public class AccessTestApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(AccessTestApplication.class, args);
	}

}
