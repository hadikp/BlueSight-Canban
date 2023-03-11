package bluesight.card;

import bluesight.col.Col;
import bluesight.col.ColNotFoundException;
import bluesight.col.ColRepository;
import bluesight.swimlane.Swimlane;
import bluesight.swimlane.SwimlaneNotFoundException;
import bluesight.swimlane.SwimlaneRepository;
import bluesight.user.User;
import bluesight.user.UserNotfoundException;
import bluesight.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CardService {

    private CardRepository cardRepository;
    private SwimlaneRepository swimlaneRepository;
    private ColRepository colRepository;
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public List<CardDto> listAllCard() {
        List<Card> cards = cardRepository.findAll();
        for (Card card: cards) {
            SetCardExistTime(card);
        }
        return cards.stream().map(c -> modelMapper.map(c, CardDto.class)).collect(Collectors.toList());
    }

    public CardDto findCardById(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        SetCardExistTime(card);
        return modelMapper.map(card, CardDto.class);
    }

    private static void SetCardExistTime(Card card) {
        CardExistTime cardExistTime = card.nowMinusStartDate();
        card.setCardExistTime(cardExistTime);
    }

    public List<CardDto> listCardBySwimlane(Long id) {
        List<Card> cards = swimlaneRepository.listCardThisSwimlane(id).getCards();
        for (Card card: cards) {
            SetCardExistTime(card);
        }
        return cards.stream().map(c -> modelMapper.map(c, CardDto.class)).collect(Collectors.toList());
    }

    public CardDto createCard(CardCommand command) {
        LocalDate createDate = LocalDate.now();
        LocalDate openDate = LocalDate.now();
        Card card = new Card(command.getTitle(), command.getDescription(), createDate, openDate, command.getPriority(), command.getPositionNumber(),
                 command.getDueAt());
        Long colId = command.getColId();
        Long userId = command.getUserId();
        Long swimlaneId = command.getSwimlaneId();
        Col findCol = colRepository.findById(colId).orElseThrow(() -> new ColNotFoundException(colId));
        User findUser = userRepository.findById(userId).orElseThrow(() -> new UserNotfoundException(userId));
        Swimlane findSwimlane = swimlaneRepository.findById(swimlaneId).orElseThrow(() -> new SwimlaneNotFoundException(swimlaneId));
        findCol.addNewCard(card);
        findUser.addCard(card);
        findSwimlane.addCard(card);
        cardRepository.save(card);
        return modelMapper.map(card, CardDto.class);
    }

    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    @Transactional
    public CardDto updateCard(Long id, UpdateCard command) {
        Card findCard = cardRepository.findById(id).orElseThrow(() -> new CardNotFoundException(id));
        findCard.setTitle(command.getTitle());
        findCard.setDescription(command.getDescription());
        findCard.setPriority(command.getPriority());
        findCard.setPositionNumber(command.getPositionNumber());
        findCard.setDueAt(command.getDueAt());
        return modelMapper.map(findCard, CardDto.class);

    }

    @Transactional
    public CardDto updateCardPosition(Long cardId, UpdateCardPosition command) {
        Card findCard = cardRepository.findById(cardId).orElseThrow(() -> new CardNotFoundException(cardId));
        findCard.setPositionNumber(command.getPositionNumber());
        return modelMapper.map(findCard, CardDto.class);
    }
}
