package com.demo.footballmanager.models.entities;

import lombok.*;
import lombok.ToString.Exclude;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
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
