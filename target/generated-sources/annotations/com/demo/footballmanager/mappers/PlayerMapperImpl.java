package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.models.entities.Team;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14 (Ubuntu)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Autowired
    private PlayerMapperResolver playerMapperResolver;

    @Override
    public PlayerDto map(Player player) {
        if ( player == null ) {
            return null;
        }

        Long teamId = null;
        Long id = null;
        Integer age = null;
        String lastName = null;
        String firstName = null;
        String careerStartDate = null;

        Long id1 = playerTeamId( player );
        if ( id1 != null ) {
            teamId = id1;
        }
        if ( player.getId() != null ) {
            id = player.getId();
        }
        if ( player.getAge() != null ) {
            age = player.getAge();
        }
        if ( player.getLastName() != null ) {
            lastName = player.getLastName();
        }
        if ( player.getFirstName() != null ) {
            firstName = player.getFirstName();
        }
        if ( player.getCareerStartDate() != null ) {
            careerStartDate = DateTimeFormatter.ISO_LOCAL_DATE.format( player.getCareerStartDate() );
        }

        PlayerDto playerDto = new PlayerDto( id, age, lastName, firstName, careerStartDate, teamId );

        return playerDto;
    }

    @Override
    public Player map(PlayerDto playerDto) {
        if ( playerDto == null ) {
            return null;
        }

        Player player = playerMapperResolver.resolve( playerDto );

        if ( playerDto.getId() != null ) {
            player.setId( playerDto.getId() );
        }
        if ( playerDto.getAge() != null ) {
            player.setAge( playerDto.getAge() );
        }
        if ( playerDto.getLastName() != null ) {
            player.setLastName( playerDto.getLastName() );
        }
        if ( playerDto.getFirstName() != null ) {
            player.setFirstName( playerDto.getFirstName() );
        }
        if ( playerDto.getCareerStartDate() != null ) {
            player.setCareerStartDate( LocalDate.parse( playerDto.getCareerStartDate() ) );
        }

        return player;
    }

    @Override
    public List<PlayerDto> map(List<Player> players) {
        if ( players == null ) {
            return null;
        }

        List<PlayerDto> list = new ArrayList<PlayerDto>( players.size() );
        for ( Player player : players ) {
            list.add( map( player ) );
        }

        return list;
    }

    private Long playerTeamId(Player player) {
        if ( player == null ) {
            return null;
        }
        Team team = player.getTeam();
        if ( team == null ) {
            return null;
        }
        Long id = team.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
