package finalexam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/teams")
@Tag(name = "Operations on teams")
public class TeamController {

    final private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    @Operation(summary = "List conditioned teams")
    public List<TeamDTO> listTeams(@RequestParam Optional<String> name) {
        return teamService.listTeams(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a team")
    @ApiResponse(responseCode = "201", description = "Team has been created.")
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamCommand command) {
        return teamService.createTeam(command);
    }

    @PostMapping("/{id}/players")
    @Operation(summary = "Add a new player by id")
    public TeamDTO addNewPlayerToTeam(@PathVariable("id") long id, @RequestBody @Valid CreatePlayerCommand command){
        return teamService.addNewPlayerToTeam(id, command);
    }

    @PutMapping("/{id}/players")
    @Operation(summary = "Add an existing player by id")
    public TeamDTO addExistingPlayerToTeam(@PathVariable("id") long id, @RequestBody UpdateWithExistingPlayerCommand command){
        return teamService.addExistingPlayerToTeam(id, command);
    }

}
