package com.eventostec.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repository; 
    public Event createEvent(EventRequestDTO data){
        String imgUrl = null;
        if(data.image() != null){
           //imgUrl =  this.uploadImg(data.image());
           imgUrl = data.image();
        }

        Event newEvent = new Event();
        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventUrl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgUrl(imgUrl);
        newEvent.setRemote(data.remote());


        repository.save(newEvent);

        return newEvent;
    }

    private String uploadImg(MultipartFile multipartFile){
        return "";
    }
}
