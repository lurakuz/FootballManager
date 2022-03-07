package com.demo.footballmanager.repository;

import com.demo.footballmanager.models.entities.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

    @Query("Select p from Player p where p.id in :ids")
    Page<Player> findByIds(@Param("ids") List<Long> postIdsList, Pageable pageRequest);
}
