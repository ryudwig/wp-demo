package com.widerplanet.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@ToString
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
