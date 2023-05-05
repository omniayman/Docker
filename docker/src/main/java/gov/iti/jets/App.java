package gov.iti.jets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {

        System.out.println("args = " + Arrays.toString(args));
        SpringApplication.run(App.class, args);
    }
}

