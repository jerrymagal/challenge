package com.smartequip.challenge.controller;

import com.smartequip.challenge.model.SumRequest;
import com.smartequip.challenge.service.AdderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AdderController {

    @Autowired
    private AdderService adderService;

    @GetMapping
    public ResponseEntity<String> getQuestion() {
        String question = adderService.generateQuestion();
        return ResponseEntity.ok(question);
    }

    @PostMapping
    public ResponseEntity<String> checkAnswer(@RequestBody SumRequest sumRequest) {
        boolean isCorrect = adderService.validateAnswer(sumRequest);
        if (isCorrect) {
            return ResponseEntity.ok("That's great");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("That's wrong. Please try again.");
        }
    }
}
