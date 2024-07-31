package com.smartequip.challenge.service;

import com.smartequip.challenge.model.SumRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdderServiceTest {

    private final AdderService adderService = new AdderService();

    @Test
    void testGenerateQuestion() {
        String question = adderService.generateQuestion();
        assertTrue(question.startsWith("Please sum the numbers "));
        String numberString = question.replace("Please sum the numbers ", "");
        String[] numbers = numberString.split(",");
        assertEquals(3, numbers.length);
        for (String number : numbers) {
            assertTrue(number.matches("\\d"));
        }
    }

    @Test
    void testValidateCorrectAnswer() {
        SumRequest request = new SumRequest("Please sum the numbers 9,5,3", 17);
        boolean isValid = adderService.validateAnswer(request);
        assertTrue(isValid);
    }

    @Test
    void testValidateIncorrectAnswer() {
        SumRequest request = new SumRequest("Please sum the numbers 9,5,3", 16);
        boolean isValid = adderService.validateAnswer(request);
        assertFalse(isValid);
    }

    @Test
    void testValidateWithNonNumericQuestion() {
        SumRequest request = new SumRequest("Please sum the numbers a,b,c", 0);
        boolean isValid = adderService.validateAnswer(request);
        assertFalse(isValid);
    }

}
