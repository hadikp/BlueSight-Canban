package bluesight.squad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SquadDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private Long boardId;
}
