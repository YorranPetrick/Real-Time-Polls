package com.yo.RealTimePolls.controller.polls;


import com.yo.RealTimePolls.models.polls.PollCreateRequest;
import com.yo.RealTimePolls.service.polls.PollsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polls")
public class PollsController {

    private PollsService pollsService;

    public PollsController(PollsService pollsService) {
        this.pollsService = pollsService;
    }

    @PostMapping("/create")
    private ResponseEntity<String> createPoll(@RequestBody PollCreateRequest request) {
        return pollsService.createPoll(request);
    }
}
