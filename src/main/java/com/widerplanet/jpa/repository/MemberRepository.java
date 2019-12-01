package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long > {
    @Override
    @EntityGraph(attributePaths = {"team"}, type = EntityGraph.EntityGraphType.LOAD)
    public List<Member> findAll();

    // default Lazy
    public List<Member> findByName(String name);

    // default Lazy
    public Member findByMid(Long id);

    // NamedQuery Test (JPQL)
    public List<Member> findAllByTeamName(String teamName);
}
