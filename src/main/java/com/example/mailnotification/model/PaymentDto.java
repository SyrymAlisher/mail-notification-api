package com.example.mailnotification.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentDto {
    private String id;
    private String clientName;
    private String clientSurname;
    private String clientEmail;
    private HashMap<String, Double> payments;
    private Double totalPayment;
}
