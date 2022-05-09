package com.example.mailnotification.service.message;

import com.example.mailnotification.model.PaymentDto;
import com.example.mailnotification.service.send.SendService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.network.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConsumeServiceImpl implements ConsumeService{

    @Autowired
    private SendService sendService;

    @Override
    @KafkaListener(id = "${spring.kafka.consumer.group-id}", topics = "${spring.kafka.topic.in}",
            containerFactory = "singleFactory")
    public void consumeMessage(PaymentDto message) {
        log.info("Message: {} successfully consumed", message);
        sendService.send(message);
    }
}
