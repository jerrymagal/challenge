package com.smartequip.challenge.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SumRequest {
    private String question;
    private int answer;
}
