package com.yo.RealTimePolls.models.polls;

import com.yo.RealTimePolls.models.User.User;
import com.yo.RealTimePolls.models.responsePolls.ResponsePolls;
import com.yo.RealTimePolls.models.statusPolls.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Polls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPoll;

    @Column(nullable = false)
    private String question;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(nullable = false)
    private Integer responses;

    @Column(nullable = false)
    private Instant startDate;

    @Column(nullable = false)
    private Instant endDate;

    @ManyToOne
    @JoinColumn(name = "creator_id", nullable = false)
    private User creator;

    @OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
    private List<ResponsePolls> responsePolls;

    public Polls(String question, Status status, Integer responses, Instant startDate, Instant endDate, User creator) {
        this.question = question;
        this.status = status;
        this.responses = responses;
        this.startDate = startDate;
        this.endDate = endDate;
        this.creator = creator;
    }

    public Polls() {
    }
}
