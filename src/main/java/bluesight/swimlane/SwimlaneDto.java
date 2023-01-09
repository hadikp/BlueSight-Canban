package bluesight.swimlane;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SwimlaneDto {

    private Long id;
    private String name;
    private int position_number;
    private int wipLimit;
}
