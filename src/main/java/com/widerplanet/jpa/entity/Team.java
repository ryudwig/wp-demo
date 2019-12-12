package com.widerplanet.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "members")
public class Team {
    @GeneratedValue
    @Id
    private Long id;
    @Column(name = "team_name")
    private String teamName;
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Member> members = new ArrayList<Member>();
    @Column(name = "member_num")
    private int memberNum = 0;
    public Team(String name){
        this.teamName = name;
    }
}
