package finalexam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerCommand {

    @Schema(description = "Player name", example = "John Doe")
    @NotBlank(message = "The name can't empty.")
    private String name;

    @Schema(description = "Player date of birth", example = "1970.01.01")
    private LocalDate birthDate;

    @Schema(description = "Player's position valid value: GOALKEEPER, RIGHT_FULLBACK, LEFT_FULLBACK, CENTER_BACK, DEFENDING_MIDFIELDER, RIGHT_WINGER, LEFT_WINGER, STRIKER " , example = "GOALKEEPER")
    private PositionType position;

}
