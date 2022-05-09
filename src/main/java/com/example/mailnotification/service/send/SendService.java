package com.example.mailnotification.service.send;

import com.example.mailnotification.model.PaymentDto;

public interface SendService {
        void send(PaymentDto paymentDto);
}

