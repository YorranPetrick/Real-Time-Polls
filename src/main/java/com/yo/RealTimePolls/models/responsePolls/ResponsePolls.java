package com.yo.RealTimePolls.models.responsePolls;

import com.yo.RealTimePolls.models.User.User;
import com.yo.RealTimePolls.models.polls.Polls;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class ResponsePolls {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idResponsePoll;

    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "poll_id", nullable = false)
    private Polls poll;
}
