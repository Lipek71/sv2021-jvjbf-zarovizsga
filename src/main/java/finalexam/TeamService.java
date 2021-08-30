package finalexam;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TeamService {

    private TeamRepository teamRepository;

    private PlayerRepository playerRepository;

    private ModelMapper modelMapper;

    public List<TeamDTO> listTeams(Optional<String> name) {
        return teamRepository.findAll().stream()
                .filter(a -> name.isEmpty() || a.getName().toLowerCase().contains(name.get().toLowerCase()))
                .map(a -> modelMapper.map(a, TeamDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());

        teamRepository.save(team);

        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addNewPlayerToTeam(long id, CreatePlayerCommand command) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new NotFoundExeption(id));
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());
        team.addPlayer(player);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public TeamDTO addExistingPlayerToTeam(long id, UpdateWithExistingPlayerCommand command) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new NotFoundExeption(id));
        Player player = playerRepository.findById(command.getId()).orElseThrow(() -> new NotFoundExeption(command.getId()));

        /*int playersOfPosition = 0;
        for(Player player1 : team.getPlayers()) {
            if (player1.getPosition().equals(player.getPosition())){
                playersOfPosition++;
            }
        }

        if ((player.getTeam() == null) && (playersOfPosition < 1)) {
            player.setTeam(team);
        }*/

        if (player.hasNoTeam() && hasEmptyPosition(team, player)){
            team.addPlayer(player);
        }

        return modelMapper.map(team, TeamDTO.class);
    }

    private boolean hasEmptyPosition(Team team, Player player){
        return team.getPlayers().stream()
                .filter(p->p.getPosition()==player.getPosition())
                .collect(Collectors.toList()).size() < 2;
    }
}
