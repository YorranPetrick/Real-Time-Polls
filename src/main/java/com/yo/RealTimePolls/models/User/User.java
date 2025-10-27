package com.yo.RealTimePolls.models.User;

import com.yo.RealTimePolls.models.polls.Polls;
import com.yo.RealTimePolls.models.responsePolls.ResponsePolls;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.util.List;


@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<Polls> polls;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ResponsePolls> responsePolls;
}
