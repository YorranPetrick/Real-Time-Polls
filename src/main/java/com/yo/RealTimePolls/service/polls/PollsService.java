package com.yo.RealTimePolls.service.polls;

import com.yo.RealTimePolls.models.User.User;
import com.yo.RealTimePolls.models.polls.PollCreateRequest;
import com.yo.RealTimePolls.models.polls.Polls;
import com.yo.RealTimePolls.models.statusPolls.Status;
import com.yo.RealTimePolls.repository.PollsRepository;
import com.yo.RealTimePolls.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PollsService {

    private PollsRepository pollsRepository;
    private UserRepository userRepository;

    public PollsService(PollsRepository pollsRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.pollsRepository = pollsRepository;
    }


    public ResponseEntity<String> createPoll(PollCreateRequest request) {
        try{
            if(userRepository.existsByEmail(request.emailCreator())){
                User creator = userRepository.findByEmail(request.emailCreator());
                Integer response = 0;
                Status status = Status.ACTIVE;
                Polls poll = new Polls(request.question(), status, response, Instant.now(), Instant.parse(request.endDate()), creator);

                pollsRepository.save(poll);
                return ResponseEntity.ok("Poll created successfully.");

            }else {
                return ResponseEntity.badRequest().body("User with email " + request.emailCreator() + " does not exist.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error creating poll: " + e.getMessage());
        }

    }
}
