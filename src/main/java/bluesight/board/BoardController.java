package bluesight.board;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@Tag(name = "Operations the Board")
public class BoardController {

    private BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @GetMapping
    public List<BoardDto> listAllBoard(){
        return service.findAllBoard();
    }

    @GetMapping("/{id}")
    public BoardDto findBoardById(@PathVariable("id") Long id){
        return service.findBoardById(id);
    }
}
