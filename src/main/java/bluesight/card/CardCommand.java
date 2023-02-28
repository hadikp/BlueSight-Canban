package bluesight.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardCommand {

    private String title;
    private String description;
    private int priority;
    private int positionNumber;
    private LocalDate dueAt;
    private Long colId;
    private Long userId;
    private Long swimlaneId;
}
