package finalexam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/players")
@Tag(name = "Operation on players")
public class PlayerController {

    final public PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @Operation(summary = "List conditioned agents")
    public List<PlayerDTO> listPlayers(@RequestParam Optional<String> name) {
        return playerService.listPlayers(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a player")
    @ApiResponse(responseCode = "201", description = "Player has been created.")
    public PlayerDTO createPlayer(@Valid @RequestBody CreatePlayerCommand command) {
        return playerService.createPlayer(command);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a player")
    public void deletePlayer(@PathVariable("id") long id) {
        playerService.deletePlayer(id);
    }

}
