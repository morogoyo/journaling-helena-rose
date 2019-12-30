package com.helenarose.webServices.webService.controllers;

import com.helenarose.webServices.webService.model.Message;
import com.helenarose.webServices.webService.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;


@RestController
@RequestMapping(value = "/api/v1/message")
public class MessageControllers {

    private static final  Logger LOG = LoggerFactory.getLogger(MessageControllers.class);

    @Autowired
    private MessageRepository messageRepo;


    @PostMapping(value = "/insert")
    public ResponseEntity<?> insertMessage(@NotNull @RequestBody Message message){
        LOG.info("This is the message = {}",message.toString());
        messageRepo.save(message);
        return new ResponseEntity<Message>(HttpStatus.OK);

    }


}
