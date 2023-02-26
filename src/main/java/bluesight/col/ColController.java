package bluesight.col;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/col")
@Tag(name = "Operations with Column")
public class ColController {

    private ColService service;

    public ColController(ColService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Find all Column")
    public List<ColDto> listAllColumn(){
        return service.listAllColumn();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find one Column by id")
    public ColDto findColumnById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{colId}/card/{cardId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete a specific column on a specific card")
    @ApiResponse(responseCode = "204", description = "This card has benn deleted from the col cardList")
    public void deleteCardFromColumnList(@PathVariable("colId") Long colId, @PathVariable("cardId") Long cardId){
        service.deleteCardFromColumnCardList(colId, cardId);
    }
}
