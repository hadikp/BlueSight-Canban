package bluesight.card;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {

    private Long id;
    private String title;
    private String description;
    private int priority;
    private int status;
    private int position_number;
    private LocalDate createDate;
    private LocalDate openedAt;
    private LocalDate closedAt;
    private LocalDate dueAt;
    private Long colId;
    private Long userId;
    private Long swimlaneId;
    private CardExistTime cardExistTime;
}

