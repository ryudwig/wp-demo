package com.widerplanet.jpa.repository;

import com.widerplanet.jpa.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long > {
    /**
     * "@Query"를 통한 JPQL 실행
     * @param aLong
     * @return
     */
    @Override
    @Query("select t from Team t where t.id = ?1")
    Optional<Team> findById(Long aLong);

    /**
     * "@Query"를 통한 Native Query 실행
     * @param teamName
     * @return
     */
    @Query(value = "select * from Team where team_name = ?1", nativeQuery = true)
    List<Team> findByTeamName(String teamName);




}
