package bluesight.col;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColDto {

    private Long id;
    private String name;
    private int position_number;
    private int wip_limit;
    private int cardCount;
}
