package com.example.mailnotification.service.message;

import com.example.mailnotification.model.PaymentDto;

public interface ConsumeService {
    void consumeMessage(PaymentDto message);
}
