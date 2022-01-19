package com.thbrabbitserver.thbrabbitmqserver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thbrabbitserver.thbrabbitmqserver.model.NhanhHookRequest;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nhanh/hook")
public class NhanhHookAPI {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private ObjectWriter objectWriter;

    @PostMapping
    public void nhanhHookListener(@RequestBody NhanhHookRequest<Object> message) throws JsonProcessingException {
        String json = objectWriter.writeValueAsString(message);
        try {
            rabbitTemplate.convertAndSend(directExchange.getName(),message.getEvent() , json );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping
    public String healChecker(){
        return "alive";
    }

}
