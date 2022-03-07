package com.demo.footballmanager.models.entities;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String city;
    String country;
    String teamName;

    Double accountAmount;
    Integer transferCommission;

    @Exclude
    @OneToMany(mappedBy = "team")
    List<Player> players;
}
