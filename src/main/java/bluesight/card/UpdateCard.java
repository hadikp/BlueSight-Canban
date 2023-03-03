package bluesight.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCard {

    private String title;
    private String description;
    private int priority;
    private int positionNumber;
    private LocalDate dueAt;
}
