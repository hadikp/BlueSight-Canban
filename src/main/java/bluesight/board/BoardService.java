package bluesight.board;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BoardService {

    private BoardRepository repository;
    private ModelMapper modelMapper;

    public List<BoardDto> findAllBoard() {
        List<Board> boards = repository.findAll();
        return boards.stream().map(b -> modelMapper.map(b, BoardDto.class)).collect(Collectors.toList());
    }

    public BoardDto findBoardById(Long id) {
        Board board = repository.findById(id).orElseThrow(() -> new BoardNotFoundException(id));
        return modelMapper.map(board, BoardDto.class);
    }
}
