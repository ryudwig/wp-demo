package com.widerplanet.jpa.resource;

import com.widerplanet.jpa.entity.Member;
import com.widerplanet.jpa.entity.Team;
import com.widerplanet.jpa.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @PostMapping("/team")
    public Team createTeam(@Valid @RequestBody Team team) {
        return teamRepository.save(team);
    }
}
