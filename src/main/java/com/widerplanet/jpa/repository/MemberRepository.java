package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long >, MemberCustomRepository {
    @Override
    @EntityGraph(attributePaths = {"team"}, type = EntityGraph.EntityGraphType.LOAD)
    public List<Member> findAll();

    /**
     * JpaRepository Method명을 이용 (default Lazy Loading)
     * @param name
     * @return
     */
    public List<Member> findByName(String name);

    /**
     * JpaRepository Method명을 이용 (default Lazy Loading)
     * @param id
     * @return
     */
    public Member findByMid(Long id);

    /**
     * NamedQuery Test
     * Method명을 가지고 NamedQuery를 먼저 찾고, 없는 경우 Method Naming Rule을 따름
     * @param teamName
     * @return
     */
    public List<Member> findAllByTeamName(String teamName);

    /**
     * JpaRepository의 Method Naming Rule을 따르는 복잡한 Query ( 메소드 선언 만하고 구현 필요없음 )
     * @param name
     * @return
     */
    public List<Member> findByNameLikeOrderByName(String name);
}
