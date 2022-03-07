package com.demo.footballmanager.repository;

import com.demo.footballmanager.models.entities.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
}
