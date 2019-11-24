package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long > {
    public Member findByName(String name);
    public Member findByMid(Long id);
}
