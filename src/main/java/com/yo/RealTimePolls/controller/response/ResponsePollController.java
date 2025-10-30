package com.yo.RealTimePolls.controller.response;

import com.yo.RealTimePolls.models.responsePolls.ResponsePollRequest;
import com.yo.RealTimePolls.service.response.ResponsePollService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/response")
public class ResponsePollController {

    private ResponsePollService responsePollService;

    public ResponsePollController(ResponsePollService responsePollService) {
        this.responsePollService = responsePollService;
    }

    @PostMapping("/submit")
    private ResponseEntity<String> submitResponse(@RequestBody @Valid ResponsePollRequest request) {
        return responsePollService.submitResponse(request);
    }

}
