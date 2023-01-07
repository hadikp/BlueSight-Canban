package bluesight.squad;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class SquadNotFoundException extends AbstractThrowableProblem {
    public SquadNotFoundException(Long id) {
        super(
                URI.create("squad/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Squad not found %d", id)
        );
    }
}
