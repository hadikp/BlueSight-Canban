package bluesight.card;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
