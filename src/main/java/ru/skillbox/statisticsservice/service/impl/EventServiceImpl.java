package ru.skillbox.statisticsservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.skillbox.statisticsservice.dto.response.EventResponseDto;
import ru.skillbox.statisticsservice.exception.EventNotFoundException;
import ru.skillbox.statisticsservice.mapper.EventMapper;
import ru.skillbox.statisticsservice.model.Event;
import ru.skillbox.statisticsservice.repository.EventRepository;
import ru.skillbox.statisticsservice.service.EventService;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    @Override
    public EventResponseDto getEventById(String eventId) throws EventNotFoundException {
        Event findedEvent = eventRepository.findById(eventId).orElseThrow(()
                -> new EventNotFoundException("An event with the specified ID was not found."));

        return eventMapper.eventToEventResponseDto(findedEvent);
    }

    @Override
    public List<EventResponseDto> getEventsByObjectId(String objectId) {
        List<Event> findedEventList;
        if (objectId == null || objectId.isEmpty()) {
            findedEventList = eventRepository.findAll();
        } else {
            findedEventList = eventRepository.findAllByObjectId(objectId);
        }

        return eventMapper.eventListToEventResponseDtoList(findedEventList);
    }
}
