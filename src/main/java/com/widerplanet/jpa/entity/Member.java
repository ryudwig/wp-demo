package com.widerplanet.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
// CUSTOM JPQL 정의
@NamedQuery( name = "Member.findAllByTeamName", query = "select m from Member m where m.team.teamName = ?1" )
@ToString(exclude = "team")
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @GeneratedValue
    @Id
    private Long mid;
    private String name;
    @ManyToOne(cascade=CascadeType.DETACH)
    @JoinColumn(name="ID")
    private Team team;

    public Member(String name){
        this.name = name;
    }

}
