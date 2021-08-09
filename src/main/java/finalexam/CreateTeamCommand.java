package finalexam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamCommand {
    @Schema(description = "Team name", example = "Training360 FC")
    @NotBlank(message = "The name can't empty.")
    private String name;
}
