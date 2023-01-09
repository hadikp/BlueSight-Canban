package bluesight.swimlane;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class SwimlaneNotFoundException extends AbstractThrowableProblem {
    public SwimlaneNotFoundException(Long id) {
        super(
                URI.create("swimlane/not-found"),
                "Not found",
                Status.NOT_FOUND,
                String.format("Swimlane not found %d", id)
        );
    }
}
