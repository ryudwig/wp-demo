package com.widerplanet.jpa.resource;

import com.widerplanet.jpa.entity.Team;
import com.widerplanet.jpa.repository.TeamRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/teams")
public class TeamResource {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/")
    public List<Team> getTeams(){
        List<Team> teams = teamRepository.findAll();
        int memberNum = 0;
        for (Team team : teams) {
            team.setMemberNum( team.getMembers().size() );
        }
        return teams;
    }

    @ApiOperation(value = "@Query를 활용한 JPQL실행", notes = "ID에 의한 Team 조회")
    @GetMapping("/team/id/{teamId}")
    public Optional<Team> getTeamById(@PathVariable("teamId") final Long teamId){

        System.out.println("[변경전]");
        Optional<Team> team = teamRepository.findById(teamId);
        Team firstFoundTeam = null;

        // JPA 1차 Cache Test (1차 Cache 사용 및 Call by Reference )

        if(team.isPresent()){
            firstFoundTeam = team.get();
            System.out.println(firstFoundTeam);

            System.out.println("[다시조회]");
            Team secondFoundTeam = teamRepository.findById(teamId).get();
            System.out.println(secondFoundTeam);

            if(firstFoundTeam.equals(secondFoundTeam)){
                System.out.println("[일치]");
            }else{
                System.out.println("[일치]");
            }

            firstFoundTeam.setTeamName("Lions");

            System.out.println("[변경후]");
            System.out.println(firstFoundTeam);
            System.out.println(secondFoundTeam);
        }
        return team;

        //return teamRepository.findById(teamId);
    }

    @ApiOperation(value = "@Query를 활용한 Native Query 실행", notes = "TeamName에 의한 Team들 조회")
    @GetMapping("/team/name/{teamName}")
    public List<Team> getTeamByName(@PathVariable("teamName") final String teamName){
        return teamRepository.findByTeamName(teamName);
    }

    @PostMapping("/team")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }
}
