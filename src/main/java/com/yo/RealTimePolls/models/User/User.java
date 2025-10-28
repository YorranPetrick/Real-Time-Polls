package com.yo.RealTimePolls.models.User;

import com.yo.RealTimePolls.models.polls.Polls;
import com.yo.RealTimePolls.models.responsePolls.ResponsePolls;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Entity(name = "users")
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

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User() {

    }
}
