package com.smartequip.challenge.service;

import com.smartequip.challenge.model.SumRequest;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AdderService {

    private Pattern pattern = Pattern.compile("\\d");

    public String generateQuestion() {
        Random random = new Random();
        int number = random.nextInt(900) + 100; // Generate a random 3-digit number
        String numberString = String.valueOf(number);
        String formattedNumberString = String.join(",", numberString.split(""));
        return "Please sum the numbers " + formattedNumberString;
    }

    public boolean validateAnswer(SumRequest sumRequest) {
        String question = sumRequest.getQuestion();
        int providedAnswer = sumRequest.getAnswer();

        Matcher matcher = pattern.matcher(question);
        if (!matcher.find()) {
            return false;
        }

        String numberString = question.replaceAll("[^0-9]", "");
        int sum = numberString.chars().map(Character::getNumericValue).sum();

        return sum == providedAnswer;
    }
}
