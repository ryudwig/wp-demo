package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long > {
    public List<Member> findByName(String name);
    public Member findByMid(Long id);

    public List<Member> findAllByTeamName(String teamName);
}
