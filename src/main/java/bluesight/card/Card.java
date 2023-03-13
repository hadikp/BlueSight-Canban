package bluesight.card;

import bluesight.col.Col;
import bluesight.swimlane.Swimlane;
import bluesight.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    private int priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "position_number")
    private int positionNumber;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "opened_at")
    private LocalDate openedAt;

    @Column(name = "closed_at")
    private LocalDate closedAt;

    @Column(name = "due_at")
    private LocalDate dueAt;

    @Embedded
    @Transient
    private CardExistTime cardExistTime;

    @ManyToOne
    private Col col;

    @ManyToOne
    private User user;

    @ManyToOne
    private Swimlane swimlane;

    public Card(String title, String description, LocalDate createDate) {
        this.title = title;
        this.description = description;
        this.createDate = createDate;
    }

    public Card(String title, String description, LocalDate createDate, LocalDate openedAt, int priority, Status status, int positionNumber, LocalDate dueAt) {
        this(title, description, createDate);
        this.openedAt = openedAt;
        this.priority = priority;
        this.status = status;
        this.positionNumber = positionNumber;
        this.dueAt = dueAt;
    }

    public Card(String title, String description, int priority, Status status, int positionNumber, LocalDate createDate, LocalDate openedAt, LocalDate closedAt, LocalDate dueAt) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.positionNumber = positionNumber;
        this.createDate = createDate;
        this.openedAt = openedAt;
        this.closedAt = closedAt;
        this.dueAt = dueAt;
    }

    public CardExistTime nowMinusStartDate(){
        LocalDate dateNow = LocalDate.now();
        long createDateInSecond = this.createDate.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN);
        long nowInSecond = dateNow.toEpochSecond(LocalTime.NOON, ZoneOffset.MIN);
        long existInDay = (nowInSecond - createDateInSecond) / 60 / 60 / 24;
        int existInWeek = (int) (existInDay / 7);
        long remainDays = existInDay - existInWeek * 7;

        CardExistTime cardExistTime = new CardExistTime(existInWeek, remainDays);

        return cardExistTime;
    }
}
