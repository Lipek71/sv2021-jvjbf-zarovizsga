package finalexam;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateWithExistingPlayerCommand {

    @Schema(description = "Player id", example = "1")
    @NotBlank(message = "The id can't empty.")
    private Long id;

}
