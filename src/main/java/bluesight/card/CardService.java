package bluesight.card;

import bluesight.swimlane.SwimlaneRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository repository;
    private SwimlaneRepository swimlaneRepository;
    private ModelMapper modelMapper;

    public List<CardDto> listAllCard() {
        List<Card> cards = repository.findAll();
        for (Card card: cards) {
            SetCardExistTime(card);
        }
        return cards.stream().map(c -> modelMapper.map(c, CardDto.class)).collect(Collectors.toList());
    }

    public CardDto findCardById(Long id) {
        Card card = repository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        SetCardExistTime(card);
        return modelMapper.map(card, CardDto.class);
    }

    private static void SetCardExistTime(Card card) {
        CardExistTime cardExistTime = card.nowMinusStartDate();
        card.setCardExistTime(cardExistTime);
    }

    public List<CardDto> listCardBySwimlane(Long id) {
        List<Card> cards = swimlaneRepository.listCardThisSwimlane(id).getCards();
        return cards.stream().map(c -> modelMapper.map(c, CardDto.class)).collect(Collectors.toList());
    }
}
