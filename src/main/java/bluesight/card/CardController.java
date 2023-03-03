package bluesight.card;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
@Tag(name = "Operations by Card")
public class CardController {

    private CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @GetMapping
    private List<CardDto> listAllCard(){
    return service.listAllCard();
    }

    @GetMapping("/{id}")
    private CardDto findCardById(@PathVariable("id") Long id){
        return service.findCardById(id);
    }

    @GetMapping("/swimlane/{id}")
    private List<CardDto> listCardBySwimlane(@PathVariable("id") Long id){
        return service.listCardBySwimlane(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a card")
    @ApiResponse(responseCode = "201", description = "card has been created")
    public CardDto createCard(@RequestBody CardCommand command){
        return service.createCard(command);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update the card")
    public CardDto updateCard(@PathVariable("id") Long id, @RequestBody UpdateCard command){
        return service.updateCard(id, command);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete card")
    @ApiResponse(responseCode = "204", description = "Card has been deleted")
    public void deleteCard(@PathVariable("id") Long id){
        service.deleteCard(id);
    }



}
