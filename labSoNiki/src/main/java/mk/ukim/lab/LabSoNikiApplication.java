package mk.ukim.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LabSoNikiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabSoNikiApplication.class, args);
    }

}
