package com.example.mailnotification.service.send;

import com.example.mailnotification.model.PaymentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class SendServiceImpl implements SendService{


    @Autowired
    private JavaMailSender mailSender;
    @Override
    public void send(PaymentDto paymentDto) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("syrym.second@gmail.com");
        email.setTo(paymentDto.getClientEmail());

        email.setSubject("Payment receipt #" + paymentDto.getId());


        String message = " Customer " + paymentDto.getClientName() + " has successfully paid for receipt #" + paymentDto.getTotalPayment() + ". \n";
        message += " Paid services: \n";

        HashMap<String, Double> clientsPayments = paymentDto.getPayments();
        for (Map.Entry<String, Double> payment : clientsPayments.entrySet()) {
            message += "    " + payment.getKey() + " - " + payment.getValue() + " tenge \n";
        }
        message += " The total amount of payment was " + paymentDto.getTotalPayment() + " tenge.";

        email.setText(message);

        mailSender.send(email);
        System.out.println(paymentDto);
    }

}
