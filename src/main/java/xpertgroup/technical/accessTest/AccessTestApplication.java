package xpertgroup.technical.accessTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessTestApplication {
        
        public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String[] args) {
		SpringApplication.run(AccessTestApplication.class, args);
	}

}
