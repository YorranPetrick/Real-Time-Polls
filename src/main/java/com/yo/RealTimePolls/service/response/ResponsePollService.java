package com.yo.RealTimePolls.service.response;

import com.yo.RealTimePolls.models.responsePolls.ResponsePollRequest;
import com.yo.RealTimePolls.models.responsePolls.ResponsePolls;
import com.yo.RealTimePolls.repository.PollsRepository;
import com.yo.RealTimePolls.repository.ResponsePollsRepository;
import com.yo.RealTimePolls.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ResponsePollService {

    private ResponsePollsRepository responsePollsRepository;
    private UserRepository userRepository;
    private PollsRepository pollsRepository;

    public ResponsePollService(ResponsePollsRepository responsePollsRepository, UserRepository userRepository, PollsRepository pollsRepository) {
        this.userRepository = userRepository;
        this.pollsRepository = pollsRepository;
        this.responsePollsRepository = responsePollsRepository;
    }

    public ResponseEntity<String> submitResponse(ResponsePollRequest request) {
        try {
            UUID userId = UUID.fromString(request.userAnswer());
            UUID pollId = UUID.fromString(request.poll());

            if(userRepository.existsById(userId) && pollsRepository.existsById(pollId)) {

                ResponsePolls response = new ResponsePolls(
                        request.answer(),
                        userRepository.findById(UUID.fromString(request.userAnswer())).get(),
                        pollsRepository.findById(UUID.fromString(request.poll())).get()
                );

                responsePollsRepository.save(response);
                return ResponseEntity.ok("Response submitted successfully");
            } else {
                return ResponseEntity.badRequest().body("Invalid Data user or poll");
            }
        }catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }
}
