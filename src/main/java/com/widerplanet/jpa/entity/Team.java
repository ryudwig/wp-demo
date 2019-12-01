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
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @GeneratedValue
    @Id
    private Long id;
    private String teamName;
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Member> members = new ArrayList<Member>();
    private int memberNum;
    public Team(String name){
        this.teamName = name;
    }
}
