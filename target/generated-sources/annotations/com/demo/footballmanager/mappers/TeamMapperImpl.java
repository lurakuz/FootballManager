package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.TeamDto;
import com.demo.footballmanager.models.entities.Team;
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
public class TeamMapperImpl implements TeamMapper {

    @Autowired
    private TeamMapperResolver teamMapperResolver;

    @Override
    public TeamDto map(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        if ( team.getId() != null ) {
            teamDto.setId( team.getId() );
        }
        if ( team.getCity() != null ) {
            teamDto.setCity( team.getCity() );
        }
        if ( team.getCountry() != null ) {
            teamDto.setCountry( team.getCountry() );
        }
        if ( team.getTeamName() != null ) {
            teamDto.setTeamName( team.getTeamName() );
        }
        if ( team.getTransferCommission() != null ) {
            teamDto.setTransferCommission( team.getTransferCommission() );
        }
        if ( team.getAccountAmount() != null ) {
            teamDto.setAccountAmount( team.getAccountAmount() );
        }

        mapPlayerIds( teamDto, team );

        return teamDto;
    }

    @Override
    public Team map(TeamDto teamDto) {
        if ( teamDto == null ) {
            return null;
        }

        Team team = teamMapperResolver.resolve( teamDto );

        if ( teamDto.getId() != null ) {
            team.setId( teamDto.getId() );
        }
        if ( teamDto.getCity() != null ) {
            team.setCity( teamDto.getCity() );
        }
        if ( teamDto.getCountry() != null ) {
            team.setCountry( teamDto.getCountry() );
        }
        if ( teamDto.getTeamName() != null ) {
            team.setTeamName( teamDto.getTeamName() );
        }
        if ( teamDto.getAccountAmount() != null ) {
            team.setAccountAmount( teamDto.getAccountAmount() );
        }
        if ( teamDto.getTransferCommission() != null ) {
            team.setTransferCommission( teamDto.getTransferCommission() );
        }

        return team;
    }

    @Override
    public List<TeamDto> map(List<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        List<TeamDto> list = new ArrayList<TeamDto>( teams.size() );
        for ( Team team : teams ) {
            list.add( map( team ) );
        }

        return list;
    }
}
