package ru.skillbox.statisticsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.statisticsservice.dto.response.EventResponseDto;
import ru.skillbox.statisticsservice.exception.EventNotFoundException;
import ru.skillbox.statisticsservice.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable String eventId) throws EventNotFoundException {
        return ResponseEntity.ok(eventService.getEventById(eventId));
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDto>> getEventsByObjectId(@RequestParam(name = "object_uuid", required = false)
                                                                      String objectId) {

        return ResponseEntity.ok(eventService.getEventsByObjectId(objectId));
    }
}
