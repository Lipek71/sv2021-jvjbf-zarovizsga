package finalexam;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;

    private ModelMapper modelMapper;

    public List<PlayerDTO> listPlayers(Optional<String> name) {
        return playerRepository.findAll().stream()
                .filter(a -> name.isEmpty() || a.getName().toLowerCase().contains(name.get().toLowerCase()))
                .map(p -> modelMapper.map(p, PlayerDTO.class))
                .collect(Collectors.toList());
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getBirthDate(), command.getPosition());

        playerRepository.save(player);

        return modelMapper.map(player, PlayerDTO.class);
    }


    public void deletePlayer(long id) {
        Player player = playerRepository.getById(id);
        if(player == null){
            throw new IllegalArgumentException("Training class not found!" + id);
        }
        playerRepository.deleteById(id);
    }
}
