package bluesight.board;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BoardNotFoundException extends AbstractThrowableProblem {
    public BoardNotFoundException(Long id) {
        super(
                URI.create("board/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Board not found %d", id)
        );
    }
}
