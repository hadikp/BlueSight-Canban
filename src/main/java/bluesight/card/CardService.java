package bluesight.card;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository repository;
    private ModelMapper modelMapper;

    public List<CardDto> listAllCard() {
        List<Card> cards = repository.findAll();
        return cards.stream().map(c -> modelMapper.map(c, CardDto.class)).collect(Collectors.toList());
    }

    public CardDto findCardById(Long id) {
        Card card = repository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        CardExistTime cardExistTime = card.nowMinusStartDate();
        CardDto cardDtoWithoutExistingTime = modelMapper.map(card, CardDto.class);
        cardDtoWithoutExistingTime.setCardExistTime(cardExistTime);
        return cardDtoWithoutExistingTime;
    }
}
