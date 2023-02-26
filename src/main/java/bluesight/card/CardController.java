package bluesight.card;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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

   /* @PostMapping("/colId/{cardId}")
    @Operation(summary = "Update the card column Id")
    public CardDto updateColId(@PathVariable("cardId") Long cardId, @RequestBody c)*/
}
