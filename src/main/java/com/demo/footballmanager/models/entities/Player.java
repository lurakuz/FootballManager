package com.demo.footballmanager.models.entities;

import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private String lastName;
    private String firstName;

    private LocalDate careerStartDate;

    @Exclude
    @ManyToOne
    private Team team;
}
