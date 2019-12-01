package com.widerplanet.jpa.resource;

import com.widerplanet.jpa.entity.Member;
import com.widerplanet.jpa.repository.MemberRepository;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/members")
public class MemberResource {

    @Autowired
    private MemberRepository repository;

    @GetMapping("/")
    public List<Member> getMembers(){
        return repository.findAll();
    }

    @GetMapping("/{name}")
    public List<Member> getMember(@PathVariable("name") final String memberName){
        return repository.findByName(memberName);
    }

    @PostMapping("/member")
    public Member createEmployee(@Valid @RequestBody Member member) {
        return repository.save(member);
    }

    // NamedQuery Test (JPQL)
    @ApiOperation(value = "팀 멤버들 조회", notes = "팀 이름으로 모든 멤버들 가져오기(Named JPQL Test)")
    @GetMapping("/team/{team}")
    public List<Member> getTeamMembers(@PathVariable("team") final String teamName){
        return repository.findAllByTeamName(teamName);
    }




}
