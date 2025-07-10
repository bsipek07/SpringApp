package hr.java.spring.boot.Example;

import hr.java.spring.boot.Example.data.Hardver;
import hr.java.spring.boot.Example.data.TipHardvera;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import hr.java.spring.boot.Example.repository.HardverRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class Main  {

    @Autowired
    private HardverRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }


}
