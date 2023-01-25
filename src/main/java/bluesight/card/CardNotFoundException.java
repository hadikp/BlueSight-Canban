package bluesight.card;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class CardNotFoundException extends AbstractThrowableProblem {
    public CardNotFoundException(Long id) {
        super(
                URI.create("card/not-found"),
                "Not-found",
                Status.NOT_FOUND,
                String.format("Card not found %d", id)
        );
    }
}
