package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long > {
    @Override
    @EntityGraph(attributePaths = {"team"}, type = EntityGraph.EntityGraphType.LOAD)
    public List<Member> findAll();

    // default Lazy
    public Member findByName(String name);

    // default Lazy
    public Member findByMid(Long id);

    public List<Member> findAllByTeamName(String teamName);
}
