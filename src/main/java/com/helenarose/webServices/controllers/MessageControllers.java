package com.helenarose.webServices.controllers;

import com.helenarose.webServices.model.Message;
import com.helenarose.webServices.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping(value = "/api/v1/message")
public class MessageControllers {

    private static final  Logger LOG = LoggerFactory.getLogger(MessageControllers.class);

    @Autowired
    private MessageRepository messageRepo;


    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertMessage(@NotNull @RequestBody Message message){
        LOG.info("This is the message = {}", message.toString());
        messageRepo.save(message);
        return new ResponseEntity<Message>(HttpStatus.OK);

    }

    @GetMapping(value = "/get-message")
    public ResponseEntity<?> getMessage(@NotNull @RequestBody Message message){
        LOG.info("This is the message = {}",message.toString());
        Message userMessage = messageRepo.getOne(message.getUser().getUserId());
        return new ResponseEntity<Message>(userMessage, HttpStatus.OK);

    }

}
