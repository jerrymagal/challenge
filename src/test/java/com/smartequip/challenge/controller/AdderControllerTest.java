package com.smartequip.challenge.controller;

import com.smartequip.challenge.model.SumRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdderControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetQuestion() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + port + "/", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).contains("Please sum the numbers ");
        String numberString = Objects.requireNonNull(response.getBody()).replace("Please sum the numbers ", "");
        String[] numbers = numberString.split(",");
        assertThat(numbers.length).isEqualTo(3);
        for (String number : numbers) {
            assertThat(number).matches("\\d");
        }
    }

    @Test
    void testCorrectAnswer() {
        String question = "Please sum the numbers 9,5,3";
        SumRequest request = new SumRequest(question, 17);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/", request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo("That's great");
    }

    @Test
    void testIncorrectAnswer() {
        String question = "Please sum the numbers 9,5,3";
        SumRequest request = new SumRequest(question, 16);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:" + port + "/", request, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo("That's wrong. Please try again.");
    }

}
