package com.widerplanet.jpa;

import com.widerplanet.jpa.entity.Member;
import com.widerplanet.jpa.entity.Team;
import com.widerplanet.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaApplication {



    public static void main(String[] args) {

        SpringApplication.run(JpaApplication.class, args);

    }
}
