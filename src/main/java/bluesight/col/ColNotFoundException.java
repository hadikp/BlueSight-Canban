package bluesight.col;

import org.springframework.http.HttpStatus;
import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class ColNotFoundException extends AbstractThrowableProblem {

    public ColNotFoundException(Long id) {
        super(
                URI.create("squad/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Column not found %d", id)
        );
    }
}
