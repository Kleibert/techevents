package com.eventostec.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.service.EventService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private  EventService eventService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Event> create(
    @RequestParam("title") String title,
    @RequestParam("description") String description,
    @RequestParam("date") long date,
    @RequestParam("city") String city,
    @RequestParam("state") String state,
    @RequestParam("remote") Boolean remote,
    @RequestParam("eventUrl") String eventUrl,
    @RequestParam("image") String image){

        EventRequestDTO eventRequestDTO = new EventRequestDTO(title, description, date, city,state, remote, eventUrl, image);

        Event newEvent = this.eventService.createEvent(eventRequestDTO);

        return ResponseEntity.ok(newEvent);
    }
}
