package com.widerplanet.jpa.resource;

import com.widerplanet.jpa.entity.Member;
import com.widerplanet.jpa.repository.MemberRepository;
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
    public Member getMember(@PathVariable("name") final String memberName){
        return repository.findByName(memberName);
    }

    @PostMapping("/member")
    public Member createEmployee(@Valid @RequestBody Member member) {
        return repository.save(member);
    }





}
