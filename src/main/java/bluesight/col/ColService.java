package bluesight.col;

import bluesight.card.Card;
import bluesight.card.CardNotFoundException;
import bluesight.card.CardRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColService {

    private ModelMapper modelMapper;
    private ColRepository repository;
    private CardRepository cardRepository;


    public List<ColDto> listAllColumn() {
        List<Col> cols = repository.findAll();
        return cols.stream().map(c -> modelMapper.map(c, ColDto.class)).collect(Collectors.toList());
    }

    public ColDto findById(Long id) {
        Col col = repository.findById(id).orElseThrow(() -> new ColNotFoundException(id));
        return modelMapper.map(col, ColDto.class);
    }

    /*public void deleteCardFromColumnCardList(Long colId, Long cardId) {
        Col findColumn = repository.findById(colId).orElseThrow(() -> new ColNotFoundException(colId));
        Card card = cardRepository.findById(cardId).orElseThrow(() ->new CardNotFoundException(cardId));

        //Is Card included in the col card list?
        Boolean isCardInColumnCardlist = repository.findCardThisColumn(colId).getCards().contains(card);

        if(isCardInColumnCardlist){
            System.out.println(findColumn.getCards().size());
            findColumn.deleteCardFromCardlist(card);
            System.out.println("Card deleted from ColumnCardlist.");
            System.out.println(findColumn.getCards().size());
            repository.save(findColumn);
        }else {
            System.out.println("No such card in the ColumnCardlist!");
        }
    }*/

    public void addCardToNewColumn(Long colId, Long cardId) {
        Col findColumn = repository.findById(colId).orElseThrow(() -> new ColNotFoundException(colId));
        Card card = cardRepository.findById(cardId).orElseThrow(() ->new CardNotFoundException(cardId));

        findColumn.addNewCard(card);
        repository.save(findColumn);
    }
}
