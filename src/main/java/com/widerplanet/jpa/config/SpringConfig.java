package com.widerplanet.jpa.config;

import com.widerplanet.jpa.entity.Member;
import com.widerplanet.jpa.entity.Team;
import com.widerplanet.jpa.repository.MemberRepository;
import com.widerplanet.jpa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;



    @Bean
    public void init(){
        Member member1 = new Member("Ryu");
        Member member2 = new Member("Lee");

        Team team = new Team("Tigers");
        teamRepository.save(team);

        teamRepository.flush();

        member1.setTeam(team);
        member2.setTeam(team);

        memberRepository.save(member1);
        memberRepository.save(member2);

        memberRepository.flush();

    }
}
